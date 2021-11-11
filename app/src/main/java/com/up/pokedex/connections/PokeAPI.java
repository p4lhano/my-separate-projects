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

    public void getPokemon(String nome, OnPokeDatailAPIListener listener){
        Pokemon pokemon;
        PokeConnectionTaks asyncTask = new PokeConnectionTaks(new PokeConnectionTaks.onRequestListener() {
            @Override
            public void onRequestFinish(JSONObject resultObject) {
                try {
                    Log.v("APP_POKEDEX", String.valueOf(resultObject));


                } catch (Exception e) {
                    Log.v("APP_POKEDEX","Não possivel iniciar. Erro: ",e);
                    listener.onFisinh(null);
                }

            }
        });
    }

    public interface OnPokeAPIListener {
        void onFisinh(ArrayList<Pokemon> pokemons);
    }
    public interface OnPokeDatailAPIListener {
        void onFisinh(Pokemon pokemon);
    }


}
