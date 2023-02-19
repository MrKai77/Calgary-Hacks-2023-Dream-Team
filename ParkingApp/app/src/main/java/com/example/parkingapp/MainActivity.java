package com.example.parkingapp;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

import androidx.core.content.ContextCompat;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {



    TextView displayParkingSpot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn = findViewById(R.id.theRefreshButton);
        displayParkingSpot = (TextView) findViewById(R.id.textView);
        ImageView imageViewEastGate = findViewById(R.id.eastGateParkade);
        ImageView imageViewLot4 = findViewById(R.id.parkingLot4);
        ImageView imageViewLot5 = findViewById(R.id.parkingLot5);
        ImageView imageViewLotB = findViewById(R.id.parkingLot6A);

        Drawable drawable = ContextCompat.getDrawable(MainActivity.this, R.drawable.eastgateparkade_green);
        Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
        imageViewEastGate.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    int x = (int) event.getX();
                    int y = (int) event.getY();

                    try {
                        int pixel = bitmap.getPixel(x, y);

                        int green = Color.green(pixel);
                        int red = Color.red(pixel);
                        int blue = Color.blue(pixel);

                        //int pixel = bitmap.getPixel(x, y);
                        int alpha;

                        if (bitmap.getConfig() == Bitmap.Config.ARGB_8888) {
                            alpha = Color.alpha(pixel);
                            alpha = alpha >>> 16;

                        } else {
                            alpha = 255; // no alpha channel, so assume fully opaque
                        }

                        imageViewEastGate.setImageDrawable(drawable);
                        displayParkingSpot.setText(" "+x+" "+y);
                        return true;
                    }
                    catch(Exception e) {
                        displayParkingSpot.setText("out of range");
                        return false;
                    }
                }
                return false;
            }
        });
//        imageView.setOnTouchListener(new View.OnTouchListener() {
//
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                if (event.getAction() == MotionEvent.ACTION_DOWN) {
//                    int x = (int) event.getX();
//                    int y = (int) (event.getY()/2);
//
//
//                    Drawable drawable = ContextCompat.getDrawable(MainActivity.this, R.drawable.eastgateparkade_green);
//                    imageView.setImageDrawable(drawable);
//
//                    Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
//                    int pixel = bitmap.getPixel(x, y);
//                    int opacity = Color.alpha(pixel);
////                    if (opacity == 0) {
//                        displayParkingSpot.setText(String.valueOf(y));
////                    }
//                    return true;
//                }
//                return false;
//            }
//        });

    }

}