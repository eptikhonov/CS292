package edu.uwgb.class11_stack;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        System.out.println("MainActivity: onCreate");
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
        Intent intent = new Intent(this,Main3Activity.class);
        startActivity(intent);
    }

    public void onPrev(View view) {
        finish();
    }
}
