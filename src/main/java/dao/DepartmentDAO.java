package dao;

import models.Department;
//import models.DepartmentNews;
import models.User;

import java.util.List;

public interface DepartmentDAO {


    //create
    void add(Department department);

    //    read
    List<Department> getAllDepartment();

    Department getDepartmentById(int departmentId);


}