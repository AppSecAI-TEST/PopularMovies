package com.dant2.popularmovies;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadMoviesFromWebTask test = new loadMoviesFromWebTask();
        test.execute();
    }


    private class loadMoviesFromWebTask extends AsyncTask<Void, Void, ArrayList<Movie>>{

        @Override
        protected ArrayList<Movie> doInBackground(Void... voids) {
            Log.v("Util", "will this even run");
            String movies = Utilities.downloadMoviesAsJson();
            Log.v("Test", movies);
            ArrayList<Movie> ArrayOfmovies = Utilities.parseMoviesFromJSON(movies);
            Log.v("Array of Movies", ArrayOfmovies.toString());
            return ArrayOfmovies;
        }

        @Override
        protected void onPostExecute(ArrayList<Movie> movies) {
            String debug1 = "";
            for (Movie m:
                 movies) {
                debug1 += "Name: " + m.getName() + " Release: " + m.getReleaseDate() + " Summary: " + m.getPlotSummary() + " Rating: " + m.getRating()+ "\n\n";
            }
            Log.v("DEBUG", debug1);
            TextView debugText = (TextView) findViewById(R.id.debug_text);
            debugText.setText(debug1);
        }
    }
}
