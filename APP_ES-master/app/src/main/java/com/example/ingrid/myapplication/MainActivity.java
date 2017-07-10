package com.example.ingrid.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;


import com.example.ingrid.myapplication.banco.*;

public class MainActivity extends AppCompatActivity {
    private EditText editLogin;
    private EditText editSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

        editLogin = (EditText) findViewById(R.id.editLogin);
        editSenha = (EditText) findViewById(R.id.editSenha);
    }

    public void entrar(View view) {
        Intent intent = new Intent(this, MenuPrincipalActivity.class);
        //pega dados de login digitados pelo usuário
        String Login = editLogin.getText().toString();

        //pega dados de senha digitados pelo usuário
        String Senha = editSenha.getText().toString();
        startActivity(intent);

    }

    public void cadastrar(View view) {
        Intent intent = new Intent(this, CadastroActivity.class);
        startActivity(intent);

    }

}
