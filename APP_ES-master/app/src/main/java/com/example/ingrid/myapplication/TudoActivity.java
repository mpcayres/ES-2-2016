package com.example.ingrid.myapplication;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.ingrid.myapplication.banco.SuperTela;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class TudoActivity extends SuperTela {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_tudo);
        super.onCreate(savedInstanceState);

        ListView listUnico = (ListView) findViewById(R.id.listUnico);
        String[] values = new String[] { "Apresentação do Trabalho Final de Engenharia de Software (10/11/2016 - 08:00-09:50)" };

        final ArrayList<String> list1 = new ArrayList<>();
        Collections.addAll(list1, values);
        final StableArrayAdapter adapter = new StableArrayAdapter(this, list1);
        listUnico.setAdapter(adapter);

        listUnico.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, final View view,
                                    int position, long id) {
                final String item = (String) parent.getItemAtPosition(position);
                view.animate().setDuration(2000).alpha(0)
                        .withEndAction(new Runnable() {
                            @Override
                            public void run() {
                                //list.remove(item);
                                //adapter.notifyDataSetChanged();
                                view.setAlpha(1);
                            }
                        });
            }

        });

        ListView listRec = (ListView) findViewById(R.id.listRec);
        String[] valuesRec = new String[] { "Trabalho de Software Básico (19:30-22:00)" };

        final ArrayList<String> list2 = new ArrayList<>();
        Collections.addAll(list2, valuesRec);
        final StableArrayAdapter adapterRec = new StableArrayAdapter(this, list2);
        listRec.setAdapter(adapterRec);

        listRec.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, final View view,
                                    int position, long id) {
                final String item = (String) parent.getItemAtPosition(position);
                view.animate().setDuration(2000).alpha(0)
                        .withEndAction(new Runnable() {
                            @Override
                            public void run() {
                                //list.remove(item);
                                //adapter.notifyDataSetChanged();
                                view.setAlpha(1);
                            }
                        });
            }

        });

        ListView listPer = (ListView) findViewById(R.id.listPer);
        String[] valuesPer = new String[] { "Engenharia de Software (Ter, Qui - 08:00-09:50)",
                "Teleinformática e Redes (Ter, Qui - 10:00-11:50)",
                "PIBIC (Qui - 15:00-16:00)", "Laboratório de Circuitos Elétricos 2 (Qui - 16:00-17:50)" };

        final ArrayList<String> list3 = new ArrayList<>();
        Collections.addAll(list3, valuesPer);
        final StableArrayAdapter adapterPer = new StableArrayAdapter(this, list3);
        listPer.setAdapter(adapterPer);

        listPer.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, final View view,
                                    int position, long id) {
                final String item = (String) parent.getItemAtPosition(position);
                view.animate().setDuration(2000).alpha(0)
                        .withEndAction(new Runnable() {
                            @Override
                            public void run() {
                                //list.remove(item);
                                //adapter.notifyDataSetChanged();
                                view.setAlpha(1);
                            }
                        });
            }

        });
    }

    private class StableArrayAdapter extends ArrayAdapter<String> {

        HashMap<String, Integer> mIdMap = new HashMap<String, Integer>();

        public StableArrayAdapter(Context context, List<String> objects) {
            super(context, R.layout.list_black_text, R.id.list_content, objects);
            for (int i = 0; i < objects.size(); ++i) {
                mIdMap.put(objects.get(i), i);
            }
        }

        @Override
        public long getItemId(int position) {
            String item = getItem(position);
            return mIdMap.get(item);
        }

        @Override
        public boolean hasStableIds() {
            return true;
        }

    }
}
