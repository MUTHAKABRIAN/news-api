import com.google.gson.Gson;


import dao.*;
import exceptions.ApiException;
//import models.DepartmentNews;
import models.Department;
import models.News;
import models.User;
import org.sql2o.Sql2o;

import static spark.Spark.*;
import org.sql2o.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class App {
    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }



    public static void main(String[] args) {

        port(getHerokuAssignedPort());
        staticFileLocation("/public");


        Sql2oUserDAO UserDAO;
        Sql2oNewsDAO NewsDAO;
        Sql2oDepartmentDAO DepartmentDAO;

        Connection conn;
        Gson gson = new Gson();
//        String connectionString = "jdbc:h2:~/news_org.db;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
//        Sql2o sql2o =new Sql2o (connectionString, "","");
              String connectionString = "jdbc:postgresql://ec2-54-159-175-113.compute-1.amazonaws.com:5432/d9bhenh6h6u33v";
              Sql2o sql2o = new Sql2o(connectionString, "peymsvmhylrbpk", "54b10385e7dbeee788ce771034e57293897fa9a5266586a56301c9afd24d947f");
//        String connectionString =  ("jdbc:postgresql://localhost:5432/news_api");
//        Sql2o sql2o = new Sql2o(connectionString, "moringa", "Access");

        UserDAO = new Sql2oUserDAO(sql2o);
        NewsDAO = new Sql2oNewsDAO(sql2o);
        DepartmentDAO =new Sql2oDepartmentDAO(sql2o);
        conn = sql2o.open();




        get("/", "application/json", (req, res) ->
                "{\"message\":\"Welcome to the main page of Organisation news api.\"}");

        post("/news/new","application/json",(request, response) -> {
            News news =gson.fromJson(request.body(),News.class);
            NewsDAO.add(news);
            response.status(201);
            return gson.toJson(news);
        });
        get("/news","application/json", (request, response) -> {
            System.out.println(NewsDAO.getAllNews());
            return gson.toJson(NewsDAO.getAllNews());
        });
        post("/department/new", "application/json", (req, res) -> {
            Department department = gson.fromJson(req.body(), Department.class);
            DepartmentDAO.add (department);
            res.status(201);
            return gson.toJson(department);
        });
        get("/department", "application/json", (req, res) -> {
            res.type("application/json");
            return gson.toJson(DepartmentDAO.getAllDepartment());//send it back to be displayed
        });


        post("/users/new", "application/json", (req, res) -> {
            User users = gson.fromJson(req.body(), User.class);
            UserDAO.add(users);
            res.status(201);
            res.type("application/json");
            return gson.toJson(users);
        });

        get("/users", "application/json", (req, res) -> {
            res.type("application/json");
            return gson.toJson( UserDAO.getAllUsers());//send it back to be displayed
        });



        get("/users/:id", "application/json", (req, res) -> {
            int Uid = Integer.parseInt(req.params("id"));
            User usersToFind = UserDAO.getUserById(Uid);
            if(usersToFind == null) {
                throw new ApiException (404, String.format("No user with the id: \"%s\" exists", req.params("id")));
            }
            return gson.toJson(usersToFind);
        });
        get("/department/:id", "application/json", (req, res) -> { //accept a request in format JSON from an app
            int departmentId = Integer.parseInt(req.params("id"));
            Department departmentsToFind = DepartmentDAO.getDepartmentById(departmentId );
            if (departmentsToFind == null){
                throw new ApiException(404, String.format("No department with the id: \"%s\" exists", req.params("id")));
            }
            return gson.toJson(departmentsToFind );
        });
        get("/news/:id", "application/json", (req, res) -> { //accept a request in format JSON from an app
            int newsId = Integer.parseInt(req.params("id"));
            News generalNewsToFind = NewsDAO.getNewsById(newsId );
            if (generalNewsToFind== null){
                throw new ApiException(404, String.format("No news with the id: \"%s\" exists", req.params("id")));
            }
            return gson.toJson(generalNewsToFind );
        });
//        getUserByDepartment
        get("/users/:departmentId", "application/json", (req, res) -> { //accept a request in format JSON from an app
            int departmentId = Integer.parseInt(req.params("id"));
            User findUserByDep = UserDAO.getUserByDepartment(departmentId );
            if (findUserByDep== null){
                throw new ApiException(404, String.format("No news with the id: \"%s\" exists", req.params("id")));
            }
            return gson.toJson(findUserByDep );
        });

        get("/news/:departmentId", "application/json", (req, res) -> { //accept a request in format JSON from an app
            int departmentNewsId= Integer.parseInt(req.params("id"));
            News newsToFind = NewsDAO.getNewsByDepartment(departmentNewsId );
            if (newsToFind== null){
                throw new ApiException(404, String.format("No news with the id: \"%s\" exists", req.params("id")));
            }
            return gson.toJson(newsToFind );
        });



        //FILTERS
        exception(ApiException.class, (exception, req, res) -> {
            ApiException err = (ApiException) exception;
            Map<String, Object> jsonMap = new HashMap<>();
            jsonMap.put("status", err.getStatusCode());
            jsonMap.put("errorMessage", err.getMessage());
            res.type("application/json");
            res.status(err.getStatusCode());
            res.body(gson.toJson(jsonMap));
        });
        after((req, res) -> {
            res.type("application/json");
        });
    }
}