package com.acme.architecture.amazon.sqs.entity;

public class UserPasswordCredentials {

	private String userName;
    private String password;
    
    public UserPasswordCredentials withUserName(String userName) {
        this.setUserName(userName);
        return this;
    }
    
    public UserPasswordCredentials withPassword(String password) {
        this.setPassword(password);
        return this;
    }
    
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
