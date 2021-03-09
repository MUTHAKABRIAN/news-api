package dao;

//import models.DepartmentNews;
import models.News;

import java.util.List;

public interface NewsDAO {

    //create
    void add(News news);
//    read
    List<News>getAllNews();

    News getNewsById(int newsId);

    News getNewsByDepartment(int departmentId);



}