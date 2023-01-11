package com.cosminionescu.androidfall2022;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieViewHolder> {

    /**
     * Datasource-ul nostru: elementele ce trebuie afisate.
     */
    private List<Movie> movieList;

    public MovieAdapter(List<Movie> movieList) {
        this.movieList = movieList;
    }

    /**
     *  Etapa 1:
     *
     *  Cream layout-ul. In aceasta etapa nu se intra in detalii despre
     * populare. Atat Etapa 1, cat si Etapa 2 sunt apelate una dupa
     * alta pentru fiecare element.
     * @param parent
     * @param viewType
     * @return
     */
    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater
                // contextul poate fi pasat si din MovieAdapter (?)
                .from(parent.getContext())
                // adauga, unul cate unul, elemente la parinte
                // attachToRoot == false <=> implementarea default = unul sub celalalt
                .inflate(R.layout.movie_item, parent, false);
        return new MovieViewHolder(itemView);
    }

    /**
     *  Etapa 2:
     *
     *  Populam layout-ul (luam elementele din datasource si le punem
     * in UI).
     * @param holder la el aduagam elementele pe care le dorim afisate
     *               (ale elementului dorit din datasource-ul nostru)
     * @param position pozitia elementului curent (pentru care luam
     *                 campurile inserate in holder).
     */
    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {

        /*
        Idee:
                position poate fi utilizat si pentru alte lucruri:
                pare - colorate albastru/ impare - coorate rosu
         */
        Movie currentMovie = movieList.get(position);
        holder.getTextViewTitle().setText(currentMovie.getTitle());
        holder.getTextViewCategory().setText(currentMovie.getCategory());
    }

    /**
     * Cati itemi vrem sa avem afisati in acelasi timp
     * @return nr itemi
     */
    @Override
    public int getItemCount() {
        // le punem pe toate
        return movieList.size();
    }
}
