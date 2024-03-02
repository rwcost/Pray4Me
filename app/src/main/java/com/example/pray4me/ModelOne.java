package com.example.pray4me;

public class ModelOne {
    public ModelOne(){

    }

    String userIdForSession;

    public void setUserId(String userId)
    {
        this.userIdForSession = userId;
    }

    public String getUserId()
    {
        return this.userIdForSession;
    }



}
