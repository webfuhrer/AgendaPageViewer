package com.example.luis.agendapageviewer;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.List;

/**
 * Created by luis on 23/11/2017.
 */

public class FragmentoListar extends Fragment {
    EditText et_nombre, et_telefono;
    Button btn_grabar;
    static AdaptadorListView a;
    static List lista_contactos;
    static Context contexto;
    static ListView lv;
    public FragmentoListar() {
        Log.v("FragmentoListar", "Entrada en constructor de fragmento listar");


    }

    public static void actualizarData()
    {
        if(a!=null)
        {
            rellenarLista();
            inicializarAdaptador();

        }
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View vista_listar=inflater.inflate(R.layout.fragment_listar, container, false);
        lv=vista_listar.findViewById(R.id.list_view);
        contexto=getContext();
        rellenarLista();
        inicializarAdaptador();

return vista_listar;
    }
    public static void rellenarLista()
    {
        lista_contactos=AccesoBD.devolverContactos(contexto);
    }
    public static void inicializarAdaptador()
    {
        a=new AdaptadorListView( contexto, lista_contactos);
        lv.setAdapter(a);
    }
}
