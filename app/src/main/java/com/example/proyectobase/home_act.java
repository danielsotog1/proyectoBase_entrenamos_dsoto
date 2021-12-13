package com.example.proyectobase;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

public class home_act extends AppCompatActivity {

    private VideoView video;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        video= findViewById(R.id.vw);

        String ruta ="android.resource://" + getPackageName() + "/" + R.raw.video;

        Uri uri = Uri.parse(ruta);

        video.setVideoURI(uri);
        video.start();

        MediaController media = new MediaController(this);
        video.setMediaController(media);
    }


}