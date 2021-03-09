
package dao;

import models.News;
import models.User;

import java.util.List;

public interface UserDAO {

    List<User> getAllUsers();

    void add(User users);

    User getUserById(int id);
    User getUserByDepartment(int departmentId);
    News getUidByNewsPost(int userId);

}
