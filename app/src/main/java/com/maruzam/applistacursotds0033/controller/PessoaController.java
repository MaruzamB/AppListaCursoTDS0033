package com.maruzam.applistacursotds0033.controller;

import android.content.SharedPreferences;
import android.util.Log;

import androidx.annotation.NonNull;

import com.maruzam.applistacursotds0033.model.Pessoa;
import com.maruzam.applistacursotds0033.view.MainActivity;

public class PessoaController {

    SharedPreferences preferences;
    SharedPreferences.Editor listaVip;
    public static final String NOME_PREFERENCES = "pref_listavip";

    public PessoaController(MainActivity mainActivity) {
        preferences = mainActivity.getSharedPreferences(NOME_PREFERENCES, 0);
        listaVip = preferences.edit();
    }

    @NonNull
    @Override
    public String toString() {

        Log.d("MVC_Controller", "Controller Iniciada...");
        return super.toString();
    }

    public void salvar(Pessoa pessoa) {

        listaVip.putString("primeiroNome", pessoa.getPrimeiroNome());
        listaVip.putString("sobrenome", pessoa.getSobrenome());
        listaVip.putString("cursoDesejado", pessoa.getCursoDesejado());
        listaVip.putString("telefoneContato", pessoa.getTelefoneContato());
        listaVip.apply();

        Log.d("MVC_Controller", "Salvo: " + pessoa.toString());

    }

    public Pessoa buscar(Pessoa pessoa) {
        pessoa.setPrimeiroNome(preferences.getString("primeiroNome", "NA"));
        pessoa.setSobrenome(preferences.getString("sobrenome", "NA"));
        pessoa.setCursoDesejado(preferences.getString("cursoDesejado", "NA"));
        pessoa.setTelefoneContato(preferences.getString("telefoneContato", "NA"));

        return pessoa;
    }

    public void limpar() {

        listaVip.clear();
        listaVip.apply();
    }
}
