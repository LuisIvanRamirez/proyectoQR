package com.example.jorge.proyectoqr;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class inicio extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
    }
    public void cliente(View view) {
        Intent i = new Intent(this, inicioSesion.class );
        startActivity(i);
    }
    public void vendedor(View view) {
        Intent i = new Intent(this, inicioSesionV.class );
        startActivity(i);
    }



}
