package com.cosminionescu.androidfall2022;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 *   Rol ViewHolder = mapare unu la unu cu obiectul pe care
 * vrem sa-l punem in UI. ViewHolder-ul este utilizat si in
 * adapter.
 */
public class MovieViewHolder extends RecyclerView.ViewHolder {

    /**
     * Imaginea atasata.
     */
    private final ImageView imageViewPoster;
    private final TextView textViewTitle, textViewCategory;

    public MovieViewHolder(@NonNull View itemView) {
        super(itemView);
        imageViewPoster = itemView.findViewById(R.id.imageViewPoster);
        textViewTitle = itemView.findViewById(R.id.textViewMovieTitle);
        textViewCategory = itemView.findViewById(R.id.textViewMovieCategory);
    }

    public ImageView getImageViewPoster() {
        return imageViewPoster;
    }

    public TextView getTextViewTitle() {
        return textViewTitle;
    }

    public TextView getTextViewCategory() {
        return textViewCategory;
    }
}
