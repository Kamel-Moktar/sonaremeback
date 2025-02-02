package sonaremettakwine.commercial.service.invoicedetail;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sonaremettakwine.commercial.dao.Price.Price;
import sonaremettakwine.commercial.dao.benifit.Benefit;
import sonaremettakwine.commercial.dao.booking.Booking;
import sonaremettakwine.commercial.dao.customer.Customer;
import sonaremettakwine.commercial.dao.inscription.Inscription;
import sonaremettakwine.commercial.dao.invoice.Invoice;
import sonaremettakwine.commercial.dao.invoicedetail.InvoiceDetail;
import sonaremettakwine.commercial.dao.invoicedetail.InvoiceDetailRepository;
import sonaremettakwine.commercial.dao.phase.Phase;
import sonaremettakwine.commercial.dao.sale.Sale;
import sonaremettakwine.commercial.dao.sale.Vente;
import sonaremettakwine.commercial.dao.session.Session;
import sonaremettakwine.commercial.dao.unit.UnitRepository;
import sonaremettakwine.commercial.service.benefit.BenefitService;
import sonaremettakwine.commercial.service.booking.BookingService;
import sonaremettakwine.commercial.service.inscription.InscriptionService;
import sonaremettakwine.commercial.service.phase.PhaseService;
import sonaremettakwine.commercial.service.price.PriceService;
import sonaremettakwine.commercial.service.sale.SaleService;

import java.text.SimpleDateFormat;
import java.util.List;

@Service
@Transactional
public class InvoiceDetailService {
    @Autowired
    InvoiceDetailRepository invoiceDetailRepository;

    @Autowired
    BenefitService benefitService;

    @Autowired
    BookingService bookingService;

    @Autowired
    PriceService priceService;

    @Autowired
    PhaseService phaseService;

    @Autowired
    InscriptionService inscriptionService;

    @Autowired
    SaleService saleService;

    public List<InvoiceDetail> getAll() {
        return invoiceDetailRepository.findAll();
    }

    public InvoiceDetail getById(Long id) {
        return invoiceDetailRepository.getReferenceById(id);
    }


    public List<InvoiceDetail> getByInvoice(Invoice invoice) {
        return invoiceDetailRepository.findByInvoiceOrderByInscriptionStagiaireFirstNameAndBenefitDesignation(invoice);
    }

    public List<Inscription> getDistinctInscriptionByInvoice(Invoice invoice) {
        return invoiceDetailRepository.getDistinctStagiaireByInvoice(invoice);
    }

    public List<Inscription> getDistinctInscriptionByPhaseAndCustomer(Phase phase, Customer customer) {
        return invoiceDetailRepository.getDistinctInscriptionByPhaseAndInvoiceCustomer(phase, customer);
    }


    public InvoiceDetail update(InvoiceDetail invoiceDetail) {
        InvoiceDetail invoiceDetail1 = getById(invoiceDetail.getId());
        invoiceDetail1.setPrice(invoiceDetail.getPrice());
        invoiceDetail1.setQte(invoiceDetail.getQte());
        invoiceDetail1.setObs(invoiceDetail.getObs());

        updateSale(invoiceDetail1.getInvoice());
        return invoiceDetail;
    }


    public InvoiceDetail delete(InvoiceDetail invoiceDetail) {
        invoiceDetailRepository.delete(invoiceDetail);
        updatePhaseIsBilled(invoiceDetail);
        updateSale(invoiceDetail.getInvoice());
        return invoiceDetail;
    }

    public InvoiceDetail deleteAll(Inscription inscription, Invoice invoice) {

        List<InvoiceDetail> invoiceDetails = invoiceDetailRepository.getAllByInvoiceAndInscription(invoice, inscription);

        for (InvoiceDetail invoiceDetail : invoiceDetails) {

            invoiceDetailRepository.delete(invoiceDetail);
            updateSale(invoice);
            updatePhaseIsBilled(invoiceDetail);
        }


        return null;
    }

    public void updatePhaseIsBilled(InvoiceDetail invoiceDetail) {


        List<Inscription> reelInscriptions = inscriptionService.getByStagiaireCustomer(invoiceDetail.getInvoice().getCustomer(), invoiceDetail.getPhase().getSession());
        List<Inscription> billedInscriptions = getDistinctInscriptionByPhaseAndCustomer(invoiceDetail.getPhase(), invoiceDetail.getInvoice().getCustomer());

        phaseService.setIsBilled(invoiceDetail.getPhase().getId(), reelInscriptions.size()== billedInscriptions.size());

    }

    List<Inscription> getByInscriptionAndPhase(Inscription inscription, Phase phase) {
        return invoiceDetailRepository.getInscriptionByPhase(inscription, phase);
    }

    public InvoiceDetail add(InvoiceDetail invoiceDetail) {
        List<Inscription> inscriptions = getByInscriptionAndPhase(invoiceDetail.getInscription(), invoiceDetail.getPhase());

        if (inscriptions.size() == 0) {
            InvoiceDetail invoiceDetail1 = new InvoiceDetail();
            invoiceDetail1.setInvoice(invoiceDetail.getInvoice());
            invoiceDetail1.setInscription(invoiceDetail.getInscription());
            Phase phase = phaseService.getPhaseById(invoiceDetail.getPhase().getId());
            invoiceDetail1.setPhase(phase);
            Benefit enseignement = benefitService.getBenefitById(1L);
            Benefit hebergement = benefitService.getBenefitById(4L);
            Benefit restauration = benefitService.getBenefitById(3L);


            invoiceDetail1.setBenefit(enseignement);
            invoiceDetail1.setQte(phase.getDuration());

            List<Price> prices = priceService.getAllByBenifitByAction(enseignement, invoiceDetail.getInscription().getSession().getAction());
            if (!prices.isEmpty())
                invoiceDetail1.setPrice(prices.get(0).getPrice());
            invoiceDetailRepository.save(invoiceDetail1);


            List<Booking> bookings = bookingService.getBookingsInPeriode(invoiceDetail.getInscription(), phase.getStartDate(), phase.getEndDate());

            long d = 0;
            for (Booking booking : bookings) {

                d = (booking.getLeavingDate().getTime() - booking.getArriveDate().getTime()) / (1000 * 60 * 60 * 24);

                InvoiceDetail invoiceDetail2 = new InvoiceDetail();
                invoiceDetail2.setInvoice(invoiceDetail.getInvoice());
                invoiceDetail2.setInscription(invoiceDetail.getInscription());
                invoiceDetail2.setPhase(invoiceDetail.getPhase());


                invoiceDetail2.setBenefit(hebergement);
                invoiceDetail2.setBooking(booking);
                invoiceDetail2.setQte((double) d);
                prices = priceService.getAllByBenifitByHotel(hebergement, booking.getHotel());
                if (!prices.isEmpty())
                    invoiceDetail2.setPrice(prices.get(0).getPrice());
                invoiceDetailRepository.save(invoiceDetail2);


                InvoiceDetail invoiceDetail3 = new InvoiceDetail();
                invoiceDetail3.setInvoice(invoiceDetail.getInvoice());
                invoiceDetail3.setInscription(invoiceDetail.getInscription());
                invoiceDetail3.setPhase(invoiceDetail.getPhase());

                invoiceDetail3.setBenefit(restauration);

                invoiceDetail3.setBooking(booking);
                invoiceDetail3.setQte((double) d * 2);
                prices = priceService.getAllByBenifitByHotel(restauration, booking.getHotel());
                if (!prices.isEmpty())
                    invoiceDetail3.setPrice(prices.get(0).getPrice());


                invoiceDetailRepository.save(invoiceDetail3);
            }

            updatePhaseIsBilled(invoiceDetail1);
            updateSale(invoiceDetail1.getInvoice());
        }
        return invoiceDetail;
    }

@Autowired
    UnitRepository unitRepository;

    public void updateSale(Invoice invoice) {
      List<Sale> sales=saleService.getSaleByInvoice(invoice);
      for(Sale s:sales)saleService.delete(s);
        SimpleDateFormat d = new SimpleDateFormat("dd/MM/yy");

      List<Vente> ventes=invoiceDetailRepository.getSaleOfInvoice(invoice);
      for(Vente v:ventes){
          Double qte=v.getNumber().doubleValue();
          Benefit enseignement = benefitService.getBenefitById(1L);
          Sale sale=new Sale();
          sale.setInvoice(v.getInvoice());
          sale.setBenefit(v.getBenefit());
          sale.setUnit(unitRepository.getReferenceById("Unité"));
          sale.setQuantity(v.getQuantity());
          sale.setNumber(qte);
          sale.setPrice(v.getPrice());
          if(v.getBenefit().equals(enseignement))

          sale.setObservation( "  "+v.getSession().getAction().getName() +"  '"+v.getSession().getName()+" du "+d.format(v.getSession().getStartDate())+" au "+d.format(v.getSession().getEndDate())+"' ");


          saleService.add(sale);
      }


    }




    public List<Session> getDistinctSessionByInvoice(Invoice invoice) {

        return invoiceDetailRepository.getDistinctInscriptionSessionByInvoice(invoice);
    }

    public InvoiceDetail add1(InvoiceDetail invoiceDetail) {
        InvoiceDetail invoiceDetail1=invoiceDetailRepository.save(invoiceDetail);
        updateSale(invoiceDetail1.getInvoice());
        return invoiceDetail1;
    }

    public List<Phase> getPhase(Inscription inscription, Invoice invoice) {

        return invoiceDetailRepository.getPhaseBYInscriptionAndInvoice(inscription, invoice);
    }
}
