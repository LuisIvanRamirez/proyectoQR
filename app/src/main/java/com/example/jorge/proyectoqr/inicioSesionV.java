package com.example.jorge.proyectoqr;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class inicioSesionV extends AppCompatActivity {
    EditText nombreV;
    EditText passV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio_sesion_v);
        nombreV=(EditText) findViewById(R.id.userV);
        passV=(EditText) findViewById(R.id.passV);

    }
    public void vendedor(View view) {
        if (nombreV.getText().toString().equals("admin")&& passV.getText().toString().equals("1234")) {
            Intent i = new Intent(this, vendedor.class);
            startActivity(i);

        }else{
            Toast.makeText(inicioSesionV.this, "Credenciales Invalidas", Toast.LENGTH_SHORT).show();
            nombreV.setText("");
            passV.setText("");
        }


    }
    public void inicio(View view) {
        Intent i = new Intent(this, inicio.class);
        startActivity(i);

    }

}
