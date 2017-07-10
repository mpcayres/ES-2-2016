package com.example.ingrid.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.ingrid.myapplication.banco.SuperTela;
import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.BubbleChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.BubbleData;
import com.github.mikephil.charting.data.BubbleDataSet;
import com.github.mikephil.charting.data.BubbleEntry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

public class EstatisticaActivity extends SuperTela {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_estatistica);
        super.onCreate(savedInstanceState);

        //GRÁFICO DE PIZZA
        PieChart pie = (PieChart) findViewById(R.id.piechart);

        List<PieEntry> pieEntries = new ArrayList<>();

        pieEntries.add(new PieEntry(40f, "Engenharia de Software"));
        pieEntries.add(new PieEntry(26.7f, "Teleinformática e Redes"));
        pieEntries.add(new PieEntry(24.0f, "Software Básico"));
        pieEntries.add(new PieEntry(30.8f, "Circuitos Elétricos"));
        pieEntries.add(new PieEntry(20.8f, "Francês"));

        PieDataSet pieSet = new PieDataSet(pieEntries, "Prioridades de estudo");
        pieSet.setColors(ColorTemplate.VORDIPLOM_COLORS);
        PieData Pdata = new PieData(pieSet);
        pie.setData(Pdata);
        pie.setDescription(" ");
        pie.animateY(3000, Easing.EasingOption.EaseInCirc);
        pie.animateX(3000, Easing.EasingOption.EaseInCirc);
        pie.invalidate(); // refresh*/

        //GRÁFICO DE BARRAS
        BarChart bar = (BarChart) findViewById(R.id.barchart);

        List<BarEntry> barEntries = new ArrayList<>();
        barEntries.add(new BarEntry(1f, 20f));
        barEntries.add(new BarEntry(2f, 25f));
        barEntries.add(new BarEntry(3f, 50f));
        barEntries.add(new BarEntry(4f, 45f));
        barEntries.add(new BarEntry(5f, 55f));
        barEntries.add(new BarEntry(6f, 40f));
        barEntries.add(new BarEntry(7f, 25f));

        BarDataSet barSet = new BarDataSet(barEntries, "Horas diárias de estudo");
        barSet.setColors(ColorTemplate.LIBERTY_COLORS);
        BarData bardata = new BarData(barSet);
        bardata.setBarWidth(0.9f); // set custom bar width
        bar.setDescription(" ");
        bar.setData(bardata);
        bar.setFitBars(true);
        bar.animateY(3000, Easing.EasingOption.EaseInBack);
        bar.invalidate(); // refresh

    }
}
