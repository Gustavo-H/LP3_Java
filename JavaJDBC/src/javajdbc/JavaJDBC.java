package javajdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JavaJDBC {

    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        Cliente cliente = new Cliente();
        
        System.out.println("Escolha uma opcao: ");
        System.out.println("1 - Cadastrar Cliente");
        System.out.println("2 - Listar Clientes");
        String op = ler.next();
        
        if (op.equalsIgnoreCase("1")) {
            System.out.println("\n");
            
            System.out.println("Digite o Nome do cliente: ");
            cliente.setNome(ler.next());
            
            System.out.println("Digite o Email do cliente: ");
            cliente.setEmail(ler.next());
            
            System.out.println("Digite o Endereco do cliente: ");
            cliente.setEndereco(ler.next());
            
            System.out.println("Digite o RG do cliente: ");
            cliente.setRg(ler.next());
            
            System.out.println("Digite o Telefone do cliente: ");
            cliente.setTelefone(ler.next());
            
            create(cliente);           
        }
        else if (op.equalsIgnoreCase("2")) {
            System.out.println("Listando todos os Clientes \n");
            System.out.println("ID Nome            Endereco        Rg         Telefone          Email");
            listarClientes();
        }
        else
            System.out.println("Opção invalida!");        
    }

    public static void listarClientes() {
        Connection con = Conexao.getConnection();
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<Cliente> listaClientes = new ArrayList<>();
        Cliente c = null;
        try {
            stm = con.prepareStatement("SELECT * FROM cliente");
            rs = stm.executeQuery();
            while (rs.next()) {
                c = new Cliente();
                System.out.println(rs.getInt("codigo") + "  " + rs.getString("nome") + "  " + 
                rs.getString("endereco") + "  " + rs.getString("rg") + "  " + rs.getString("telefone") + 
                "  " + rs.getString("email"));
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao ler do SGBD!!" + ex);
        } finally {
            Conexao.closeConnection(con, stm, rs);            
        }
    }

    public static void create(Cliente c) {
        Connection con = Conexao.getConnection();
        PreparedStatement stm = null;
        try {
            stm = con.prepareStatement("INSERT INTO cliente (nome,endereco,rg,"
                    + "telefone,email) VALUES( ?,  ?,  ?,  ?,  ?)");
            stm.setString(1, c.getNome());
            stm.setString(2, c.getEndereco());
            stm.setString(3, c.getRg());
            stm.setString(4, c.getTelefone());
            stm.setString(5, c.getEmail());
            stm.executeUpdate();
            System.out.println(c.getNome() + " Foi Salvo com sucesso!!");
        } catch (SQLException ex) {
            System.out.println("Erro ao salvar!!" + ex);
        } finally {
            Conexao.closeConnection(con, stm);
        }
    }
}
