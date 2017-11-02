package com.example.manolo.galeriaimagenesclase;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    int []obraId= {
            R.drawable.boti,
            R.drawable.cara,
            R.drawable.dega,
            R.drawable.gaug,
            R.drawable.goya,
            R.drawable.klim,
            R.drawable.leon,
            R.drawable.mane,
            R.drawable.remb,
            R.drawable.reno
    };

    String []descripcionObra={
            "Boticelli: 'El nacimiento de la primavera'",
            "Caravaggio: 'La conversión de San Pablo'",
            "Degas: 'La clase de baile'",
            "Gauguin: 'Autoretrato con crucifijo'",
            "Goya: 'Los fusilamientos del 3 de mayo'",
            "Klint: 'Madame Fritz'",
            "Leonardo da Vinci: 'La Gioconda'",
            "Manet: 'Desayuno sobre la hierba'",
            "Rembrandt: 'La ronda de noche'",
            "Renoir: 'Mujer en el tocador'"
    };

    int i=0;
    int totalObras=obraId.length;

    Button btnPrevio, btnSiguiente;
    TextView tvDescripcion;
    ImageView ivCuadro;
    //Creo un Object MediaPlayer
    MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnPrevio=(Button)findViewById(R.id.btnPrevio);
        btnSiguiente=(Button)findViewById(R.id.btnSiguiente);
        ivCuadro=(ImageView)findViewById(R.id.ivCuadro);
        tvDescripcion=(TextView)findViewById(R.id.tvDescripcion);

        btnPrevio.setOnClickListener(this);
        btnSiguiente.setOnClickListener(this);
        //instancio el MediaPlayer con el metodo create()
        mp = MediaPlayer.create(this, R.raw.click);
    }

    @Override
    public void onClick(View view) {
        int id=view.getId();
        if(id==R.id.btnSiguiente){
            i++;
            if(i==totalObras)
                i=0;
            //inicio el sonido
            mp.start();
        }

        else {
            i--;
            if(i==-1)
                i=totalObras-1;
            mp.start();
        }

        ivCuadro.setImageResource(obraId[i]);
        tvDescripcion.setText(descripcionObra[i]);

    }
}
