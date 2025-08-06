package org.example;

import org.example.dominio.Pessoa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {

        // Cria a fábrica de conexões com o banco de dados
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("exemplo-jpa");
        // Cria o gerenciador de entidades
        EntityManager manager = factory.createEntityManager();

        manager.getTransaction().begin();

        // Para remover uma entidade é necessário primeiro recuperá-la do banco para que ela esteja em estado de "monitorada"
        Pessoa p = manager.find(Pessoa.class, 2);
        manager.remove(p);

        manager.getTransaction().commit();

        System.out.println(p);

        // Fecha as conexões do manager e factory com o banco
        manager.close();
        factory.close();
    }
}