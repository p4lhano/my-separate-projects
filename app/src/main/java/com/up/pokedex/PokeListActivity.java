package com.up.pokedex;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.up.pokedex.adapter.PokeAdapter;
import com.up.pokedex.connections.PokeAPI;
import com.up.pokedex.models.Pokemon;

import java.util.ArrayList;

public class PokeListActivity extends AppCompatActivity {

        private RecyclerView recycleViewPokeList;
        private ArrayList<Pokemon> pokemons= new ArrayList<Pokemon>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poke_list);

        recycleViewPokeList = findViewById(R.id.recycle_poke_list);
        recycleViewPokeList.setLayoutManager(new GridLayoutManager(this,2));

        // falta configuração aqui para o PokeAdapter conseguir renderizar

        //pokemons = MokeAPI.getPokemon();

        recycleViewPokeList.setAdapter( new PokeAdapter(pokemons, new PokeAdapter.OnPokemonClickListener() {
            @Override
            public void OnPokemonClickListener(Pokemon pokemon) {
                Log.v("POKEDEX","Pokemon selecionado: " + pokemon.getNome());
                Intent intentPokemon = new Intent(PokeListActivity.this , PokemonDetailActivity.class);
                intentPokemon.putExtra("pokemon",pokemon);
                startActivity(intentPokemon);
            }
        }) );

        new PokeAPI().getPokemons(new PokeAPI.OnPokeAPIListener() {
            @Override
            public void onFisinh(ArrayList<Pokemon> pokemons) {
                PokeListActivity.this.pokemons.addAll(pokemons);
                recycleViewPokeList.getAdapter().notifyDataSetChanged();
            }
        });
    }
}