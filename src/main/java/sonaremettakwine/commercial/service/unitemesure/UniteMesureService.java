package sonaremettakwine.commercial.service.unitemesure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sonaremettakwine.commercial.dao.unitmeasurement.UnitMeasurement;
import sonaremettakwine.commercial.dao.unitmeasurement.UnitMeasurementRepository;

import java.util.List;

@Service
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

    public UnitMeasurement update(UnitMeasurement newUnitMeasurement) {
        UnitMeasurement oldUnitMeasurement = unitMeasurementRepository.getReferenceById(newUnitMeasurement.getId());
        oldUnitMeasurement.setName(newUnitMeasurement.getName());

        return oldUnitMeasurement;
    }
}
