package com.lab02.visitamedica;

import static com.lab02.visitamedica.R.id.txtDatoPac;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button buttonSendEmail, btnregistrar;
    private TextView mostrarDatosPacientes;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonSendEmail = (Button) findViewById(R.id.btnEnviarCorreo);

        buttonSendEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String destino  = "";
                String asunto   = "";
                String mensaje  = "";

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

        String nombres   = getIntent().getStringExtra("nombres");
        String apellidos    = getIntent().getStringExtra("apellidos");
        String dni          = getIntent().getStringExtra("dni");
        String direccion    = getIntent().getStringExtra("direccion");
        String correo       = getIntent().getStringExtra("correo");

        mostrarDatosPacientes.setText("Nombres: "+nombres+"\nApellidos: "+apellidos+"\nDNI: "+dni+"\nDirección: "+direccion+"\nCorreo: "+correo);


        btnregistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i    = new Intent(MainActivity.this,Registrar_Paciente_Activity.class);

                startActivity(i);
            }
        });


    }

}