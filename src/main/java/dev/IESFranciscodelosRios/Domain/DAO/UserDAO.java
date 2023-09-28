package dev.IESFranciscodelosRios.Domain.DAO;

import dev.IESFranciscodelosRios.Domain.Model.User;
import dev.IESFranciscodelosRios.Interface.IUserDAO;
import dev.IESFranciscodelosRios.Utils.XMLManager;

public class UserDAO implements IUserDAO {

    private static UserDAO instance;
    private XMLManager xmlManager;

    private UserDAO() {
        xmlManager=new XMLManager();
    }


    public static UserDAO getInstance() {
        if (instance == null) {
            instance = new UserDAO();
        }
        return instance;
    }

    @Override
    public User searchUser() {
        //buscar usuario en el xml
        User user = new User(); // Crea un objeto User vacío
        user = xmlManager.readXML(user, "usuarios.xml"); // Lee el usuario desde el XML
        return user;
    }

    @Override
    public boolean newUser(User user) {
        return xmlManager.writeXML(user, "usuarios.xml"); // Escribe el usuario en el XML
    }
}

