package com.example.luis.agendapageviewer;

import android.content.Context;
import android.database.DataSetObserver;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by luis on 24/11/2017.
 */

public class AdaptadorListView extends BaseAdapter {
List<Contacto> lista;
Context contexto;

    public AdaptadorListView(Context contexto, List lista) {
        this.lista = lista;
        this.contexto = contexto;

    }

    @Override
    public boolean areAllItemsEnabled() {
        return true;
    }

    @Override
    public boolean isEnabled(int position) {
        return true;
    }

    @Override
    public void registerDataSetObserver(DataSetObserver observer) {

    }

    @Override
    public void unregisterDataSetObserver(DataSetObserver observer) {

    }

    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public Object getItem(int position) {
        return lista.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater=LayoutInflater.from(contexto);
        View v=inflater.inflate(R.layout.objeto_listview, parent, false);
        TextView tv_nombre=v.findViewById(R.id.tv_nombre);
        TextView tv_telefono=v.findViewById(R.id.tv_telefono);
        tv_nombre.setText(lista.get(position).getNombre());
        tv_telefono.setText(lista.get(position).getTelefono());
        return v;
    }

    @Override
    public int getItemViewType(int position) {
        return 1;
    }

    @Override
    public int getViewTypeCount() {
        return lista.size();
    }

    @Override
    public boolean isEmpty() {
        return lista.isEmpty();
    }
}
