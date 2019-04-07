package com.example.admin.movie;

import android.content.Context;
import android.content.SharedPreferences;

public class pola {
    static String Filename="Myfile";

    public static String readSharedSetting(Context ctx, String settingName, String defaultValue) {
        SharedPreferences sharedPreferences=ctx.getSharedPreferences(Filename,Context.MODE_PRIVATE);
        return sharedPreferences.getString(settingName,defaultValue);

    }
    public static void saveSharedsetting(Context ctx,String settingName,String settingValue) {
        SharedPreferences sharedPreferences = ctx.getSharedPreferences(Filename,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(settingName,settingValue);
        editor.apply();
    }
    public static void SAVE(Context ctx,String Name) {
        SharedPreferences prefs = ctx.getSharedPreferences("NAME",0);
        SharedPreferences.Editor prefEdit = prefs.edit();
        prefEdit.putString("Name",Name);
        prefEdit.commit();

    }
}
