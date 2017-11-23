package com.example.chaoa.livehood.view;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.chaoa.livehood.R;
import com.example.chaoa.livehood.dao.CursoDao;
import com.example.chaoa.livehood.dao.ExercicioDao;
import com.example.chaoa.livehood.dao.ModuloDao;
import com.example.chaoa.livehood.dao.RespostaDao;
import com.example.chaoa.livehood.dao.RespostaUsuarioDao;
import com.example.chaoa.livehood.dao.UsuarioDao;
import com.example.chaoa.livehood.model.Curso;
import com.example.chaoa.livehood.model.Exercicio;
import com.example.chaoa.livehood.model.Modulo;
import com.example.chaoa.livehood.model.Resposta;
import com.example.chaoa.livehood.model.Usuario;
import com.example.chaoa.livehood.util.ArrayAdapterRespostas;

import java.util.List;

public class ExercicioActivity extends AppCompatActivity {

    TextView txtPergunta;
    ListView lstRespostas;
    String itemSelecionadoModulo, itemSelecionadoResposta, itemSelecionadoCurso, usuario;
    Integer idExercicio, idCurso;

    Usuario u;
    Modulo m = new Modulo();
    Curso c = new Curso();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercicio);

        usuario = getIntent().getStringExtra("Usuario");
        u = UsuarioDao.retornarUsuarioPorNome(getApplicationContext(), usuario);

        txtPergunta = (TextView) findViewById(R.id.txtPergunta);
        itemSelecionadoModulo = getIntent().getStringExtra("Modulo");
        m.setNome(itemSelecionadoModulo);
        Integer idModulo = ModuloDao.retornarModuloPorNome(getApplicationContext(),m);
        m.setId(idModulo);
        itemSelecionadoCurso = getIntent().getStringExtra("Curso");
        c.setNome(itemSelecionadoCurso);
        idCurso = CursoDao.retornarCursoPorNome(getApplicationContext(),c);
        m.setCursoId(idCurso);

        //Lista os exercicios por usuário
        List<Exercicio> exercicios = ExercicioDao.retornarExercicio(getApplicationContext(),m, u);

        if(exercicios.size() > 0){

            //Preenche a pergunta do proximo exercicio
            txtPergunta.setText(exercicios.get(0).getPergunta());
            //pegar o id do proximo Exercicio
            idExercicio = ExercicioDao.retornarExercicioPorPergunta(getApplicationContext(), exercicios.get(0));

            //Listas respostas conforme o exercicio selecionado
            lstRespostas = (ListView) findViewById(R.id.lstRespostas);
            ArrayAdapterRespostas arrayAdapterRespostas = new ArrayAdapterRespostas(this, RespostaDao.retornarRespostas(getApplicationContext(), idExercicio),-1);
            lstRespostas.setAdapter(arrayAdapterRespostas);

            lstRespostas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick (AdapterView< ? > adapter, View view, int position, long arg){
                    TextView txtNome = (TextView) view.findViewById(R.id.txtNome);
                    //Toast.makeText(getApplicationContext(), "selected Item Name is " + txtNome.getText(), Toast.LENGTH_LONG).show();
                    itemSelecionadoResposta = (String) txtNome.getText();
                    ArrayAdapterRespostas arrayAdapterRespostas = new ArrayAdapterRespostas(ExercicioActivity.this, RespostaDao.retornarRespostas(getApplicationContext(), idExercicio),position);
                    lstRespostas.setAdapter(arrayAdapterRespostas);

                }
            });

        }
        else{

            Toast.makeText(this, "Não existem exercicios para carregar!", Toast.LENGTH_SHORT).show();
        }


    }

    public void btnContinuarClick(View view) {
        //Validar se a resposta está certa e informar ao usuário

        if (itemSelecionadoResposta != null) {
            Resposta r = new Resposta();
            r.setResposta(itemSelecionadoResposta);
            r.setExercicioId(idExercicio);
            // Carrego se a resposta é certa ou errada
            r = RespostaDao.retornarRespostaPorResposta(getApplicationContext(), r);

            if (ExercicioDao.validarResposta(getApplicationContext(), r)) {
                Toast.makeText(this, "Parabéns, você acertou!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "infelizmente , você errou!", Toast.LENGTH_SHORT).show();
            }
            // Gravar a resposta do usuário
            RespostaUsuarioDao.adicionarRespostaUsuario(getApplicationContext(), r, u, m);
            //RespostaUsuarioDao.retornarRespostasUsuario(getApplicationContext(),r,u,m);

            // Carregar a proximo exercicio e respostas
            List<Exercicio> exercicios = ExercicioDao.retornarExercicio(getApplicationContext(), m, u);

            if (exercicios.size() > 0) {
                Intent intent = new Intent(ExercicioActivity.this, ExercicioActivity.class);
                intent.putExtra("Modulo", itemSelecionadoModulo);
                intent.putExtra("Curso", itemSelecionadoCurso);
                intent.putExtra("Usuario", usuario);
                startActivity(intent);
                // Fecha a intent de pergunta anterior
                finish();
            } else {
                // Criar Notificação e envio de e-mail se não existirem mais perguntas
               /*
                Toast.makeText(this, "Parabéns, você finalizou o modulo " + itemSelecionadoModulo, Toast.LENGTH_SHORT).show();
                 */

                //********************************************************************//
                //                     E - M A I L                                  **//
                //********************************************************************//
                String[] emails = new  String[]{
                        u.getEmail()
                };

                final Intent intentEmail = new Intent(Intent.ACTION_SENDTO); // it's not ACTION_SEND
                intentEmail.setType("text/plain");
                intentEmail.putExtra(Intent.EXTRA_SUBJECT, "Parabéns, você finalizou um modulo!"); // assunto
                intentEmail.putExtra(Intent.EXTRA_TEXT, "Parabéns, você finalizou o modulo: "+ itemSelecionadoModulo + " do curso: " + itemSelecionadoCurso);
                intentEmail.setData(Uri.parse("mailto:")); // or just "mailto:" for blank
                intentEmail.putExtra(Intent.EXTRA_EMAIL, emails);
                //intentEmail.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK); // this will make such that when user returns to your app, your app is displayed, instead of the email app.
                //startActivity(intentEmail);
                startActivity(Intent.createChooser(intentEmail, "Selecione um aplicativo"));


                //********************************************************************/
                //                     N O T I F I C A Ç Ã O                        **//
                //********************************************************************//

                final NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
                builder.setSmallIcon(R.drawable.logo);
                builder.setContentTitle("Conclusão do modulo" + itemSelecionadoModulo + "!");
                builder.setContentText("Parabéns, você finalizou o modulo!" );
                //builder.setContentText("Parabéns, você finalizou o modulo: " + itemSelecionadoModulo + " do curso: " + itemSelecionadoCurso );

                Intent notificationIntent = new Intent(this, CursoActivity.class);
                notificationIntent.putExtra("Usuario", usuario);

                PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT );

                builder.setContentIntent(pendingIntent);

                final NotificationManager notificationManager = ( NotificationManager ) getSystemService(Context.NOTIFICATION_SERVICE);

                notificationManager.notify(0, builder.build());



                AlertDialog.Builder builderDiag = new AlertDialog.Builder(ExercicioActivity.this);
                builderDiag.setTitle("Livehood");
                builderDiag.setMessage("Você concluiu o modulo! Você deseja selecionar um novo:");

                builderDiag.setPositiveButton("Modulo", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(ExercicioActivity.this, ModuloActivity.class);
                        intent.putExtra("Usuario", usuario);
                        intent.putExtra("Curso",itemSelecionadoCurso);
                        startActivity(intent);

                    }

                });

                builderDiag.setNegativeButton("Curso", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(ExercicioActivity.this, CursoActivity.class);
                        intent.putExtra("Usuario", usuario);
                        startActivity(intent);
                    }
                });

                AlertDialog alertDialog = builderDiag.create();
                alertDialog.setCanceledOnTouchOutside(false);
                alertDialog.show();


            }
        }
        else {
            Toast.makeText(this, "Por Favor, selecione uma resposta!", Toast.LENGTH_SHORT).show();
        }
    }
}
