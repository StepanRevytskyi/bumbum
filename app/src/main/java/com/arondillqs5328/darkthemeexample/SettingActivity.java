package com.arondillqs5328.darkthemeexample;

import android.app.TaskStackBuilder;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.CompoundButton;
import android.widget.Switch;

import java.util.Set;

public class SettingActivity extends AppCompatActivity {

    private Switch mSwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        switch (ThemeUtil.getTheme(this)) {
            case "dark":
                setTheme(R.style.DarkTheme);
                break;
            case "light":
                setTheme(R.style.AppTheme);
                break;
        }
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_setting);

        mSwitch = findViewById(R.id.switch1);

        if (getSharedPreferences("com.arondillqs5328.darkthemeexample_preference", MODE_PRIVATE).getString("theme", "light").equals("dark")) {
            mSwitch.setChecked(true);
        }

        mSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    SharedPreferences.Editor editor = getSharedPreferences("com.arondillqs5328.darkthemeexample_preference", MODE_PRIVATE).edit();
                    editor.putString("theme", "dark");
                    editor.apply();
                    restartApp();
                } else {
                    SharedPreferences.Editor editor = getSharedPreferences("com.arondillqs5328.darkthemeexample_preference", MODE_PRIVATE).edit();
                    editor.putString("theme", "light");
                    editor.apply();
                    restartApp();
                }
            }
        });
    }

    private void restartApp() {
        finish();
        TaskStackBuilder.create(SettingActivity.this)
                .addNextIntent(new Intent(this, MainActivity.class))
                .addNextIntent(new Intent(this, SettingActivity.class))
        .startActivities();
    }
}
