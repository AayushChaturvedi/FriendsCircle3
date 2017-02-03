package com.example.aayush.friendscircle;

import android.content.Intent;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;

public class ThirdActivity extends AppCompatActivity {
    Editable name;
    Editable email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        //final Intent intent = new Intent(this, FourthScreen.class);
        Button proceedBtn2= (Button)findViewById(R.id.proceedBtn2);
        DatePicker datePicker = (DatePicker) findViewById(R.id.datePicker1);
        int day = datePicker.getDayOfMonth();
        int month = datePicker.getMonth() + 1;
        int year = datePicker.getYear();

        proceedBtn2.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        //startActivity();
                    }
                }

        );
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
