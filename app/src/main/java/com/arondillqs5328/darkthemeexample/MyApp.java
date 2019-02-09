package com.arondillqs5328.darkthemeexample;

import android.app.Application;

public class MyApp extends Application {

    @Override
    public void onCreate() {
        switch (ThemeUtil.getTheme(this)) {
            case "dark":
                setTheme(R.style.DarkTheme);
                break;
            case "light":
                setTheme(R.style.AppTheme);
                break;
        }
        super.onCreate();
    }
}
