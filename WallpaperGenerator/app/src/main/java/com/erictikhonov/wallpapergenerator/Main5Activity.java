package com.erictikhonov.wallpapergenerator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.graphics.drawable.Drawable;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;

public class Main5Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        // change the color of the drawable shape
        Drawable circle = getResources().getDrawable(R.drawable.button_circle);
        //Drawable square = getResources().getDrawable(R.drawable.button_square;
        circle.setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_ATOP);

        /*
        Drawable
                drawable = new DrawableBuilder()
                .rectangle()
                .solidColor(0xffe67e22)
                .bottomLeftRadius(20) // in pixels
                .bottomRightRadius(20) // in pixels
//        .cornerRadii(0, 0, 20, 20) // the same as the two lines above
                .build();
    */
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

    public void onPrev(View view) {
        //This automatically closes the current activity
        //If there are no more activities on the Stack the app will close
        finish();
    }

}
