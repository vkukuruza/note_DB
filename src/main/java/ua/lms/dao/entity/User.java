package ua.lms.dao.entity;

import java.util.Objects;

public class User {
    private long id;
    private String email;
    private  String password;
    private String name;
    private String created_at;
    private String deleted_at;

    public User() {
    }

    public User(long id, String email, String password, String name, String created_at, String deleted_at) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.name = name;
        this.created_at = created_at;
        this.deleted_at = deleted_at;
    }

    public User(String email, String password, String name, String created_at, String deleted_at) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.created_at = created_at;
        this.deleted_at = deleted_at;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getDeleted_at() {
        return deleted_at;
    }

    public void setDeleted_at(String deleted_at) {
        this.deleted_at = deleted_at;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", created_at='" + created_at + '\'' +
                ", deleted_at='" + deleted_at + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                Objects.equals(email, user.email) &&
                Objects.equals(password, user.password) &&
                Objects.equals(name, user.name) &&
                Objects.equals(created_at, user.created_at) &&
                Objects.equals(deleted_at, user.deleted_at);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, password, name, created_at, deleted_at);
    }
}

