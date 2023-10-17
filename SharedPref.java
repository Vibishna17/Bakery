package com.example.lab_05;



import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import androidx.annotation.NonNull;

public class SharedPref {
    private static SharedPreferences getSharedPref(@NonNull Context context){
        return context.getSharedPreferences("mypreference",Context.MODE_PRIVATE);
    }

    public static String getName(Context context){
                return getSharedPref(context).getString("name","");
    }

    public static void setName(Context context,String name){
        SharedPreferences.Editor editor = getSharedPref(context).edit();
        editor.putString("name",name);
        editor.apply();
    }
}
