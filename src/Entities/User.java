package Entities;

import java.util.UUID;

public class User {
    private final String userID;
    private final String userName;

    public User(String userName)
    {
        this.userID= UUID.randomUUID().toString();
        this.userName=userName;
    }

    public String getUserName()
    {
        return userName;
    }

    public String getUserID()
    {
        return userID;
    }

}