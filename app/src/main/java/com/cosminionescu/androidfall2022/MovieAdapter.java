package com.cosminionescu.androidfall2022;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieViewHolder> {

    private List<Movie> movieList;

    public MovieAdapter(List<Movie> movieList) {
        this.movieList = movieList;
    }

    /**
     *  Cream layout-ul
     * @param parent
     * @param viewType
     * @return
     */
    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater
                .from(parent.getContext())
                // adauga, unul cate unul, elemente la parinte
                .inflate(R.layout.movie_item, parent, false);
        return new MovieViewHolder(itemView);
    }

    /**
     *  Populam layout-ul
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        Movie currentMovie = movieList.get(position);
        holder.getTextViewTitle().setText(currentMovie.getTitle());
        holder.getTextViewCategory().setText(currentMovie.getCategory());
    }

    /**
     * Cati itemi vrem sa avem afisat in acelasi timp
     * @return nr itemi
     */
    @Override
    public int getItemCount() {
        return movieList.size();
    }
}
