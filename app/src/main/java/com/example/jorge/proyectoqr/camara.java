package com.example.jorge.proyectoqr;


import android.Manifest;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class camara extends AppCompatActivity implements ZXingScannerView.ResultHandler {
    ZXingScannerView scanner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camara);
        scanner = new ZXingScannerView(this);
        setContentView(scanner);
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.CAMERA)
                != PackageManager.PERMISSION_GRANTED) {

            // Permission is not granted
            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.CAMERA)) {
                // Show an explanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.
            } else {
                // No explanation needed; request the permission
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.CAMERA}, 1);

                // MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
                // app-defined int constant. The callback method gets the
                // result of the request.
            }
        } else {
            // Permission has already been granted
        }

    }

    @Override
    public void handleResult(Result result) {
        String[] scan = result.getText().split(",");
        String cNombre = scan[0];
        String cPrecio = scan[1];
        if (cNombre.equals(null)&&cPrecio.equals(null)) {
            cliente.nombre = "";
            cliente.precio = "";
        }
        else{
            cliente.nombre = cNombre;
            cliente.precio = cPrecio;
        }
        onBackPressed();
        }


    @Override
    protected void onPause() {
        super.onPause();
        scanner.stopCamera();

    }

    @Override
    protected void onResume() {
        super.onResume();
        scanner.setResultHandler(this);
        scanner.startCamera();
    }

}
