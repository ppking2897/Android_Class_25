package com.example.user.android_class_25;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private GridView gridView;
    private MyAdapter myAdapter;
    private MyAdapter2 myAdapter2;
    private int imgs[] = {R.drawable.po1,R.drawable.po2,R.drawable.po3,
                         R.drawable.po4,R.drawable.po5,R.drawable.po6,R.drawable.po7};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridView = (GridView)findViewById(R.id.gridView);
        initGridView();
    }

    private void initGridView(){
        myAdapter = new MyAdapter(this);
        myAdapter2 = new  MyAdapter2(this);
        gridView.setAdapter(myAdapter2);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.v("brad", "i = " +i);
            }
        });
    }

    private class MyAdapter extends BaseAdapter{
        private Context context;
        MyAdapter(Context context){this.context = context;}
        @Override
        public int getCount() {
            return imgs.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            ImageView img;
            if (view == null){
                img = new ImageView(context);
                img.setLayoutParams(new GridView.LayoutParams(185, 185));
                img.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            }else{
                img = (ImageView)view;
            }
            img.setImageResource(imgs[i]);
            return img;
        }
    }



    private class MyAdapter2 extends BaseAdapter{
        private Context context;
        MyAdapter2(Context context){this.context = context;}
        @Override
        public int getCount() {
            return imgs.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null){
                view = LayoutInflater.from(context).inflate(R.layout.layout,null);
            }
            ImageView img = (ImageView)view.findViewById(R.id.layout_imgView);
            TextView title = (TextView)view.findViewById(R.id.layout_title);

            img.setImageResource(imgs[i]);
            title.setText("Img " +i);
            if (i%2==0){
                view.setBackgroundColor(Color.YELLOW);
            }
            else{
                view.setBackgroundColor(Color.WHITE);
            }


            return view;
        }
    }

}
