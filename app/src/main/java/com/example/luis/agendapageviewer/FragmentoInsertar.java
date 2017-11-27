package com.example.luis.agendapageviewer;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

/**
 * Created by luis on 23/11/2017.
 */

public class FragmentoInsertar extends Fragment {
    EditText et_nombre, et_telefono;
    Button btn_grabar;
    public FragmentoInsertar() {
        super();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View vista_insertar=inflater.inflate(R.layout.fragment_insertar, container, false);
        et_nombre=vista_insertar.findViewById(R.id.et_nombre);
        et_telefono=vista_insertar.findViewById(R.id.et_telefono);
        btn_grabar=vista_insertar.findViewById(R.id.btn_grabar);
        btn_grabar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombre=et_nombre.getText().toString();
                String telefono=et_telefono.getText().toString();
                Contacto c=new Contacto(nombre, telefono);
                AccesoBD.grabarContacto(c, getContext());
                FragmentoListar.actualizarData();
            }
        });

        return vista_insertar;
    }

}
