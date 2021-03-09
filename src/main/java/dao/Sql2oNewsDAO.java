
package dao;

//import models.DepartmentNews;
import models.News;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import javax.sound.midi.Soundbank;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class Sql2oNewsDAO implements NewsDAO {


    private final Sql2o sql2o;

    public Sql2oNewsDAO(Sql2o sql2o) {

        this.sql2o = sql2o;
    }

    @Override
    public void add(News news) {
        String sql = "INSERT INTO news (userId,departmentId, content, type) VALUES (:userId,:departmentId, :content, :type)";
        try (Connection conn = sql2o.open()) {
            int id = (int) conn.createQuery(sql, true)
                    .bind(news)
                    .executeUpdate()
                    .getKey();
            news.setId(id);

        } catch (Sql2oException ex) {
            System.out.println(ex);
        }

    }

    @Override
    public List<News> getAllNews() {
        try (Connection conn = sql2o.open()) {
            System.out.println(conn.createQuery("SELECT * FROM news")
                    .executeAndFetch(News.class));
            return conn.createQuery("SELECT * FROM news")
                    .executeAndFetch(News.class);

        }
    }

    @Override
    public News getNewsById(int newsId) {
        String sql = "SELECT * FROM news WHERE id = :id";
        try (Connection con = sql2o.open()) {
            return con.createQuery(sql)
                    .addParameter("id", newsId)
                    .executeAndFetchFirst(News.class);
        }
    }

    @Override
    public News getNewsByDepartment(int departmentId) {
        String sql = "SELECT * FROM news WHERE departmentId =:departmentId";
        try (Connection con = sql2o.open()) {
            return con.createQuery(sql)
                    .addParameter("departmentId", departmentId)
                    .executeAndFetchFirst(News.class);
        }
    }
}






