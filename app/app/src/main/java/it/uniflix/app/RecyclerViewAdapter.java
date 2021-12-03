package it.uniflix.app;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import org.ksoap2.serialization.SoapObject;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private String TAG = "RVA";

    private List<SoapObject> mData;
    private LayoutInflater mInflater;

    // data is passed into the constructor
    RecyclerViewAdapter(Context context, List<SoapObject> data) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
    }

    // inflates the row layout from xml when needed
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.adapter_reviews, parent, false);
        return new ViewHolder(view);
    }

    // binds the data to the TextView in each row
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        SoapObject review = mData.get(position);
        String author = review.getPropertyAsString("author");
        String content = review.getPropertyAsString("content");
        Log.d(TAG, "author: " + author);
        holder.authorTextView.setText(author);
        holder.contentTextView.setText(content);
    }

    // total number of rows
    @Override
    public int getItemCount() {
        Log.d(TAG, "Size: " + mData.size());
        return mData.size();
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView authorTextView;
        TextView contentTextView;

        ViewHolder(View itemView) {
            super(itemView);
            authorTextView = itemView.findViewById(R.id.review_author);
            contentTextView = itemView.findViewById(R.id.review_content);
        }
    }
}
