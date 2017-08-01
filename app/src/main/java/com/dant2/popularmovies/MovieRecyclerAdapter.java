package com.dant2.popularmovies;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * RecycleView Adapter for the MainActivity recycleView
 */

public class MovieRecyclerAdapter extends RecyclerView.Adapter<MovieRecyclerAdapter.MovieViewHolder> {
    int mNumberOfItems;
    ArrayList<Movie> mMovies;


    public MovieRecyclerAdapter(int numberOfItems, ArrayList<Movie> movies){
        //NumberOfItems should be the length of the ArrayList of Movies
        mNumberOfItems = numberOfItems;
        mMovies = movies;
    }


    public MovieRecyclerAdapter.MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflatedView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.movie_item, parent, false);
        return new MovieRecyclerAdapter.MovieViewHolder(inflatedView);
    }

    @Override
    public void onBindViewHolder(MovieViewHolder holder, int position) {
        Movie current = mMovies.get(position);
        ImageView imageView = holder.mMoviePic;
        TextView descText = holder.mMovieDesc;
        TextView ratingText = holder.mMovieRating;
        TextView nameText = holder.mMovieName;

        descText.setText(current.getPlotSummary());
        nameText.setText(current.getName());


    }

    @Override
    public int getItemCount() {
        return mNumberOfItems;
    }

    class MovieViewHolder extends RecyclerView.ViewHolder{
        ImageView mMoviePic;
        TextView mMovieName;
        TextView mMovieDesc;
        TextView mMovieRating;
        public MovieViewHolder(View v){
            super(v);
            mMoviePic = v.findViewById(R.id.iv_movie_image);
            mMovieName = v.findViewById(R.id.tv_movie_name);
            mMovieDesc = v.findViewById(R.id.tv_movie_description);
        }
    }
}
