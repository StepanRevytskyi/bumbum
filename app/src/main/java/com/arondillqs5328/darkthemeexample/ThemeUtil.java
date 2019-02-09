package com.arondillqs5328.darkthemeexample;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;

import static android.content.Context.MODE_PRIVATE;

public class ThemeUtil {

   public static String getTheme(Context context) {
       SharedPreferences sharedPreferences =  context.getSharedPreferences("com.arondillqs5328.darkthemeexample_preference", MODE_PRIVATE);
       Log.i("TAG_L", sharedPreferences.getString("theme", "light"));
       return sharedPreferences.getString("theme", "light");
   }


}
