package com.up.pokedex;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.up.pokedex.connections.PokeAPI;
import com.up.pokedex.models.Pokemon;

import java.util.ArrayList;

public class PokemonDetailActivity extends AppCompatActivity {
    private Pokemon pokemonLocal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemon_detail);
        TextView textViewTitle = (TextView)findViewById(R.id.text_view_name);
        ImageView imageView = (ImageView)findViewById(R.id.image_pokemon) ;
        pokemonLocal = new Pokemon();
        Intent it = getIntent();

        pokemonLocal.setNome(it.getStringExtra("pokemon"));
        Log.v("POKEDEX","Recebido: "+ pokemonLocal.getNome() );


        textViewTitle.setText( pokemonLocal.getNome() );


        new PokeAPI().getPokemon(pokemonLocal.getNome(), new PokeAPI.OnPokeDatailAPIListener() {
                    @Override
                    public void onFisinh(Pokemon pokemon) {
                        pokemonLocal = pokemon;
                        Log.v("POKEDEX","Finalizado requisição, com o resultado: " + pokemon);
                    }
                }

        );

    }
}