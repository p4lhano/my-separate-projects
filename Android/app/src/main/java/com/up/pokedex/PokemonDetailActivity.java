package com.up.pokedex;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import com.up.pokedex.adapter.PokeDetailsAdapter;
import com.up.pokedex.connections.PokeAPI;
import com.up.pokedex.models.Pokemon;

public class PokemonDetailActivity extends AppCompatActivity {
    private Pokemon pokemonLocal;
    private RecyclerView listViewPokeTypes;
    private RecyclerView listViewPokeMoves;
    private TextView textViewTitle;
    private ImageView imageView ;
    private ArrayAdapter<String> ArrayAdapterPokeHabilty;
    private ListView textViewMoves;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemon_detail);
        TextView textViewTitle = (TextView)findViewById(R.id.text_view_name);
        ImageView imageView = (ImageView)findViewById(R.id.image_pokemon) ;
        textViewMoves = (ListView) findViewById(R.id.list_view_moves_pokemon);
        listViewPokeTypes = findViewById(R.id.recycle_view_typesy_pokemon);
        listViewPokeTypes.setLayoutManager(new GridLayoutManager(this,2));

        listViewPokeMoves = findViewById(R.id.recycle_view_habilty_pokemon);
        listViewPokeMoves.setLayoutManager(new GridLayoutManager(this,3));

        pokemonLocal = new Pokemon();
        Intent it = getIntent();



/*
        listViewPokeTypes.setAdapter( new PokeAdapter(pokemons, new PokeAdapter.OnPokemonClickListener() {
            @Override
            public void OnPokemonClickListener(Pokemon pokemon) {
                Log.v("POKEDEX","Pokemon selecionado: " + pokemon.getNome());
                Intent intentPokemon = new Intent(PokeListActivity.this , PokemonDetailActivity.class);
                intentPokemon.putExtra("pokemon", Integer.toString( pokemon.getId() ) );
                startActivity(intentPokemon);
            }
        }) );
*/




        pokemonLocal.setId( Integer.parseInt( it.getStringExtra("pokemon") ) );
        Log.v("POKEDEX","Recebido: "+ pokemonLocal.getId() );


        new PokeAPI().getPokemon( Integer.toString( pokemonLocal.getId() ) , new PokeAPI.OnPokeDatailAPIListener() {
                    @Override
                    public void onFisinh(Pokemon pokemon) {
                        pokemonLocal = pokemon;
                        setTitle(pokemonLocal.getNome().toUpperCase());
                        Log.v("POKEDEX","Finalizado requisição, com o resultado: " + pokemon);
                        textViewTitle.setText(pokemonLocal.getNome().substring(0,1).toUpperCase().concat(pokemonLocal.getNome().substring(1)));
                        Picasso.get().load(pokemonLocal.getImage()).into(imageView);
                        //listViewPokeTypes.getAdapter().notifyDataSetChanged();

                        listViewPokeTypes.setAdapter( new PokeDetailsAdapter(pokemonLocal.getTypes(), new PokeDetailsAdapter.OnPokemonStringClickListener() {
                            @Override
                            public void OnPokemonStringClickListener(String seleted) {
                                Log.v("POKEDEX","Selecionado: " + seleted);
                            }
                        }));

                        listViewPokeMoves.setAdapter( new PokeDetailsAdapter(pokemonLocal.getAbilities(), new PokeDetailsAdapter.OnPokemonStringClickListener() {
                            @Override
                            public void OnPokemonStringClickListener(String seleted) {
                                Log.v("POKEDEX","Selecionado: " + seleted);
                            }
                        }));

                        atualizarArray();

                    }
                }

        );

    }

    private void atualizarArray(){
        ArrayAdapterPokeHabilty = new ArrayAdapter<String>(
                this,
                R.layout.support_simple_spinner_dropdown_item,
                pokemonLocal.getMoves() );
        textViewMoves.setAdapter(ArrayAdapterPokeHabilty);
    }

}