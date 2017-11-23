package com.example.chaoa.livehood.util;

/**
 * Created by ChaOa on 02/12/2016.
 */

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;
import com.example.chaoa.livehood.R;
import java.util.List;
import com.example.chaoa.livehood.model.Modulo;

public class ArrayAdapterModulos extends ArrayAdapter{

    Context context;
    List<Modulo> modulos;
    TextView txtNome;
    int posGeral;

    public ArrayAdapterModulos(Context context, List<Modulo> modulos, int pos){
        super(context,0,modulos);
        this.context = context;
        this.modulos = modulos;
        this.posGeral = pos;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Modulo modulo = modulos.get(position);

        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item_layout,null);
        }

        txtNome = (TextView) convertView.findViewById(R.id.txtNome);

        txtNome.setText(modulo.getNome());

        if(posGeral == position) {
            txtNome.setTextColor(Color.RED);
        }

        return convertView;
    }
}

