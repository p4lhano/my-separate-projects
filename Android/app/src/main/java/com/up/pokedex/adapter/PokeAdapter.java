package com.up.pokedex.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import com.up.pokedex.R;
import com.up.pokedex.models.Pokemon;

import java.util.ArrayList;

public class PokeAdapter extends RecyclerView.Adapter<PokeAdapter.PokeViewHoulder> {

    private ArrayList<Pokemon> pokemons;
    private  OnPokemonClickListener listenerPokemons;

    public PokeAdapter(ArrayList<Pokemon> pokemons,OnPokemonClickListener listenerPokemons){
        this.pokemons = pokemons;
        this.listenerPokemons = listenerPokemons;
    }

    @NonNull
    @Override
    public PokeViewHoulder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.view_item_pokemon,parent,false);
        return new PokeViewHoulder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PokeViewHoulder holder, int position) {
        Pokemon pokemon = pokemons.get(position);
        TextView textView = holder.itemView.findViewById(R.id.text_view_poke_nome);
        textView.setText(pokemon.getNome().substring(0,1).toUpperCase().concat(pokemon.getNome().substring(1)));
        ImageView imageView = holder.itemView.findViewById(R.id.image_view_pokemon);

        Picasso.get().load(pokemon.getImage()).into(imageView);
    }

    @Override
    public int getItemCount() {
        return pokemons.size();
    }

    public class PokeViewHoulder extends RecyclerView.ViewHolder{

        public PokeViewHoulder(@NonNull View itemView) {
            super(itemView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    Pokemon pokemon = pokemons.get(position);
                    listenerPokemons.OnPokemonClickListener(pokemon);
                }
            });
        }
    }

    public interface OnPokemonClickListener{
        void OnPokemonClickListener(Pokemon pokemon);
    }
}
