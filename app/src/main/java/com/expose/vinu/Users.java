package com.expose.vinu;


public class Users {


    private String name;
    private String password;
    private String identity;
    private String admin;
    private String data;
    private String answer;
    private String status;

    public Users(String name, String password, String identity, String admin, String data, String answer, String status) {
        this.name = name;
        this.password = password;
        this.identity = identity;
        this.admin = admin;
        this.data = data;
        this.answer = answer;
        this.status = status;
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

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = data;
    }


}
