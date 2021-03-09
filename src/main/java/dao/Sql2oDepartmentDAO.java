package dao;


import models.Department;
//import models.DepartmentNews;
import models.User;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;
import java.util.stream.Collectors;

public  class Sql2oDepartmentDAO implements DepartmentDAO {   //connecting to the interface


    private final Sql2o sql2o;


    public Sql2oDepartmentDAO(Sql2o sql2o) {
        this.sql2o = sql2o;

    }


    @Override
    public void add(Department department) {
        String sql = "INSERT INTO department (userId, name, description) VALUES (:userId, :name, :description)";
        try (Connection conn = sql2o.open()) {
            int id = (int) conn.createQuery(sql, true)
                    .bind(department)
                    .executeUpdate()
                    .getKey();
            department.setId(id);

        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public List<Department> getAllDepartment() {
        try (Connection conn = sql2o.open()) {
            System.out.println(conn.createQuery("SELECT * FROM department")
                    .executeAndFetch(Department.class));
            return conn.createQuery("SELECT * FROM department")
                    .executeAndFetch(Department.class);

        }
    }

    @Override
    public Department getDepartmentById(int departmentId) {
        String sql = "SELECT * FROM department WHERE id = :id";
        try (Connection con = sql2o.open()) {
            return con.createQuery(sql)
                    .addParameter("id", departmentId)
                    .executeAndFetchFirst(Department.class);
        }
    }
}

