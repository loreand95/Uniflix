package it.uniflix.app;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import org.apache.commons.lang3.StringUtils;

import java.util.List;

public class MovieRecyclerViewAdapter extends RecyclerView.Adapter<MovieRecyclerViewAdapter.ViewHolder> {

    private List<Movie> mData;
    private LayoutInflater mInflater;
    private Context context;

    // data is passed into the constructor
    MovieRecyclerViewAdapter(Context context, List<Movie> data) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
        this.context = context;
    }

    // inflates the row layout from xml when needed
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.recyclerview_row, parent, false);
        return new ViewHolder(view);
    }

    // binds the data to the TextView in each row
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Movie movie = mData.get(position);
        holder.title.setText(movie.getTitle());

        String trimmed_ov =StringUtils.abbreviate(movie.getOverview(), 150);
        holder.overview.setText(trimmed_ov);
        Picasso.get().load(movie.getPosterPath()).into(holder.poster);
    }

    // total number of rows
    @Override
    public int getItemCount() {
        return mData.size();
    }


// stores and recycles views as they are scrolled off screen
public class ViewHolder extends RecyclerView.ViewHolder {
    TextView title;
    TextView overview;
    ImageView poster;


    ViewHolder(View itemView) {
        super(itemView);
        title = itemView.findViewById(R.id.movie_title);
        overview = itemView.findViewById(R.id.movie_overview);
        poster = itemView.findViewById(R.id.movie_poster);

        // Define the click event on item
        itemView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                // Open another Activity and pass to it the right city
                Movie movie = mData.get(getAdapterPosition());
                Intent intent = new Intent(context, ReviewsActivity.class);
                intent.putExtra("movie", movie);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }

        });
    }

    }
}