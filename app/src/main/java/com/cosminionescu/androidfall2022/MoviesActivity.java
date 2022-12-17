package com.cosminionescu.androidfall2022;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MoviesActivity extends AppCompatActivity {

    private List<Movie> movieList;

    private RecyclerView moviesRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies);

        moviesRecyclerView = findViewById(R.id.recyclerViewMovies);
        setupRecyclerView();
    }

    // STEP 0 => add RecyclerView in xml

    // STEP 1: get data source
    // 1.1. crate dedicated class for movie
    // 1.2. populate datasource
    private void setMovies() {
        movieList = new ArrayList<>();

        movieList.add(new Movie("Home Alone", "comedy", ""));
        movieList.add(new Movie("Harry Potter", "Fantasy", ""));
        movieList.add(new Movie("Kill Bill", "Action", ""));
        movieList.add(new Movie("Avatar", "SF", ""));
        movieList.add(new Movie("Matrix", "Action", ""));
        movieList.add(new Movie("The Light House", "SF", ""));
        movieList.add(new Movie("Annabelle", "Horror", ""));
        movieList.add(new Movie("Spiderman", "Action", ""));
    }

    // STEP 2: get costumer adapter
    // 2.1. define the ViewHolder
    // 2.2. define the Adapter
    // setAdapter...movieList

    // STEP 3: setup adapter fir RecyclerView
    // 3.1. setup LayoutManager
    // 3.2. setup adapter
    private void setMoviesLayoutManager(){
        moviesRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void setMoviesAdapter() {
        moviesRecyclerView.setAdapter(new MovieAdapter(movieList));
    }

    private void setupRecyclerView() {
        setMovies();
        setMoviesLayoutManager();
        setMoviesAdapter();
    }
}