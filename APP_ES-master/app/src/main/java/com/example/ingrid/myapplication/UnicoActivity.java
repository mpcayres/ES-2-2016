package com.example.ingrid.myapplication;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import com.example.ingrid.myapplication.banco.*;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class UnicoActivity extends SuperTela {
    private EditText editNome;
    private EditText editData;
    private EditText editHoraIni;
    private EditText editHoraFin;
    private EditText editNotas;
    private DatePickerDialog data_Dialog;
    private TimePickerDialog horaIni_Dialog, horaFin_Dialog;
    private Date dataPicker;
    private Time horaIniPicker, horaFinPicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_unico);
        super.onCreate(savedInstanceState);

        editNome = (EditText) findViewById(R.id.editNome);
        editData = (EditText) findViewById(R.id.editData);
        editHoraIni = (EditText) findViewById(R.id.editHoraIni);
        editHoraFin = (EditText) findViewById(R.id.editHoraFin);
        editNotas = (EditText) findViewById(R.id.editNotas);

        Calendar data_atual = Calendar.getInstance();
        data_Dialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {

            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                dataPicker =  new Date(year - 1900, monthOfYear, dayOfMonth);

                SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
                editData.setText(format.format(dataPicker));
            }

        }, data_atual.get(Calendar.YEAR), data_atual.get(Calendar.MONTH), data_atual.get(Calendar.DAY_OF_MONTH));

        editData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data_Dialog.show();
                data_Dialog.getButton(DialogInterface.BUTTON_NEUTRAL).setTextColor(getResources().getColor(R.color.material_blue_500));
                data_Dialog.getButton(DialogInterface.BUTTON_NEGATIVE).setTextColor(getResources().getColor(R.color.material_blue_500));
                data_Dialog.getButton(DialogInterface.BUTTON_POSITIVE).setTextColor(getResources().getColor(R.color.material_blue_500));
            }
        });

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
    }

    public void recorrente(View view) {
        Intent intent = new Intent(this, RecorrenteActivity.class);
        String Nome = editNome.getText().toString();
        String Data = editData.getText().toString();
        String HoraIni = editHoraIni.getText().toString();
        String HoraFin = editHoraFin.getText().toString();
        String Notas = editNotas.getText().toString();

        Unico unico = new Unico();
        unico.setNome(Nome);
        SimpleDateFormat formatTime = new SimpleDateFormat("HH:mm:ss", Locale.ENGLISH);
        Date HoraInicial;
        try {
            HoraInicial = formatTime.parse(HoraIni);
        } catch (ParseException e){
            HoraInicial = null;
        }
        unico.setHoraInicial((java.sql.Time) HoraInicial);
        Date HoraFinal;
        try {
            HoraFinal = formatTime.parse(HoraFin);
        } catch (ParseException e){
            HoraFinal = null;
        }
        unico.setHoraFinal ((java.sql.Time) HoraFinal);

        SimpleDateFormat formatData = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        Date dataTeste;
        try {
            dataTeste = formatData.parse(Data);
        } catch (ParseException e){
            dataTeste = null;
        }
        unico.setData(dataTeste);
        unico.setNome(Notas);

        DataBaseHelper.getInstance(this.getApplicationContext()).addUnico(unico);

        startActivity(intent);

    }
    public void salvar(View view) {
        Intent intent = new Intent(this, MenuPrincipalActivity.class);
        String Nome = editNome.getText().toString();
        String Data = editData.getText().toString();
        String HoraIni = editHoraIni.getText().toString();
        String HoraFin = editHoraFin.getText().toString();
        String Notas = editNotas.getText().toString();

        Unico unico = new Unico();
        unico.setNome(Nome);
        SimpleDateFormat formatTime = new SimpleDateFormat("HH:mm:ss", Locale.ENGLISH);
        Date HoraInicial;
        try {
            HoraInicial = formatTime.parse(HoraIni);
        } catch (ParseException e){
            HoraInicial = null;
        }
        unico.setHoraInicial((java.sql.Time) HoraInicial);
        Date HoraFinal;
        try {
            HoraFinal = formatTime.parse(HoraFin);
        } catch (ParseException e){
            HoraFinal = null;
        }
        unico.setHoraFinal ((java.sql.Time) HoraFinal);

        SimpleDateFormat formatData = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        Date dataTeste;
        try {
            dataTeste = formatData.parse(Data);
        } catch (ParseException e){
            dataTeste = null;
        }
        unico.setData(dataTeste);
        unico.setNome(Notas);

        DataBaseHelper.getInstance(this.getApplicationContext()).addUnico(unico);

        startActivity(intent);

    }

    public void cancelar(View view) {
        Intent intent = new Intent(this, MenuPrincipalActivity.class);
        startActivity(intent);

    }
}
