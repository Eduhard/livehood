package com.example.chaoa.livehood.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.chaoa.livehood.R;
import com.example.chaoa.livehood.dao.CursoDao;
import com.example.chaoa.livehood.dao.ExercicioDao;
import com.example.chaoa.livehood.dao.ModuloDao;
import com.example.chaoa.livehood.dao.RespostaDao;
import com.example.chaoa.livehood.dao.UsuarioDao;
import com.example.chaoa.livehood.model.Curso;
import com.example.chaoa.livehood.model.Exercicio;
import com.example.chaoa.livehood.model.Modulo;
import com.example.chaoa.livehood.model.Resposta;
import com.example.chaoa.livehood.model.Usuario;


public class MainActivity extends AppCompatActivity {

    EditText edtUsuario, edtSenha;
    Button btnCadastro, btnEntrar;
    String usuario, senha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtUsuario = (EditText) findViewById(R.id.edtUsuario);
        edtSenha = (EditText) findViewById(R.id.edtSenha);
        btnCadastro = (Button) findViewById(R.id.btnCadastro);
        btnEntrar = (Button) findViewById(R.id.btnEntrar);



    }

    public void btnEntrarClick(View view) {

        usuario = edtUsuario.getText().toString();
        senha = edtSenha.getText().toString();
        Usuario u = new Usuario();

        //Validar se existe esse usuário e senha no banco
        u = UsuarioDao.retornarUsuarioPorNome(getApplicationContext(), usuario);

        if (u.getNome() != null && u.getUsuario().equals(usuario)){
            if (u.getSenha().equals(senha)){
                Intent intent = new Intent(MainActivity.this,CursoActivity.class);
                // Passa usuário como parametro para a tela de curso
                intent.putExtra("Usuario",usuario);
                startActivity(intent);
            }
            else {
                Toast.makeText(MainActivity.this, "Usuário ou senha inválido!", Toast.LENGTH_SHORT).show();
            }

        }
        else {
            Toast.makeText(MainActivity.this, "Usuário ou senha inválido!", Toast.LENGTH_SHORT).show();
        }
    }


    public void btnCadastroClick(View view) {

/*
        Curso c = new Curso();
        c.setNome("Português");
        CursoDao.adicionarCurso(getApplicationContext(), c);

        Modulo m = new Modulo();
        m.setNome("Português 1");
        ModuloDao.adicionarModulo(getApplicationContext(),m,c);

        Exercicio e = new Exercicio();
        e.setPergunta("Assinale a alternativa incorreta acerca da pontuação:");
        ExercicioDao.adicionarExercicio(getApplicationContext(),e,m);

        Resposta r = new Resposta();
        r.setResposta("Ribeirão Pires, 16 de fevereiro de 2009");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("Aqui está, filha, a saia que prometi");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("Domingo à tarde, fomos ao teatro");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("Mari, foi passear com sua irmã");
        r.setCorreta("S");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        e = new Exercicio();
        e.setPergunta("Todas as palavras estão corretamente formadas, EXCETO:");
        ExercicioDao.adicionarExercicio(getApplicationContext(),e,m);

        r = new Resposta();
        r.setResposta("dedutibilidade – obrigatoriedade");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("indistinguibilidade – espontaniedade");
        r.setCorreta("S");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("apreensibilidade – compulsoriedade");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("indemissibilidade – instantaneidade");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        e = new Exercicio();
        e.setPergunta("Uma das flexões verbais é a voz. A forma flexionada na voz passiva analítica é a em que se encontra o verbo:");
        ExercicioDao.adicionarExercicio(getApplicationContext(),e,m);

        r = new Resposta();
        r.setResposta("saber: ( [...] mas pelo que se sabe!)");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("ser: ( [...] mas mil dólares é um absurdo!)");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("dizer: (A nota dizia: “Serviços Prestados”)");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("chamar: (Um especialista foi chamado para solucionar um problema [...])");
        r.setCorreta("S");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        e = new Exercicio();
        e.setPergunta("Assinale a alternativa em que o vocábulo melhor funciona como advérbio:");
        ExercicioDao.adicionarExercicio(getApplicationContext(),e,m);

        r = new Resposta();
        r.setResposta("Ele é muito melhor que vocês");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("Nada melhor que um dia após o outro");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("Conheço isso melhor que vocês");
        r.setCorreta("S");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("Tudo é pior quando se vê melhor");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        e = new Exercicio();
        e.setPergunta("Marque a única alternativa em que todas as palavras estão grafadas corretamente.");
        ExercicioDao.adicionarExercicio(getApplicationContext(),e,m);

        r = new Resposta();
        r.setResposta("xampu – próclise – análize – nascer");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("mexer – exagero – paletó – exceção");
        r.setCorreta("S");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("vexame – mochila – exumação – ezílio");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("acréscimo – suscinto – lisongear – acensorista");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        m = new Modulo();
        m.setNome("Português 2");
        ModuloDao.adicionarModulo(getApplicationContext(),m,c);

        e = new Exercicio();
        e.setPergunta("A frase onde os parônimos estão com significação invertida é:");
        ExercicioDao.adicionarExercicio(getApplicationContext(),e,m);

        r = new Resposta();
        r.setResposta("Era iminente a queda do eminente político");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("Ele foi espectador da discussão, expectador de um final feliz");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("A justiça infringe uma pena a quem inflige a legislação vigente");
        r.setCorreta("S");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("O mandado de segurança culminou com a cassação do mandato");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        e = new Exercicio();
        e.setPergunta("Identifique a alternativa em que ocorre objeto direto pleonástico:");
        ExercicioDao.adicionarExercicio(getApplicationContext(),e,m);

        r = new Resposta();
        r.setResposta("Seus cavalos, ela os montava em pelo");
        r.setCorreta("S");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("Tia Mirtes já não sentia dor nem cansaço");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("Amava-a tanto como a nós");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("Sobram-lhe qualidades e recursos");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        e = new Exercicio();
        e.setPergunta("Aponte a substantivo masculino:");
        ExercicioDao.adicionarExercicio(getApplicationContext(),e,m);

        r = new Resposta();
        r.setResposta("Cal");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("Guaraná");
        r.setCorreta("S");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("Hélice");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("Omelete");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        e = new Exercicio();
        e.setPergunta("Analise as frases abaixo e assinale a alternativa correta em relação à concordância:");
        ExercicioDao.adicionarExercicio(getApplicationContext(),e,m);

        r = new Resposta();
        r.setResposta("Eles comeu bastante");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("Os óculos quebrou na bolsa de Carmem");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("Paula foram a festa com seus amigos");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("Milton jantou com seus pais");
        r.setCorreta("S");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        e = new Exercicio();
        e.setPergunta("Qual das alternativas apresenta correta concordância nominal?");
        ExercicioDao.adicionarExercicio(getApplicationContext(),e,m);

        r = new Resposta();
        r.setResposta("Ela conhece bastante lugares");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("É proibida entrada de animais");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("Faz-se necessária a compreensão de todos");
        r.setCorreta("S");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("Já é meio-dia e meio");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        m = new Modulo();
        m.setNome("Português 3");
        ModuloDao.adicionarModulo(getApplicationContext(),m,c);

        e = new Exercicio();
        e.setPergunta("Assinale a alternativa que apresenta o verbo usado na voz reflexiva:");
        ExercicioDao.adicionarExercicio(getApplicationContext(),e,m);

        r = new Resposta();
        r.setResposta("Vendem-se apartamentos à beira do mar");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("O menino feriu-se");
        r.setCorreta("S");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("Ele lembrou-se do ocorrido");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("O trabalho foi analisado por nós, os que o fizemos");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        e = new Exercicio();
        e.setPergunta("A relação ERRADA entre verbo e substantivo derivado é:");
        ExercicioDao.adicionarExercicio(getApplicationContext(),e,m);

        r = new Resposta();
        r.setResposta("render / renda");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("prover / provisão");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("evitar / evidência");
        r.setCorreta("S");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("aumentar / aumento");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        e = new Exercicio();
        e.setPergunta("O vocábulo que apresenta dígrafo encontra-se na alternativa:");
        ExercicioDao.adicionarExercicio(getApplicationContext(),e,m);

        r = new Resposta();
        r.setResposta("primeiro");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("vermelho");
        r.setCorreta("S");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("gordo");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("novato");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        e = new Exercicio();
        e.setPergunta("Qual dos substantivos abaixo é feminino?");
        ExercicioDao.adicionarExercicio(getApplicationContext(),e,m);

        r = new Resposta();
        r.setResposta("Dó");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("Formicida");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("Aguardente");
        r.setCorreta("S");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("Pólen");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        e = new Exercicio();
        e.setPergunta("Quantos adjetivos existem na frase: Essa lanchonete é famosa na cidade?");
        ExercicioDao.adicionarExercicio(getApplicationContext(),e,m);

        r = new Resposta();
        r.setResposta("1");
        r.setCorreta("S");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("2");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("3");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("4");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        // História

        c.setNome("História");
                CursoDao.adicionarCurso(getApplicationContext(), c);

        m = new Modulo();
        m.setNome("História 1");
        ModuloDao.adicionarModulo(getApplicationContext(),m,c);

        e = new Exercicio();
        e.setPergunta("Na criação dos Territórios Federais, criou-se o Território Federal do Rio Branco que, posteriormente, foi rebatizado, por volta de 1962, para:");
        ExercicioDao.adicionarExercicio(getApplicationContext(),e,m);

        r = new Resposta();
        r.setResposta("Amazonas");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("Rondônia");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("Acre");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("Roraima");
        r.setCorreta("S");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("Amapá");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);


        e = new Exercicio();
        e.setPergunta("Analisando a sociedade brasileira desde, a sua independência até os dias atuais, podemos encontrar a permanência das seguintes características descritas nas alternativas abaixo, exceto:");
        ExercicioDao.adicionarExercicio(getApplicationContext(),e,m);

        r = new Resposta();
        r.setResposta("Grandes contrastes sociais, econômicos e culturais entre as elites e as camadas populares");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("Efetiva exclusão das camadas populares do processo político-decisório");
        r.setCorreta("S");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("Alto grau de concentração da propriedade fundiária");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("Permanência de mecanismos de hierarquização e exclusão social");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("Forte influência cultural estrangeira");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);


        e = new Exercicio();
        e.setPergunta("Considerando os fundamentos da cultura brasileira, assinale a opção correta");
        ExercicioDao.adicionarExercicio(getApplicationContext(),e,m);

        r = new Resposta();
        r.setResposta("A maior contribuição dada pelos indígenas foi o idioma");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("A cultura brasileira resulta de influências diversas");
        r.setCorreta("S");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("O samba, herança portuguesa, é símbolo musical brasileiro");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("A presença africana restringiu-se ao mundo do trabalho");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        e = new Exercicio();
        e.setPergunta("Considerando a organização política e social do Brasil contemporâneo, assinale a opção correta.");
        ExercicioDao.adicionarExercicio(getApplicationContext(),e,m);

        r = new Resposta();
        r.setResposta("A República brasileira é federativa e presidencialista");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("O Poder Legislativo, exercido pelo Senado, é unicameral");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("Os analfabetos estão proibidos de votar nas eleições");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("Os prefeitos municipais são escolhidos pelos vereadores");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        e = new Exercicio();
        e.setPergunta("As afirmativas abaixo retratam características da religião romana na Antiguidade, exceto:");
        ExercicioDao.adicionarExercicio(getApplicationContext(),e,m);

        r = new Resposta();
        r.setResposta("Influência da religião de outros povos, como etruscos e gregos");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("Deuses apresentando formas e sentimentos humanos");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("Forte relação entre religião e o Estado romano.");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("Culto aos deuses para atender questões mais imediatas, sem-preocupação com a vida após a morte");
        r.setCorreta("S");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("Existência de cultos domésticos, e posterior triunfo do Cristianismo sobre o politeísmo pagão");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);


        m = new Modulo();
        m.setNome("História 2");
        ModuloDao.adicionarModulo(getApplicationContext(),m,c);

        e = new Exercicio();
        e.setPergunta("A data de 15 de novembro de 1889 refere-se à:");
        ExercicioDao.adicionarExercicio(getApplicationContext(),e,m);

        r = new Resposta();
        r.setResposta("Dia do Fico");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("Abolição da escravatura");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("Proclamação da República");
        r.setCorreta("S");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("Declaração de Independência");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("Vinda da Corte Portuguesa ao Brasil");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        e = new Exercicio();
        e.setPergunta("Sobre o fim do período militar no Brasil em 1985, pode-se afirmar que ocorreu de forma:");
        ExercicioDao.adicionarExercicio(getApplicationContext(),e,m);

        r = new Resposta();
        r.setResposta("Lenta e gradual, como desejavam setores das Forças Armadas");
        r.setCorreta("S");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("Conflituosa, resultando em um rompimento entre as Forças Armadas e os partidos políticos.");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("Abrupta e inesperada, como na Argentina do general Galtieri");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("Negociada, como no Chile, entre o ditador e os partidos na ilegalidade");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        e = new Exercicio();
        e.setPergunta("A produção econômica do feudalismo baseava-se na");
        ExercicioDao.adicionarExercicio(getApplicationContext(),e,m);

        r = new Resposta();
        r.setResposta("Indústria artesanal e exploração mineral");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("Produção das corporações de ofício e no trabalho dos jornaleiros");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("Exploração das riquezas provenientes das conquistas marítimas e venda de escravos");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("Indústria manufatureira e no comércio ambulante");
        r.setCorreta("S");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("gricultura e atividade pastoril");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        e = new Exercicio();
        e.setPergunta("Durante o Período Regencial, ocorreram rebeliões em várias províncias provocadas em parte pelo descontentamento das elites provinciais em relação ao governo central e, pelo descontentamento da maior parte da população devido às condições em que viviam. Entre as principais revoltas desse período destaca-se:");
        ExercicioDao.adicionarExercicio(getApplicationContext(),e,m);

        r = new Resposta();
        r.setResposta("A Guerra dos Emboabas");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("A Revolta de Beckman");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("A Insurreição Pernambucana");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("A Confederação do Equador");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("A Revolução Farroupilha");
        r.setCorreta("S");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        e = new Exercicio();
        e.setPergunta("“Deus, Pátria e Família” era o lema do(a):");
        ExercicioDao.adicionarExercicio(getApplicationContext(),e,m);

        r = new Resposta();
        r.setResposta("Queremismo");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("Coluna Prestes");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("Coronelismo");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("Integralismo");
        r.setCorreta("S");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        m = new Modulo();
        m.setNome("História 3");
        ModuloDao.adicionarModulo(getApplicationContext(),m,c);

        e = new Exercicio();
        e.setPergunta("A data de 15 de novembro de 1889 refere-se à:");
        ExercicioDao.adicionarExercicio(getApplicationContext(),e,m);

        r = new Resposta();
        r.setResposta("Dia do Fico");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("Abolição da escravatura");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("Proclamação da República");
        r.setCorreta("S");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("Declaração de Independência2");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        e = new Exercicio();
        e.setPergunta("Sobre a Grécia Antiga podemos afirmar:");
        ExercicioDao.adicionarExercicio(getApplicationContext(),e,m);

        r = new Resposta();
        r.setResposta("Atenas é considerada o berço da democracia");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("A Grécia Antiga era um conjunto de cidades estado dependentes entre si");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("Ao governante de Atenas era dado o titulo de César");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("Eram considerados cidadãos de Atenas homens livres, nascidos em Atenas e maiores de idade");
        r.setCorreta("S");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);


        e = new Exercicio();
        e.setPergunta("Sobre sujeito histórico é incorreto afirmar que:");
        ExercicioDao.adicionarExercicio(getApplicationContext(),e,m);

        r = new Resposta();
        r.setResposta("Não precisa pertencer a uma casta social pré-estabelecida");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("Podem ser os personagens que desempenham ações individuais ou consideradas como heróicas");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("Torna-se irrelevante, quando o fato histórico é realizado por uma coletividade");
        r.setCorreta("S");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("Podem compreender pessoas individualizadas ou grupos");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        e = new Exercicio();
        e.setPergunta("São tribos indígenas existentes no Estado de Roraima, EXCETO:");
        ExercicioDao.adicionarExercicio(getApplicationContext(),e,m);

        r = new Resposta();
        r.setResposta("Macuxi");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("Atroarikam");
        r.setCorreta("S");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("Taurepang");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("Ingarikó");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        e = new Exercicio();
        e.setPergunta("O presidente Fernando Henrique Cardoso foi substituído no dia 1º de janeiro de 2003, dia da posse de");
        ExercicioDao.adicionarExercicio(getApplicationContext(),e,m);

        r = new Resposta();
        r.setResposta("Fernando Collor de Mello");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("Itamar Franco");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("Tancredo Neves");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("Luís Inácio Lula da Silva");
        r.setCorreta("S");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);


        // INFORMATICA

        c.setNome("Informática");
        CursoDao.adicionarCurso(getApplicationContext(), c);

        m = new Modulo();
        m.setNome("Informática 1");
        ModuloDao.adicionarModulo(getApplicationContext(),m,c);

        e = new Exercicio();
        e.setPergunta("Segurança é um dos aspectos mais importantes a ser considerado na construção de uma rede de computadores. O objetivo é prover comunicação de forma segura. Qual das alternativas abaixo NÃO apresenta uma propriedade desejável da comunicação segura?");
        ExercicioDao.adicionarExercicio(getApplicationContext(),e,m);

        r = new Resposta();
        r.setResposta("Confidencialidade");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("Autenticação");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("Integridade");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("Anonimato");
        r.setCorreta("S");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("Disponibilidade e controle de acesso");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);


        e = new Exercicio();
        e.setPergunta("O mecanismo de controle de acesso adequado para bloquear segmentos UDP e conexões FTP, em uma rede, é o(a)");
        ExercicioDao.adicionarExercicio(getApplicationContext(),e,m);

        r = new Resposta();
        r.setResposta("sistema de detecção de intrusos (SDI)");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("firewall de filtragem de pacotes");
        r.setCorreta("S");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("rede privada virtual (VPN)");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("gateway de aplicação");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("rede local virtual (VLAN)");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        e = new Exercicio();
        e.setPergunta("Marque a opção que representa o decimal 1558 em binário.");
        ExercicioDao.adicionarExercicio(getApplicationContext(),e,m);

        r = new Resposta();
        r.setResposta("0110001110110");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("11000010110");
        r.setCorreta("S");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("110000111101");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("111000");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("1111111100000");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        e = new Exercicio();
        e.setPergunta("As margens de um documento do Word podem ser ajustadas de acordo com as especificações requeridas. Indique qual das opções mostra corretamente como se faz para alterar estas opções.");
        ExercicioDao.adicionarExercicio(getApplicationContext(),e,m);

        r = new Resposta();
        r.setResposta("Clicar na barra de menu Arquivo, clicar na opção Configurar margens, inserir os números de margens inferior, superior, esquerda e direita e clicar em Ok.");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("Clicar na barra de menu Arquivo, clicar na opção Inserir margens, inserir os números de margens inferior, superior, esquerda e direita e clicar em Ok.");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("Clicar na barra de menu Arquivo, clicar na opção Alterar margens, inserir os números de margens inferior, superior, esquerda e direita e clicar em Ok.");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("Clicar na barra de menu Arquivo, clicar na opção Configurar página, inserir os números de margens inferior, superior, esquerda e direita e clicar em Ok.");
        r.setCorreta("S");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("Clicar na barra de menu Formatar, clicar na opção Configurar margens, inserir os números de margens inferior, superior, esquerda e direita e clicar em Ok.");
        r.setCorreta("S");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        e = new Exercicio();
        e.setPergunta("Marque a opção que não é um componente da janela do Excel 2000.");
        ExercicioDao.adicionarExercicio(getApplicationContext(),e,m);

        r = new Resposta();
        r.setResposta("Menu Tabela");
        r.setCorreta("S");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("Barra de status");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("Barra de Fórmulas");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("Caixa de endereço");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);


        m = new Modulo();
        m.setNome("Informática 2");
        ModuloDao.adicionarModulo(getApplicationContext(),m,c);

        e = new Exercicio();
        e.setPergunta("No Microsoft Windows XP Professional (configuração padrão), são descrições de itens que podem ser configurados a partir da ferramenta painel de controle, EXCETO:");
        ExercicioDao.adicionarExercicio(getApplicationContext(),e,m);

        r = new Resposta();
        r.setResposta("Mouse");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("Teclado");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("Monitor");
        r.setCorreta("S");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("Adicionar ou remover programas");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("Data e hora");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        e = new Exercicio();
        e.setPergunta("Uma Intranet é:");
        ExercicioDao.adicionarExercicio(getApplicationContext(),e,m);

        r = new Resposta();
        r.setResposta("Uma rede de computadores pública");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("Uma rede de computadores privada");
        r.setCorreta("S");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("Uma rede mundial de computadores com acesso a internet");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("É o mesmo que Extranet");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        e = new Exercicio();
        e.setPergunta("Uma grande empresa deseja trocar dados com seus parceiros e, para isso, opta por uma solução de mensageria. No MQSeries (Unix), que comando cria um gerenciador de filas (queue manager)?");
        ExercicioDao.adicionarExercicio(getApplicationContext(),e,m);

        r = new Resposta();
        r.setResposta("crtmqm");
        r.setCorreta("S");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("setupqm");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("strmqm");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("strmqtrc");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("setmqaut");
        r.setCorreta("S");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        e = new Exercicio();
        e.setPergunta("O Microsoft Office realiza serviços de mensagens de correio eletrônico (e-mail), edição e produção de texto, apresentações, planilhas de calculo e também de banco de dados, principalmente, por meio dos seus respectivos programas (produtos) especializados.");
        ExercicioDao.adicionarExercicio(getApplicationContext(),e,m);

        r = new Resposta();
        r.setResposta("word, outlook, excel, powerpoint e access");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("outlook, access, word, powerpoint e excel");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("outlook, word, powerpoint, excel e access");
        r.setCorreta("S");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("outlook, word, excel, access e powerpoint");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("excel, outlook, word, powerpoint e access");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        e = new Exercicio();
        e.setPergunta("O Microsoft Word 2000 possui o recurso de formatação de texto usando estilos. Sobre este recurso, tem-se que");
        ExercicioDao.adicionarExercicio(getApplicationContext(),e,m);

        r = new Resposta();
        r.setResposta("a criação de novos estilos não é permitida");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("a criação de grupos de estilo é possível");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("a fonte e o alinhamento do texto podem ser definidos por um mesmo estilo");
        r.setCorreta("S");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("a remoção de um estilo não é possível");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("os estilos não podem ser modificados");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        m = new Modulo();
        m.setNome("Informática 3");
        ModuloDao.adicionarModulo(getApplicationContext(),m,c);

        e = new Exercicio();
        e.setPergunta("Com relação ao PowerPoint, assinale a opção correta.");
        ExercicioDao.adicionarExercicio(getApplicationContext(),e,m);

        r = new Resposta();
        r.setResposta("No PowerPoint, é possível alterar o esquema de cores do slide, mas não é possível alterar o slide mestre");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("A cada alteração feita em um slide no PowerPoint deve-se imediatamente aplicar a opção Salvar para que não sejam definitivamente perdidas as mudanças de edição das apresentações");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("O assistente de apresentações permite que sejam editados diferentes modelos de design aos slides. Cada arquivo .ppt deve possuir apenas um modelo de design de slides");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("A visualização dos slides em forma de tópicos permite a leitura dos títulos e tópicos, o que facilita a revisão do texto, sem características de edição de leiaute e design");
        r.setCorreta("S");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("No PowerPoint, é possível incluir somente uma figura em cada slide");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        e = new Exercicio();
        e.setPergunta("Arquivos com extensão .docx são arquivos desenvolvidos no Word:");
        ExercicioDao.adicionarExercicio(getApplicationContext(),e,m);

        r = new Resposta();
        r.setResposta("Mx");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("2007");
        r.setCorreta("S");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("2003");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("XP");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        e = new Exercicio();
        e.setPergunta("Considerando-se a instalação de uma impressora de conexão paralela, a porta que normalmente é utilizada para essa conexão é:");
        ExercicioDao.adicionarExercicio(getApplicationContext(),e,m);

        r = new Resposta();
        r.setResposta("COM1.");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("USB");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("Serial");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("LPT1");
        r.setCorreta("S");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        e = new Exercicio();
        e.setPergunta("Os hackers possuem diversas formas de ataques contra as redes de computadores. Sobre os ataques gerados por hackers, é correto afirmar que:");
        ExercicioDao.adicionarExercicio(getApplicationContext(),e,m);

        r = new Resposta();
        r.setResposta("IP Spamming é uma técnica de disseminação de vírus na rede mundial de computadores por meio de tecnologia de voz sobre IP");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("MAC Flooding é uma técnica empregada para comprometer a segurança da rede de switches, e, como resultado deste ataque, o switch fica em um estado chamado mode de falha aberta");
        r.setCorreta("S");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("Ataque Smurf é uma técnica destinada a quebrar senhas e códigos criptografados que estejam armazenados no computador da vítima");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("Ataque Sniffer é uma técnica de negação de serviços no qual o hacker envia uma rápida sequência de solicitações ping para um endereço de broadcast");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("Scamming é uma técnica na qual o hacker fica monitorando o tráfego da porta 80 do seu alvo, antes de realizar o ataque");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);


        e = new Exercicio();
        e.setPergunta("Acerca dos meios de transmissão utilizados em redes de comunicação, assinale a opção correta.");
        ExercicioDao.adicionarExercicio(getApplicationContext(),e,m);

        r = new Resposta();
        r.setResposta("Os cabos de fibra óptica são usados para conexões de longa distância por permitirem altas taxas de velocidade, apresentarem baixo custo operacional e serem de fácil reposição em caso de danos");
        r.setCorreta("S");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("Um cabo de UTP, também conhecido como par trançado não blindado, contém quatro tipos de pares de fios trançados de maneira alternada para cancelar ruído elétrico dos pares adjacentes e de outros dispositivos existentes no ambiente em uso");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("O cabo coaxial é utilizado para médias distâncias e tem custo operacional médio, mas é inadequado por ser suscetível a interferências produzidas por correntes elétricas externas");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("As redes sem-fio podem ser interligadas por meio de ondas de rádio, som, calor, celular e satélite");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("O cabo de par trançado blindado, ou STP, oferece alto grau de proteção contra interferências produzidas por corrente elétrica externa. Apesar de ser de baixa velocidade de transmissão, esse tipo de cabo pode ser empregado para partilhar dados em redes token-ring de longa distância");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        // LOGICA


        c.setNome("Lógica");
        CursoDao.adicionarCurso(getApplicationContext(), c);

        m = new Modulo();
        m.setNome("Lógica 1");
        ModuloDao.adicionarModulo(getApplicationContext(),m,c);

        e = new Exercicio();
        e.setPergunta("Quantos números de até 3 algarismos são múltiplos de 5?");
        ExercicioDao.adicionarExercicio(getApplicationContext(),e,m);

        r = new Resposta();
        r.setResposta("180");
        r.setCorreta("S");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("190");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("200");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("210");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        e = new Exercicio();
        e.setPergunta("A negação da proposição “Se o candidato estuda, então passa no concurso” é");
        ExercicioDao.adicionarExercicio(getApplicationContext(),e,m);

        r = new Resposta();
        r.setResposta("o candidato não estuda e passa no concurso");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("o candidato estuda e não passa no concurso");
        r.setCorreta("S");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("	se o candidato estuda, então não passa no concurso");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("se o candidato não estuda, então passa no concurso");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        e = new Exercicio();
        e.setPergunta("A solução da equação 2.( x + 2 ) – 5 = 15 é:");
        ExercicioDao.adicionarExercicio(getApplicationContext(),e,m);

        r = new Resposta();
        r.setResposta("6");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("8");
        r.setCorreta("S");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("10");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("12");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        e = new Exercicio();
        e.setPergunta("Admita verdadeira a declaração: “se A é C, então B não é C”. Conclui-se corretamente que:");
        ExercicioDao.adicionarExercicio(getApplicationContext(),e,m);

        r = new Resposta();
        r.setResposta("se B é C, então A não é C");
        r.setCorreta("S");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("se B é C, então A é C");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("se B não é C, então A não é C");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("se B não é C, então A é C");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        e = new Exercicio();
        e.setPergunta("A negação da proposição “Mário é brasileiro ou Maria não é boliviana” é:");
        ExercicioDao.adicionarExercicio(getApplicationContext(),e,m);

        r = new Resposta();
        r.setResposta("Mário não é brasileiro e Maria é boliviana");
        r.setCorreta("S");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("Mário não é brasileiro ou Maria é boliviana");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("Mário não é brasileiro e Maria não é boliviana");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("Mário é brasileiro e Maria não é boliviana");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        m = new Modulo();
        m.setNome("Lógica 2");
        ModuloDao.adicionarModulo(getApplicationContext(),m,c);

        e = new Exercicio();
        e.setPergunta("Observe a sequência a seguir: 3, 6, 11, 22, 27,...O 9° termo dessa sequência é:");
        ExercicioDao.adicionarExercicio(getApplicationContext(),e,m);

        r = new Resposta();
        r.setResposta("54");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("59");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("118");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("123");
        r.setCorreta("S");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        e = new Exercicio();
        e.setPergunta("Dentre os números abaixo, o que apresenta menor valor é:");
        ExercicioDao.adicionarExercicio(getApplicationContext(),e,m);

        r = new Resposta();
        r.setResposta("√2");
        r.setCorreta("S");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("10/3");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("1,71");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("3/2");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        e = new Exercicio();
        e.setPergunta("Considere a afirmação: “Hoje é domingo e amanhã não vou trabalhar”. A negação dessa afirmação é:");
        ExercicioDao.adicionarExercicio(getApplicationContext(),e,m);

        r = new Resposta();
        r.setResposta("Hoje é domingo e amanhã vou trabalhar");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("Hoje não é domingo e amanhã não vou trabalhar");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("Hoje não é domingo ou amanhã não vou trabalhar");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("Hoje não é domingo ou amanhã vou trabalhar");
        r.setCorreta("S");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        e = new Exercicio();
        e.setPergunta("Observe a sequência a seguir 1/2, 3/4, 7/8, 15/16, 31/32, 63/64,... Qual será o 9º termo dessa sequência?");
        ExercicioDao.adicionarExercicio(getApplicationContext(),e,m);

        r = new Resposta();
        r.setResposta("127/128");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("255/256");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("511/512");
        r.setCorreta("S");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("1.023/1.024");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        e = new Exercicio();
        e.setPergunta("Calcule a medida dos lados de um terreno retangular de perímetro medindo 54 metros e área de 170 m², cuja largura é 7 metros menor que o comprimento.");
        ExercicioDao.adicionarExercicio(getApplicationContext(),e,m);

        r = new Resposta();
        r.setResposta("7 metros e 20 metros");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("8 metros e 19 metros");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("9 metros e 18 metros");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("10 metros e 17 metros");
        r.setCorreta("S");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        m = new Modulo();
        m.setNome("Lógica 3");
        ModuloDao.adicionarModulo(getApplicationContext(),m,c);

        e = new Exercicio();
        e.setPergunta("Uma anta está a 40 m na frente de uma onça que a persegue. A anta percorre 5 m e a onça 9 m. Quantos metros deverá percorrer a onça para alcançar a anta?");
        ExercicioDao.adicionarExercicio(getApplicationContext(),e,m);

        r = new Resposta();
        r.setResposta("80m");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("90m");
        r.setCorreta("S");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("180m");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("160m");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        e = new Exercicio();
        e.setPergunta("Resolvendo a expressão: 2 + 1/2 + 2/5 X 5/4 é igual a");
        ExercicioDao.adicionarExercicio(getApplicationContext(),e,m);

        r = new Resposta();
        r.setResposta("3");
        r.setCorreta("S");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("4");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("5");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("6");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        e = new Exercicio();
        e.setPergunta("Se x Є [0, 2π], a soma de todas as soluções da equação trigonométrica 2 cos x = 3tgx é igual a:");
        ExercicioDao.adicionarExercicio(getApplicationContext(),e,m);

        r = new Resposta();
        r.setResposta("π/2");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("3π/4");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("π");
        r.setCorreta("S");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("5π/4");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        e = new Exercicio();
        e.setPergunta("Numa vila, para cada morador do sexo feminino há dois do sexo masculino. Assim, essa vila pode ter a seguinte quantidade de moradores:");
        ExercicioDao.adicionarExercicio(getApplicationContext(),e,m);

        r = new Resposta();
        r.setResposta("48");
        r.setCorreta("S");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("50");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("52");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("56");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        e = new Exercicio();
        e.setPergunta("Cláudio estava no 6º degrau de uma escada. Desceu 4 degraus e, depois, subiu 6. Para atingir o 7º degrau, Cláudio deve:");
        ExercicioDao.adicionarExercicio(getApplicationContext(),e,m);

        r = new Resposta();
        r.setResposta("subir 3 degraus");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("subir 2 degraus");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("subir 1 degrau");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("descer 1 degrau");
        r.setCorreta("S");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        // Matematica

        c.setNome("Matemática");
        CursoDao.adicionarCurso(getApplicationContext(), c);

        m = new Modulo();
        m.setNome("Matemática 1");
        ModuloDao.adicionarModulo(getApplicationContext(),m,c);

        e = new Exercicio();
        e.setPergunta("Dado um paralelepípedo retângulo de dimensões: de lado 2m, altura 3m e profundidade 6m. O valor e seu volume é:");
        ExercicioDao.adicionarExercicio(getApplicationContext(),e,m);

        r = new Resposta();
        r.setResposta("36 m³");
        r.setCorreta("S");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("30 m²");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("36 m²");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("30 m³");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);


        e = new Exercicio();
        e.setPergunta("Sabe-se que uma determinada vaca dá 6 litros de leite por dia. Quantos litros de leite dará em 5 dias?");
        ExercicioDao.adicionarExercicio(getApplicationContext(),e,m);

        r = new Resposta();
        r.setResposta("25 litros");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("30 litros");
        r.setCorreta("S");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("35 litros");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("40 litros");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        e = new Exercicio();
        e.setPergunta("Uma pessoa aplica R$2.000,00 rendendo 10% ao mês, em regime de juros compostos e capitalização mensal. Qual o montante gerado por este capital ao fim de 3 meses?");
        ExercicioDao.adicionarExercicio(getApplicationContext(),e,m);

        r = new Resposta();
        r.setResposta("R$ 2.662,00");
        r.setCorreta("S");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("R$ 2.682,00");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("R$ 2.672,00");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("R$ 2.660,00");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        e = new Exercicio();
        e.setPergunta("Marque a alternativa que representa o número racional compreendido entre 6 e 7.");
        ExercicioDao.adicionarExercicio(getApplicationContext(),e,m);

        r = new Resposta();
        r.setResposta("11/2");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("13/2");
        r.setCorreta("S");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("15/4");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("25/3");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        e = new Exercicio();
        e.setPergunta("Rui tem uma granja que contém 4.800 frangos, 230 galos e 1960 galinhas.Dos pintinhos que nasceram, 72 morreram. Quantos ficaram vivos?");
        ExercicioDao.adicionarExercicio(getApplicationContext(),e,m);

        r = new Resposta();
        r.setResposta("9.758");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("9.728");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("9.578");
        r.setCorreta("S");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("10.128");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);


        m = new Modulo();
        m.setNome("Matemática 2");
        ModuloDao.adicionarModulo(getApplicationContext(),m,c);

        e = new Exercicio();
        e.setPergunta("Numa turma com um total de 40 alunos, 30 gostam de português e 25 gostam de matemática. O número de alunos que gostam das duas matérias é:");
        ExercicioDao.adicionarExercicio(getApplicationContext(),e,m);

        r = new Resposta();
        r.setResposta("No mínimo 5 alunos");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("No máximo 5 alunos");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("No mínimo 15 alunos");
        r.setCorreta("S");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("No máximo 15 alunos");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        e = new Exercicio();
        e.setPergunta("Rui tem uma granja que contém 4.800 frangos, 230 galos e 1960 galinhas.Dos pintinhos que nasceram, 72 morreram. Quantos ficaram vivos?");
        ExercicioDao.adicionarExercicio(getApplicationContext(),e,m);

        r = new Resposta();
        r.setResposta("9.758");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("9.728");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("9.578");
        r.setCorreta("S");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("10.128");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        e = new Exercicio();
        e.setPergunta("Uma pastelaria móvel estabelece-se em uma praça apenas aos sábados. Na primeira vez que foi aberta, 30 famílias compraram pastéis. A cada sábado subsequente, o número de famílias aumentou em 6 em relação ao sábado anterior. Sabendo-se que a capacidade máxima possível de atendimento é 120 famílias, em quantos sábados, a partir da primeira vez que foi aberta, a pastelaria atingiu a cota máxima de atendimento?");
        ExercicioDao.adicionarExercicio(getApplicationContext(),e,m);

        r = new Resposta();
        r.setResposta("19");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("17");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("18");
                r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("16");
        r.setCorreta("S");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        e = new Exercicio();
        e.setPergunta("Ângela recebeu R$485,00 do aluguel de sua casa e R$65,00 pela venda de um brinquedo. Com quanto ficou?");
        ExercicioDao.adicionarExercicio(getApplicationContext(),e,m);

        r = new Resposta();
        r.setResposta("R$ 680,00");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("R$ 630,00");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("R$ 500,00");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("R$ 550,00");
        r.setCorreta("S");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("R$ 490,00");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        e = new Exercicio();
        e.setPergunta("Por 2,85 kg de carne, paguei R$ 32,49. Quanto custou o kg dessa carne?");
        ExercicioDao.adicionarExercicio(getApplicationContext(),e,m);

        r = new Resposta();
        r.setResposta("R$ 16,89");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("R$ 16,79");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("R$ 11,40");
        r.setCorreta("S");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("R$ 10,40");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        m = new Modulo();
        m.setNome("Matemática 3");
        ModuloDao.adicionarModulo(getApplicationContext(),m,c);

        e = new Exercicio();
        e.setPergunta("Usando moedas nos valores de 1, 5, 10, 25 e 50 centavos, seja x o menor número de moedas necessário para pagar uma conta de 84 centavos e y o menor número de moedas necessário para pagar uma conta de 89 centavos. Então x - y é igual a:");
        ExercicioDao.adicionarExercicio(getApplicationContext(),e,m);

        r = new Resposta();
        r.setResposta("1");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("-1");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("0");
        r.setCorreta("S");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("2");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        e = new Exercicio();
        e.setPergunta("Duas construtoras farão conjuntamente a pavimentação de uma estrada, danificada pelo forte inverno, cada uma trabalhando em sentido contrário a partir de uma das extremidades. Se uma delas pavimentar 3/5 da estrada e a outra, os 100 km restantes, a extensão dessa estrada é de:");
        ExercicioDao.adicionarExercicio(getApplicationContext(),e,m);

        r = new Resposta();
        r.setResposta("170 Km");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("238 Km");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("250 Km");
        r.setCorreta("S");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("354 Km.");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("553 Km.");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        e = new Exercicio();
        e.setPergunta("Um vendedor de uma concessionária recebe mensalmente um salário composto de uma quantia fixa no valor de R$ 500,00 e de uma quantia comissionada a 2% sobre as vendas por ele realizadas durante o mês. Sabendo que ele vendeu R$ 72.000,00 no mês de outubro de 2011, o valor que recebeu de salário para esse mês foi de:");
        ExercicioDao.adicionarExercicio(getApplicationContext(),e,m);

        r = new Resposta();
        r.setResposta("R$ 1.440,00");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("R$ 2.000,00");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("R$ 1.940,00");
        r.setCorreta("S");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("R$ 1.490,00");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("R$ 2.940,00");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        e = new Exercicio();
        e.setPergunta("Não dispondo dos meios necessários para o cálculo exato do log 500, podemos afirmar que");
        ExercicioDao.adicionarExercicio(getApplicationContext(),e,m);

        r = new Resposta();
        r.setResposta("é maior que 4");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("é maior que 3");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("está entre 0 e 1");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("Restá entre 2 e 3");
        r.setCorreta("S");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        e = new Exercicio();
        e.setPergunta("Uma loja vende seus produtos nas seguintes condições: à vista, com 20% de desconto sobre o preço de tabela, ou no cartão de crédito, com 20% de acréscimo sobre o preço de tabela. Uma televisão que, à vista, sai por R$ 840,00, no cartão sairá por:");
        ExercicioDao.adicionarExercicio(getApplicationContext(),e,m);

        r = new Resposta();
        r.setResposta("R$ 1.050,00");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("R$ 875,00");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("R$ 1.260,00");
        r.setCorreta("S");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

        r = new Resposta();
        r.setResposta("R$ 999,00");
        r.setCorreta("N");
        RespostaDao.adicionarResposta(getApplicationContext(),r,e);

*/
     Intent intent = new Intent(MainActivity.this,CadastroActivity.class);
        //intent.putExtra("Dificuldade",dificuldade);
        startActivity(intent);

    }


}
