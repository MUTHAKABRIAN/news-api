package models;

import java.util.Objects;

public class Users {
    private int id;
    private String role;
    private String position;
    private int departmentId;
    private String name;

    public Users(String role, String position, int departmentId, String name) {
        this.role = role;
        this.position = position;
        this.departmentId = departmentId;
        this.name = name;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Override
    public boolean equals(Object o) {
        if ( this == o ) return true;
        if ( o == null || getClass () != o.getClass () ) return false;
        Users users = (Users) o;
        return id == users.id &&
                departmentId == users.departmentId &&
                Objects.equals ( position, users.position ) &&
                Objects.equals ( role, users.role ) &&
                Objects.equals ( name, users.name );
    }
    @Override
    public int hashCode() {
        return Objects.hash(id, departmentId, position, role, name);
    }
    public int departmentId() {
        return 0;
    }
        public int getUserName() {
            return 0;
        }

        public int getUserPosition() {
            return 0;
        }

        public int getUserRole() {
            return 0;
        }
    }


