package andro.heklaton.rsc.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import andro.heklaton.rsc.R;

/**
 * Created by Andro on 11/18/2015.
 */
public class DetailsActivity extends AppCompatActivity {

    public static final String TAG_IMAGE_DETAILS = "image_details";
    public static final String TAG_TITLE_DETAILS = "title_details";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Bundle bundle = getIntent().getExtras();
        String imageUrl = bundle.getString(TAG_IMAGE_DETAILS);

        ImageView imgDetails = (ImageView) findViewById(R.id.image_details);
        Picasso.with(this)
                .load(imageUrl)
                .into(imgDetails);
    }
}
