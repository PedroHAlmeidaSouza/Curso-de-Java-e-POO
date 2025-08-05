package model.dao.impl;

import db.DB;
import db.exceptions.DbException;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class SellerDaoJDBC implements SellerDao {

    private Connection conn;

    public SellerDaoJDBC(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insert(Seller obj) {
    }

    @Override
    public void update(Seller obj) {
    }

    @Override
    public void deleteById(Integer id) {
    }

    @Override
    public List<Seller> findAll() {
        return null;
    }

    @Override
    public Seller findById(Integer id) {
        // Representa o comando SQL pré-compilado
        PreparedStatement st = null;

        // Representa o resultado de uma consulta SQL
        ResultSet rs = null;

        try {
            st = conn.prepareStatement(
                    "SELECT seller.*,department.Name as DepName "
                            + "FROM seller INNER JOIN department "
                            + "ON seller.DepartmentId = department.Id "
                            + "WHERE seller.Id = ?");

            // Define o valor Id no 1o ? da query como um inteiro, usado para indicar o Id do departamento que será consultado
            st.setInt(1, id);

            // Executa a query no banco de dados
            rs = st.executeQuery();

            // Itera sobre as linhas do ResultSet instânciando os departamentos encontrados
            if (rs.next()) {
                Department dep = instantiateDepartment(rs);
                return instantiateSeller(rs, dep);
            }
            return null;
        }
        catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
        finally {
            // Fecha as conexões
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }
    }

    // Método privado para gerar instancias de Seller
    private Seller instantiateSeller(ResultSet rs, Department dep) throws SQLException {
        Seller obj =new Seller();
        obj.setId(rs.getInt("Id"));
        obj.setName(rs.getString("Name"));
        obj.setEmail(rs.getString("Email"));
        obj.setBaseSalary(rs.getDouble("BaseSalary"));
        obj.setBirthDate(rs.getDate("BirthDate"));
        obj.setDepartment(dep);
        return obj;
    }

    // Método privado para gerar instancias de Departament
    private Department instantiateDepartment(ResultSet rs) throws SQLException {
        Department dep = new Department();
        dep.setId(rs.getInt("DepartmentId"));
        dep.setName(rs.getString("DepName"));
        return dep;
    }
}
