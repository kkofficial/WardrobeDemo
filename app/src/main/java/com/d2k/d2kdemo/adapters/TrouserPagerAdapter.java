package com.d2k.d2kdemo.adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.PagerAdapter;

import com.d2k.d2kdemo.Database.DatabaseTables.TopWearTable;
import com.d2k.d2kdemo.Database.DatabaseTables.TrouserWeartable;
import com.d2k.d2kdemo.R;

import java.util.ArrayList;

import static com.d2k.d2kdemo.MainActivity.trouserImageID;

public class TrouserPagerAdapter extends PagerAdapter {
    Context context;
    ArrayList<TrouserWeartable> images;
    LayoutInflater layoutInflater;


    public TrouserPagerAdapter(Context context, ArrayList<TrouserWeartable> images) {
        this.context = context;
        this.images = images;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return images.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((ConstraintLayout) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {
        View itemView = layoutInflater.inflate(R.layout.trouser_pager_item, container, false);

        ImageView imageView = (ImageView) itemView.findViewById(R.id.imageView);
//
//        final TopWearTable topWearTable =images.get(position);
//        topWearTable.g

        byte[]  imageBytes = Base64.decode(String.valueOf(images.get(position).getImage()), Base64.DEFAULT);
        Bitmap decodedImage = BitmapFactory.decodeByteArray(imageBytes, 0, imageBytes.length);
        imageView.setImageBitmap(decodedImage);

        trouserImageID = String.valueOf(images.get(position).getId());
        container.addView(itemView);

        //listening to image click
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "you clicked image " + (position + 1), Toast.LENGTH_LONG).show();
            }
        });

        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((ConstraintLayout) object);
    }
}