package andro.heklaton.rsc.ui.adapter;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import andro.heklaton.rsc.R;
import andro.heklaton.rsc.model.RecyclerItem;
import andro.heklaton.rsc.ui.activity.DetailsActivity;

/**
 * Created by Andro on 11/18/2015.
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private Activity activity;
    private List<RecyclerItem> items;

    public RecyclerAdapter(Activity activity) {
        this.activity = activity;
    }

    public RecyclerAdapter(Activity activity, List<RecyclerItem> items) {
        this.activity = activity;
        this.items = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // Load image
        Picasso.with(activity)
                .load(items.get(position).getImageUrl())
                .into(holder.image);

        // Display title
        holder.title.setText(items.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        CardView cardView;
        ImageView image;
        TextView title;

        public ViewHolder(View view) {
            super(view);

            cardView = (CardView) view.findViewById(R.id.card);
            image = (ImageView) view.findViewById(R.id.image_details);
            title = (TextView) view.findViewById(R.id.title);

            cardView.setOnClickListener(cardClickListener);
        }

        View.OnClickListener cardClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, DetailsActivity.class);

                intent.putExtra(DetailsActivity.TAG_IMAGE_DETAILS, items.get(getAdapterPosition()).getImageUrl());
                intent.putExtra(DetailsActivity.TAG_TITLE_DETAILS, items.get(getAdapterPosition()).getTitle());

                if (Build.VERSION.SDK_INT > 21) {
                    ActivityOptionsCompat options = ActivityOptionsCompat.
                            makeSceneTransitionAnimation(activity, image, "item_image");
                    activity.startActivity(intent, options.toBundle());

                } else {
                    activity.startActivity(intent);
                }
            }
        };

    }
}
