package com.example.lab4_fragmentjava;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

public class BlankFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_blank, container, false);

        EditText edtNombres = view.findViewById(R.id.edtNombres);
        EditText edtApellidos = view.findViewById(R.id.edtApellidos);
        EditText edtUsuario = view.findViewById(R.id.edtUsuario2);
        EditText edtContrasena = view.findViewById(R.id.edtContrasena2);
        Button btnEnviarDatos = view.findViewById(R.id.btnEnviarDatos);

        btnEnviarDatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombres = edtNombres.getText().toString();
                String apellidos = edtApellidos.getText().toString();
                String usuario = edtUsuario.getText().toString();
                String contrasena = edtContrasena.getText().toString();

                Intent intent = new Intent("com.example.ejmresuelt26_05.USER_DATA");
                intent.putExtra("nombres", nombres);
                intent.putExtra("apellidos", apellidos);
                intent.putExtra("usuario", usuario);
                intent.putExtra("contrasena", contrasena);

                LocalBroadcastManager.getInstance(requireContext()).sendBroadcast(intent);
            }
        });

        return view;
    }
}