package com.dant2.popularmovies;

import android.net.Uri;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;

import static android.R.id.input;

public class Utilities {
    //API key has been removed before uploading to GitHub
    private final static String API_KEY = null;
    private static URL fullMoviesURL = null;
    private static HttpURLConnection connection = null;
    public static String downloadMoviesAsJson(){
        String listOfMovies = null;
        try {

            fullMoviesURL = new URL("https://api.themoviedb.org/3/movie/popular?api_key=" + API_KEY + "&language=en-US&page=1");

        } catch (MalformedURLException e) {

            Log.v("MalformedURLException", e.toString());

        }
        if (fullMoviesURL != null){

            try {

                connection = (HttpURLConnection) fullMoviesURL.openConnection();

            } catch (IOException e) {

                Log.v("IOException", e.toString());
            }

        }
        if( connection != null){
            Log.v("tag", "made connection");
            InputStream moviesResponse;
            try {
                moviesResponse = connection.getInputStream();
                listOfMovies = inputsteamToString(moviesResponse);

            }
            catch ( IOException e){
                Log.v("IOException", e.toString());
            }

        }
        else{
            Log.v("tag", "didnt make connection");
        }

        return listOfMovies;
    }

    private static String inputsteamToString(InputStream inputStream) throws IOException {

        StringBuilder resultString = new StringBuilder();
        if(inputStream != null){

            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, Charset.forName("UTF-8"));
            BufferedReader inputReader = new BufferedReader(inputStreamReader);
            String line = inputReader.readLine();
            while(line != null){

                resultString.append(line);
                line = inputReader.readLine();

            }


        }
        Log.v("test", resultString.toString());
        return resultString.toString();
    }

    public static ArrayList<Movie> parseMoviesFromJSON(String jsonString){
        JSONObject fullMovies = null;
        JSONArray individualMovies;
        ArrayList<Movie> movieArrayList = new ArrayList<Movie>();
        try {
            fullMovies = new JSONObject(jsonString);
            individualMovies = fullMovies.getJSONArray("results");

            for(int i = 0; i < individualMovies.length(); i++){
                JSONObject currentMovie = individualMovies.getJSONObject(i);
                String name = currentMovie.getString("title");
                String releaseDate = currentMovie.getString("release_date");
                String plotSummary = currentMovie.getString("overview");
                int rating = currentMovie.getInt("vote_average");
                movieArrayList.add(i,new Movie(name, releaseDate, plotSummary,rating));
            }
        } catch (JSONException e) {
            Log.v("parseMoviesFromJSON", "failed to create JSON object");
        }

        return movieArrayList;

    }





}
