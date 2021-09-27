package com.example.listabd;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class AdapterListContact extends BaseAdapter {
    private List<Contact> list;
    private Context context;
    private int resouce;

    public AdapterListContact(List<Contact> list, Context context, int resouce){
        this.list = list;
        this.context = context;
        this.resouce = resouce;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(resouce,null);

        TextView nombre =(TextView) convertView.findViewById(R.id.AlcTvInfNombre);
        TextView apellido = convertView.findViewById(R.id.AlcTVInfApellido);
        TextView numero = convertView.findViewById(R.id.AlcTvInfNumero);

        nombre.setText(list.get(position).getNombre());
        apellido.setText(list.get(position).getApellido());
        numero.setText(list.get(position).getNumero());
        return convertView;
    }
}
