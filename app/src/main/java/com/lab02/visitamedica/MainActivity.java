package com.lab02.visitamedica;

import static com.lab02.visitamedica.R.id.txtDatoPac;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button buttonSendEmail, btnregistrar, btnRegistrarVisita;
    private TextView mostrarDatosPacientes;

    String nombres  ;
    String apellidos;
    String dni    ;
    String direccion;
    String correo;

    String valoresCorreo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonSendEmail = (Button) findViewById(R.id.btnEnviarCorreo);

        buttonSendEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String destino  = correo;
                String asunto   = "Laboratorio 03";
                String mensaje  = valoresCorreo;

                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_EMAIL, new String[]{destino});
                intent.putExtra(Intent.EXTRA_SUBJECT, asunto);
                intent.putExtra(Intent.EXTRA_TEXT, mensaje);
                intent.setType("message/rfc822");

                startActivity(Intent.createChooser(intent,"Elija una aplicación de correo"));

            }
        });

        mostrarDatosPacientes   = (TextView)findViewById (R.id.txtDatoPac);
        btnregistrar       = (Button) findViewById(R.id.btnRegistrarPac2);

        btnregistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i    = new Intent(MainActivity.this,Registrar_Paciente_Activity.class);
                startActivityForResult(i, 1);
            }
        });

        btnRegistrarVisita = (Button) findViewById(R.id.btnRegistrarVisita);
        btnRegistrarVisita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(dni!=null) {
                    Intent i = new Intent(MainActivity.this, Registrar_Visita_Activity.class);
                    i.putExtra("dni",dni);
                    startActivityForResult(i, 2);

                }else{
                    Toast.makeText(getApplicationContext(), "No existe DNI. Registre paciente.", Toast.LENGTH_LONG).show();
                }
            }
        });

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1) {
            nombres   = data.getStringExtra("nombres");
            apellidos    = data.getStringExtra("apellidos");
            dni          = data.getStringExtra("dni");
            direccion    = data.getStringExtra("direccion");
            correo       = data.getStringExtra("correo");
            mostrarDatosPacientes.setText("Nombres: "+nombres+"\nApellidos: "+apellidos+"\nDNI: "+dni+"\nDirección: "+direccion+"\nCorreo: "+correo);
        }
        if(requestCode == 2){
            valoresCorreo = data.getStringExtra("valoresVisita");
        }

    }
}