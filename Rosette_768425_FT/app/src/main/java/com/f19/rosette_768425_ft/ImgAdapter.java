package com.f19.rosette_768425_ft;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ImgAdapter extends BaseAdapter {
    Context context;
    int[] imageIcons;

    public ImgAdapter(Context context, int[] imageIcons) {
        this.context = context;
        this.imageIcons = imageIcons;
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
        if (view == null)
            view = LayoutInflater.from(context).inflate(R.layout.cell_item, null);
        ImageView imageView = view.findViewById(R.id.image_view);
        imageView.setImageResource(imageIcons[i]);

        return view;
    }
}
