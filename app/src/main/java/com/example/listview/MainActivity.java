package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ListView listLocais;
    private String[] itens = {
            "Angra dos Reis", "Caldas Novas", "Campos do Jordão",
            "Costa do Sauípe", "Ilhéus", "Porto Seguro", "Blumenau",
            "Praga", "Santiago", "Zurique", "Caribe", "Buenos Aires",
            "Budapeste", "Cancún", "Aruba"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listLocais = findViewById(R.id.listLocais);

        //Adaptador para a ListView. Serve para definir o layout de apresentação da ListView.
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(
            getApplicationContext(),
            android.R.layout.simple_list_item_1,
            android.R.id.text1,
            itens
        );

        //Adiciona o adaptador para a lista
        listLocais.setAdapter(adaptador);

        //Adiciona clique na Lista
        listLocais.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //String que armazena o item clicado. Convertido de item para String.
                String valorSelecionado = listLocais.getItemAtPosition(position).toString();
                //Toast é a caixa de texto que aparece temporariamente com o nome do item.
                Toast.makeText(getApplicationContext(), valorSelecionado, Toast.LENGTH_LONG).show();
            }
        });
    }
}
