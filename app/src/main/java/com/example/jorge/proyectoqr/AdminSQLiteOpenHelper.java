package com.example.jorge.proyectoqr;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class AdminSQLiteOpenHelper extends SQLiteOpenHelper {
    public AdminSQLiteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table cliente(cedulaC varchar(10) primary key,contraseñaC varchar(10),nombreC text,apellidoC text,correo_electronicoC varchar(25),direccionC varchar (30),telefonoC varchar (10))");
        db.execSQL("create table vendedor(cedulaV varchar(10) primary key,contraseñaV varchar(10),nombreV text,apellidoV text,correo_electronicoV varchar(25),direccionV varchar (30),telefonoV varchar (10))");
        db.execSQL("create table producto(id_producto int primary key,nombreP text,stock int,precio float)");
        db.execSQL("create table carrito_producto(id_carrito_producto int primary key,id_producto int,idCarrito int,cantidad int, foreign key (id_producto) references producto(id_producto),foreign key (idCarrito) references carrito(idCarrito))");
        db.execSQL("create table carrito(idCarrito int primary key,cedulaC varchar (10),total float, foreign key (cedulaC) references cliente(cedulaC) )");
        db.execSQL("create table compra(id_compra int primary key,cedulaV varchar(10),cedulaC varchar(10),idCarrito int,foreign key(cedulaV)references vendedor(cedulaV),foreign key(cedulaC)references cliente(cedulaC),foreign key(idCarrito)references carrito(idCarrito))");
        db.execSQL("insert into cliente values('0910549351','123','liliana','revelo','jaqueli_1418@','la romadera','0992254730')");




    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}
