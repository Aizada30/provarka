package med.model;

import med.model.service.PatientService;
import med.model.service.serviceImpl.DepartmentImpl;

import java.util.List;

public class DataBase {
   private List<Hospital> hospitalList;
   private List<Department>departmentList;
   private List<Doctor>doctorList;
   private List<Patient>patientList;

    public DataBase(List<Hospital> hospitalList, List<Department> departmentList, List<Doctor> doctorList, List<Patient> patientList) {
        this.hospitalList = hospitalList;
        this.departmentList = departmentList;
        this.doctorList = doctorList;
        this.patientList = patientList;
    }

    public List<Hospital> getHospitalList() {
        return hospitalList;
    }

    public void setHospitalList(List<Hospital> hospitalList) {
        this.hospitalList = hospitalList;
    }

    public List<Department> getDepartmentList() {
        return departmentList;
    }

    public void setDepartmentList(List<Department> departmentList) {
        this.departmentList = departmentList;
    }

    public List<Doctor> getDoctorList() {
        return doctorList;
    }

    public void setDoctorList(List<Doctor> doctorList) {
        this.doctorList = doctorList;
    }

    public List<Patient> getPatientList() {
        return patientList;
    }

    public void setPatientList(List<Patient> patientList) {
        this.patientList = patientList;
    }

    @Override
    public String toString() {
        return "DataBase{" +
                "hospitalList=" + hospitalList +
                ", departmentList=" + departmentList +
                ", doctorList=" + doctorList +
                ", patientList=" + patientList +
                '}';
    }
}
