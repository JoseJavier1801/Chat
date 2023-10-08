/**
 * La clase UserList se utiliza para representar una lista de usuarios y facilitar su serialización y deserialización a/desde XML
 * utilizando anotaciones JAXB.
 */
package dev.IESFranciscodelosRios.Domain.Model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
public class UserList {
    // Declaramos un campo privado para almacenar la lista de usuarios.
    private List<User> users;

    /**
     * Devuelve la lista de usuarios.
     *
     * @return La lista de usuarios.
     */
    @XmlElement
    public List<User> getUsers() {
        return users;
    }

    /**
     * Establece la lista de usuarios.
     *
     * @param users La lista de usuarios a establecer.
     */
    public void setUsers(List<User> users) {
        this.users = users;
    }
}
