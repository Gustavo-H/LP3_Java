/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author GustavoHenriquePinhe
 */
public class ProdutoDAO implements IProdutoDAO {

    @Override
    public List lerProdutos() {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<Produto> listaProdutos = new ArrayList<>();
        Produto p = null;
        try {
            stm = con.prepareStatement("SELECT * FROM produto");
            rs = stm.executeQuery();
            while (rs.next()) {
                p = new Produto();
                p.setCodigo(rs.getInt("codigo"));
                p.setDescricao(rs.getString("descricao"));
                p.setMarca(rs.getString("marca"));
                p.setPreco(rs.getDouble("preco"));
                listaProdutos.add(p);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao ler do SGBD!!" + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stm, rs);
            return listaProdutos;
        }
    }

    @Override
    public void create(Produto p) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stm = null;
        try {
            stm = con.prepareStatement("INSERT INTO produto (marca,descricao,preco) VALUES( ?,  ?,  ?)");
            stm.setString(1, p.getMarca());
            stm.setString(2, p.getDescricao());
            stm.setDouble(3, p.getPreco());
            stm.executeUpdate();
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar!!" + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stm);
        }
    }

    @Override
    public void update(Produto p) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stm = null;
        try {
            stm = con.prepareStatement(
            "UPDATE produto SET descricao =  ?, marca = ?, preco = ? WHERE  codigo = ?");
            stm.setString(1, p.getDescricao());
            stm.setString(2, p.getMarca());
            stm.setDouble(3, p.getPreco());
            stm.setInt(4, p.getCodigo());
            stm.executeUpdate();
            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar!!" + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stm);
        }
    }

    @Override
    public void delete(Produto p) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stm = null;
        try {
            stm = con.prepareStatement("DELETE FROM produto WHERE codigo = ?");
            stm.setInt(1, p.getCodigo());
            stm.executeUpdate();
            JOptionPane.showMessageDialog(null, "Removido com sucesso!!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao remover!!" + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stm);
        }
    }
}
