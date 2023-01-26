package com.example.IT_CONTROLNO.model;

public class Client {
    protected int id_Client;
    protected String name_client;
    protected String email_client;
    protected String phone_client;
    protected int age_client;
    protected String password_client;

    public Client(){
        this.id_Client=getId_Client();
        this.name_client=getName_client();
        this.email_client=getEmail_client();
        this.phone_client=getPhone_client();
        this.age_client=getAge_client();
        this.password_client=getPassword_client();
    }
    public Client(int id_Client,String name_client){
        this.id_Client=id_Client;
        this.name_client=name_client;
    }
    public int getId_Client() {
        return id_Client;
    }

    public void setId_Client(int id_Client) {
        this.id_Client = id_Client;
    }

    public String getName_client() {
        return name_client;
    }

    public void setName_client(String name_client) {
        this.name_client = name_client;
    }
    public String getEmail_client() {
        return email_client;
    }

    public void setEmail_client(String email_client) {
        this.email_client = email_client;
    }

    public String getPhone_client() {
        return phone_client;
    }

    public void setPhone_client(String phone_client) {
        this.phone_client = phone_client;
    }

    public int getAge_client() {
        return age_client;
    }

    public void setAge_client(int age_client) {
        this.age_client = age_client;
    }

    public String getPassword_client() {
        return password_client;
    }

    public void setPassword_client(String password_client) {
        this.password_client = password_client;
    }

}
