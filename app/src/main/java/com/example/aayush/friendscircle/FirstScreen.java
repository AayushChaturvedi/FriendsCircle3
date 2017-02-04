package com.example.aayush.friendscircle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FirstScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_screen);
        final Intent intent= new Intent(this, SecondActivity.class);

        Button button= (Button)findViewById(R.id.button);

        button.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        startActivity(intent);
                    }
                }
        );
    }
}
