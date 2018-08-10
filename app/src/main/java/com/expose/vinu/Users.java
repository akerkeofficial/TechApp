package com.expose.vinu;


public class Users {


    private String name;
    private String password;
    private String identity;
    private String admin;

    public Users(String name, String password, String identity, String admin) {
        this.name = name;
        this.password = password;
        this.identity = identity;
        this.admin = admin;
    }

    public Users() {

    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }
    public String getAdmin() {
        return admin;
    }

    public void setAdmin(String admin) {
        this.admin = admin;
    }
}
