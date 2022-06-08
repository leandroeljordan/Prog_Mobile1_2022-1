package com.example.prog_mobile_sem1_2022_ex3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button Calcularr;
    private EditText Peso;
    private EditText Altura;
    private TextView Masa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Calcularr = findViewById(R.id.Button_calcular);
        Peso = findViewById(R.id.Kilos);
        Altura = findViewById(R.id.Altura);
        Masa = findViewById(R.id.Masa);


        Calcularr.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        double altura, peso;
        String conversion;
        conversion = Altura.getText().toString();
        altura = Double.parseDouble(conversion);
        altura = altura /100;
        ////////////////////////////////////////

        conversion = Peso.getText().toString();
        peso = Double.parseDouble(conversion);


        double IMC = peso/(altura*altura);

        Masa.setText("Su IMC es: "+IMC);

    }
}