package app.services;

import app.models.Users;

import java.util.List;

public interface UserService {

    List<Users> getAll();

    void addUser(Users users);
}
