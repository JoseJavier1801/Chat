/**
 * La clase User representa un usuario y se utiliza para almacenar información sobre un usuario,
 * como su apodo (nickname). Esta clase también se ha configurado con anotaciones JAXB para
 * facilitar la serialización y deserialización desde XML.
 */
package dev.IESFranciscodelosRios.Domain.Model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Objects;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class User {
    // Declaramos un campo privado para almacenar el apodo del usuario.
    private String nickname;

    /**
     * Constructor de la clase User que toma un apodo como parámetro y lo establece en el objeto User.
     *
     * @param nickname El apodo del usuario.
     */
    public User(String nickname) {
        this.nickname = nickname;
    }

    /**
     * Constructor vacío de la clase User. Se utiliza para crear instancias de User sin proporcionar un apodo inicial.
     */
    public User(){
    }

    /**
     * Devuelve el apodo del usuario.
     *
     * @return El apodo del usuario.
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * Establece el apodo del usuario.
     *
     * @param nickname El apodo del usuario a establecer.
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /**
     * Sobrescribimos el método equals para comparar dos objetos User en función de sus apodos.
     *
     * @param o El objeto con el que se va a comparar.
     * @return true si los apodos son iguales, false en caso contrario.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        return Objects.equals(nickname, user.nickname);
    }

    /**
     * Sobrescribimos el método toString para proporcionar una representación de cadena legible de un objeto User.
     *
     * @return Una representación de cadena que muestra el apodo del usuario.
     */
    @Override
    public String toString() {
        return "User{" +
                "nickname='" + nickname + '\'' +
                '}';
    }
}
