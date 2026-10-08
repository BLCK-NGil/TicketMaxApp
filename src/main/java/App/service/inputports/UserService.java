package app.service.inputports;

import app.domain.User;

import java.util.List;

public interface UserService {

    User create(Integer id, String name, String lastName, String email, String phone, String password, String state, String city, String preferences);
    void selectById(int id);
    void update();
    List<User> selectUsers();
    void deleteUser(int id);
}
