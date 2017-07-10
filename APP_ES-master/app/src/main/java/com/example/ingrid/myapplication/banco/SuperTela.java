package com.example.ingrid.myapplication.banco;

import android.app.Activity;
import android.content.ContentUris;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ingrid.myapplication.ConfActivity;
import com.example.ingrid.myapplication.EstatisticaActivity;
import com.example.ingrid.myapplication.HojeActivity;
import com.example.ingrid.myapplication.MainActivity;
import com.example.ingrid.myapplication.R;
import com.example.ingrid.myapplication.TipoActivity;
import com.example.ingrid.myapplication.TudoActivity;

import java.util.Calendar;

/**
 * Created by mp_ca on 04/11/2016.
 */

public abstract class SuperTela extends AppCompatActivity {
    private DrawerLayout drawerLayout;
    public Activity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

        activity = this;

        //CRIANDO O TOOLBAR
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_geral);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        //Inicializando NavigationView
        NavigationView navigationView = (NavigationView) findViewById(R.id.navigation_view);

        View header = navigationView.getHeaderView(0);
        TextView username = (TextView) header.findViewById(R.id.username_header);
        TextView mail = (TextView) header.findViewById(R.id.email_header);


        /*if(usuario.getNome() != null && usuario.getEmail() != null){
            if (username != null) {
                username.setText(usuario.getNome());
            }
            if (mail != null) {
                mail.setText(usuario.getEmail());
            }
        }*/

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {

                //Fecha o menu de gaveta ao clicar num item
                drawerLayout.closeDrawers();

                Intent intent;
                switch (menuItem.getItemId()) {
                    case R.id.nav_inserir:
                        intent = new Intent(activity, TipoActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);
                        return true;

                    case R.id.nav_calendario:
                        /*https://developer.android.com/guide/topics/providers/calendar-provider.html*/
                        abrirCalendario();
                        return true;

                    case R.id.nav_hoje:
                        intent = new Intent(activity, HojeActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);
                        return true;

                    case R.id.nav_tudo:
                        intent = new Intent(activity, TudoActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);
                        return true;

                    case R.id.nav_estatisticas:
                        intent = new Intent(activity, EstatisticaActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);
                        return true;

                    case R.id.nav_conf:
                        intent = new Intent(activity, ConfActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);
                        return true;

                    case R.id.nav_logout:
                        intent = new Intent(activity, MainActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);
                        return true;

                    default:
                        Toast.makeText(getApplicationContext(), "Ocorreu um erro", Toast.LENGTH_SHORT).show();
                        return true;

                }
            }
        });

        //Barra de ação
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout,
                toolbar, R.string.openDrawer, R.string.closeDrawer);

        //Necessário para mostrar o ícone do menu de gaveta
        drawerLayout.setDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
    }

    public void abrirCalendario(){
        long startMillis = Calendar.getInstance().getTimeInMillis();
        Uri.Builder builder = CalendarContract.CONTENT_URI.buildUpon();
        builder.appendPath("time");
        ContentUris.appendId(builder, startMillis);
        Intent intent = new Intent(Intent.ACTION_VIEW)
                .setData(builder.build());
        startActivity(intent);
    }

}