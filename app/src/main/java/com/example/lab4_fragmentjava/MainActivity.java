package com.example.lab4_fragmentjava;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

public class MainActivity extends AppCompatActivity {
    private TextView txtNombres;
    private TextView txtApellidos;
    private TextView txtUsuario;
    private TextView txtContrasena;

    private BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent != null) {
                String nombres = intent.getStringExtra("nombres");
                String apellidos = intent.getStringExtra("apellidos");
                String usuario = intent.getStringExtra("usuario");
                String contrasena = intent.getStringExtra("contrasena");

                txtNombres.setText("Nombres: " + nombres);
                txtApellidos.setText("Apellidos: " + apellidos);
                txtUsuario.setText("Usuario: " + usuario);
                txtContrasena.setText("Contraseña: " + contrasena);
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtNombres = findViewById(R.id.edtNombres);
        txtApellidos = findViewById(R.id.edtApellidos);
        txtUsuario = findViewById(R.id.edtUsuario2);
        txtContrasena = findViewById(R.id.edtContrasena2);

        LocalBroadcastManager.getInstance(this).registerReceiver(receiver,
                new IntentFilter("com.example.ejmresuelt26_05.USER_DATA"));

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.framelayout, new BlankFragment())
                .commit();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        LocalBroadcastManager.getInstance(this).unregisterReceiver(receiver);
    }
}