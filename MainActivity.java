package com.example.plan_tahead;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void launchChoosePage(View v) {
        //launch new activity
        Intent i = new Intent(this, ChoosePage.class);
        startActivity(i);
    }
    public void launchReferencePage(View v) {
        //launch new activity
        Intent i = new Intent(this, reference.class);
        startActivity(i);
    }

}
