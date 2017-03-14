package com.udemy.abencomec.seccion_01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.udemy.abencomec.seccion_01.entity.Persona;

public class SecondActivity extends AppCompatActivity {

    private Persona persona;
    private SeekBar seekBar;
    private TextView tvProgreso;
    private Button btnCompartir;
    int pro = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Bundle bundle = getIntent().getExtras();
        persona = (Persona) bundle.get("persona");
        tvProgreso = (TextView) findViewById(R.id.tvProgreso);
        seekBar = (SeekBar) findViewById(R.id.seekBar);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                persona.setEdad(progress);
                tvProgreso.setText("" + persona.getEdad());

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        btnCompartir = (Button) findViewById(R.id.btnCompartir);
        btnCompartir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentCompartir = new Intent(SecondActivity.this, ThirdActivity.class);
                intentCompartir.putExtra("persona", persona);
                if (pro >= 18 || pro <60 ) {
                    startActivity(intentCompartir);
                } else {
                    Toast.makeText(SecondActivity.this, "No puedes compartir contenido porque no tienes la edad requerida", Toast.LENGTH_LONG).show();
                }

            }
        });


    }

}
