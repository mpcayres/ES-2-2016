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
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class RecorrenteActivity extends SuperTela {

    private EditText editNome;
    private EditText editData;
    private EditText editHora;
    private EditText editNotas;
    private EditText editHorasPre;
    private EditText editItensTot;
    private DatePickerDialog data_Dialog;
    private TimePickerDialog hora_Dialog;
    private Date dataPicker;
    private Time horaPicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_recorrente);
        super.onCreate(savedInstanceState);

        editNome = (EditText) findViewById(R.id.editNome);
        editData = (EditText) findViewById(R.id.editData);
        editHora = (EditText) findViewById(R.id.editHora);
        editNotas = (EditText) findViewById(R.id.editNotas);
        editHorasPre = (EditText) findViewById(R.id.editHorasPre);
        editItensTot = (EditText) findViewById(R.id.editItensTot);

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
        hora_Dialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {

            public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                horaPicker =  new Time(selectedHour, selectedMinute, 0);

                SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss", Locale.ENGLISH);
                editHora.setText(format.format(horaPicker));
            }

        }, hour, minute, true);

        editHora.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hora_Dialog.show();
                hora_Dialog.getButton(DialogInterface.BUTTON_NEUTRAL).setTextColor(getResources().getColor(R.color.material_blue_500));
                hora_Dialog.getButton(DialogInterface.BUTTON_NEGATIVE).setTextColor(getResources().getColor(R.color.material_blue_500));
                hora_Dialog.getButton(DialogInterface.BUTTON_POSITIVE).setTextColor(getResources().getColor(R.color.material_blue_500));
            }
        });

    }

    public void salvar(View view) {
        Intent intent = new Intent(this, MenuPrincipalActivity.class);

        String Nome = editNome.getText().toString();
        String Data = editData.getText().toString();
        String Hora = editHora.getText().toString();
        String Notas = editNotas.getText().toString();
        String HorasPre = editHorasPre.getText().toString();
        String ItensTot = editItensTot.getText().toString();

        Recorrente recorrente = new Recorrente();
        recorrente.setNome(Nome);
        SimpleDateFormat formatTime = new SimpleDateFormat("HH:mm:ss", Locale.ENGLISH);
        Date HoraTeste;
        try {
            HoraTeste = formatTime.parse(Hora);
        } catch (ParseException e){
            HoraTeste = null;
        }
        recorrente.setHoraFinal((java.sql.Time)HoraTeste);

        SimpleDateFormat formatData = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        Date dataTeste;
        try {
            dataTeste = formatData.parse(Data);
        } catch (ParseException e){
            dataTeste = null;
        }
        recorrente.setDataFinal(dataTeste);

        recorrente.setHorasDia(Integer.parseInt(HorasPre));
        recorrente.setTotalItens(Integer.parseInt(ItensTot));
        recorrente.setNome(Notas);

        DataBaseHelper.getInstance(this.getApplicationContext()).addRecorrente(recorrente);
        startActivity(intent);
    }

    public void cancelar(View view) {
        Intent intent = new Intent(this, MenuPrincipalActivity.class);
        startActivity(intent);
    }

}
