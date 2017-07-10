package com.example.ingrid.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.ingrid.myapplication.banco.SuperTela;

import it.sephiroth.android.library.tooltip.Tooltip;

public class TipoActivity extends SuperTela {
    private ImageButton help_tip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_tipo);
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
                                    .text(getResources().getString(R.string.tipo_tip))
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
    public void periodica(View view) {

        Intent intent = new Intent(this, PeriodicoActivity.class);
        startActivity(intent);

    }
    public void unica(View view) {

        Intent intent = new Intent(this, UnicoActivity.class);
        startActivity(intent);

    }
    public void recorrente(View view) {

        Intent intent = new Intent(this, RecorrenteActivity.class);
        startActivity(intent);

    }
}
