package com.example.ingrid.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;

import com.example.ingrid.myapplication.banco.*;

public class CadastroActivity extends AppCompatActivity {

    private EditText editLogin;
    private EditText editSenha;
    private EditText editConfSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

        editLogin = (EditText) findViewById(R.id.editLogin);
        editSenha = (EditText) findViewById(R.id.editSenha);
        editConfSenha = (EditText) findViewById(R.id.editConfSenha);
    }
    public void salvar(View view) {
        Intent intent = new Intent(this, MainActivity.class);

        //pega dados de login digitados pelo usuário
        String Login = editLogin.getText().toString();
        //pega dados de senha digitados pelo usuário
        String Senha = editSenha.getText().toString();
        //pega dados de senha repetida digitados pelo usuário para conferir
        String ConfSenha = editConfSenha.getText().toString();

        Usuario usuario = new Usuario();
        usuario.setLogin(Login);
        usuario.setSenha(Senha);

        DataBaseHelper.getInstance(this.getApplicationContext()).addUsuario(usuario);

        startActivity(intent);

    }
    public void cancelar(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }
}
