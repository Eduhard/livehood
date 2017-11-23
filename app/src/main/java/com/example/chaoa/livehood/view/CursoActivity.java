package com.example.chaoa.livehood.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.chaoa.livehood.R;
import com.example.chaoa.livehood.dao.CursoDao;
import com.example.chaoa.livehood.dao.UsuarioDao;
import com.example.chaoa.livehood.util.ArrayAdapterCursos;

public class CursoActivity extends AppCompatActivity {

    ListView lstCursos;
    String itemSelecionadoCurso, usuario;
    TextView txtNome, txtNascimento, txtCidade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_curso);

        usuario = getIntent().getStringExtra("Usuario");

        txtNome = (TextView) findViewById(R.id.txtNome);
        txtNome.setText(UsuarioDao.retornarUsuarioPorNome(getApplicationContext(), usuario).getNome().toString());

        txtNascimento = (TextView) findViewById(R.id.txtNascimento);
        txtNascimento.setText(UsuarioDao.retornarUsuarioPorNome(getApplicationContext(), usuario).getNascimento().toString());

        txtCidade = (TextView) findViewById(R.id.txtCidade);
        txtCidade.setText(UsuarioDao.retornarUsuarioPorNome(getApplicationContext(), usuario).getCidade().toString());

        lstCursos = (ListView) findViewById(R.id.lstCursos);
        ArrayAdapterCursos arrayAdapterCursos = new ArrayAdapterCursos(this, CursoDao.retornarCursos(getApplicationContext()),-1);
        lstCursos.setAdapter(arrayAdapterCursos);

        lstCursos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                        @Override
                                        public void onItemClick (AdapterView < ? > adapter, View view,int position, long arg){
                                            TextView txtNome = (TextView) view.findViewById(R.id.txtNome);
                                            //Toast.makeText(getApplicationContext(), "selected Item Name is " + position, Toast.LENGTH_LONG).show();

                                            itemSelecionadoCurso = (String) txtNome.getText();
                                            lstCursos.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
                                            ArrayAdapterCursos arrayAdapterCursos = new ArrayAdapterCursos(CursoActivity.this, CursoDao.retornarCursos(getApplicationContext()),position);
                                            lstCursos.setAdapter(arrayAdapterCursos);

                                        }
                                    });


    }

    public void btnContinuarClick(View view) {


        Intent intent = new Intent(CursoActivity.this, ModuloActivity.class);
        if (itemSelecionadoCurso != null){
            intent.putExtra("Curso",itemSelecionadoCurso);
            intent.putExtra("Usuario",usuario);
            startActivity(intent);
        }
        else {
            Toast.makeText(this, "Por Favor, selecione um curso!", Toast.LENGTH_SHORT).show();
        }
    }

}

