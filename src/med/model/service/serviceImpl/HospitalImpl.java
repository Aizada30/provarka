package med.model.service.serviceImpl;

import med.model.DataBase;
import med.model.Hospital;
import med.model.Patient;
import med.model.service.HospitalService;

import java.util.List;
import java.util.Map;

public class HospitalImpl implements HospitalService {

    private DataBase dataBase;
    private static long id;

    public HospitalImpl(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    @Override
    public String addHospital(Hospital hospital) {
        hospital.setId(++id);
        dataBase.getHospitalList().add(hospital);
        return "Hospital successfully saved";
    }

    @Override
    public Hospital findHospitalById(Long id) {
        List<Hospital> hospitals = dataBase.getHospitalList().stream().filter(hospital -> hospital.getId() == id).toList();
        return hospitals.get(0);
    }

    @Override
    public List<Hospital> getAllHospital() {
        return dataBase.getHospitalList();
    }

    @Override
    public List<Patient> getAllPatientFromHospital(Long id) {
        List<Hospital> hospitals = dataBase.getHospitalList().stream().filter(hospital -> hospital.getId() == id).toList();
        return hospitals.get(0).getPatientList();
    }

    @Override
    public String deleteHospitalById(Long id) {
       dataBase.getHospitalList().removeIf(hospital -> hospital.getId()==id);
        System.out.println("Hospital successfully removed");
        return "Hospital successfully removed";
    }

    @Override
    public Map<String, Hospital> getAllHospitalByAddress(String address) {
        return null;
    }
}
