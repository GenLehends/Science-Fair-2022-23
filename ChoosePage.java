package com.example.plan_tahead;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

public class ChoosePage extends AppCompatActivity {
    private Spinner spinner1;
    private ImageView image1;
    private Spinner spinner2;
    private ImageView image2;
    private Spinner spinner3;
    private ImageView image3;
    public Plant userPlant;
    public Soil userSoil;
    public String userSeason;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_page);
        spinner1 = findViewById(R.id.spinner1);
        image1 = findViewById(R.id.image1);

        String[] plant = {"select one", "Potato", "Carrot", "Tomato","Radish","Cabbage","Kale","Lettuce","Spinach","Broccoli","Basil"};
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>
                (this, android.R.layout.simple_spinner_dropdown_item, plant);
        spinner1.setAdapter(adapter1);
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 1:
                        image1.setImageResource(R.drawable.potato);
                        userPlant = new Plant("Potato", 20, "Root");
                        break;
                    case 2:
                        image1.setImageResource(R.drawable.carrot);
                        userPlant = new Plant("Carrot", 15, "Root");
                        break;
                    case 3:
                        image1.setImageResource(R.drawable.tomato);
                        userPlant = new Plant("Tomato", 11, "Tomato");
                        break;
                    case 4:
                        image1.setImageResource(R.drawable.radish);
                        userPlant = new Plant("Radish", 7, "Root");
                        break;
                    case 5:
                        image1.setImageResource(R.drawable.cabbage);
                        userPlant = new Plant("Cabbage", 11, "Brassicas");
                        break;
                    case 6:
                        image1.setImageResource(R.drawable.kale);
                        userPlant = new Plant("Kale", 11, "Brassicas");
                        ;
                        break;
                    case 7:
                        image1.setImageResource(R.drawable.lettuce);
                        userPlant = new Plant("Lettuce", 6, "Leafy Greens");
                        ;
                        break;
                    case 8:
                        image1.setImageResource(R.drawable.spinach);
                        userPlant = new Plant("Spinach", 6, "Leafy Greens");
                        ;
                        break;
                    case 9:
                        image1.setImageResource(R.drawable.brocoli);
                        userPlant = new Plant("Broccoli", 6, "Leafy Greens");
                        ;
                        break;
                    case 10:
                        image1.setImageResource(R.drawable.basil);
                        userPlant = new Plant("Basil", 4, "Herb");
                        ;
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }

        });

        spinner2 = findViewById(R.id.spinner2);
        image2 = findViewById(R.id.image2);
        String[] region = {"select one", "Summer", "Spring", "Fall", "Winter"};
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>
                (this, android.R.layout.simple_spinner_dropdown_item, region);
        spinner2.setAdapter(adapter2);

        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 1:
                        image2.setImageResource(R.drawable.summer);
                        userSeason = "Summer";
                        break;
                    case 2:
                        image2.setImageResource(R.drawable.spring);
                        userSeason = "Spring";
                        break;
                    case 3:
                        image2.setImageResource(R.drawable.fall);
                        userSeason = "Fall";
                        break;
                    case 4:
                        image2.setImageResource(R.drawable.winter);
                        userSeason = "Winter";
                        break;
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        spinner3 = findViewById(R.id.spinner3);
        image3 = findViewById(R.id.image3);
        String[] soilType = {"select one", "Sand", "Silt", "Peaty", "Chalky", "Loam"};
        ArrayAdapter<String> adapter3 = new ArrayAdapter<String>
                (this, android.R.layout.simple_spinner_dropdown_item, soilType);
        spinner3.setAdapter(adapter3);
        spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 1:
                        image3.setImageResource(R.drawable.sand);
                        userSoil = new Soil(soilType[1]);
                        break;
                    case 2:
                        image3.setImageResource(R.drawable.silt);
                        userSoil = new Soil(soilType[2]);
                        break;
                    case 3:
                        image3.setImageResource(R.drawable.peat);
                        userSoil = new Soil(soilType[3]);
                        break;
                    case 4:
                        image3.setImageResource(R.drawable.chalk);
                        userSoil = new Soil(soilType[4]);
                        break;
                    case 5:
                        image3.setImageResource(R.drawable.loam);
                        userSoil = new Soil(soilType[5]);
                        break;

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
    }

    public void grow(View v) {
        String soilComp = "";
        String grow = "";
        //first change growth time according to soil used
        userSoil.changeGrowthFactor(userPlant);
        TextView tv = findViewById(R.id.textView7);
        tv.setText("The plant you have chosen is " + userPlant.getName());
        spinner1.setVisibility(View.GONE);
        spinner2.setVisibility(View.GONE);
        spinner3.setVisibility(View.GONE);
        TextView tv1 = findViewById(R.id.textView4);
        tv1.setVisibility(View.GONE);
        TextView tv2 = findViewById(R.id.textView5);
        tv2.setVisibility(View.GONE);
        TextView tv3 = findViewById(R.id.textView6);
        tv3.setVisibility(View.GONE);
        TextView tv4 = findViewById(R.id.textView8);
        tv4.setText("The Season you have chosen is " + userSeason + "\n" +inCorrectSeason(userPlant));
        if (userSoil.getGrowthFactor() == 1.0) {
            soilComp = "This soil is ideal to use with the plant!";
        } else {
            soilComp = "This soil is not ideal with the plant.";
        }
        TextView tv5 = findViewById(R.id.textView9);
        tv5.setText("The Soil you have chosen is " + userSoil + "\n" + soilComp);
        if (userSeason == "Winter" && userPlant.noGrowInWinter() == true) {
            grow = "You Cannot grow this Plant with the given conditions :( ";
        } else {
            grow = "This plant will take " + userPlant.getWeeksToGrow() * userSoil.getGrowthFactor() + " Weeks to Grow";
        }
        TextView tv6 = findViewById(R.id.textView10);
        tv6.setText(grow);
    }

    public void tryAgain() {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }

    public String inCorrectSeason(Plant userPlant) {
        if (userSeason.equals(userPlant.getPreferedSeason())) {
            return "You are planting during the preferred season";
        } else if (userSeason.equals("Winter") && userPlant.getCantGrowInWinter()) {
            return "Sorry you can't grow " + userPlant.toString() + " in the winter";
        } else {
            return ("You are planting during " + userSeason +
                    " but this plant is better grown in " + userPlant.getPreferedSeason());
        }
    }
}
