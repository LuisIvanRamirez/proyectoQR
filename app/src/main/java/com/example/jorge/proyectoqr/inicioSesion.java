package com.example.jorge.proyectoqr;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class inicioSesion extends AppCompatActivity {
    EditText nombre;
    EditText password;
    private Cursor fila;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio_sesion);
        nombre = (EditText) findViewById(R.id.userV);
        password = (EditText) findViewById(R.id.passV);
        nombre.setText("");
        password.setText("");
    }

    public void cliente(View view) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "EZ-BUY", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        String user = nombre.getText().toString();
        String pass = password.getText().toString();
        fila = bd.rawQuery("select cedulaC,contraseñaC from cliente where cedulaC='" + user + "' and contraseñaC='" + pass + "'", null);
        if (fila.moveToFirst()) {
            Intent ven = new Intent(this, cliente.class);
            startActivity(ven);
        } else {
            Toast.makeText(this, "Credenciales Invalidas", Toast.LENGTH_SHORT).show();
        }
    }

    public void inicio(View view) {
            Intent i = new Intent(this, inicio.class);
            startActivity(i);

        }
}
