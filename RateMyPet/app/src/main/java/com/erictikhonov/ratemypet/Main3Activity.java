package com.erictikhonov.ratemypet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Main3Activity extends AppCompatActivity {

    private int currentPicNum = 0;
    private int[] catPics = {R.drawable.cat1, R.drawable.cat2, R.drawable.cat3, R.drawable.cat4, R.drawable.cat5};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        getSupportActionBar().setTitle("Cats");

        final ImageView catPhoto = findViewById(R.id.catPhoto);

        final Button like_button = findViewById(R.id.like_btn);
        like_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                currentPicNum++;

                if (currentPicNum < 5) {
                    catPhoto.setImageResource(catPics[currentPicNum]);
                }
            }
        });

        final Button dislike_button = findViewById(R.id.dislike_btn);
        dislike_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                currentPicNum++;

                if (currentPicNum < 5) {
                    catPhoto.setImageResource(catPics[currentPicNum]);
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

    public void cat(View view) {
        //This is how you create a new Intent to push activites onto the stack
        Intent intent = new Intent(this,Main3Activity.class);
        startActivity(intent);
    }

    public void dog(View view) {
        //This is how you create a new Intent to push activites onto the stack
        Intent intent = new Intent(this,Main5Activity.class);
        startActivity(intent);
    }

    public void help(View view) {
        //This is how you create a new Intent to push activites onto the stack
        Intent intent = new Intent(this, Main4Activity.class);
        startActivity(intent);
    }

}
