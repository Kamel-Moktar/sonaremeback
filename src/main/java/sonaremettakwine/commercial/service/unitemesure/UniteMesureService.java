package sonaremettakwine.commercial.service.unitemesure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sonaremettakwine.commercial.dao.unitmeasurement.UnitMeasurement;
import sonaremettakwine.commercial.dao.unitmeasurement.UnitMeasurementRepository;

import java.util.List;

@Service
@Transactional
public class UniteMesureService {
    @Autowired
    UnitMeasurementRepository unitMeasurementRepository;

    public List<UnitMeasurement> getAll(String name) {
        return unitMeasurementRepository.getAllSortByID(name);
    }

    public UnitMeasurement getById(Long id){
        return unitMeasurementRepository.getReferenceById(id);
    }

    public UnitMeasurement add(UnitMeasurement unitMeasurement) {
        return unitMeasurementRepository.save(unitMeasurement);
    }

    public void delete(UnitMeasurement unitMeasurement) {
        unitMeasurementRepository.delete(unitMeasurement);
    }

    public UnitMeasurement update(UnitMeasurement unitMeasurement) {
        UnitMeasurement unitMeasurement1 = getById(unitMeasurement.getId());
        unitMeasurement1.setName(unitMeasurement.getName());
        unitMeasurement1.setSymbol(unitMeasurement.getSymbol());
        unitMeasurement1.setDesignation(unitMeasurement.getDesignation());
        return unitMeasurement1;
    }
}
