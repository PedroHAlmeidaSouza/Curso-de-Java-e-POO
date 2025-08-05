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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        // Representa o comando SQL pré-compilado
        PreparedStatement st = null;

        // Representa o resultado de uma consulta SQL
        ResultSet rs = null;

        try {
            st = conn.prepareStatement(
                    "SELECT seller.*,department.Name as DepName "
                            + "FROM seller INNER JOIN department "
                            + "ON seller.DepartmentId = department.Id "
                            + "ORDER BY Name");

            // Executa a query no banco de dados
            rs = st.executeQuery();

            // Gera um HashMap para não gerar duplicidade ao apontar para o Seller associado
            List<Seller> list = new ArrayList<>();
            Map<Integer, Department> map = new HashMap<>();

            // Itera sobre os resultado encontrados no ResultSet
            while (rs.next()) {
                // Valida se no HashMap não existe um valor de DepartmentId já existente, caso não exista ele adiciona no Map
                Department dep = map.get(rs.getInt("DepartmentId"));

                // Se dep for igual a nulo significa que ele nao existe na lista do HashMap, ou seja, deve ser instanciado e adicionado a mesma posteriormente
                if (dep == null) {
                    // Somente para cada valor encontrado ele instancia um novo Department através do ResultSet
                    dep = instantiateDepartment(rs);
                    map.put(rs.getInt("DepartmentId"), dep);
                }

                Seller obj = instantiateSeller(rs, dep);

                // Adiciona os objetos Seller encontrados à lista de retorno
                list.add(obj);
            }
            return list;
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

    @Override
    public List<Seller> findByDepartment(Department department) {
        // Representa o comando SQL pré-compilado
        PreparedStatement st = null;

        // Representa o resultado de uma consulta SQL
        ResultSet rs = null;

        try {
            st = conn.prepareStatement(
                    "SELECT seller.*,department.Name as DepName "
                            + "FROM seller INNER JOIN department "
                            + "ON seller.DepartmentId = department.Id "
                            + "WHERE DepartmentId = ? "
                            + "ORDER BY Name");

            // Define o valor Id no 1o ? da query como um inteiro, usado para indicar o Id do department que será consultado
            st.setInt(1, department.getId());

            // Executa a query no banco de dados
            rs = st.executeQuery();

            // Gera um HashMap para não gerar duplicidade ao apontar para o Seller associado
            List<Seller> list = new ArrayList<>();
            Map<Integer, Department> map = new HashMap<>();
            
            // Itera sobre os resultado encontrados no ResultSet
            while (rs.next()) {
                // Valida se no HashMap não existe um valor de DepartmentId já existente, caso não exista ele adiciona no Map
                Department dep = map.get(rs.getInt("DepartmentId"));

                // Se dep for igual a nulo significa que ele nao existe na lista do HashMap, ou seja, deve ser instanciado e adicionado a mesma posteriormente
                if (dep == null) {
                    // Somente para cada valor encontrado ele instancia um novo Department através do ResultSet
                    dep = instantiateDepartment(rs);
                    map.put(rs.getInt("DepartmentId"), dep);
                }

                Seller obj = instantiateSeller(rs, dep);

                // Adiciona os objetos Seller encontrados à lista de retorno
                list.add(obj);
            }
            return list;
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

            // Define o valor Id no 1o ? da query como um inteiro, usado para indicar o Id do Seller que será consultado
            st.setInt(1, id);

            // Executa a query no banco de dados
            rs = st.executeQuery();

            // Valida a linha de posição 1 encontrada o ResultSet se é nula, caso contrario instância o Seller e Department associado
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
