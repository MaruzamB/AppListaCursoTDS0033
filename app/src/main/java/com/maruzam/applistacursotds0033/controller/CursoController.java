package com.maruzam.applistacursotds0033.controller;

import com.maruzam.applistacursotds0033.model.Curso;

import java.util.ArrayList;
import java.util.List;

public class CursoController {
    private List listaCurso;

    public List getListaCursos() {

        listaCurso = new ArrayList<Curso>();

        listaCurso.add(new Curso("Java"));
        listaCurso.add(new Curso("Python"));
        listaCurso.add(new Curso("C"));
        listaCurso.add(new Curso("Kotlin"));
        listaCurso.add(new Curso("C#"));

        return listaCurso;
    }

    public ArrayList<String> dadosSpinner() {
        ArrayList<String> dados = new ArrayList<>();
        for (int i = 0; i < getListaCursos().size(); i++) {

            Curso objeto = (Curso) getListaCursos().get(i);
            dados.add(objeto.getCursoDesejado());
        }
        return dados;
    }

}
    



