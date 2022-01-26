package it.uniflix.app;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity {

    private MovieRecyclerViewAdapter adapter;
    List<Movie> movies = new ArrayList<Movie>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // ActionBar title
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null)
        {
            actionBar.setTitle("Uniflix");
        }

        // set up the RecyclerView
        final RecyclerView recyclerView = findViewById(R.id.rvMain);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        RequestParams params = new RequestParams();
        params.add("_limit", "100");

        RestClient.get("rest/movies", params , new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                // Handle success
                Log.i("INFO", new String(responseBody));

                try {
                    JSONArray resp = new JSONArray(new String(responseBody));
                    for (int i=0; i<resp.length(); i++) {
                        JSONObject respObj = (JSONObject) resp.get(i);
                        Movie m = new Movie(respObj.getString("movieId"), respObj.getString("title"), respObj.getString("posterPath"), respObj.getString("overview"));
                        movies.add(m);
                        Log.i("MOVIE", m.toString());
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                adapter = new MovieRecyclerViewAdapter(getApplicationContext(), movies);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                // Handle error
                error.printStackTrace();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);

        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.exit:
                finish();
                System.exit(0);
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }
    }

}