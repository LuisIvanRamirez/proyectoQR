package com.example.jorge.proyectoqr;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.google.zxing.Result;

import java.text.DecimalFormat;
import java.util.ArrayList;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class cliente extends AppCompatActivity {

    public static TextView resultado;;
    public static double total=0;
    public static LinearLayout linearLayout;
    public static String nombre="";
    public static String precio="";
    public static String last="";
    public static LinearLayout horizontal;
    public static EditText cantidad;
    public static Button ok;
    Button escanner;
    public String ct="";
    public int CTint=1;
    public ArrayList<String> descripcion = new ArrayList<>();
    public ArrayList<Double> valor = new ArrayList<>();
    public ArrayList<Integer> nElementos = new ArrayList<>();
    public static int cont=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cliente);
        escanner= (Button) findViewById(R.id.escanner);
        linearLayout = (LinearLayout) findViewById(R.id.scroller);
        total=0;

    }

    public void escanner(View view) {
        Intent i = new Intent(this, camara.class );
        startActivity(i);
    }

    public void handle(String nombre,String precio){
        //total+=Double.parseDouble(precio);
        agregarProducto(nombre+"$"+ precio);
}

    public void agregarProducto(String s){
        LinearLayout horizontal = new LinearLayout(this);
        horizontal.setOrientation(LinearLayout.HORIZONTAL);
        horizontal.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        resultado=new TextView(this);
        cantidad=new EditText(this);
        ok= new Button(this);
        cantidad.setHint("");
        cantidad.setTextSize(20);
        cantidad.setInputType(InputType.TYPE_CLASS_NUMBER);
        cantidad.setWidth(125);
        cantidad.setText("1");
        ok.setText("+");
        ok.setTextSize(25);
        ok.setWidth(0);
        resultado.setText(s);
        resultado.setTextSize(25);
        resultado.setWidth(700);
        ok.setId(cont);
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ct=cantidad.getText().toString();
                CTint= Integer.parseInt(ct);
                nElementos.add(CTint);
                //nElementos.set(ok.getId(),CTint);
                //Double precio1=Double.parseDouble(precio)*CTint;
                //total+=precio1;
            }
        });
        resultado.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.MATCH_PARENT));
        cantidad.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.MATCH_PARENT));
        ok.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.MATCH_PARENT));
        ((LinearLayout)horizontal).addView(resultado);
        ((LinearLayout)horizontal).addView(cantidad);
        ((LinearLayout)horizontal).addView(ok);
        linearLayout.addView(horizontal);
        cont++;

    }

    public void checkOut(View view){
        resultado=new TextView(this);
        TextView linea =new TextView(this);
        linea.setText("------------------------------------------");
        linea.setTextSize(25);
        DecimalFormat df = new DecimalFormat("#.00");
        for(int i =0;i<valor.size();i++){
            double subt=valor.get(i)*nElementos.get(i);
            total+=subt;
        }
        String t=df.format(total);
        resultado.setText("El total a pagar es: $"+t+Integer.toString(ok.getId()));
        total=0;
        resultado.setTextSize(25);
        linea.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT));
        ((LinearLayout) linearLayout).addView(linea);
        resultado.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT));
        ((LinearLayout) linearLayout).addView(resultado);

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        if (!last.equals(nombre)){
            handle(this.nombre,this.precio);
            last=nombre;
            descripcion.add(nombre);
            valor.add(Double.parseDouble(precio));
        }else{
            nombre = "";
            precio = "";
        }
    }




















}
