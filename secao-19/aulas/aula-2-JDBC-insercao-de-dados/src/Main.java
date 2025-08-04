import db.DB;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Main {
    public static void main(String[] args) {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Connection conn = null;

        // A classe PreparedStatement segura e performática e segura de executar SQL com parâmetros.
        PreparedStatement st = null;

        try {
            conn = DB.getConnection();

            // Monta a cláusula de inserção usando a sobrecarga para recuperar os IDs inseridos
            st = conn.prepareStatement(
                    "INSERT INTO seller " +
                            "(Name, Email, BirthDate, BaseSalary, DepartmentId) " +
                            "VALUES (?, ?, ?, ?, ?)"
                    , Statement.RETURN_GENERATED_KEYS
            );

            // Atribui os valores às varáveis
            st.setString(1, "Carl Purple");
            st.setString(2, "carl@gmail.com");
            st.setDate(3, new Date(sdf.parse("22/04/1985").getTime()));
            st.setDouble(4, 3000.00);
            st.setInt(5, 4);

            // Executa a operação no banco de dados. O resultado dessa operação é um número inteiro indicando quantas linhas foram alteradas.
            int rowsAffected = st.executeUpdate();

            // Lógica para imprimir os IDs inseridos no banco de dados
            if (rowsAffected > 0) {
                ResultSet rs = st.getGeneratedKeys();
                while (rs.next()) {
                    System.out.println("ID do vendedor: " + rs.getInt(1));
                }
            } else {
                System.out.println("Nenhuma linha alterada.");
            }

        } catch (SQLException | ParseException e) {
            e.printStackTrace();
        } finally {
            DB.closeStatement(st);
            DB.closeConnection();
        }

    }
}