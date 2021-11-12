package DAO;
/**
 *
 * @author Felipe.Araujo
 */
import DTO.FornecedorDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class FornecedorDAO {

    Connection conn;
    PreparedStatement pstm;
    ResultSet rs;
    ArrayList<FornecedorDTO> lista = new ArrayList<>();

    public void cadastrarFornecedor(FornecedorDTO fornecedordto) {

        String sql = "insert into fornecedores (nome_forn,cnpj,endereco_forn,telefone_forn,mail_forn) values (?,?,?,?,?)";

        try {
            conn = new ConnectionFactory().createConnectionToMySQL();

            pstm = conn.prepareStatement(sql);
            pstm.setString(1, fornecedordto.getNome_forn());
            pstm.setString(2, fornecedordto.getCnpj());
            pstm.setString(3, fornecedordto.getEndereco_forn());
            pstm.setString(4, fornecedordto.getTelefone_forn());
            pstm.setString(5, fornecedordto.getMail_forn());

            pstm.execute();
            pstm.close();

        } catch (ClassNotFoundException | SQLException erro) {
            JOptionPane.showMessageDialog(null, "FornecedorDAO" + erro);
        }

    }

    public ArrayList<FornecedorDTO> listarFornecedor() throws ClassNotFoundException, SQLException {
        String sql = "select * from fornecedores";
        conn = new ConnectionFactory().createConnectionToMySQL();
        try {

            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();

            while (rs.next()) {
                FornecedorDTO fornecedordto = new FornecedorDTO();
                fornecedordto.setId_fornecedor(rs.getInt("id_fornecedor"));
                fornecedordto.setNome_forn(rs.getString("nome_forn"));
                fornecedordto.setCnpj(rs.getString("cnpj"));
                fornecedordto.setEndereco_forn(rs.getString("endereco_forn"));
                fornecedordto.setTelefone_forn(rs.getString("telefone_forn"));
                fornecedordto.setMail_forn(rs.getString("mail_forn"));

                lista.add(fornecedordto);
            }

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "FornecedorDAO Pesquisar: " + erro);
        }
        return lista;
    }

    public void alterarFornecedor(FornecedorDTO fornecedordto) {
        String sql = "update fornecedores set nome_forn = ?, cnpj = ?, endereco_forn = ?, telefone_forn = ?, mail_forn = ? where id_fornecedor = ?";

        try {

            conn = new ConnectionFactory().createConnectionToMySQL();

            pstm = conn.prepareStatement(sql);
            pstm.setString(1, fornecedordto.getNome_forn());
            pstm.setString(2, fornecedordto.getCnpj());
            pstm.setString(3, fornecedordto.getEndereco_forn());
            pstm.setString(4, fornecedordto.getTelefone_forn());
            pstm.setString(5, fornecedordto.getMail_forn());
            pstm.setInt(6, fornecedordto.getId_fornecedor());

            pstm.execute();
            pstm.close();

        } catch (ClassNotFoundException | SQLException erro) {
            JOptionPane.showMessageDialog(null, "ForncedorDAO Alterar" + erro);
        }
    }

    public void deletarFornecedor(FornecedorDTO fornecedordto) {
        String sql = "delete from fornecedores where id_fornecedor = ?";

        try {

            conn = new ConnectionFactory().createConnectionToMySQL();

            pstm = conn.prepareStatement(sql);

            pstm.setInt(1, fornecedordto.getId_fornecedor());

            pstm.execute();
            pstm.close();

        } catch (ClassNotFoundException | SQLException erro) {
            JOptionPane.showMessageDialog(null, "FornecedorDAO Deletar" + erro);
        }

    }

}
