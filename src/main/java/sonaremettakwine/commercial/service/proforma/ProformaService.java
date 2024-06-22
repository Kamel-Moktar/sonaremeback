package sonaremettakwine.commercial.service.proforma;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sonaremettakwine.commercial.dao.proforma.Proforma;
import sonaremettakwine.commercial.dao.proforma.ProformaRepository;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
@Service
@Transactional
public class ProformaService {
    @Autowired
    ProformaRepository proformaRepository;


    public List<Proforma> getAll() {

        return proformaRepository.getAllSortByID();

    }

    public Proforma getProformaById(Long id) {
        return proformaRepository.getReferenceById(id);
    }

    public List<Proforma> getDebts() {
        return proformaRepository.debts();
    }

    public List<Proforma> getDebtsByNumberByCustomerByDate(String number, String shortName, String date) {
        return proformaRepository.getDebtsByNumberByCustomerByDate(number, shortName, date);
    }
    public List<Proforma> getAllByNumberByCustomerByDate(String number, String shortName, String date) {
        return proformaRepository.getAllByNumberByCustomerByDate(number, shortName, date);
    }

    public Proforma add(Proforma proforma) {
        Proforma newProforma = new Proforma();
        newProforma.setCustomer(proforma.getCustomer());
        newProforma.setReference(proforma.getReference());
        newProforma.setObject(proforma.getObject());
        newProforma.setDate(proforma.getDate());
        newProforma.setNumber(proforma.getNumber());

        Calendar cal = new GregorianCalendar();
        cal.setTime(proforma.getDate());
        newProforma.setNumber(nextProformaNumber(String.valueOf(cal.get(Calendar.YEAR))));


        return proformaRepository.save(newProforma);
    }

    public void delete(Proforma proforma) {
        proformaRepository.delete(proforma);
    }

    public Proforma update(Proforma proforma) {
        Proforma proforma1 = getProformaById(proforma.getId());
        proforma1.setDate(proforma.getDate());
        proforma1.setObject(proforma.getObject());
        proforma1.setReference(proforma.getReference());
        proforma1.setCustomer(proforma.getCustomer());

        return proforma1;
    }


    public Proforma updateRemains(Long id, Double remains) {
        Proforma proforma1 = getProformaById(id);
        proforma1.setRemains(remains);

        return proforma1;
    }


    public Long nextProformaNumber(String year) {

        String d1 = "01/01/" + year;
        String d2 = "31/12/" + year;
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy", Locale.FRANCE);
        try {
            Date date1 = formatter.parse(d1);
            Date date2 = formatter.parse(d2);
            List<Proforma> proformas = proformaRepository.getBetweenTowDateSortByNumber(date1, date2);
            if (!proformas.isEmpty()) return proformas.get(0).getNumber() + 1;
            return 1L;

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 1L;
    }

}
