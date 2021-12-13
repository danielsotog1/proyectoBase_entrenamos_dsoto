package com.example.proyectobase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TextView;

import objetos.Insumos;

public class insumos_act extends AppCompatActivity {

    private Spinner insumos;
    private TextView resultado;
    private RatingBar calificar;
    private Insumos in = new Insumos();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insumos);

        insumos = findViewById(R.id.spninsumos);
        resultado = findViewById(R.id.resultado);
        calificar = findViewById(R.id.rt);


        Bundle bun =getIntent().getExtras();
        String[] listado = bun.getStringArray("insumos");

        ArrayAdapter adapInsumos = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listado);
        insumos.setAdapter(adapInsumos);


    }

    public void Calcular (View view)
    {
        String opcion = insumos.getSelectedItem().toString();
        int result =0;

        for(int i = 0 ; i< opcion.length(); i ++)
        {
            if(opcion.equals(in.getInsumos() [i]))
            {
                //result = in.getPrecios()[i];
                result = in.añadirAdicional(in.getPrecios()[i],1000);

                calificar.setRating(i+1);
            break;
            }

        }
        resultado.setText("La opcion es:" + opcion + "\nSu precio es: "+ result);
    }
}