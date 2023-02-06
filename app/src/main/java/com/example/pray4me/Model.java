package com.example.pray4me;

import android.text.Editable;

import java.util.ArrayList;

public class Model {
    private static Model __instance = null;

    private Model() {
    }

    public static Model instance() {
        if (__instance == null) {
            __instance = new Model();
        }
        return __instance;
    }

    ArrayList<Editable> prayerRequestList = new ArrayList<>();

    public void setPrayerRequestList(Editable prayerRequest) {
        this.prayerRequestList.add(prayerRequest);
    }

    public ArrayList<Editable> getPrayerRequestList() {
        return prayerRequestList ;
    }
}
