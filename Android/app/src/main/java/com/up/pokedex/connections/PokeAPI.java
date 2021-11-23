package com.up.pokedex.connections;

import android.util.Log;

import com.up.pokedex.models.Pokemon;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
/*
Vai solicitar a conexão para a classe PokeConnectionTaks e com o retorno dessa classe vai transformar nos dados necessáros.
Tanto para os pokemons , tanto para as demais requisições ao PokeAPI.co. Ex: Tipo de pokemons, ataques, ...
*/
public class PokeAPI {

    public void getPokemons( OnPokeAPIListener listener ){
        ArrayList<Pokemon> pokemons = new ArrayList<Pokemon>();
        PokeConnectionTaks asyncTask = new PokeConnectionTaks(new PokeConnectionTaks.onRequestListener() {
            @Override
            public void onRequestFinish(JSONObject jsonObject) {
                    //PokeListActivity.this.pokemons.addAll(pokemons);
                    //recycleViewPokeList.getAdapter().notifyDataSetChanged();
                    try {
                        JSONArray results = jsonObject.getJSONArray("pokemon_species");
                        for (int i = 0; i < results.length() ; i++){

                            JSONObject pokeObject = results.getJSONObject(i);

                            String pokeUrl = pokeObject.getString("url");
                            String stringId = pokeUrl.substring(42,pokeUrl.length()-1);
                            int idPokemon = Integer.parseInt(stringId);

                            pokemons.add( new Pokemon(
                                    idPokemon,
                                    pokeObject.getString("name"),
                                    "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/"+idPokemon+".png")
                            );
                        }

                        listener.onFisinh( pokemons );

                        //atualização da tela
                        //recycleViewPokeList.getAdapter().notifyDataSetChanged();
                    } catch (Exception e) {
                        Log.v("APP_POKEDEX","Não possivel iniciar. Erro: ",e);
                        listener.onFisinh(null);
                    }

                }
            });
        asyncTask.execute("https://pokeapi.co/api/v2/generation/1");
    }

    public void getPokemon(String idPokemon, OnPokeDatailAPIListener listener){


        PokeConnectionTaks asyncTask = new PokeConnectionTaks(new PokeConnectionTaks.onRequestListener() {
            @Override
            public void onRequestFinish(JSONObject resultObject) {
                Pokemon pokemonReturned;
                try {
                    Log.v("APP_POKEDEX","Retorno pokemon trouxe: " + String.valueOf(resultObject));

                    JSONObject species = resultObject.getJSONObject("species");
                    String name = species.getString("name");
                    String image = species.getString("url");
                    image = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/" + image.substring(42,image.length()-1)  +".png";
                    ArrayList<String> types = new ArrayList<String>();
                    ArrayList<String> abilities = new ArrayList<String>();
                    ArrayList<String> moves = new ArrayList<String>();
                    ArrayList<String> stats = new ArrayList<String>();


                    JSONArray typesJSON = resultObject.getJSONArray("types");
                    for (int i = 0; i < typesJSON.length(); i++) {
                        JSONObject pokeObject = typesJSON.getJSONObject(i);
                        types.add(pokeObject.getJSONObject("type").getString("name"));
                    }

                    JSONArray abilitiesJSON = resultObject.getJSONArray("abilities");
                    for (int i = 0; i < abilitiesJSON.length(); i++) {
                        JSONObject pokeObject = abilitiesJSON.getJSONObject(i);
                        abilities.add(pokeObject.getJSONObject("ability").getString("name"));
                    }

                    JSONArray movesJSON = resultObject.getJSONArray("moves");
                    for (int i = 0; i < movesJSON.length(); i++) {
                        JSONObject pokeObject = movesJSON.getJSONObject(i);
                        moves.add( pokeObject.getJSONObject("move").getString("name") );
                    }

                    JSONArray statsJSON = resultObject.getJSONArray("stats");
                    for (int i = 0; i < statsJSON.length(); i++) {
                        JSONObject pokeObject = statsJSON.getJSONObject(i);
                        stats.add(
                                pokeObject.getJSONObject("stat").getString("name") +
                                        " : " +
                                pokeObject.getString("base_stat")
                        );
                    }


                    pokemonReturned = new Pokemon(
                            Integer.parseInt(idPokemon),
                            name,
                            image,
                            types,
                            abilities,
                            moves);
                    pokemonReturned.setStats(stats);

                    listener.onFisinh( pokemonReturned );

                } catch (Exception e) {
                    Log.v("APP_POKEDEX","Não possivel iniciar. Erro: ",e);
                    listener.onFisinh(null);
                }

            }
        });
        Log.v("POKEDEX","Requisitando: https://pokeapi.co/api/v2/pokemon/" + idPokemon);
        asyncTask.execute("https://pokeapi.co/api/v2/pokemon/" + idPokemon,
                "GET");
    }

    public interface OnPokeAPIListener {
        void onFisinh(ArrayList<Pokemon> pokemons);
    }
    public interface OnPokeDatailAPIListener {
        void onFisinh(Pokemon pokemon);
    }


}
