package com.qualcomm.vuforia.samples.VuforiaSamples;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends Activity {

    private ImageAdapter imgAdapter = null; // 聲明圖片資源對象
    private Gallery gallery = null;
    private ImageView imageView;

    public Integer[] imgs = { R.drawable.confirm, R.drawable.next,
            R.drawable.previous, R.drawable.shoot};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gallary);


        imageView=(ImageView)findViewById(R.id.imageView);
        gallery = (Gallery) findViewById(R.id.gallery);
        imgAdapter = new ImageAdapter(this);
        gallery.setAdapter(imgAdapter); // 設置圖片資源
        gallery.setGravity(Gravity.CENTER_HORIZONTAL); // 設置水平居中顯示
        gallery.setSelection(imgAdapter.imgs.length * 100); // 設置起始圖片顯示位置（可以用來製作gallery循環顯示效果）

        gallery.setOnItemClickListener(clickListener); // 設置點擊圖片的監聽事件（需要用手點擊才觸發，滑動時不觸發）
        gallery.setOnItemSelectedListener(selectedListener); // 設置選中圖片的監聽事件（當圖片滑到屏幕正中，則視為自動選中）
        gallery.setUnselectedAlpha(0.3f); // 設置未選中圖片的透明度
        gallery.setSpacing(40); // 設置圖片之間的間距


    }

    // 點擊圖片的監聽事件
    AdapterView.OnItemClickListener clickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Toast.makeText(MainActivity.this, "點擊圖片" + (position + 1), 100).show();
        }
    };

    // 選中圖片的監聽事件
    AdapterView.OnItemSelectedListener selectedListener = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            imageView.setImageResource(imgs[position%imgs.length]);
        }

        @Override
        public void onNothingSelected(AdapterView<?> arg0) {

        }
    };

}

class ImageAdapter extends BaseAdapter {

    private Context mContext;

    // 圖片數組源
    public Integer[] imgs = { R.drawable.confirm, R.drawable.next,
            R.drawable.previous, R.drawable.shoot};

    public ImageAdapter(Context c) {
        mContext = c;
    }

    @Override
    public int getCount() {
        return Integer.MAX_VALUE;
    }

    // 獲取圖片位置
    @Override
    public Object getItem(int position) {
        return imgs[position];
    }

    // 獲取圖片ID
    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageview = new ImageView(mContext);

        imageview.setImageResource(imgs[position % imgs.length]);
        imageview.setLayoutParams(new Gallery.LayoutParams(180, 150)); // 設置佈局圖片120×120顯示
        imageview.setScaleType(ImageView.ScaleType.CENTER); // 設置顯示比例類型
        imageview.setBackgroundColor(Color.alpha(1));
        return imageview;
    }

}
