package com.example.aayush.friendscircle;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.EditText;
import android.widget.Toast;

import static com.example.aayush.friendscircle.R.id.nameInput;

/**
 * Created by Aayush on 02-02-2017.
 */

public class SecondActivity extends AppCompatActivity {
    EditText nameInput;
    boolean flag;
    int count=0;
    //Toast newT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final Intent intent = new Intent(this, ThirdActivity.class);
        setContentView(R.layout.activity_second);

        ImageButton proceedBtn= (ImageButton)findViewById(R.id.proceedBtn);

        nameInput= (EditText)findViewById(R.id.nameInput);

        flag= false;

        proceedBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name= nameInput.getText().toString();
                if(name.length()==10) {
                    for (int i = 0; i < 10; i++) {
                        if (name.charAt(i) <= 57 && name.charAt(i) >= 48) {
                            flag = true;
                        } else {
                            flag = false;
                            break;
                        }
                    }
                    if ((flag == true)) {
                        if (name.length() == 10) {
                            startActivity(intent);
                        }
                    }
                    if (!flag) {
                        Context context = getApplicationContext();
                        Toast.makeText(context, "Enter a valid Phone number !", Toast.LENGTH_SHORT).show();
                    }
                }
                else{
                    Context context = getApplicationContext();
                    Toast.makeText(context, "Enter a valid Phone number !", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
