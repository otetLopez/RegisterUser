package com.f19.rosette_768425_ft;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ImgAdapter extends BaseAdapter {
    Context context;
    int[] imageIcons;
    private int[] imgState = {-1, -1, -1, -1, -1, -1, -1, -1, -1};

    public ImgAdapter(Context context, int[] imageIcons) {
        this.context = context;
        this.imageIcons = imageIcons;
    }

    public int[] getImageIcons() {
        return imageIcons;
    }

    public void setImageIcons(int[] imageIcons) {
        this.imageIcons = imageIcons;
    }

    public ImgAdapter(Context context) {
        this.context = context;

    }

    @Override
    public int getCount() {
        return imageIcons.length;
    }

    @Override
    public Object getItem(int i) {
        return imageIcons[i];
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        final int position = i;
        if (view == null)
            view = LayoutInflater.from(context).inflate(R.layout.cell_item, null);
        final ImageView imageView = view.findViewById(R.id.image_view);
        imageView.setImageResource(imageIcons[i]);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(imgState[position] == -1) {
                    imageView.setImageResource(R.drawable.checked);
                    imageView.setBackgroundResource(imageIcons[position]);
                    imgState[position]=1;
                } else {
                    imageView.setImageResource(imageIcons[position]);
                    imgState[position]=-1;
                }
            }
        });

        return view;
    }
}
