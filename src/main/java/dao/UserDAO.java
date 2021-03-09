package dao;

import models.Users;

import java.util.List;

public interface UsersDAO {
    List<Users> getAllUsers();

    void addUser(Users users);

    Users findUserById(int id);

    void updateUser(int departmentId, String position, String role, String name, Users user);

    void updateUser(Users user, String name, String position, String role, int departmentId);

    void clearAllUsers();

//    static User getUserById(int usersId) {
//        return null;
//    }

    Object getAllUser();

//    void add(User users);

    static Users getUserById(int id) {
        return null;
    }
}