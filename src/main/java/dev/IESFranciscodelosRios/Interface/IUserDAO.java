package dev.IESFranciscodelosRios.Interface;

import dev.IESFranciscodelosRios.Domain.Model.User;

public interface IUserDAO {
    public User searchUser(String User);
    public boolean newUser(User user);

}