package dev.IESFranciscodelosRios.Interface;

import dev.IESFranciscodelosRios.Domain.Model.User;

public interface IUserDAO {
    public User searchUser();
    public boolean newUser(User user);



}
