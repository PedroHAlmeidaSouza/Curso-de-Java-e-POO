import db.DB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {

        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;

        try {
            // Abre a conexão com o banco de dados
            conn = DB.getConnection();

            // Cria um objeto Statement para criar consultas
            st = conn.createStatement();

            // Atribui e executa a clausula de consulta a variável do tipo ResultSet
            rs = st.executeQuery("SELECT * FROM department");

            // Percorre as as linhas e colunas do resultado encontrado na variável rs
            while (rs.next()) {
                System.out.println(rs.getInt("Id") + ", " + rs.getString("Name"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Fecha os recursos utilizados
            DB.closeResultSet(rs);
            DB.closeStatement(st);
            DB.closeConnection();
        }
    }
}