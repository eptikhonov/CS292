package com.erictikhonov.wallpapergenerator;

import android.content.Intent;
import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;

public class Main3Activity extends AppCompatActivity {

    int currentColorNum = 0;
    static Color currentColor = new Color();

    static int red = 0;
    static int green = 0;
    static int blue = 0;

    //static Color[] rgbColors = new Color[3];
    static int[][] colorRGBValues = new int[3][3];

    ConstraintLayout mainLayout;

    TextView rgbTextView;
    TextView colorIteratorTextView;
    SeekBar redSeekBar;
    SeekBar greenSeekBar;
    SeekBar blueSeekBar;

    Button continueButton;
    Button nextColorButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        rgbTextView = findViewById(R.id.rgbTextView);
        colorIteratorTextView = findViewById(R.id.colorIteratorTextView);
        continueButton = findViewById(R.id.continueButton);
        nextColorButton = findViewById(R.id.nextColorButton);
        redSeekBar = findViewById(R.id.redSlider);
        greenSeekBar = findViewById(R.id.greenSlider);
        blueSeekBar = findViewById(R.id.blueSlider);

        redSeekBar.setProgress(0);
        greenSeekBar.setProgress(0);
        blueSeekBar.setProgress(0);

        continueButton.setVisibility(View.GONE);

        mainLayout = findViewById(R.id.constraintLayout);

        // red slider listener
        redSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress,
                                          boolean fromUser) {
                red = progress;
                rgbTextView.setText("("+red+", "+green+", "+blue+")");
                colorIteratorTextView.setText("Color #"+(currentColorNum+1));
                currentColor.rgb(red, green, blue);

                mainLayout.setBackgroundColor(Color.rgb(red, green, blue));

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                //Toast.makeText(getApplicationContext(),"seekbar touch started!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                //Toast.makeText(getApplicationContext(),"seekbar touch stopped!", Toast.LENGTH_SHORT).show();
            }
        });

        // green slider listener
        greenSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress,
                                          boolean fromUser) {
                green = progress;
                rgbTextView.setText("("+red+", "+green+", "+blue+")");
                currentColor.rgb(red, green, blue);

                mainLayout.setBackgroundColor(Color.rgb(red, green, blue));

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                //Toast.makeText(getApplicationContext(),"seekbar touch started!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                //Toast.makeText(getApplicationContext(),"seekbar touch stopped!", Toast.LENGTH_SHORT).show();
            }
        });

        // blue slider listener
        blueSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress,
                                          boolean fromUser) {
                blue = progress;
                rgbTextView.setText("("+red+", "+green+", "+blue+")");
                currentColor.rgb(red, green, blue);

                mainLayout.setBackgroundColor(Color.rgb(red, green, blue));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                //Toast.makeText(getApplicationContext(),"seekbar touch started!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                //Toast.makeText(getApplicationContext(),"seekbar touch stopped!", Toast.LENGTH_SHORT).show();
            }
        });

        nextColorButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                currentColorNum++;

                // TODO: add current color to the array (FIX THIS PROBLEM)
                colorRGBValues[currentColorNum][0] = red;
                colorRGBValues[currentColorNum][1] = green;
                colorRGBValues[currentColorNum][2] = blue;

                System.out.println("Red color: " + colorRGBValues[currentColorNum][0]);
                System.out.println("Green color: " + colorRGBValues[currentColorNum][1]);
                System.out.println("Blue color: " + colorRGBValues[currentColorNum][2]);


                if (currentColorNum < 3) {
                    colorIteratorTextView.setText("Color #"+(currentColorNum+1));

                    if (currentColorNum == 2) {
                        nextColorButton.setVisibility(View.GONE);
                        continueButton.setVisibility(View.VISIBLE);
                    } else {
                        nextColorButton.setVisibility(View.VISIBLE);
                    }

                    // reset color and slider values
                    rgbTextView.setText("(0, 0, 0)");
                    redSeekBar.setProgress(0);
                    greenSeekBar.setProgress(0);
                    blueSeekBar.setProgress(0);
                    mainLayout.setBackgroundColor(Color.WHITE);
                }
            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.out.println("MainActivity: onDestroy");
    }

    @Override
    protected void onPause() {
        super.onPause();
        System.out.println("MainActivity: onPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        System.out.println("MainActivity: onResume");
    }

    @Override
    protected void onStart() {
        super.onStart();
        System.out.println("MainActivity: onStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        System.out.println("MainActivity: onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        System.out.println("MainActivity: onRestart");
    }

    public void onNext(View view) {
        //This is how you create a new Intent to push activites onto the stack
        Intent intent = new Intent(this,Main4Activity.class);
        startActivity(intent);
    }

    public void onPrev(View view) {
        //This automatically closes the current activity
        //If there are no more activities on the Stack the app will close
        finish();
    }

    public void updateGUIColorComponents(Color color) {
        red = Math.round(color.red());
        green = Math.round(color.green());;
        blue = Math.round(color.blue());;

        redSeekBar.setProgress(red);
        greenSeekBar.setProgress(red);
        blueSeekBar.setProgress(red);

        rgbTextView.setText("("+red+", "+green+", "+blue+")");
        //mainLayout.setBackgroundColor(currentColor);
        mainLayout.setBackgroundColor(Color.rgb(red, green, blue));
    }

}