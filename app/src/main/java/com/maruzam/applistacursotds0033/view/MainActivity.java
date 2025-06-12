package com.maruzam.applistacursotds0033.view;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.maruzam.applistacursotds0033.R;
import com.maruzam.applistacursotds0033.controller.CursoController;
import com.maruzam.applistacursotds0033.controller.PessoaController;
import com.maruzam.applistacursotds0033.model.Pessoa;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    Pessoa pessoa;
    List<String> nomesCursos;

    PessoaController controller;
    CursoController cursoController;

    EditText editPrimeiroNome;
    EditText editSobrenome;
    EditText editCursoDesejado;
    EditText editTelefoneContato;

    Button btnLimpar;
    Button btnSalvar;
    Button btnFinalizar;
    Spinner spinner;

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
        controller = new PessoaController(this);

        controller.buscar(pessoa);

        controller.toString();
        cursoController = new CursoController();
        nomesCursos = cursoController.dadosSpinner();


        editPrimeiroNome = findViewById(R.id.editPrimeiroNome);
        editSobrenome = findViewById(R.id.editSobrenome);
        editCursoDesejado = findViewById(R.id.editNomeCurso);
        editTelefoneContato = findViewById(R.id.editTelefoneContato);
        spinner = findViewById(R.id.spinner);

        editPrimeiroNome.setText(pessoa.getPrimeiroNome());
        editSobrenome.setText(pessoa.getSobrenome());
        editCursoDesejado.setText(pessoa.getCursoDesejado());
        editTelefoneContato.setText(pessoa.getTelefoneContato());

        btnLimpar = findViewById(R.id.btnLimpar);
        btnFinalizar = findViewById(R.id.btnFinalizar);
        btnSalvar = findViewById(R.id.btnSalvar);

        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editPrimeiroNome.setText(" ");
                editSobrenome.setText(" ");
                editCursoDesejado.setText(" ");
                editTelefoneContato.setText(" ");

                controller.limpar();

            }
        });

        btnFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Volte Sempre",
                        Toast.LENGTH_LONG).show();
                finish();
            }
        });

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,
                cursoController.dadosSpinner());
        adapter.setDropDownViewResource(android.R.layout.simple_list_item_1);
        spinner.setAdapter(adapter);

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pessoa.setPrimeiroNome(editPrimeiroNome.getText().toString());
                pessoa.setSobrenome(editSobrenome.getText().toString());
                pessoa.setCursoDesejado(editCursoDesejado.getText().toString());
                pessoa.setTelefoneContato(editTelefoneContato.getText().toString());

                Toast.makeText(MainActivity.this, "Dados Salvo: "
                                + pessoa.toString(),
                        Toast.LENGTH_LONG).show();

                controller.salvar(pessoa);
            }
        });

        Log.i("POOAndroid", pessoa.toString());
    }


}