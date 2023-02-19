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
        ImageView imageViewEastGateRed = findViewById(R.id.eastGateParkade_RED);
        ImageView imageViewLotA = findViewById(R.id.parkingLotA);
        ImageView imageViewLotARed = findViewById(R.id.parkingLotA_RED);
        ImageView imageViewLotB = findViewById(R.id.parkingLotB);
        ImageView imageViewLotBRed = findViewById(R.id.parkingLotB_RED);
        ImageView imageViewLot1 = findViewById(R.id.parkingLot1);
        ImageView imageViewLot1Red = findViewById(R.id.parkingLot1_RED);
        ImageView imageViewLot2 = findViewById(R.id.parkingLot2);
        ImageView imageViewLot2Red = findViewById(R.id.parkingLot2_RED);
        ImageView imageViewLot3 = findViewById(R.id.parkingLot3);
        ImageView imageViewLot3Red = findViewById(R.id.parkingLot3_RED);
        ImageView imageViewLot4 = findViewById(R.id.parkingLot4);
        ImageView imageViewLot4Red = findViewById(R.id.parkingLot4_RED);
        ImageView imageViewLot5 = findViewById(R.id.parkingLot5);
        ImageView imageViewLot5Red = findViewById(R.id.parkingLot5_RED);
        ImageView imageViewLot6 = findViewById(R.id.parkingLot6);
        ImageView imageViewLot6Red = findViewById(R.id.parkingLot6_RED);
        ImageView imageViewLot6A = findViewById(R.id.parkingLot6A);
        ImageView imageViewLot6ARed = findViewById(R.id.parkingLot6A_RED);
        ImageView imageViewLot7 = findViewById(R.id.parkingLot7);
        ImageView imageViewLot7Red = findViewById(R.id.parkingLot7_RED);
        ImageView imageViewLot8 = findViewById(R.id.parkingLot8);
        ImageView imageViewLot8Red = findViewById(R.id.parkingLot8_RED);
        ImageView imageViewLot9 = findViewById(R.id.parkingLot9);
        ImageView imageViewLot9Red = findViewById(R.id.parkingLot9_RED);


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