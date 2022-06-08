package com.example.prog_mobile_sem1_2022_clase3_ex1;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private final int REQUEST_CODE = 222;
    private Button enviar;
    private EditText user,password;
    public static final String MESSAGE = "Mesaage of return";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        enviar = (Button) findViewById(R.id.Button_Enviar);
        user = (EditText) findViewById(R.id.Et_User);
        password = (EditText) findViewById(R.id.Et_Pass);

        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Str_user, Str_pass;
                Str_user = user.getText().toString();
                Str_pass = password.getText().toString();
                verificar_datos(Str_user,Str_pass);
            }
        });


    }


    private void verificar_datos(String user, String password){
        String User = "Usuario";
        String Pass = "Usuario";
        String Name = "Fulano";

        try{
            if(user.contentEquals(User) && password.contentEquals(Pass)){
                Intent intent = new Intent(this,Pantalla_Bienvenida.class);
                Bundle datos = new Bundle();
                datos.putString("Nombre",Name);
                intent.putExtras(datos);
                startActivityForResult(intent, REQUEST_CODE);
            }else{
                Toast.makeText(getApplicationContext(),"Error en el Ingreso de Datos",Toast.LENGTH_LONG).show();
            }

        }catch (Exception e){
            System.out.println(e);
        }
        finally {}

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                TextView result_text = (TextView) findViewById(R.id.Result_text);
                String text_4_return = data.getExtras().getString("return_text");
                result_text.setText(text_4_return);
                Log.i("Return Request Code", "onActivityResult: " + requestCode);
                Log.d("String Return for TextView", "::: "+text_4_return);
            } else if(resultCode == RESULT_CANCELED) {
                Toast.makeText(getApplicationContext(), "Dato Vacío en el retorno", Toast.LENGTH_LONG).show();
                Log.i("Return Request Code", "onActivityResult: " + resultCode);
            }
        }

    }
}