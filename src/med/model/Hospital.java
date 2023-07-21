package med.model;

import java.util.ArrayList;
import java.util.List;

public class Hospital {
    private long id;
    private String hospitalName;
    private String address;
    private List<Department> departmentList;
    private List<Doctor> doctorList;
    private List<Patient> patientList;

    public Hospital(){

    }

    public Hospital(long id, String hospitalName, String address) {
        this.id = id;
        this.hospitalName = hospitalName;
        this.address = address;
    }

    public Hospital(long id, String hospitalName, String address, List<Department> departmentList, List<Doctor> doctorList, List<Patient> patientList) {
        this.id = id;
        this.hospitalName = hospitalName;
        this.address = address;
        this.departmentList = departmentList;
        this.doctorList = doctorList;
        this.patientList = patientList;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Department> getDepartmentList() {
        if(departmentList==null){
            departmentList=new ArrayList<>();
        }
        return departmentList;
    }

    public void setDepartmentList(List<Department> departmentList) {
        this.departmentList = departmentList;
    }

    public List<Doctor> getDoctorList() {
        if(doctorList==null){
            doctorList=new ArrayList<>();
        }
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
        return "\n" +
                "\n~ HOSPITAL ~" +
                "\nhospy ID: " + id +
                "\nNAME OF HOSPITAL: " + hospitalName +
                "\nADDRESS: " + address +
                "\n~ DEPARTMENT: " + departmentList +
                "\n~ DOCTORS: " + doctorList +
                "\n~ PATIENTS: " + patientList +
                '\n';
    }
}
