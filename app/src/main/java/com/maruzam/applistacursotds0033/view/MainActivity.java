package com.maruzam.applistacursotds0033.view;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.maruzam.applistacursotds0033.R;
import com.maruzam.applistacursotds0033.model.Pessoa;

public class MainActivity extends AppCompatActivity {

    Pessoa pessoa;
    Pessoa outraPessoa;

    String dadosPessoa;
    String dadosOutrapessoa;

    EditText editPrimeiroNome;
    EditText editSobrenome;
    EditText editCursoDesejado;
    EditText editTelefoneContato;

    Button btnLimpar;
    Button btnSalvar;
    Button btnFinalizar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        pessoa = new Pessoa();

        pessoa.setPrimeiroNome("Maruzam");
        pessoa.setSobrenome("Bueno");
        pessoa.setCursoDesejado("Java");
        pessoa.setTelefoneContato("99999999");

        outraPessoa = new Pessoa();

        outraPessoa.setPrimeiroNome("Luke");
        outraPessoa.setSobrenome("Skywalker");
        outraPessoa.setCursoDesejado("Android");
        outraPessoa.setTelefoneContato("Android");

        //criar o metodo findViewById

        editPrimeiroNome = findViewById(R.id.editPrimeiroNome);
        editSobrenome =  findViewById(R.id.editSobrenome);
        editCursoDesejado = findViewById(R.id.editNomeCurso);
        editTelefoneContato = findViewById(R.id.editTelefoneContato);
        btnLimpar = findViewById(R.id.btnLimpar);
        btnFinalizar = findViewById(R.id.btnFinalizar);
        btnSalvar = findViewById(R.id.btnSalvar);

        editPrimeiroNome.setText(pessoa.getPrimeiroNome());
        editSobrenome.setText(pessoa.getCursoDesejado());
        editCursoDesejado.setText(pessoa.getCursoDesejado());
        editTelefoneContato.setText(pessoa.getTelefoneContato());

        //Recuperar os dados

        dadosPessoa = "Primeiro Nome: ";
        dadosPessoa += pessoa.getPrimeiroNome();
        dadosPessoa += "Sobrenome: ";
        dadosPessoa += pessoa.getSobrenome();
        dadosPessoa += "Curso Desejado: ";
        dadosPessoa += pessoa.getCursoDesejado();
        dadosPessoa += "Telefone Contato: ";
        dadosPessoa += pessoa.getTelefoneContato();

        int parada = 0;

        dadosOutrapessoa = "Primeiro Nome: ";
        dadosOutrapessoa += outraPessoa.getPrimeiroNome();
        dadosOutrapessoa += "Sobrenome: ";
        dadosOutrapessoa += outraPessoa.getSobrenome();
        dadosOutrapessoa += "Curso Desejado: ";
        dadosOutrapessoa += outraPessoa.getCursoDesejado();
        dadosOutrapessoa += "Telefone Contato: ";
        dadosOutrapessoa += outraPessoa.getTelefoneContato();



        //visualizar dados no log cat

        Log.i("POOAndroid", pessoa.toString());
        Log.i("POOAndroid", outraPessoa.toString());














    }





}