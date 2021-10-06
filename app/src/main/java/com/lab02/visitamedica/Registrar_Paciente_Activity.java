package com.lab02.visitamedica;

import android.app.Activity;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Registrar_Paciente_Activity extends AppCompatActivity {

    EditText nombres,apellidos,dni,direccion,correo;
    Button registrar,cancelar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_paciente);

        nombres     = findViewById(R.id.editPersonName);
        apellidos   = findViewById(R.id.editPersonLastName);
        dni         = findViewById(R.id.editDNI);
        direccion   = findViewById(R.id.editPersonAddress);
        correo      = findViewById(R.id.editEmailAddress);

        registrar   = findViewById(R.id.btnRegister);
        cancelar    = findViewById(R.id.btnCancel);

        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(Registrar_Paciente_Activity.this,MainActivity.class);

                i.putExtra("nombres",nombres.getText().toString());
                i.putExtra("apellidos",apellidos.getText().toString());
                i.putExtra("dni",dni.getText().toString());
                i.putExtra("direccion",direccion.getText().toString());
                i.putExtra("correo",correo.getText().toString());

                setResult(1, i);
                finish();

            }
        });

        cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                limpiarDatos();
            }
        });
    }

    private void limpiarDatos(){
        nombres.setText("");
        apellidos.setText("");
        dni.setText("");
        direccion.setText("");
        correo.setText("");
    }

}
