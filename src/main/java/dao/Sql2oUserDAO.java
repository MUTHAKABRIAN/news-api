
package dao;

import models.News;
import models.User;
import org.sql2o.Sql2o;

import org.sql2o.Connection;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2oUserDAO implements UserDAO {
    private final Sql2o sql2o;

    public Sql2oUserDAO(Sql2o sql2o) {

        this.sql2o = sql2o;
    }

    @Override
    public List<User> getAllUsers() {
        try (Connection conn = sql2o.open()) {
            System.out.println(conn.createQuery("SELECT * FROM users")
                    .executeAndFetch(User.class));
            return conn.createQuery("SELECT * FROM users")
                    .executeAndFetch(User.class);

        }
    }


    @Override
    public void add(User users) {
        String sql = "INSERT INTO users (departmentId, role, position, name  ) VALUES (:departmentId, :role, :position, :name  )";
        try (Connection con = sql2o.open()) {
            int id = (int) con.createQuery(sql, true)
                    .bind(users)
                    .executeUpdate()
                    .getKey();
            users.setId(id);

        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public User getUserById(int id) {
        String sql = "SELECT * FROM users WHERE id = :id";
        try (Connection con = sql2o.open()) {
            return con.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(User.class);

        }
    }

    @Override
    public User getUserByDepartment(int departmentId) {
        String sql = "SELECT * FROM users WHERE departmentId =:departmentId";
        try (Connection con = sql2o.open()) {
            return con.createQuery(sql)
                    .addParameter("departmentId", departmentId)
                    .executeAndFetchFirst(User.class);
        }
    }

    @Override
    public News getUidByNewsPost(int userId) {
        String sql = "SELECT * FROM news WHERE userId =:userId";
        try (Connection con = sql2o.open()) {
            return con.createQuery(sql)
                    .addParameter("userId", userId)
                    .executeAndFetchFirst(News.class);
        }
    }

}