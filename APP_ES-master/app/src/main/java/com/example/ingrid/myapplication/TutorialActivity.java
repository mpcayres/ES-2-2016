package com.example.ingrid.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;


public class TutorialActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial);

        Intent intent = getIntent();

    }
    /** Called when the user clicks the comecar button */
    public void comecar(View view) {

        Intent intent = new Intent(this, MenuPrincipalActivity.class);
        startActivity(intent);

    }
}
