package com.example.ingrid.myapplication;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import com.example.ingrid.myapplication.banco.*;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import it.sephiroth.android.library.tooltip.Tooltip;

public class PeriodicoActivity extends SuperTela {

    private EditText editNome;
    private EditText editHoraIni;
    private EditText editHoraFin;
    private EditText editNotas;
    private TextView textFrequencia;
    private TimePickerDialog horaIni_Dialog, horaFin_Dialog;
    private Time horaIniPicker, horaFinPicker;
    public int segunda, terca, quarta, quinta, sexta, sabado, domingo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_periodico);
        super.onCreate(savedInstanceState);

        editNome = (EditText) findViewById(R.id.editNome);
        editHoraIni = (EditText) findViewById(R.id.editHoraIni);
        editHoraFin = (EditText) findViewById(R.id.editHoraFin);
        editNotas = (EditText) findViewById(R.id.editNotas);
        textFrequencia = (TextView) findViewById(R.id.textFrequencia);

        Calendar data_atual = Calendar.getInstance();
        int hour = data_atual.get(Calendar.HOUR_OF_DAY);
        int minute = data_atual.get(Calendar.MINUTE);

        horaIni_Dialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {

            public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                horaIniPicker =  new Time(selectedHour, selectedMinute, 0);

                SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss", Locale.ENGLISH);
                editHoraIni.setText(format.format(horaIniPicker));
            }

        }, hour, minute, true);

        editHoraIni.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                horaIni_Dialog.show();
                horaIni_Dialog.getButton(DialogInterface.BUTTON_NEUTRAL).setTextColor(getResources().getColor(R.color.material_blue_500));
                horaIni_Dialog.getButton(DialogInterface.BUTTON_NEGATIVE).setTextColor(getResources().getColor(R.color.material_blue_500));
                horaIni_Dialog.getButton(DialogInterface.BUTTON_POSITIVE).setTextColor(getResources().getColor(R.color.material_blue_500));
            }
        });

        horaFin_Dialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {

            public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                horaFinPicker =  new Time(selectedHour, selectedMinute, 0);

                SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss", Locale.ENGLISH);
                editHoraFin.setText(format.format(horaFinPicker));
            }

        }, hour, minute, true);

        editHoraFin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                horaFin_Dialog.show();
                horaFin_Dialog.getButton(DialogInterface.BUTTON_NEUTRAL).setTextColor(getResources().getColor(R.color.material_blue_500));
                horaFin_Dialog.getButton(DialogInterface.BUTTON_NEGATIVE).setTextColor(getResources().getColor(R.color.material_blue_500));
                horaFin_Dialog.getButton(DialogInterface.BUTTON_POSITIVE).setTextColor(getResources().getColor(R.color.material_blue_500));
            }
        });

        if(textFrequencia != null){
            textFrequencia.setOnClickListener( new View.OnClickListener()  {
                @Override
                public void onClick(View v) {
                    final ArrayList mSelectedItems = new ArrayList();  // Where we track the selected items
                    AlertDialog.Builder builder = new AlertDialog.Builder(PeriodicoActivity.this);
                    // Set the dialog title
                    builder.setTitle(R.string.frequencia)
                            // Specify the list array, the items to be selected by default (null for none),
                            // and the listener through which to receive callbacks when items are selected
                            .setMultiChoiceItems(R.array.week_days, null,
                                    new DialogInterface.OnMultiChoiceClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                                            if (isChecked) {
                                                // If the user checked the item, add it to the selected items
                                                // 0 - segunda
                                                // 1 - terca
                                                // 2 - quarta
                                                // 3 - quinta
                                                // 4 - sexta
                                                // 5 - sabado
                                                // 6 - domingo
                                                mSelectedItems.add(which);
                                                Log.d ("TAG","selected item" + which);
                                            } else if (mSelectedItems.contains(which)) {
                                                // Else, if the item is already in the array, remove it
                                                mSelectedItems.remove(Integer.valueOf(which));
                                            }
                                        }
                                    })
                            // Set the action buttons
                            .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                                @Override

                                public void onClick(DialogInterface dialog, int id) {
                                    // User clicked OK, so save the mSelectedItems results somewhere
                                    // or return them to the component that opened the dialog
                                    if(mSelectedItems.contains(0)){
                                        segunda = 1;
                                    }else{
                                        segunda = 0;
                                    }

                                    if(mSelectedItems.contains(1)){
                                        terca = 1;
                                    }else{
                                        terca = 0;
                                    }

                                    if(mSelectedItems.contains(2)){
                                        quarta = 1;
                                    }else{
                                        quarta = 0;
                                    }

                                    if(mSelectedItems.contains(3)){
                                        quinta = 1;
                                    }else{
                                        quinta = 0;
                                    }

                                    if(mSelectedItems.contains(4)){
                                        sexta = 1;
                                    }else{
                                        sexta = 0;
                                    }

                                    if(mSelectedItems.contains(5)){
                                        sabado = 1;
                                    }else{
                                        sabado = 0;
                                    }

                                    if(mSelectedItems.contains(6)){
                                        domingo = 1;
                                    }else{
                                        domingo = 0;
                                    }


                                }
                            })
                            .setNegativeButton(R.string.cancelar, new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int id) {
                                }
                            });

                    AlertDialog alert11 = builder.create();
                    alert11.show();
                }
            });
        }
    }

    public void recorrente(View view) {

        Intent intent = new Intent(this, RecorrenteActivity.class);

        Periodico periodico = new Periodico();
        String Nome = editNome.getText().toString();
        String HoraIni = editHoraIni.getText().toString();
        String HoraFin = editHoraFin.getText().toString();
        String Notas = editNotas.getText().toString();

        periodico.setNome(Nome);

        SimpleDateFormat formatTime = new SimpleDateFormat("HH:mm:ss", Locale.ENGLISH);
        Date HoraInicial;
        try {
            HoraInicial = formatTime.parse(HoraIni);
        } catch (ParseException e){
            HoraInicial = null;
        }
        periodico.setHoraInicial((java.sql.Time)HoraInicial);
        Date HoraFinal;
        try {
            HoraFinal = formatTime.parse(HoraFin);
        } catch (ParseException e){
            HoraFinal = null;
        }
        periodico.setHoraFinal ((java.sql.Time) HoraFinal);

        periodico.setNome(Notas);
        periodico.setSegunda(segunda);
        periodico.setTerca(terca);
        periodico.setQuarta(quarta);
        periodico.setQuinta(quinta);
        periodico.setSexta(sexta);
        periodico.setSabado(sabado);
        periodico.setDomingo(domingo);


        DataBaseHelper.getInstance(this.getApplicationContext()).addPeriodico(periodico);


        startActivity(intent);

    }
    public void unico(View view) {

        Intent intent = new Intent(this, UnicoActivity.class);

        String Nome = editNome.getText().toString();
        String HoraIni = editHoraIni.getText().toString();
        String HoraFin = editHoraFin.getText().toString();
        String Notas = editNotas.getText().toString();

        Periodico periodico = new Periodico();
        periodico.setNome(Nome);

        SimpleDateFormat formatTime = new SimpleDateFormat("HH:mm:ss", Locale.ENGLISH);
        Date HoraInicial;
        try {
            HoraInicial = formatTime.parse(HoraIni);
        } catch (ParseException e){
            HoraInicial = null;
        }
        periodico.setHoraInicial((java.sql.Time)HoraInicial);
        Date HoraFinal;
        try {
            HoraFinal = formatTime.parse(HoraFin);
        } catch (ParseException e){
            HoraFinal = null;
        }
        periodico.setHoraFinal ((java.sql.Time) HoraFinal);

        periodico.setNome(Notas);
        periodico.setSegunda(segunda);
        periodico.setTerca(terca);
        periodico.setQuarta(quarta);
        periodico.setQuinta(quinta);
        periodico.setSexta(sexta);
        periodico.setSabado(sabado);
        periodico.setDomingo(domingo);

        DataBaseHelper.getInstance(this.getApplicationContext()).addPeriodico(periodico);

        startActivity(intent);

    }

    public void salvar(View view) {

        Intent intent = new Intent(this, MenuPrincipalActivity.class);

        String Nome = editNome.getText().toString();
        String HoraIni = editHoraIni.getText().toString();
        String HoraFin = editHoraFin.getText().toString();
        String Notas = editNotas.getText().toString();

        Periodico periodico = new Periodico();
        periodico.setNome(Nome);



        SimpleDateFormat formatTime = new SimpleDateFormat("HH:mm:ss", Locale.ENGLISH);
        Date HoraInicial;
        try {
            HoraInicial = formatTime.parse(HoraIni);
        } catch (ParseException e){
            HoraInicial = null;
        }
        periodico.setHoraInicial((java.sql.Time)HoraInicial);
        Date HoraFinal;
        try {
            HoraFinal = formatTime.parse(HoraFin);
        } catch (ParseException e){
            HoraFinal = null;
        }
        periodico.setHoraFinal ((java.sql.Time) HoraFinal);

        periodico.setNome(Notas);
        periodico.setSegunda(segunda);
        periodico.setTerca(terca);
        periodico.setQuarta(quarta);
        periodico.setQuinta(quinta);
        periodico.setSexta(sexta);
        periodico.setSabado(sabado);
        periodico.setDomingo(domingo);

        DataBaseHelper.getInstance(this.getApplicationContext()).addPeriodico(periodico);

        startActivity(intent);

    }

    public void cancelar(View view) {

        Intent intent = new Intent(this, MenuPrincipalActivity.class);
        startActivity(intent);

    }

}