package com.example.parkingapp;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

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

        ListView parkingLotList = (ListView)findViewById(R.id.parkingListView);
        String lotList[] = {
                "East Gate Parkade",
                "Lot A",
                "Lot B",
                "Lot 1",
                "Lot 2",
                "Lot 3",
                "Lot 4",
                "Lot 5",
                "Lot 6",
                "Lot 6A",
                "Lot 7",
                "Lot 8",
                "Lot 9"
        };

        final ArrayAdapter adapter = new ArrayAdapter(this,
                R.layout.list_item, R.id.textView, lotList);

        parkingLotList.setAdapter(adapter);

        parkingLotList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                /* appending Happy with festival name */
                String value = "" + adapter.getItem(position);
                /* Display the Toast */
                Toast.makeText(getApplicationContext(), value, Toast.LENGTH_SHORT).show();
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {
                setRandomAvailabilities();
            }
        });
    }

    void setRandomAvailabilities() {
        int maxGenInt = 10;

        int eastGateParkingNumber = generateRandomNumber(maxGenInt);
        int parkingLotAOccupancies = generateRandomNumber(maxGenInt);
        int parkingLotBOccupancies = generateRandomNumber(maxGenInt);
        int parkingLot1Occupancies = generateRandomNumber(maxGenInt);
        int parkingLot2Occupancies = generateRandomNumber(maxGenInt);
        int parkingLot3Occupancies = generateRandomNumber(maxGenInt);
        int parkingLot4Occupancies = generateRandomNumber(maxGenInt);
        int parkingLot5Occupancies = generateRandomNumber(maxGenInt);
        int parkingLot6Occupancies = generateRandomNumber(maxGenInt);
        int parkingLot6AOccupancies = generateRandomNumber(maxGenInt);
        int parkingLot7Occupancies = generateRandomNumber(maxGenInt);
        int parkingLot8Occupancies = generateRandomNumber(maxGenInt);
        int parkingLot9Occupancies = generateRandomNumber(maxGenInt);

        setVisibilityOfLot(parkingLocations.PARKADE, ((eastGateParkingNumber == maxGenInt) ? false : true));
        setVisibilityOfLot(parkingLocations.LOT_A, ((parkingLotAOccupancies == maxGenInt) ? false : true));
        setVisibilityOfLot(parkingLocations.LOT_B, ((parkingLotBOccupancies == maxGenInt) ? false : true));
        setVisibilityOfLot(parkingLocations.LOT_1, ((parkingLot1Occupancies == maxGenInt) ? false : true));
        setVisibilityOfLot(parkingLocations.LOT_2, ((parkingLot2Occupancies == maxGenInt) ? false : true));
        setVisibilityOfLot(parkingLocations.LOT_3, ((parkingLot3Occupancies == maxGenInt) ? false : true));
        setVisibilityOfLot(parkingLocations.LOT_4, ((parkingLot4Occupancies == maxGenInt) ? false : true));
        setVisibilityOfLot(parkingLocations.LOT_5, ((parkingLot5Occupancies == maxGenInt) ? false : true));
        setVisibilityOfLot(parkingLocations.LOT_6, ((parkingLot6Occupancies == maxGenInt) ? false : true));
        setVisibilityOfLot(parkingLocations.LOT_6A, ((parkingLot6AOccupancies == maxGenInt) ? false : true));
        setVisibilityOfLot(parkingLocations.LOT_7, ((parkingLot7Occupancies == maxGenInt) ? false : true));
        setVisibilityOfLot(parkingLocations.LOT_8, ((parkingLot8Occupancies == maxGenInt) ? false : true));
        setVisibilityOfLot(parkingLocations.LOT_9, ((parkingLot9Occupancies == maxGenInt) ? false : true));
    }


    void setVisibilityOfLot(parkingLocations location, Boolean visibility) {
        ImageView imageViewEastGateRed = findViewById(R.id.eastGateParkade_RED);
        ImageView imageViewLotARed = findViewById(R.id.parkingLotA_RED);
        ImageView imageViewLotBRed = findViewById(R.id.parkingLotB_RED);
        ImageView imageViewLot1Red = findViewById(R.id.parkingLot1_RED);
        ImageView imageViewLot2Red = findViewById(R.id.parkingLot2_RED);
        ImageView imageViewLot3Red = findViewById(R.id.parkingLot3_RED);
        ImageView imageViewLot4Red = findViewById(R.id.parkingLot4_RED);
        ImageView imageViewLot5Red = findViewById(R.id.parkingLot5_RED);
        ImageView imageViewLot6Red = findViewById(R.id.parkingLot6_RED);
        ImageView imageViewLot6ARed = findViewById(R.id.parkingLot6A_RED);
        ImageView imageViewLot7Red = findViewById(R.id.parkingLot7_RED);
        ImageView imageViewLot8Red = findViewById(R.id.parkingLot8_RED);
        ImageView imageViewLot9Red = findViewById(R.id.parkingLot9_RED);

        switch (location) {
            case PARKADE:
                imageViewEastGateRed.setVisibility((!visibility ? View.VISIBLE : View.GONE));
                break;
            case LOT_A:
                imageViewLotARed.setVisibility((!visibility ? View.VISIBLE : View.GONE));
                break;
            case LOT_B:
                imageViewLotBRed.setVisibility((!visibility ? View.VISIBLE : View.GONE));
                break;
            case LOT_1:
                imageViewLot1Red.setVisibility((!visibility ? View.VISIBLE : View.GONE));
                break;
            case LOT_2:
                imageViewLot2Red.setVisibility((!visibility ? View.VISIBLE : View.GONE));
                break;
            case LOT_3:
                imageViewLot3Red.setVisibility((!visibility ? View.VISIBLE : View.GONE));
                break;
            case LOT_4:
                imageViewLot4Red.setVisibility((!visibility ? View.VISIBLE : View.GONE));
                break;
            case LOT_5:
                imageViewLot5Red.setVisibility((!visibility ? View.VISIBLE : View.GONE));
                break;
            case LOT_6:
                imageViewLot6Red.setVisibility((!visibility ? View.VISIBLE : View.GONE));
                break;
            case LOT_6A:
                imageViewLot6ARed.setVisibility((!visibility ? View.VISIBLE : View.GONE));
                break;
            case LOT_7:
                imageViewLot7Red.setVisibility((!visibility ? View.VISIBLE : View.GONE));
                break;
            case LOT_8:
                imageViewLot8Red.setVisibility((!visibility ? View.VISIBLE : View.GONE));
                break;
            case LOT_9:
                imageViewLot9Red.setVisibility((!visibility ? View.VISIBLE : View.GONE));
                break;
        }
    }

    enum parkingLocations {
        PARKADE,
        LOT_A,
        LOT_B,
        LOT_1,
        LOT_2,
        LOT_3,
        LOT_4,
        LOT_5,
        LOT_6,
        LOT_6A,
        LOT_7,
        LOT_8,
        LOT_9
    }
}