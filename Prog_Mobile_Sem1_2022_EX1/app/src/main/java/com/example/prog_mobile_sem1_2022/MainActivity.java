package com.example.prog_mobile_sem1_2022;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/*
    Principal_EditText
    Button_TextView_Change
    Button_Toast
    Name_In_TextView
   */

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private    EditText EditText1;
    private    Button change_name,make_toast;
    private    TextView Name;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText1 = findViewById(R.id.Principal_EditText);
        change_name = findViewById(R.id.Button_TextView_Change);
        make_toast = findViewById(R.id.Button_Toast);


        make_toast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name_to_show;
                if(EditText1.getText().length() < 4){
                    name_to_show ="Nombre no Valido, favor ingrese un nombre";
                }else name_to_show = EditText1.getText().toString();

                Toast.makeText(getApplicationContext(),name_to_show,Toast.LENGTH_LONG).show();
            }


        });

        change_name.setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {
        Name = findViewById(R.id.Name_In_TextView);
        String name_take = EditText1.getText().toString();
        if(name_take.length() < 4){
            Toast.makeText(getApplicationContext(),"Ingrese un Nombre Valido",Toast.LENGTH_LONG).show();
        }else Name.setText(name_take);

    }
}