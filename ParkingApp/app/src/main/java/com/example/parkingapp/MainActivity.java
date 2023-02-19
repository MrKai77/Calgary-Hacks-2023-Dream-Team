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

import java.util.Random;


public class MainActivity extends AppCompatActivity {

    public int generateRandomNumber(int upperBound) {
        Random random = new Random();
        int randomNumber = random.nextInt(upperBound) + 1;
        return randomNumber;
    }
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
        int eastGateParkingNumber = generateRandomNumber(20);
        int lotAParkingNumber = generateRandomNumber(20);
        int lotBParkingNumber = generateRandomNumber(20);
        int lotParkingLot1 = generateRandomNumber(20);
        int lotParkingLot2 = generateRandomNumber(20);
        int lotParkingLot3 = generateRandomNumber(20);
        int lotParkingLot4 = generateRandomNumber(20);
        int lotParkingLot5 = generateRandomNumber(20);
        int lotParkingLot6 = generateRandomNumber(20);
        int lotParkingLot6A = generateRandomNumber(20);
        int lotParkingLot7 = generateRandomNumber(20);
        int lotParkingLot8 = generateRandomNumber(20);
        int lotParkingLot9 = generateRandomNumber(20);
        Drawable drawable = ContextCompat.getDrawable(MainActivity.this, R.drawable.eastgateparkade_green);
        Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();



        btn.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {


                displayParkingSpot.setText("East Gate Parking " + eastGateParkingNumber + "/20" + "\n" + "Lot A Parking " + lotAParkingNumber + "/20" + "\n" + "Lot B Parking " + lotBParkingNumber + "/20" + "\n" + "Lot B Parking " + lotBParkingNumber + "/20" + "\n" + "Lot 1 Parking " + lotParkingLot1 + "/20" + "\n" + "Lot 2 Parking " + lotParkingLot2 + "/20" + "\n" + "Lot 3 Parking " + lotParkingLot3 + "/20" + "\n" + "Lot 4 Parking " + lotParkingLot4 + "/20" + "\n" + "Lot 5 Parking " + lotParkingLot5 + "/20" + "\n" + "Lot 6 Parking " + lotParkingLot6 + "/20" + "\n" + "Lot 7 Parking " + lotParkingLot7 + "/20" + "\n" + "Lot 8 Parking " + lotParkingLot8 + "/20" + "\n" + "Lot 9 Parking " + lotParkingLot9 + "/20" + "\n" );

            }
        });

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