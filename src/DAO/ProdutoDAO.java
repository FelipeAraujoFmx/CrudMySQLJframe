package DAO;
/**
 *
 * @author Felipe.Araujo
 */
import DTO.ProdutoDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ProdutoDAO {

    Connection conn;
    PreparedStatement pstm;
    ResultSet rs;
    ArrayList<ProdutoDTO> lista = new ArrayList<>();

    public void cadastraProduto(ProdutoDTO produtodto) {
        String sql = "insert into produtos (nome_prod,referencia,lote,valor,quantidade) values (?,?,?,?,?)";

        try {
            conn = new ConnectionFactory().createConnectionToMySQL();

            pstm = conn.prepareStatement(sql);
            pstm.setString(1, produtodto.getNome_prod());
            pstm.setString(2, produtodto.getReferencia());
            pstm.setString(3, produtodto.getLote());
            pstm.setDouble(4, produtodto.getValor());
            pstm.setInt(5, produtodto.getQuantidade());

            pstm.execute();
            pstm.close();

        } catch (ClassNotFoundException | SQLException erro) {
            JOptionPane.showMessageDialog(null, "ProdutoDAO" + erro);
        }
    }

    public ArrayList<ProdutoDTO> listarProduto() throws ClassNotFoundException, SQLException {
        String sql = "select * from produtos";
        conn = new ConnectionFactory().createConnectionToMySQL();
        try {

            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();

            while (rs.next()) {
                ProdutoDTO produtodto = new ProdutoDTO();
                produtodto.setId_produto(rs.getInt("id_produto"));
                produtodto.setNome_prod(rs.getString("nome_prod"));
                produtodto.setReferencia(rs.getString("referencia"));
                produtodto.setLote(rs.getString("lote"));
                produtodto.setValor(rs.getDouble("valor"));
                produtodto.setQuantidade(rs.getInt("quantidade"));

                lista.add(produtodto);
            }

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "ProdutoDAO Pesquisar: " + erro);
        }
        return lista;
    }

    public void alterarProduto(ProdutoDTO produtodto) {
        String sql = "update produtos set nome_prod = ?, referencia = ?, lote = ?, valor = ?, quantidade = ? where id_produto = ?";

        try {

            conn = new ConnectionFactory().createConnectionToMySQL();

            pstm = conn.prepareStatement(sql);
            pstm.setString(1, produtodto.getNome_prod());
            pstm.setString(2, produtodto.getReferencia());
            pstm.setString(3, produtodto.getLote());
            pstm.setDouble(4, produtodto.getValor());
            pstm.setInt(5, produtodto.getQuantidade());
            pstm.setInt(6, produtodto.getId_produto());

            pstm.execute();
            pstm.close();

        } catch (ClassNotFoundException | SQLException erro) {
            JOptionPane.showMessageDialog(null, "ProdutoDAO Alterar" + erro);
        }
    }

    public void deletarProduto(ProdutoDTO produtodto) {
        String sql = "delete from produtos where id_produto = ?";

        try {

            conn = new ConnectionFactory().createConnectionToMySQL();

            pstm = conn.prepareStatement(sql);

            pstm.setInt(1, produtodto.getId_produto());

            pstm.execute();
            pstm.close();

        } catch (ClassNotFoundException | SQLException erro) {
            JOptionPane.showMessageDialog(null, "ProdutoDAO Deletar" + erro);
        }

    }

}
