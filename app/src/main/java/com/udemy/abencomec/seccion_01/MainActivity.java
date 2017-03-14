package com.udemy.abencomec.seccion_01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.udemy.abencomec.seccion_01.entity.Persona;

public class MainActivity extends AppCompatActivity {
    private Persona persona;

    private EditText txtNombre;
    private EditText txtEmail;
    private EditText txtTelefono;
    private Button btnSiguiente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_myform);
        iniciar();


        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!txtNombre.getText().equals(null) && !txtNombre.getText().equals("")) {
                    btnSiguiente.setClickable(true);
                    Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                    intent.putExtra("persona", persona);
                    startActivity(intent);
                } else {
                    btnSiguiente.setClickable(false);
                    Toast.makeText(MainActivity.this, "", Toast.LENGTH_LONG).show();
                }

                persona = new Persona();
                persona.setNombre(txtNombre.getText().toString());
                persona.setEmail(txtEmail.getText().toString());
                persona.setTelefono(txtTelefono.getText().toString());



            }
        });


    }

    private void iniciar() {
        btnSiguiente = (Button) findViewById(R.id.next);
        btnSiguiente.setClickable(false);
        txtNombre = (EditText) findViewById(R.id.txtNombre);
        txtEmail = (EditText) findViewById(R.id.txtEmail);
        txtTelefono = (EditText) findViewById(R.id.txtTelefono);

    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
}
