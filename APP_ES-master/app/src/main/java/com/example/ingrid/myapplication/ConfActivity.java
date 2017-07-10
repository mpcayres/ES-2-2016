package com.example.ingrid.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.ingrid.myapplication.banco.SuperTela;

public class ConfActivity extends SuperTela {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_conf);
        super.onCreate(savedInstanceState);
    }

    public void salvar(View view) {
        Intent intent = new Intent(this, MenuPrincipalActivity.class);
        startActivity(intent);
    }

    public void cancelar(View view) {
        Intent intent = new Intent(this, MenuPrincipalActivity.class);
        startActivity(intent);

    }
}
