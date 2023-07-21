package med.model.service.serviceImpl;

import com.sun.security.auth.module.LdapLoginModule;
import med.model.DataBase;
import med.model.Department;
import med.model.Doctor;
import med.model.Hospital;
import med.model.service.DoctorService;
import med.model.service.GenericService;

import javax.print.Doc;
import javax.xml.crypto.Data;
import java.util.List;
import java.util.Optional;

public class DoctorImpl implements GenericService<Doctor> , DoctorService  {

    private DataBase dataBase;
    private static long id;

    public DoctorImpl (DataBase dataBase){
        this.dataBase=dataBase;
    }

    @Override
    public Doctor findDoctorById(Long id) {
        List<Doctor> doctorList = dataBase.getDoctorList().stream().filter(doctor -> doctor.getId() == id).toList();
        return doctorList.get(0);
    }

    @Override
    public String assignDoctorToDepartment(Long departmentId, List<Long> doctorsId) {
        return null;
    }

    @Override
    public List<Doctor> getAllDoctorsByHospitalId(Long id) {
        return dataBase.getDoctorList();
    }

    @Override
    public List<Doctor> getAllDoctorsByDepartmentId(Long id) {
        List<Department> departmentList = dataBase.getDepartmentList().stream().filter(department -> department.getId() == id).toList();
        return departmentList.get(0).getDoctorList();
    }

    @Override
    public String add(Long hospitalId, Doctor doctor) {
        if(dataBase.getHospitalList().isEmpty()){
            doctor.setId(++id);
        }else {
            doctor.setId(++id);
        }

        dataBase.getDoctorList().add(doctor);
      dataBase.getHospitalList().stream().filter(hospital -> hospital.getId()==hospitalId).toList().forEach(hospital -> hospital.getDoctorList().add(doctor));
        return "New doctor successfully saved! ";
    }

    @Override
    public void removeById(Long id) {
      dataBase.getHospitalList().stream()
              .filter(hospital -> hospital.getDoctorList()
                      .removeIf(doctor -> doctor.getId()==id))
              .toList().forEach(System.out::println);
        System.out.println("Doctor successfully deleted ");
    }

    @Override
    public String updateById(Long id, Doctor doctor) {
        List<Doctor> doctorList = dataBase.getDoctorList().stream().filter(doctor1 -> doctor1.getId() == id).toList();
        doctorList.get(0).setFirstName(doctor.getFirstName());
        doctorList.get(0).setLastName(doctor.getLastName());
        doctorList.get(0).setGender(doctor.getGender());
        doctorList.get(0).setExperienceYear(doctor.getExperienceYear());
        return "Doctor successfully updated ";
    }
}