package com.example.pray4me;

import java.util.ArrayList;

public class SaveDataHere {
    ArrayList<String> contactList = new ArrayList<>();
    ArrayList<String> prayRequestList = new ArrayList<>();
    public SaveDataHere(){

    }

    public void saveContactData(String contact)
    {
            this.contactList.add(contact);
    }
//
    public ArrayList<String> getData(String name){
        return this.contactList;
    }

}
