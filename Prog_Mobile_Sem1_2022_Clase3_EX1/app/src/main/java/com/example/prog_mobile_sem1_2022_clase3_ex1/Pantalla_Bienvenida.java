package com.example.prog_mobile_sem1_2022_clase3_ex1;

import static com.example.prog_mobile_sem1_2022_clase3_ex1.MainActivity.MESSAGE;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Pantalla_Bienvenida extends AppCompatActivity {

    private TextView name;
    private EditText text_2_Return;
    private Button Btn_Return;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_bienvenida);

        name = (TextView) findViewById(R.id.Tv_name);
        text_2_Return = (EditText) findViewById(R.id.Text_2_return);
        Btn_Return = (Button) findViewById(R.id.Btn_Return);

        Bundle args = getIntent().getExtras();
        String Str_name = args.getString("Nombre");
        name.setText("Bienvenido "+Str_name+" A pantalla de Bienvenida");


        Btn_Return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                String message = text_2_Return.getText().toString();
                intent.putExtra(MESSAGE, message);
                intent.putExtra("return_text",message);
                setResult(RESULT_OK, intent);
                finish();
            }
        });


    }

}