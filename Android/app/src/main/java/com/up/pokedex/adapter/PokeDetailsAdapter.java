package com.up.pokedex.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.up.pokedex.R;
import com.up.pokedex.models.Pokemon;

import java.util.ArrayList;

public class PokeDetailsAdapter extends RecyclerView.Adapter<PokeDetailsAdapter.PokeViewHoulder> {

    private Pokemon pokemon;
    private ArrayList<String> details;
    private  OnPokemonStringClickListener listenerPokemon;

    public PokeDetailsAdapter(ArrayList<String> details, OnPokemonStringClickListener listenerPokemon){
        this.details = details;
        this.listenerPokemon = listenerPokemon;
    }



    @NonNull
    @Override
    public PokeViewHoulder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.view_itens_details,parent,false);
        return new PokeViewHoulder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PokeViewHoulder holder, int position) {
        String stringPokemon = details.get(position);
        TextView textView = holder.itemView.findViewById(R.id.view_itens_details_text);
        textView.setText(stringPokemon);
    }

    @Override
    public int getItemCount() {
        return details.size();
    }

    public class PokeViewHoulder extends RecyclerView.ViewHolder{

        public PokeViewHoulder(@NonNull View itemView) {
            super(itemView);
            

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    String pokemon = details.get(position);
                    listenerPokemon.OnPokemonStringClickListener(pokemon);
                }
            });

        }
    }

    public interface OnPokemonStringClickListener{
        void OnPokemonStringClickListener(String pokemon);
    }
}
