package com.example.chaoa.livehood.view;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.chaoa.livehood.R;
import com.example.chaoa.livehood.dao.CursoDao;
import com.example.chaoa.livehood.dao.ExercicioDao;
import com.example.chaoa.livehood.dao.ModuloDao;
import com.example.chaoa.livehood.dao.UsuarioDao;
import com.example.chaoa.livehood.model.Exercicio;
import com.example.chaoa.livehood.model.Modulo;
import com.example.chaoa.livehood.model.Usuario;
import com.example.chaoa.livehood.util.ArrayAdapterCursos;
import com.example.chaoa.livehood.util.ArrayAdapterModulos;

import java.util.List;

public class ModuloActivity extends AppCompatActivity {

    ListView lstModulos;

    String itemSelecionadoCurso, itemSelecionadoModulo, usuario;
    TextView txtNome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_modulo);

        usuario = getIntent().getStringExtra("Usuario");
        txtNome = (TextView) findViewById(R.id.txtNome);
        txtNome.setText(UsuarioDao.retornarUsuarioPorNome(getApplicationContext(), usuario).getNome().toString());

        lstModulos = (ListView) findViewById(R.id.lstModulos);
        itemSelecionadoCurso = getIntent().getStringExtra("Curso");
        ArrayAdapterModulos arrayAdapterModulos = new ArrayAdapterModulos(this, ModuloDao.retornarModulos(getApplicationContext(),itemSelecionadoCurso), -1);
        lstModulos.setAdapter(arrayAdapterModulos);

        lstModulos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick (AdapterView< ? > adapter, View view, int position, long arg){
                TextView txtNome = (TextView) view.findViewById(R.id.txtNome);
                //Toast.makeText(getApplicationContext(), "selected Item Name is " + txtNome.getText(), Toast.LENGTH_LONG).show();
                itemSelecionadoModulo = (String) txtNome.getText();
                ArrayAdapterModulos arrayAdapterModulos = new ArrayAdapterModulos(ModuloActivity.this, ModuloDao.retornarModulos(getApplicationContext(),itemSelecionadoCurso), position);
                lstModulos.setAdapter(arrayAdapterModulos);
            }
        });



        //Toast.makeText(this, "Curso Selecionado"+ itemSelecionadoCurso, Toast.LENGTH_SHORT).show();

    }

    public void btnContinuarClick(View view) {

        Modulo m = new Modulo();
        Usuario u;


        //Validar se existem exercicios para exbir
        m.setNome(itemSelecionadoModulo);
        Integer idModulo = ModuloDao.retornarModuloPorNome(getApplicationContext(),m);
        m.setId(idModulo);
        u = UsuarioDao.retornarUsuarioPorNome(getApplicationContext(), usuario);

        List<Exercicio> exercicios = ExercicioDao.retornarExercicio(getApplicationContext(),m, u);


        if(exercicios.size() > 0) {

            if (itemSelecionadoModulo != null) {
                Intent intent = new Intent(ModuloActivity.this, ExercicioActivity.class);
                intent.putExtra("Modulo", itemSelecionadoModulo);
                intent.putExtra("Curso", itemSelecionadoCurso);
                intent.putExtra("Usuario", usuario);
                startActivity(intent);
            } else {
                Toast.makeText(this, "Por Favor, selecione um modulo!", Toast.LENGTH_SHORT).show();
            }
        }
        else{
            Toast.makeText(this, "Você já finalizou o modulo " + itemSelecionadoModulo, Toast.LENGTH_SHORT).show();
        }

    }
}
