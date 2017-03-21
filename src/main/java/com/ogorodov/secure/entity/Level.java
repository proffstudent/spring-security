package com.ogorodov.secure.entity;

public class Level {
    private Integer id = null;
    private String access;

    public Level(Integer id, String access) {
        this.id = id;
        this.access = access;
    }

    public Level(String access) {
        this.access = access;
    }

    public Integer getId() {
        return id;
    }

    public String getAccess(){
        return access;
    }

    public void setId(int id){
        this.id = id;
    }



    public void setAccess(String access){
        this.access = access;
    }

}
