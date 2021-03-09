package models;

import java.security.Timestamp;
import java.util.Objects;

public class News{
    private int id;
    private int userId;
    private String type;
    private String content;
    private int departmentId;
   // private Timestamp postdate;

    public News(int id, int userId,int departmentId, String type, String content){
        this.id = id;
        this.userId = userId;
        this.content = content;
        this.type = type;
        this.departmentId=departmentId;
        //this.postdate = postdate;
    }


    public int getDepartmentId(){
        return departmentId;
    }
    public void setDepartmentId(int departmentId){
        this.departmentId =departmentId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {

        this.id = id;
    }

    public int getUserId() {

        return userId;
    }

    public void setUserId(int userId) {

        this.userId = userId;
    }

    public String getType() {

        return type;
    }

    public void setType(String type) {

        this.type = type;
    }

    public String getContent() {

        return content;
    }

    public void setContent(String content) {

        this.content = content;
    }

//    public Timestamp getPostdate() {
//
//        return postdate;
//    }
//
//    public void setPostdate(Timestamp postdate) {
//
//        this.postdate = postdate;
//    }

    @Override
    public boolean equals(Object o) {
        if ( this == o ) return true;
        if (!(o instanceof News)) return  false;
        News news = (News) o;
        return id == news.id &&
                userId == news.userId &&
                Objects.equals ( type, news.type ) &&
                Objects.equals ( departmentId, news.departmentId )&&
                Objects.equals ( content, news.content ) ;
//                Objects.equals ( postdate, news.postdate );
    }

    @Override
    public int hashCode() {

        return Objects.hash ( id, userId,departmentId, type, content);
    }
}

