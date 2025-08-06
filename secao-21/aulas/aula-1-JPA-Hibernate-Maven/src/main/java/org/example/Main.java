package org.example;

import org.example.dominio.Pessoa;

public class Main {
    public static void main(String[] args) {

        Pessoa pessoa1 = new Pessoa(1, "Maria Silva", "maria@email.com");
        Pessoa pessoa2 = new Pessoa(2, "João Santos", "joao@email.com");
        Pessoa pessoa3 = new Pessoa(3, "Ana Oliveira", "ana@email.com");

        System.out.println(pessoa1);
        System.out.println(pessoa2);
        System.out.println(pessoa3);
    }
}