package com.qualcomm.vuforia.samples.VuforiaSamples.app.ImageTargets;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.qualcomm.vuforia.samples.VuforiaSamples.R;

/**
 * Created by chen41283922 on 2016/4/10.
 */
public class GridViewActivity extends Activity {
    public ImageAdapter adapter;
    public GridView gridView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gridview);
        int [] image={R.drawable.shoot,R.drawable.confirm,R.drawable.shoot,R.drawable.send,R.drawable.cancel};
        adapter=new ImageAdapter(image, this);
        gridView=(GridView) findViewById(R.id.grid);
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1,
                                    int position, long arg3) {
                adapter.choiceState(position);
            }
        });
    }
}

//
//
//class ImageAdapter extends BaseAdapter {
//    private int[] image;
//    private boolean isChoice[];
//    private Context context;
//
//
//    public ImageAdapter(int[] im, Context context) {
//        this.image = im;
//        Log.i("hck", im.length + "length");
//        isChoice = new boolean[im.length];
//        for (int i = 0; i < im.length; i++) {
//            isChoice[i] = false;
//        }
//        this.context = context;
//    }
//
//
//    @Override
//    public int getCount() {
//        return image.length;
//    }
//
//
//    @Override
//    public Object getItem(int arg0) {
//        return image[arg0];
//    }
//
//
//    @Override
//    public long getItemId(int arg0) {
//        return arg0;
//    }
//
//
//    @Override
//    public View getView(int arg0, View arg1, ViewGroup arg2) {
//        View view = arg1;
//        GetView getView = null;
//        if (view == null) {
//            view = LayoutInflater.from(context).inflate(R.layout.item, null);
//            getView = new GetView();
//            getView.imageView = (ImageView) view.findViewById(R.id.image_item);
//            view.setTag(getView);
//        } else {
//            getView = (GetView) view.getTag();
//        }
//        getView.imageView.setImageDrawable(getView(arg0));
//
//        return view;
//    }
//
//    static class GetView {
//        ImageView imageView;
//    }
//
//    private LayerDrawable getView(int post) {
//
//        Bitmap bitmap = ((BitmapDrawable) context.getResources().getDrawable(image[post])).getBitmap();
//        Bitmap bitmap2 = null;
//        LayerDrawable la = null;
//        if (isChoice[post]) {
//            bitmap2 = BitmapFactory.decodeResource(context.getResources(),
//                    R.drawable.btncheck_yes);
//        }
//        if (bitmap2 != null) {
//            Drawable[] array = new Drawable[2];
//            array[0] = new BitmapDrawable(bitmap);
//            array[1] = new BitmapDrawable(bitmap2);
//            la = new LayerDrawable(array);
//            la.setLayerInset(0, 0, 0, 0, 0);   //第几张图离各边的间距
//            la.setLayerInset(1, 0, 65, 65, 0);
//        } else {
//            Drawable[] array = new Drawable[1];
//            array[0] = new BitmapDrawable(bitmap);
//            la = new LayerDrawable(array);
//            la.setLayerInset(0, 0, 0, 0, 0);
//        }
//        return la; // 返回叠加后的图
//    }
//
//    public void choiceState(int post) {
//        isChoice[post] = isChoice[post] == true ? false : true;
//        this.notifyDataSetChanged();
//    }
//}
