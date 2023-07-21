package med.model.service.serviceImpl;

import med.model.DataBase;
import med.model.Department;
import med.model.Hospital;
import med.model.service.DepartmentService;
import med.model.service.GenericService;

import java.util.List;

public class DepartmentImpl implements DepartmentService, GenericService<Department> {
    private DataBase dataBase;
    private static long id;

    public DepartmentImpl(DataBase dataBase) {
        this.dataBase = dataBase;
    }


    @Override
    public List<Department> getAllDepartmentByHospital(Long id) {
        List<Hospital> hospitals = dataBase.getHospitalList().stream().filter(hospital -> hospital.getId() == id).toList();
        return  hospitals.get(0).getDepartmentList();
    }

    @Override
    public Department findDepartmentByName(String name) {
        List<Department> departmentList = dataBase.getDepartmentList().stream()
                .filter(department -> department.getDepartmentName().equalsIgnoreCase(name)).toList();
        return departmentList.get(0);
    }

    @Override
    public String add(Long hospitalId, Department department) {
        department.setId(++id);
        List<Hospital> hospitals = dataBase.getHospitalList().stream().filter(hospital -> hospital.getId() == hospitalId).toList();
        hospitals.get(0).getDepartmentList().add(department);
        return "New department successfully saved";
    }

    @Override
    public void removeById(Long id) {
        dataBase.getHospitalList()
                .stream()
                .filter(hospital -> hospital.getDepartmentList()
                        .removeIf(department -> department.getId()==id))
                .toList().forEach(System.out::println);
        System.out.println("Department succesfully deleted");
    }

    @Override
    public String updateById(Long id, Department department) {
        List<Department> departmentList = dataBase.getDepartmentList().stream().filter(department1 -> department.getId() == id).toList();
        departmentList.get(0).setDepartmentName(department.getDepartmentName());
        return null;
    }
}
