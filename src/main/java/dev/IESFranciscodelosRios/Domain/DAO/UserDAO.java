package dev.IESFranciscodelosRios.Domain.DAO;

import dev.IESFranciscodelosRios.Domain.Model.User;
import dev.IESFranciscodelosRios.Interface.IUserDAO;
import dev.IESFranciscodelosRios.Utils.XMLManager;

public class UserDAO implements IUserDAO {

    private static UserDAO instance;
    private XMLManager xmlManager;

    private UserDAO() {
        xmlManager = new XMLManager();
    }

    public static UserDAO getInstance() {
        if (instance == null) {
            instance = new UserDAO();
        }
        return instance;
    }

    @Override
    public User searchUser(String username) {
        // Aquí puedes usar XMLManager para leer un objeto User desde un archivo XML.
        User user = xmlManager.readXML(new User(), username + ".xml");
        return user;
    }

    @Override
    public boolean newUser(User user) {
        // Aquí puedes usar XMLManager para escribir un objeto User en un archivo XML.
        boolean result = xmlManager.writeXML(user, user.getNickname() + ".xml");
        return result;
    }
}