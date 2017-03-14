package com.udemy.abencomec.seccion_01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.udemy.abencomec.seccion_01.entity.Persona;

public class ThirdActivity extends AppCompatActivity {
    private Button btnComparti;
    private Button btnOK;
    private Persona persona;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);

        btnOK = (Button) findViewById(R.id.btnOK);
        btnComparti = (Button) findViewById(R.id.btnCompartir);
        Bundle bundle = getIntent().getExtras();
        persona = (Persona) bundle.get("persona");

        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnComparti.setVisibility(View.VISIBLE);
                btnOK.setVisibility(View.INVISIBLE);
            }
        });

        btnComparti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sendIntent = new Intent()
                        .setAction(Intent.ACTION_SEND)
                        .putExtra(Intent.EXTRA_STREAM, persona.getMenssage())
                        .setType("text/plain");
                startActivity(Intent.createChooser(sendIntent, "Elegir la app para compartir"));
            }
        });

    }
}
