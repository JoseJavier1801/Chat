package dev.IESFranciscodelosRios.Domain.DAO;

import dev.IESFranciscodelosRios.Domain.Model.User;
import dev.IESFranciscodelosRios.Domain.Model.UserList;
import dev.IESFranciscodelosRios.Utils.XMLManager;

import javax.xml.bind.JAXBException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    // Instancia única del DAO (patrón Singleton)
    private static UserDAO instance;

    // Lista de usuarios y ruta del archivo XML donde se almacenan los datos
    private UserList userList;
    private final String xmlFilePath; // Ruta del XML

    // Constructor privado para asegurar la instancia única y carga inicial de datos
    private UserDAO() {
        xmlFilePath = "users.xml";
        loadUserListFromXml();
    }

    /**
     * Obtiene la instancia única del DAO utilizando el patrón Singleton.
     *
     * @return La instancia única del UserDAO.
     */
    public static UserDAO getInstance() {
        if (instance == null) {
            instance = new UserDAO();
        }
        return instance;
    }


    /**
     * Agrega un nuevo usuario a la lista y guarda los datos en el archivo XML.
     *
     * @param user El usuario a agregar.
     * @throws JAXBException Si ocurre un error durante la escritura del archivo XML.
     */
    public void addUser(User user) throws JAXBException {
        userList.getUsers().add(user);
        saveUsersToXml();
    }
    /**
     * Obtiene un usuario por su apodo (nickname).
     *
     * @param nickname El apodo del usuario a buscar.
     * @return El usuario con el apodo especificado, o null si no se encuentra.
     */
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

    /**
     * Obtiene todos los usuarios en la lista.
     *
     * @return Una lista de todos los usuarios.
     */
    public List<User> getAllUsers() {
        // Devuelve una lista que contiene a todos los usuarios almacenados en userList.
        return userList.getUsers();
    }

    /**
     * Actualiza un usuario existente y guarda los datos actualizados en el archivo XML.
     *
     * @param updatedUser El usuario actualizado.
     * @throws JAXBException Si ocurre un error durante la escritura del archivo XML.
     */
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

    /**
     * Elimina un usuario por su apodo (nickname) y guarda los datos actualizados en el archivo XML.
     *
     * @param nickname El apodo del usuario a eliminar.
     * @throws JAXBException Si ocurre un error durante la escritura del archivo XML.
     */
    public void deleteUser(String nickname) throws JAXBException {
        userList.getUsers().removeIf(user -> user.getNickname().equals(nickname));
        saveUsersToXml();
    }

    // Métodos que manejan la lectura y escritura del archivo XML

    /**
     * Guarda los datos de la lista de usuarios en un archivo XML.
     *
     * @throws JAXBException Si ocurre un error durante la escritura del archivo XML.
     */
    private void saveUsersToXml() throws JAXBException {
        XMLManager.writeXML(userList, xmlFilePath);
    }

    /**
     * Carga la lista de usuarios desde un archivo XML.
     * Si no se puede cargar desde el XML, crea una instancia vacía de la lista de usuarios.
     */
    private void loadUserListFromXml(){
        userList = XMLManager.readXML(new UserList(), xmlFilePath);
        if (userList == null) {
            // Si no cargael XML, se crea una instancia vacía
            userList = new UserList();
            userList.setUsers(new ArrayList<>());
        }
    }
}