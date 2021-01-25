package model;

import java.util.Objects;

public class User {
    private int id;
    private String userName;
    private String login;
    private String password;
    private Role role;

    public User() {
    }

    public User(String userName, String login, String password,Role role) {
        this.userName = userName;
        this.login = login;
        this.password = password;
        this.role = role;
    }

    public User(int id, String userName, String login, String password) {
        this.id = id;
        this.userName = userName;
        this.login = login;
        this.password = password;
    }

    public User(int id, String userName, String login, String password, Role role) {
        this.id = id;
        this.userName = userName;
        this.login = login;
        this.password = password;
        this.role = role;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                Objects.equals(userName, user.userName) &&
                Objects.equals(login, user.login) &&
                Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userName, login, password);
    }

    @Override
    public String toString() {
        return "ID: " + id +",\n" +
                "Name: " + userName +",\n" +
                "Login: " + login +",\n" +
                "Password: " + password+".";
    }
}
