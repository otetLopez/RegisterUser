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
    private int[] answer = {0,1,2,3};
    private int[] checked = {-1,-1,-1,-1};

    public ImgAdapter(Context context, int[] imageIcons) {
        this.context = context;
        this.imageIcons = imageIcons;
    }

    public int[] getImageIcons() {
        return imageIcons;
    }

    public void setImageIcons(int[] imageIcons) {
        this.imageIcons = imageIcons;
        setAnswer();
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
                    imgState[position]=position;
                } else {
                    imageView.setImageResource(imageIcons[position]);
                    imgState[position]=-1;
                }
            }
        });

        return view;
    }

    private void setAnswer() {
        int idx = 0;
        for(int i=0; i<9; ++i) {
            if((imageIcons[i] == R.drawable.img1) || (imageIcons[i] == R.drawable.img2) ||
                    (imageIcons[i] == R.drawable.img3) || (imageIcons[i] == R.drawable.img4)) {
                answer[idx] = i;
                Log.i("Answers", "New answer:"+i);
                idx++;
            }
        }
    }

    public boolean checkAnswer() {
        int count = 0;
        int numCheck = 0;
        for(int i =0; i<9; ++i) {
            if((imgState[i] != -1) &&
                    ((imgState[i] == answer[0]) || (imgState[i] == answer[1]) ||
                            (imgState[i] == answer[2]) || (imgState[i] == answer[3]))) {
                Log.i("Answers", "This is answer:"+i);
                count++;
            }
        }

        Log.i("Answers", "Total count:"+count);
        if(count == 4) {
            return true;
        }
        return false;
    }
}
