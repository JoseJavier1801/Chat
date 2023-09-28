package dev.IESFranciscodelosRios.Domain.Model;

import java.util.Objects;

public class User {

     private String Username;

    public User(String username) {
        this.Username = username;
    }

    public User() {
        this(" ");
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        return Objects.equals(Username, user.Username);
    }
    @Override
    public String toString() {
        return "Username: " + Username;
    }
}
