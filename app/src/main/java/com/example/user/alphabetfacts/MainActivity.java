package com.example.user.alphabetfacts;


import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewSwitcher;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Random random;
    RelativeLayout colorLayout;
    TextSwitcher textSwitcher;
    Button btnNext, btnPrevious, btnRandom;
    int currentPosition = -1;

    String[] Alphabets = {"A", "B", "C", "D", "E", "F","G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q",
            "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
    int AlphaLength = Alphabets.length -1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        colorLayout = findViewById(R.id.relativeLayout);



        random = new Random();

        btnNext = findViewById(R.id.next);
        btnNext.setOnClickListener(this);

        btnPrevious =  findViewById(R.id.previous);
        btnPrevious.setOnClickListener(this);

        btnRandom = findViewById(R.id.random);
        btnRandom.setOnClickListener(this);

        textSwitcher = findViewById(R.id.textSwitcher);

        textSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                TextView text= new TextView(getApplicationContext());
                text.setTextSize(30);

                text.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                text.setTextColor(getResources().getColor(R.color.white));

                text.setFreezesText(true);

                return text;
            }
        });




        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.next:

                colorLayout.setBackgroundColor(Color.argb(255, random.nextInt(256), random.nextInt(256), random.nextInt(256) ));
                if(currentPosition == AlphaLength){
                    currentPosition = 0;
                    textSwitcher.setText(Alphabets[currentPosition]);

                } else{
                    currentPosition = currentPosition + 1;
                    textSwitcher.setText(Alphabets[currentPosition]);
                }
                Toast.makeText(this, ""+currentPosition + " of "+AlphaLength, Toast.LENGTH_SHORT).show();
                return;

            case R.id.previous:

                colorLayout.setBackgroundColor(Color.argb(255, random.nextInt(256), random.nextInt(256), random.nextInt(256) ));
                if(currentPosition == 0 || currentPosition == -1){
                    currentPosition = AlphaLength;
                    textSwitcher.setText(Alphabets[currentPosition]);
                } else{
                    currentPosition = currentPosition -1;
                    textSwitcher.setText(Alphabets[currentPosition]);
                }
                Toast.makeText(this, ""+currentPosition + " of "+AlphaLength, Toast.LENGTH_SHORT).show();
                return;

            case R.id.random:

                colorLayout.setBackgroundColor(Color.argb(255, random.nextInt(256), random.nextInt(256), random.nextInt(256) ));
                currentPosition = random.nextInt(AlphaLength);
                textSwitcher.setText(Alphabets[currentPosition]);
                Toast.makeText(this, ""+currentPosition + " of "+AlphaLength, Toast.LENGTH_SHORT).show();
        }
    }
}
