package com.arondillqs5328.darkthemeexample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        switch (ThemeUtil.getTheme(this)) {
            case "dark":
                setTheme(R.style.DarkTheme);
                break;
            case "light":
                setTheme(R.style.AppTheme);
                break;
        }
        super.onCreate(savedInstanceState);

    }
}
