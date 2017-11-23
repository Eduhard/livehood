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
import com.example.chaoa.livehood.model.Curso;
import com.example.chaoa.livehood.view.MainActivity;

import java.util.List;

public class ArrayAdapterCursos extends ArrayAdapter{



    Context context;
    List<Curso> cursos;
    TextView txtNome;
    int posGeral;

    public ArrayAdapterCursos(Context context, List<Curso> cursos, int pos){
        super(context,0,cursos);
        this.context = context;
        this.cursos = cursos;
        this.posGeral = pos;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Curso curso = cursos.get(position);

        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item_layout,null);
        }

        txtNome = (TextView) convertView.findViewById(R.id.txtNome);

        txtNome.setText(curso.getNome());

        if(posGeral == position) {
            txtNome.setTextColor(Color.RED);
        }

        return convertView;
    }
}
