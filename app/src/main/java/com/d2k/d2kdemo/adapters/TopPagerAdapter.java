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
import com.d2k.d2kdemo.MainActivity;
import com.d2k.d2kdemo.R;

import java.util.ArrayList;

import static com.d2k.d2kdemo.MainActivity.imageID;

public class TopPagerAdapter extends PagerAdapter {
    Context context;
//    int images[];
    ArrayList<TopWearTable> topWearList;
    LayoutInflater layoutInflater;


    /*public TopPagerAdapter(Context context, int images[]) {
        this.context = context;
        this.images = images;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }*/

    public TopPagerAdapter(MainActivity context, ArrayList<TopWearTable> topWearList) {
        this.context = context;
        this.topWearList = topWearList;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return topWearList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((ConstraintLayout) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {
        View itemView = layoutInflater.inflate(R.layout.top_pager_item, container, false);

        ImageView imageView = (ImageView) itemView.findViewById(R.id.imageView);
        //decode base64 string to image
      byte[]  imageBytes = Base64.decode(String.valueOf(topWearList.get(position).getImage()), Base64.DEFAULT);
        Bitmap decodedImage = BitmapFactory.decodeByteArray(imageBytes, 0, imageBytes.length);
        imageView.setImageBitmap(decodedImage);
      //  imageView.setImageResource(topWearList.indexOf(position));

        container.addView(itemView);

        imageID =String.valueOf(topWearList.get(position).getId());
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
