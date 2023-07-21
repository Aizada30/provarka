import med.model.*;
import med.model.service.DepartmentService;
import med.model.service.DoctorService;
import med.model.service.HospitalService;
import med.model.service.serviceImpl.DepartmentImpl;
import med.model.service.serviceImpl.DoctorImpl;
import med.model.service.serviceImpl.HospitalImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Hospital> hospitalList = new ArrayList<>();
        List<Doctor> doctorList = new ArrayList<>();
        List<Patient> patientList = new ArrayList<>();
        List<Department> departmentList = new ArrayList<>();


        DataBase dataBase = new DataBase(hospitalList, departmentList, doctorList, patientList);
        HospitalService hospitalService = new HospitalImpl(dataBase);
        DoctorImpl doctorImpl = new DoctorImpl(dataBase);
        DepartmentImpl departmentService = new DepartmentImpl(dataBase);
        boolean isTrue = true;

        while (isTrue) {
            System.out.println("""
                     
                    1 . to add Hospital 
                    2 . find Hospital by id 
                    3 . get all Hospitals 
                    4 . get Patients from Hospital by id
                    5 . delete Hospital by id
                    6 . get all Hospital by address
                    7 . to add new Doctor
                    8 . delete Doctor by id 
                    9 . update Doctor by id 
                    10 . find Doctor by id
                    11 . assiga Doctor to Department 
                    12 . get all Doctors by Hospital 
                    13 . get all Doctors by Department
                    14 . to add new Department 
                    15 . delete Department by id
                    16 . update Department by id
                    17 . get all Department by Hospital id
                    18 . find Department by name
                    19 . 
                    
                     
                    0 . to close the operation
                    """);
            int num = new Scanner(System.in).nextInt();
            switch (num) {

                case 1 -> {
                    Hospital hospital = new Hospital();
                    System.out.println("Enter a name of hospital: ");
                    String name = new Scanner(System.in).nextLine();
                    System.out.println("Enter a address of hospital: ");
                    String address = new Scanner(System.in).nextLine();
                    hospital.setHospitalName(name);
                    hospital.setAddress(address);
                    System.out.println(hospitalService.addHospital(hospital));
                }
                case 2 -> {
                    System.out.println("Enter the id of the hospital you are looking for: ");
                    long id = new Scanner(System.in).nextLong();
                    System.out.println(hospitalService.findHospitalById(id));
                }
                case 3 -> System.out.println(hospitalService.getAllHospital());
                case 4 -> {
                    System.out.println("Enter id: ");
                    long id = new Scanner(System.in).nextLong();
                    hospitalService.getAllPatientFromHospital(id);
                }
                case 5 -> {
                    System.out.println("Write the id of the hospital you want to delete: ");
                    long id = new Scanner(System.in).nextLong();
                    hospitalService.deleteHospitalById(id);
                }
                case 6 -> System.out.println("i don't know how can i do this task");
                case 7 -> {
                    Doctor doctor = new Doctor();
                    System.out.println("enter a id of hospital: ");
                    long id = new Scanner(System.in).nextLong();
                    System.out.println("enter a new first name of doctor:");
                    String name = new Scanner(System.in).nextLine();
                    System.out.println("enter a last name of doctor: ");
                    String lastName = new Scanner(System.in).nextLine();
                    System.out.println("enter a doctors gender: ");
                    String gender = new Scanner(System.in).nextLine();
                    if (gender.equalsIgnoreCase("male")) {
                        doctor.setGender(Gender.MALE);
                    } else if (gender.equalsIgnoreCase("female")) {
                        doctor.setGender(Gender.FEMALE);
                    }
                    System.out.println("enter experience Year: ");
                    int year = new Scanner(System.in).nextInt();

                    doctor.setFirstName(name);
                    doctor.setLastName(lastName);
                    doctor.setExperienceYear(year);
                    System.out.println(doctorImpl.add(id, doctor));
                }
                case 8 -> {
                    System.out.println("enter a id of doctor to remove: ");
                    long id = new Scanner (System.in).nextLong();
                    doctorImpl.removeById(id);
                }
                case 9 -> {
                    Doctor doctor = new Doctor();
                    System.out.println("enter a id: ");
                    long id  = new Scanner (System.in).nextLong();
                    System.out.println("enter a new first name: ");
                    String newName = new Scanner(System.in).nextLine();
                    System.out.println("enter a new last name: ");
                    String newLastName = new Scanner(System.in).nextLine();
                    System.out.println("enter a gender: ");
                    String gender = new Scanner(System.in).nextLine();
                    if(gender.equalsIgnoreCase("female")){
                        doctor.setGender(Gender.FEMALE);
                    } else if (gender.equalsIgnoreCase("male")) {
                        doctor.setGender(Gender.MALE);
                    }
                    System.out.println("enter a experience year: ");
                    int year=new Scanner(System.in).nextInt();
                    doctor.setFirstName(newName);
                    doctor.setLastName(newLastName);
                    doctor.setExperienceYear(year);
                    System.out.println(doctorImpl.updateById(id, doctor));
                }
                case 10 ->{
                    System.out.println("enter the Doctors id: ");
                    long id = new Scanner(System.in).nextLong();
                    System.out.println(doctorImpl.findDoctorById(id));
                }
                case 11 -> {
                    System.out.println("enter the Doctors id: ");
//                    long id= new Scanner(System.in).nextLong();           I DON'T KNOW
//                    doctorImpl.assignDoctorToDepartment(id);
                }
                case 12 -> {
                    System.out.println("enter a hospital id: ");
                    long id = new Scanner(System.in).nextLong();
                    System.out.println(doctorImpl.getAllDoctorsByHospitalId(id));
                }
                case 13 -> {
                    System.out.println("enter a department id: ");
                    long id = new Scanner(System.in).nextLong();
                    System.out.println(doctorImpl.getAllDoctorsByDepartmentId(id));
                }
                case 14 -> {
                    Department department= new Department();
                    System.out.println("enter the id of Hospital: ");
                    long id = new Scanner(System.in).nextLong();
                    System.out.println("enter a name of Department: ");
                    String name = new Scanner(System.in).nextLine();
                   department.setDepartmentName(name);
                    System.out.println(departmentService.add(id, department));
                }
                case 15 -> {
                    System.out.println("enter the id: ");
                    long id = new Scanner(System.in).nextLong();
                    departmentService.removeById(id);
                }
                case 0 -> isTrue = false;

            }
        }
    }
}