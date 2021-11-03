package com.up.pokedex;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.up.pokedex.models.Pokemon;

public class PokemonDetailActivity extends AppCompatActivity {
    private Pokemon pokemon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemon_detail);

        Intent it = getIntent();

        String pokemonString = it.getStringExtra("pokemon");
        Log.v("POKEDEX","Recebido: "+pokemonString);
    }
}