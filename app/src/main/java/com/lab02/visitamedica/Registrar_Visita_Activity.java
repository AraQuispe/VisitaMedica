package com.lab02.visitamedica;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class Registrar_Visita_Activity extends AppCompatActivity {
    private TextView mostrarDNI;
    private EditText editWeight,editTemperature,editPresion,editSaturación;
    private ArrayList<String> arrayList= new ArrayList<String>();
    Button btnRegister,btnCancel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_visita);
        String dni = getIntent().getStringExtra("dni");
        mostrarDNI= (TextView)findViewById (R.id.textViewDNI);
        mostrarDNI.setText("DNI: " +dni);
        editWeight     = findViewById(R.id.editWeight);
        editTemperature   = findViewById(R.id.editTemperature);
        editPresion  = findViewById(R.id.editPresion);
        editSaturación   = findViewById(R.id.editSaturación);
        btnRegister = findViewById(R.id.btnRegister);
        btnCancel = findViewById(R.id.btnCancel);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    arrayList.add( "NUEVO REGISTRO\n"+"Su peso: "+editWeight.getText().toString()+  "\n"+
                                  "Su temperatura: "+editTemperature.getText().toString()+   "\n"+
                                  "Su Presion: "+ editPresion.getText().toString()+ "\n"+
                                  "Su saturación"+ editSaturación.getText().toString()+ "\n");
                    Log.d("Array",arrayList.toString());
            }

        });
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i    = new Intent(Registrar_Visita_Activity.this,MainActivity.class);
                i.putExtra("valoresVisita",arrayList.toString());
                startActivity(i);
            }

        });
    }
}