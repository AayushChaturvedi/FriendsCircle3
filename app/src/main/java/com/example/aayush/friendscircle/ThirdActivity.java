package com.example.aayush.friendscircle;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

public class ThirdActivity extends Activity {
    DatePicker datePicker;
    EditText name, email;
    int day, month, year;
    String phnno, nameValue, emailValue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        //final Intent intent = new Intent(this, FourthScreen.class);
        datePicker = (DatePicker) findViewById(R.id.datePicker);
        name= (EditText)findViewById(R.id.name);
        email= (EditText)findViewById(R.id.email);
    }

    public void userReg(View v){
        /*
        Context cont=getApplicationContext();
        Toast.makeText(cont, "userRg Worked", Toast.LENGTH_SHORT).show();*/
        day = datePicker.getDayOfMonth();
        month = datePicker.getMonth() + 1;
        year = datePicker.getYear();
        nameValue= name.getText().toString();
        emailValue= email.getText().toString();
        String dayS= Integer.toString(day);
        String monthS= Integer.toString(month);
        String yearS= Integer.toString(year);
        String dob= dayS.concat("-").concat(monthS).concat("-").concat(yearS);
        Bundle bundle= getIntent().getExtras();
        phnno= bundle.getString("phone");
        BackgroundDBMS backgroundDBMS= new BackgroundDBMS(this);
        backgroundDBMS.execute(nameValue, phnno, dob, emailValue);
        finish();

        Intent intent= new Intent(this, MapActivity.class);
        startActivity(intent);
    }

}
