package dev.IESFranciscodelosRios.Domain.Model;

import java.util.Objects;

public class User {
    private String nickname;

    public User(String nickname) {
        this.nickname = nickname;
    }

    public User(){
        this(" ");
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        return Objects.equals(nickname, user.nickname);
    }
    @Override
    public String toString() {
        return "User{" +
                "nickname='" + nickname + '\'' +
                '}';
    }
}
