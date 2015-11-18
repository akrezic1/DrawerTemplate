package andro.template.drawertemplate.ui.adapter;

import android.app.Activity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import andro.template.drawertemplate.R;
import andro.template.drawertemplate.model.RecyclerItem;

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

        }

    }
}
