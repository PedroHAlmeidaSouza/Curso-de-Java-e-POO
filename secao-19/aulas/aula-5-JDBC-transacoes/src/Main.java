import db.DB;
import db.exceptions.DbException;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {

        Connection conn = null;
        Statement st = null;

        try {
            conn = DB.getConnection();

            conn.setAutoCommit(false);

            st = conn.createStatement();

            int rows1 = st.executeUpdate("UPDATE seller SET BaseSalary = 3090 WHERE DepartmentId = 1");

            if (1 < 2) {
                throw new SQLException("Fake erro!");
            }

            int rows2 = st.executeUpdate("UPDATE seller SET BaseSalary = 4090 WHERE DepartmentId = 2");

            conn.commit();

            System.out.println("Rows " + rows1);
            System.out.println("Rows " + rows2);

        } catch (SQLException e) {
            try {
                conn.rollback();
                throw new DbException("Transaction rolled back! Caused by: " + e.getMessage());
            } catch (SQLException ex) {
                throw new DbException("Error trying to rollback! Caused by: " + e.getMessage());
            }
        } finally {
            DB.closeStatement(st);
            DB.closeConnection();
        }
    }
}