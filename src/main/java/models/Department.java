package models;


import java.util.Objects;

public class Department{
    private int id;
    private String name;
    private String description;
    private int userId;

    public Department(int id, int userId, String name, String description){
        this.description = description;
        this.id = id;
        this.name = name;
        this.userId =userId;
    }

    public int getUserId (){
        return userId;
    }

    public void  setUserId(int userId){
        this.userId =userId;
    }


    public int getId()  {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if ( this == o ) return true;
        if ( o == null || getClass () != o.getClass () ) return false;
        Department that = (Department) o;
        return id == that.id &&
                Objects.equals(userId,that.userId)&&
                Objects.equals ( name, that.name ) &&
                Objects.equals ( description, that.description );
    }

    @Override
    public int hashCode() {
        return Objects.hash ( id,userId, name, description );
    }

//
}