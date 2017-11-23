package com.example.chaoa.livehood.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.chaoa.livehood.R;
import com.example.chaoa.livehood.dao.UsuarioDao;
import com.example.chaoa.livehood.model.Usuario;


public class CadastroActivity extends AppCompatActivity {

    EditText edtUsuario, edtSenha, edtNome, edtEmail, edtNascimento, edtCidade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        edtUsuario = (EditText) findViewById(R.id.edtUsuario);
        edtSenha = (EditText) findViewById(R.id.edtSenha);
        edtNome = (EditText) findViewById(R.id.edtNome);
        edtEmail = (EditText) findViewById(R.id.edtEmail);
        edtNascimento = (EditText) findViewById(R.id.edtNascimento);
        edtCidade = (EditText) findViewById(R.id.edtCidade);

    }

    public void btnRegistrarClick(View view) {

        Usuario u = new Usuario();
        u.setUsuario(edtUsuario.getText().toString());
        u.setSenha(edtSenha.getText().toString());
        u.setNome(edtNome.getText().toString());
        u.setEmail(edtEmail.getText().toString());
        u.setNascimento(edtNascimento.getText().toString());
        u.setCidade(edtCidade.getText().toString());



        if(!u.getUsuario().equals("") && !u.getSenha().equals("") && !u.getNome().equals("") && !u.getEmail().equals("")) {
            UsuarioDao.adicionarUsuario(getApplicationContext(), u);

            Intent intent = new Intent(CadastroActivity.this, MainActivity.class);
            startActivity(intent);
        }
        else{
            Toast.makeText(CadastroActivity.this, "Por favor, preencha todos os campos!", Toast.LENGTH_SHORT).show();
        }
    }
}
