package com.udemy.abencomec.seccion_01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.udemy.abencomec.seccion_01.entity.Persona;

public class SecondActivity extends AppCompatActivity {

    private Persona persona;
    private SeekBar seekBar;
    private TextView tvProgreso;
    private Button btnCompartir;
    private RadioButton rdTipo;
    private static final int MAX_AGE = 60;
    private static final int MIN_AGE = 16;
    int pro = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Bundle bundle = getIntent().getExtras();
        persona = (Persona) bundle.get("persona");
        tvProgreso = (TextView) findViewById(R.id.tvProgreso);
        btnCompartir = (Button) findViewById(R.id.btnCompartir);
        seekBar = (SeekBar) findViewById(R.id.seekBar);
        rdTipo = (RadioButton) findViewById(R.id.rdSaludar);
        persona.setEdad(Integer.parseInt(tvProgreso.getText().toString()));

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                persona.setEdad(0);
                persona.setEdad(progress);
                tvProgreso.setText("" + persona.getEdad());


            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                persona.setEdad(0);
                persona.setEdad(seekBar.getProgress());
                tvProgreso.setText("" + persona.getEdad());

                if (persona.getEdad() >= MIN_AGE && persona.getEdad() < MAX_AGE) {
                    btnCompartir.setVisibility(View.VISIBLE);

                } else {
                    if (persona.getEdad() <= MIN_AGE) {

                        Toast.makeText(SecondActivity.this, "No puedes compartir contenido porque" +
                                " debes ser mayor de 16", Toast.LENGTH_SHORT).show();

                    }else if(persona.getEdad() > MAX_AGE){
                        Toast.makeText(SecondActivity.this, "No puedes compartir contenido porque" +
                                "debes ser menor de 60", Toast.LENGTH_SHORT).show();
                    }

                    btnCompartir.setVisibility(View.INVISIBLE);

                }

            }
        });

        btnCompartir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                persona.setTipo(rdTipo.isChecked());
                Intent intentCompartir = new Intent(SecondActivity.this, ThirdActivity.class);
                intentCompartir.putExtra("persona", persona);
                startActivity(intentCompartir);
            }
        });


    }

}
