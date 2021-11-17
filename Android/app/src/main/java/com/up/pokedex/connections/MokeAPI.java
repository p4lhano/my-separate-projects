package com.up.pokedex.connections;

import com.up.pokedex.models.Pokemon;

import java.util.ArrayList;

public class MokeAPI {

    public static ArrayList<Pokemon> getPokemon(){
        ArrayList<Pokemon> pokemons = new ArrayList<Pokemon>();

        pokemons.add(new Pokemon(1,"Bulbassar","https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/1.png"));
        pokemons.add(new Pokemon(2,"ivysaur","https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/2.png"));
        pokemons.add(new Pokemon(3,"Venosaur","https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/3.png"));
        pokemons.add(new Pokemon(4,"Chamander","https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/4.png"));
        pokemons.add(new Pokemon(5,"Chamilion","https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/5.png"));
        pokemons.add(new Pokemon(6,"Charizard","https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/6.png"));


        return pokemons;
    }
}
