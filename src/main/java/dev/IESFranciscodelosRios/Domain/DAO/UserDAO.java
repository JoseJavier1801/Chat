package dev.IESFranciscodelosRios.Domain.DAO;

import dev.IESFranciscodelosRios.Domain.Model.User;
import dev.IESFranciscodelosRios.Domain.Model.UserList;
import dev.IESFranciscodelosRios.Utils.XMLManager;

import javax.xml.bind.JAXBException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {

    private static UserDAO instance;
    private UserList userList;
    private final String xmlFilePath; // Ruta del XML

    private UserDAO() {
        xmlFilePath = "users.xml";
        loadUserListFromXml();
    }

    public static UserDAO getInstance(){
        if (instance == null) {
            instance = new UserDAO();
        }
        return instance;
    }

    public void addUser(User user) throws JAXBException {
        userList.getUsers().add(user);
        saveUsersToXml();
    }

    public User getUserByNickname(String nickname) {
        if (userList == null || userList.getUsers() == null) {
            // Si userList o userList.getUsers() son null, crea un nuevo XML con una lista vacía
            userList = new UserList();
            userList.setUsers(new ArrayList<>());
            try {
                saveUsersToXml(); // Guarda el XML vacío
            } catch (JAXBException e) {
                e.printStackTrace(); // Maneja la excepción de JAXB
            }
            return null;
        }

        for (User user : userList.getUsers()) {
            if (user != null && user.getNickname() != null && user.getNickname().equals(nickname)) {
                return user;
            }
        }
        return null;
    }


    public List<User> getAllUsers() {
        return userList.getUsers();
    }

    public void updateUser(User updatedUser) throws JAXBException {
        List<User> users = userList.getUsers();
        for (int i = 0; i < users.size(); i++) {
            User user = users.get(i);
            if (user.getNickname().equals(updatedUser.getNickname())) {
                users.set(i, updatedUser);
                saveUsersToXml();
                return;
            }
        }
    }

    public void deleteUser(String nickname) throws JAXBException {
        userList.getUsers().removeIf(user -> user.getNickname().equals(nickname));
        saveUsersToXml();
    }

    private void saveUsersToXml() throws JAXBException {
        XMLManager.writeXML(userList, xmlFilePath);
    }

    private void loadUserListFromXml(){
        userList = XMLManager.readXML(new UserList(), xmlFilePath);
        if (userList == null) {
            // Si no se pudo cargar desde el XML, crea una instancia vacía
            userList = new UserList();
            userList.setUsers(new ArrayList<>());
        }
    }
}