package sonaremettakwine.commercial.service.shippingslip;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sonaremettakwine.commercial.dao.invoice.Invoice;
import sonaremettakwine.commercial.dao.shippingslip.ShippingSlip;
import sonaremettakwine.commercial.dao.shippingslip.ShippingSlipRepository;
import sonaremettakwine.commercial.dao.shippingslipinvoice.ShippingSlipInvoice;
import sonaremettakwine.commercial.dao.shippingslipinvoice.ShippingSlipInvoiceRepository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
@Transactional
public class ShippingSlipService {

    @Autowired
    ShippingSlipRepository shippingSlipRepository;

    @Autowired
    ShippingSlipInvoiceRepository shippingSlipInvoiceRepository;

    public List<ShippingSlip> getAll(){
        return shippingSlipRepository.getAllSortByID();
    }

    public ShippingSlip getShippingSlipById(Long id){
        return shippingSlipRepository.getReferenceById(id);
    }

    public List<ShippingSlipInvoice> getInvoiceByShippingSlip(ShippingSlip shippingSlip){
        return shippingSlipInvoiceRepository.getShippingSlipInvoiceByShippingSlip(shippingSlip);
    }

    public ShippingSlipInvoice getShippingSlipInvoiceById(Long shippingSlipInvoiceId){
        return shippingSlipInvoiceRepository.getReferenceById(shippingSlipInvoiceId);
    }


    public ShippingSlip add(ShippingSlip shippingSlip){
        ShippingSlip newShippingSlip=new ShippingSlip();
        newShippingSlip.setDate(shippingSlip.getDate());
        newShippingSlip.setCustomer(shippingSlip.getCustomer());

        Calendar cal = new GregorianCalendar();
        cal.setTime(shippingSlip.getDate());
        newShippingSlip.setNumber(nextShippingSlipNumber(String.valueOf(cal.get(Calendar.YEAR))));
        return shippingSlipRepository.save(newShippingSlip);
    }


    public void delete(ShippingSlip shippingSlip){shippingSlipRepository.delete(shippingSlip);}

    public ShippingSlip update(ShippingSlip shippingSlip){
        ShippingSlip shippingSlip1=getShippingSlipById(shippingSlip.getId());
        shippingSlip1.setDate(shippingSlip.getDate());
        return shippingSlip1;
    }

    public ShippingSlip accuse(ShippingSlip shippingSlip) {
        ShippingSlip shippingSlip1=getShippingSlipById(shippingSlip.getId());
        shippingSlip1.setAccuse(shippingSlip.getAccuse());
        return shippingSlip1;
    }

    public Long nextShippingSlipNumber(String year)  {
        String d1="01/01/"+year;
        String d2="31/12/"+year;
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy", Locale.FRANCE);
        try {
            Date date1=formatter.parse(d1);
            Date date2=formatter.parse(d2);
            List<ShippingSlip> shippingSlips=shippingSlipRepository.getBetweenTowDateSortByNumber(date1,date2);
            if(!shippingSlips.isEmpty()) return shippingSlips.get(0).getNumber()+1;
            return 1L;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 1L;
    }


    public ShippingSlipInvoice addInvoice(ShippingSlipInvoice shippingSlipInvoice) {
        return shippingSlipInvoiceRepository.save(shippingSlipInvoice);
    }

    public ShippingSlipInvoice deleteInvoice(ShippingSlipInvoice shippingSlipInvoice) {
        ShippingSlipInvoice shippingSlipInvoice1=shippingSlipInvoiceRepository.getReferenceById(shippingSlipInvoice.getId());
       shippingSlipInvoiceRepository.delete(shippingSlipInvoice1);
        return shippingSlipInvoice1;
    }


    public ShippingSlipInvoice updateShippingSlipInvoice(ShippingSlipInvoice shippingSlipInvoice){

        ShippingSlipInvoice shippingSlipInvoice1=shippingSlipInvoiceRepository.getReferenceById(shippingSlipInvoice.getId());

        shippingSlipInvoice1.setNbrPage(shippingSlipInvoice.getNbrPage());
        shippingSlipInvoice1.setObs(shippingSlipInvoice.getObs());
        return  shippingSlipInvoice1;

    }
}


