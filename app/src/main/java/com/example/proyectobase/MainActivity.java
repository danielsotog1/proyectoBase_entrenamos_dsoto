package com.example.proyectobase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import objetos.Administrador;
import objetos.Insumos;

public class MainActivity extends AppCompatActivity {

    private EditText user, pass;
    private TextView msj;
    private Administrador adm= new Administrador();
    private Insumos in = new Insumos();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user = (EditText)findViewById(R.id.etuser);
        pass =(EditText)findViewById(R.id.etpass);
        msj = (TextView)findViewById(R.id.msj);
    }
    public void LoadSesion(View view)
    {
        String usuario = user.getText().toString().trim();
        String contraseña = pass.getText().toString().trim();

        String userObj = adm.getUser().trim();
        String passObj = adm.getPass().trim();

        switch (usuario)
        {
            case "Daniel":
                if(usuario.equals(userObj) && contraseña.equals(passObj))
                {
                    Intent i = new Intent(this, insumos_act.class);

                    Bundle bun = new Bundle();
                    bun.putStringArray("insumos",in.getInsumos());
                    i.putExtras(bun);
                    startActivity(i);
                }
                break;
            case "":
                if(usuario.equals("") && contraseña.equals(""))
                {
                    msj.setText("campos vacios por favor intente nuevamente ");
                }
            default:
                if(!usuario.equals(userObj) && !contraseña.equals(passObj))
                {
                    msj.setText("campos incorrectos intente nuevamente");
                }
                break;
        }

    }

    public void facebook(View view)
    {
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse("https://www.facebook.com/"));
        startActivity(i);

    }

    public void youtube(View view)
    {
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse("https://www.youtube.com/"));
        startActivity(i);

    }
    public void twitter(View view)
    {
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse("https://www.twitter.com/"));
        startActivity(i);

    }

    public void Info(View view)
    {
        Intent i = new Intent(this, info_act.class);
        startActivity(i);
    }


}
