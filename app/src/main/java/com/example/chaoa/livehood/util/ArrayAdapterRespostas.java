package com.example.chaoa.livehood.util;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.chaoa.livehood.R;
import com.example.chaoa.livehood.model.Modulo;
import com.example.chaoa.livehood.model.Resposta;

import java.util.List;

/**
 * Created by ChaOa on 03/12/2016.
 */

public class ArrayAdapterRespostas extends ArrayAdapter {

    Context context;
    List<Resposta> respostas;
    TextView txtNome;
    int posGeral;

    public ArrayAdapterRespostas(Context context, List<Resposta> respostas, int pos){
        super(context,0,respostas);
        this.context = context;
        this.respostas = respostas;
        this.posGeral = pos;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Resposta resposta = respostas.get(position);

        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item_layout,null);
        }

        txtNome = (TextView) convertView.findViewById(R.id.txtNome);

        txtNome.setText(resposta.getResposta());

        if(posGeral == position) {
            txtNome.setTextColor(Color.RED);
        }


        return convertView;
    }
}
