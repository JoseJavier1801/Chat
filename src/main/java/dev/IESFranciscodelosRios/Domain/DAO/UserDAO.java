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
    private String xmlFilePath; // Ruta del XML

    private UserDAO() {
        userList = new UserList();
        userList.setUsers(new ArrayList<>());
        xmlFilePath = "users.xml";
    }

    public static UserDAO getInstance() {
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
        UserList loadedUserList = XMLManager.readXML(new UserList(), xmlFilePath);
        if (loadedUserList != null) {
            userList = loadedUserList;
        }

        for (User user : userList.getUsers()) {
            if (user.getNickname().equals(nickname)) {
                return user;
            }
        }
        return null;
    }




    public List<User> getAllUsers() {
        return userList.getUsers();
    }

    public void updateUser(User updatedUser) throws JAXBException {
        for (int i = 0; i < userList.getUsers().size(); i++) {
            User user = userList.getUsers().get(i);
            if (user.getNickname().equals(updatedUser.getNickname())) {
                userList.getUsers().set(i, updatedUser);
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
        XMLManager.writeXML(userList, xmlFilePath, UserList.class);
    }
}
