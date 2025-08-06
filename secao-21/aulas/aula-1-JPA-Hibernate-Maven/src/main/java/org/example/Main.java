package org.example;

import org.example.dominio.Pessoa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {

        // Instancia objetos Pessoa sem ID (banco irá gerar)
        Pessoa pessoa1 = new Pessoa(null, "Maria Silva", "maria@email.com");
        Pessoa pessoa2 = new Pessoa(null, "João Santos", "joao@email.com");
        Pessoa pessoa3 = new Pessoa(null, "Ana Oliveira", "ana@email.com");

        // Cria a fábrica de conexões com o banco de dados
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("exemplo-jpa");

        // Cria o gerenciador de entidades
        EntityManager manager = factory.createEntityManager();

        // Inicia a transação com o banco de dados
        manager.getTransaction().begin();

        // Salva os objetos no banco de dados
        manager.persist(pessoa1);
        manager.persist(pessoa2);
        manager.persist(pessoa3);

        // Confirma a transação
        manager.getTransaction().commit();

        // Fecha as conexões do manager e factory com o banco
        manager.close();
        factory.close();

        // Imprime os objetos já salvos com os IDs gerados
        System.out.println(pessoa1);
        System.out.println(pessoa2);
        System.out.println(pessoa3);
    }
}