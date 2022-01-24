package it.uniflix.app;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class ReviewsActivity extends AppCompatActivity {

    private ReviewRecyclerViewAdapter adapter;
    List<SoapObject> list = new ArrayList<>();
    private RecyclerView recyclerView;

    private String TAG = "SOAPClient";

    private Movie movie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reviews);


        // set up the RecyclerView
        recyclerView = findViewById(R.id.rvResponse);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new ReviewRecyclerViewAdapter(getApplicationContext(), list);
        recyclerView.setAdapter(adapter);

        AsyncCallWS task = new AsyncCallWS();

        //in SecondActivity
        if(getIntent().getExtras() != null) {
            movie = getIntent().getParcelableExtra("movie");
            task.execute(movie.getMovieId());
        }


    }

    private class AsyncCallWS extends AsyncTask<String, Integer, Void> {

        @Override
        protected Void doInBackground(String... params) {
            Log.i(TAG, "doInBackground");

            Long movieId = null;
            try {
                movieId = Long.parseLong(params[0]);

                getReviews(movieId);
            } catch (NumberFormatException ex) {
                ex.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            Log.i(TAG, "onPostExecute");
        }

        @Override
        protected void onPreExecute() {
            Log.i(TAG, "onPreExecute");
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            Log.i(TAG, "onProgressUpdate");
        }


    }

    public void getReviews(long movieId)
    {

        // CALLING getReviews

        String NAMESPACE = "http://soap.controller.reviewservice.uniflix.it/";
        String METHOD_NAME = "getReviews";
        String WSDL_URL = "http://10.0.2.2:8080/reviewservice/review";
        String SOAP_ACTION = "";

        try {

            SoapObject Request = new SoapObject(NAMESPACE, METHOD_NAME);
            Request.addProperty("arg0", movieId);

            SoapSerializationEnvelope soapEnvelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
            soapEnvelope.dotNet = false;
            soapEnvelope.setOutputSoapObject(Request);

            HttpTransportSE transport= new HttpTransportSE(WSDL_URL);

            Log.i(TAG, "Invoking the " + METHOD_NAME + "operation");
            Log.i(TAG, "Asking the reviews for the movie with id '" + movieId + "'");
            transport.call(SOAP_ACTION, soapEnvelope);
            Vector<SoapObject> result = (Vector<SoapObject>) soapEnvelope.getResponse();
            Log.i(TAG, "Response received: '" + result + "'");

            this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    list.clear();
                    list.addAll(result);
                    Log.d(TAG, "Size: " + list.size());
                    adapter.notifyDataSetChanged();
                }
            });


        }
        catch(Exception ex) {
            Log.e(TAG, "Error: " + ex.getMessage());
        }
    }


}