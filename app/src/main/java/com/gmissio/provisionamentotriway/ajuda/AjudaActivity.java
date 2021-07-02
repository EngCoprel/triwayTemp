package com.gmissio.provisionamentotriway.ajuda;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ExpandableListView;

import com.gmissio.provisionamentotriway.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AjudaActivity extends AppCompatActivity {

    ExpandableListView lvAjuda;

    List<String> topicos;
    HashMap<String,List<String>> listItem;
    AjudaAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajuda);

        lvAjuda = findViewById(R.id.lvAjuda);
        topicos = new ArrayList<>();
        listItem = new HashMap<>();
        adapter = new AjudaAdapter(this, topicos, listItem);
        lvAjuda.setAdapter(adapter);
        preencherLista();
    }

    private void preencherLista() {
        topicos.add(getString(R.string.ajuda1));
        topicos.add(getString(R.string.ajuda2));
        topicos.add(getString(R.string.ajuda3));

        String[] array;

        List<String> list1 = new ArrayList<>();
        array = getResources().getStringArray(R.array.ajuda1);
        for (String item : array){
            list1.add(item);
        }
        List<String> list2 = new ArrayList<>();
        array = getResources().getStringArray(R.array.ajuda2);
        for (String item : array){
            list2.add(item);
        }
        List<String> list3 = new ArrayList<>();
        array = getResources().getStringArray(R.array.ajuda3);
        for (String item : array){
            list3.add(item);
        }

        listItem.put(topicos.get(0),list1);
        listItem.put(topicos.get(1),list2);
        listItem.put(topicos.get(2),list3);

        adapter.notifyDataSetChanged();
    }
}