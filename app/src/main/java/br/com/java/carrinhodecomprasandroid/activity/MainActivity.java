package br.com.java.carrinhodecomprasandroid.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import br.com.java.carrinhodecomprasandroid.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Intent mainIntent = new Intent(MainActivity.this,RegistrarActivity.class);
        startActivity(mainIntent);
        finish();
    }
}