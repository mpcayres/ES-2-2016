package com.example.ingrid.myapplication;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ingrid.myapplication.banco.SuperTela;

import it.sephiroth.android.library.tooltip.Tooltip;


public class MenuPrincipalActivity extends SuperTela {
    private ImageButton help_tip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_menu_principal);
        super.onCreate(savedInstanceState);

        help_tip = (ImageButton) findViewById(R.id.help_tip);

        if(help_tip != null){
            help_tip.setOnClickListener( new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Tooltip.make(activity,
                            new Tooltip.Builder(101)
                                    .anchor(help_tip, Tooltip.Gravity.BOTTOM)
                                    .closePolicy(new Tooltip.ClosePolicy()
                                            .insidePolicy(true, true)
                                            .outsidePolicy(true, false), 200000)
                                    .text(getResources().getString(R.string.menu_tip))
                                    .fitToScreen(true)
                                    .withArrow(true)
                                    .withOverlay(true)
                                    .floatingAnimation(Tooltip.AnimationBuilder.SLOW)
                                    .build()
                    ).show();
                }
            });
        }
    }

    public void inserir(View view) {
        Intent intent = new Intent(this, TipoActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    public void calendario(View view) {
        abrirCalendario();
    }

    public void hoje(View view) {
        Intent intent = new Intent(this, HojeActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    public void tudo(View view) {
        Intent intent = new Intent(this, TudoActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    public void estatistica(View view) {
        Intent intent = new Intent(this, EstatisticaActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);

    }

    public void conf(View view) {
        Intent intent = new Intent(this, ConfActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

}
