package db;

import db.exceptions.DbException;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class DB {

    private static Connection conn = null;

    // A classe Connection é usada para estabelecer e gerenciar a conexão com o banco de dados.
    public static Connection getConnection() {
        if (conn == null) {
            try {
                Properties props = loadProperties();
                // A classe DriverManager é usada para gerenciar os drivers JDBC e obter conexões com o banco de dados.
                conn = DriverManager.getConnection(props.getProperty("dburl"), props.getProperty("user"), props.getProperty("password"));
            } catch (SQLException e) {
                throw new DbException(e.getMessage());
            }
        }
        return conn;
    }

    // Método auxiliar para fechar conexão com o banco de dados
    public static void closeConnection() {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                throw new DbException(e.getMessage());
            }
        }
    }

    // A classe Properties é usada para armazenar pares chave-valor do tipo String, geralmente para configurações.
    private static Properties loadProperties() {
        try (FileInputStream fs = new FileInputStream("db.properties")) {
            Properties props = new Properties();
            props.load(fs);
            return props;
        } catch (IOException e) {
            throw new DbException(e.getMessage());
        }
    }

    // Método auxiliar para fechar conexões do tipo Statement
    public static void closeStatement(Statement st) {
        if (st != null) {
            try {
                st.close();
            } catch (SQLException e) {
                throw new DbException(e.getMessage());
            }
        }
    }

    // Método auxiliar para fechar conexões do tipo ResultSet
    public static void closeResultSet(ResultSet rt) {
        if (rt != null) {
            try {
                rt.close();
            } catch (SQLException e) {
                throw new DbException(e.getMessage());
            }
        }
    }
}
