package med.model.service.serviceImpl;

import med.model.DataBase;
import med.model.Hospital;
import med.model.Patient;
import med.model.service.GenericService;
import med.model.service.PatientService;

import javax.xml.crypto.Data;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class PatientImpl implements PatientService, GenericService<Patient> {

    private DataBase dataBase;
    private static long id;

    public PatientImpl(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    @Override
    public String add(Long hospitalId, Patient patient) {
        List<Hospital> hospitals = dataBase.getHospitalList().stream().filter(hospital -> hospital.getId() == id).toList();
        hospitals.get(0).getPatientList().add(patient);
        return "\nNew patient successfully saved ";
    }

    @Override
    public void removeById(Long id) {
        dataBase.getPatientList().removeIf(patient -> patient.getId() == id);
        System.out.println("\nPatient successfully deleted");
    }

    @Override
    public String updateById(Long id, Patient patient) {
        List<Patient> patientList = dataBase.getPatientList().stream().filter(patient1 -> patient.getId() == id).toList();
        patientList.get(0).setFirstName(patient.getFirstName());
        patientList.get(0).setLastName(patient.getLastName());
        patientList.get(0).setAge(patient.getAge());
        patientList.get(0).setGender(patient.getGender());
        return "\nPatient successfully updated";
    }

    @Override
    public String addPatientsToHospital(Long id, List<Patient> patients) {
        List<Hospital> hospitals = dataBase.getHospitalList().stream().filter(hospital -> hospital.getId() == id).toList();
        hospitals.get(0).getPatientList().addAll(patients);
        return "\nNew patients successfully saved!";
    }

    @Override
    public Patient getPatientById(Long id) {
        List<Patient> patientList = dataBase.getPatientList().stream().filter(patient -> patient.getId() == id).toList();
        return patientList.get(0);
    }

    @Override
    public Map<Integer, Patient> getPatientByAge() {
        return null;
    }

    @Override
    public List<Patient> sortPatientsByAge(String ascOrDesc) {
        if(ascOrDesc.equalsIgnoreCase("1")){
            dataBase.getPatientList().sort(sort);
            System.out.println(dataBase.getPatientList());
        }else if (ascOrDesc.equalsIgnoreCase("2")){
            dataBase.getPatientList().sort(sortDescendis);
            System.out.println(dataBase.getPatientList());
        }

        return null;
    }

    Comparator <Patient>sort = new Comparator<Patient>() {
        @Override
        public int compare(Patient o1, Patient o2) {
            return o1.getAge()- o2.getAge();
        }
    };
    Comparator<Patient>sortDescendis = new Comparator<Patient>() {
        @Override
        public int compare(Patient o1, Patient o2) {
            return o2.getAge()-o1.getAge();
        }
    };

}
