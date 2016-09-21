package com.example.diego.trabalhoandroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    Lanche lc;
    private ImageButton incluir;
    Intent i;
    ListView lista;
    int cod=0;
    static Lanche[] lanches = new Lanche[100];
    ArrayAdapter<String> adapterLista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        incluir = (ImageButton) findViewById(R.id.imageButton);
        lista = (ListView) findViewById(R.id.listView);



        adapterLista = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
        lista.setAdapter(adapterLista);
        lista.setOnItemClickListener(this);

        Lanche lanche = new Lanche();
        lanche.setNome("X-Frango");
        lanche.setCodigo(cod);
        lanche.setPreco("12.50");
        lanche.setRecheio("Pão, frango, queijo, presunto, alface, tomate, milho, batata");
        lanches[cod] = lanche;
        cod++;

        adapterLista.add(lanche.getNome());


        lanche = new Lanche();
        lanche.setNome("X-bacon");
        lanche.setCodigo(cod);
        lanche.setPreco("15.50");
        lanche.setRecheio("Pão, hamburguer, bacon, queijo, presunto, alface, tomate, milho, batata");
        lanches[cod] = lanche;
        cod++;
        adapterLista.add(lanche.getNome());

        lanche = new Lanche();
        lanche.setNome("À Moda");
        lanche.setCodigo(cod);
        lanche.setPreco("14.50");
        lanche.setRecheio("Pão, frango, salsicha, ovo, presunto, alface, tomate, milho, batata");
        lanches[cod] = lanche;
        cod++;
        adapterLista.add(lanche.getNome());

        lanche = new Lanche();
        lanche.setNome("X-Tudo");
        lanche.setCodigo(cod);
        lanche.setPreco("15.50");
        lanche.setRecheio("Pão, hamburguer, frango, ovo, salsicha, bacon, calabresa, queijo, presunto, alface, tomate, milho, batata");
        lanches[cod] = lanche;
        cod++;
        adapterLista.add(lanche.getNome());

        lanche = new Lanche();
        lanche.setNome("x-Simples");
        lanche.setCodigo(cod);
        lanche.setPreco("14.50");
        lanche.setRecheio("Pão, hamburguer, calabresa, alface, tomate, milho, batata");
        lanches[cod] = lanche;
        cod++;
        adapterLista.add(lanche.getNome());


        lanche = new Lanche();
        lanche.setNome("X-Egg");
        lanche.setCodigo(cod);
        lanche.setPreco("12.50");
        lanche.setRecheio("Pão, 2 ovos, queijo, presunto,");
        lanches[cod] = lanche;
        cod++;
        adapterLista.add(lanche.getNome());

        lanche = new Lanche();
        lanche.setNome("X-Calabresa");
        lanche.setCodigo(cod);
        lanche.setPreco("18.50");
        lanche.setRecheio("Pão, calabresa, ovo, queijo, alface, tomate, milho");
        lanches[cod] = lanche;
        cod++;
        adapterLista.add(lanche.getNome());

        lanche = new Lanche();
        lanche.setNome("X-ratão");
        lanche.setCodigo(cod);
        lanche.setPreco("12.50");
        lanche.setRecheio("Pão, 2 hamburgues, 2 frango, 2 ovos, 2 salsichas, bacon, calabresa, queijo, presunto, alface, tomate, milho");
        lanches[cod] = lanche;
        cod++;
        adapterLista.add(lanche.getNome());


             i = getIntent();
        Bundle b = i.getExtras();
        if(b != null){

            lc = (Lanche) b.get("lancheCadastrado");

            adapterLista.add(lc.getNome());

        }
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        Intent i = new Intent(getApplicationContext(), DetalhesActivity.class);
        i.putExtra("id", lanches[position].getCodigo());
        i.putExtra("nome", lanches[position].getNome());
        i.putExtra("preco", lanches[position].getPreco());
        i.putExtra("recheio", lanches[position].getRecheio());

        startActivity(i);
    }
}
