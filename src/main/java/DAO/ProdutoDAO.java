package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.Produto;
import dao.Conexao;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {

    public void cadastrar(Produto produto) {

        String sql = "INSERT INTO produto(nome, preco, estoque) VALUES (?,?,?)";

        try  (Connection conexao = Conexao.conectar(); 
                
            PreparedStatement comando = conexao.prepareStatement(sql)) {
            
            comando.setString(1, produto.getNome());
            comando.setDouble(2, produto.getPreco());
            comando.setInt(3, produto.getEstoque());
            comando.executeUpdate();
            
            System.out.println("Produto cadastrado com sucesso");
        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar produto. " + e.getMessage());

        }
    }
    
    
     public List<Produto> listar() {

        List<Produto> produtos = new ArrayList<>();

        String sql = """
				COMANDO SQL
            """;

        try (Connection conexao = Conexao.conectar();
             PreparedStatement comando = conexao.prepareStatement(sql);
             ResultSet resultado = comando.executeQuery()) {

            while (resultado.next()) {

                Produto produto = new Produto(
                    resultado.getInt("id"),
                    resultado.getString("nome"),
                    resultado.getDouble("preco"),
                    resultado.getInt("estoque")
                );

                produtos.add(produto);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao listar produtos: " + e.getMessage());
        }

        return produtos;
     }
}
