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

                if (persona.getEdad() >= 16 && persona.getEdad() < 60) {
                    btnCompartir.setVisibility(View.VISIBLE);

                } else {
                    if (persona.getEdad() <= 16) {

                        Toast.makeText(SecondActivity.this, "No puedes compartir contenido porque" +
                                " debes ser mayor de 16", Toast.LENGTH_SHORT).show();

                    }else if(persona.getEdad() > 60){
                        Toast.makeText(SecondActivity.this, "No puedes compartir contenido porque" +
                                "debes ser menor de 60", Toast.LENGTH_SHORT).show();
                    }

                    btnCompartir.setVisibility(View.INVISIBLE);

                }

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

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
