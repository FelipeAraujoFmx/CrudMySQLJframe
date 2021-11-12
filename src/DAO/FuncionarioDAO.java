package DAO;
/**
 *
 * @author Felipe.Araujo
 */
import DTO.FuncionarioDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class FuncionarioDAO {

    Connection conn;
    PreparedStatement pstm;
    ResultSet rs;
    ArrayList<FuncionarioDTO> lista = new ArrayList<>();

    public void cadastrarFuncionario(FuncionarioDTO funcionariodto) {
        String sql = "insert into funcionarios (nome_func, RG_func, CPF_func, endereco_func, sexo_func, mail_func,telefone_func) values (?,?,?,?,?,?,?)";

        try {

            conn = new ConnectionFactory().createConnectionToMySQL();

            pstm = conn.prepareStatement(sql);
            pstm.setString(1, funcionariodto.getNome_func());
            pstm.setString(2, funcionariodto.getRG_func());
            pstm.setString(3, funcionariodto.getCPF_func());
            pstm.setString(4, funcionariodto.getEndereco_func());
            pstm.setString(5, funcionariodto.getSexo_func());
            pstm.setString(6, funcionariodto.getMail_func());
            pstm.setString(7, funcionariodto.getTelefone_func());

            pstm.execute();
            pstm.close();

        } catch (ClassNotFoundException | SQLException erro) {
            JOptionPane.showMessageDialog(null, "FuncionarioDAO Cadastrar" + erro);
        }

    }

    public ArrayList<FuncionarioDTO> listarFuncionario() throws ClassNotFoundException, SQLException {
        String sql = "select * from funcionarios";
        conn = new ConnectionFactory().createConnectionToMySQL();
        try {

            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();

            while (rs.next()) {
                FuncionarioDTO funcionariodto = new FuncionarioDTO();
                funcionariodto.setId_funcionario(rs.getInt("id_funcionario"));
                funcionariodto.setNome_func(rs.getString("nome_func"));
                funcionariodto.setRG_func(rs.getString("RG_func"));
                funcionariodto.setCPF_func(rs.getString("CPF_func"));
                funcionariodto.setEndereco_func(rs.getString("endereco_func"));
                funcionariodto.setSexo_func(rs.getString("sexo_func"));
                funcionariodto.setMail_func(rs.getString("mail_func"));
                funcionariodto.setTelefone_func(rs.getString("telefone_func"));

                lista.add(funcionariodto);
            }

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "FuncionarioDAO Pesquisar: " + erro);
        }
        return lista;
    }

    public void alterarFuncionario(FuncionarioDTO funcionariodto) {
        String sql = "update funcionarios set nome_func = ?, RG_func = ?, CPF_func = ?, endereco_func = ?, sexo_func = ?, mail_func = ?, telefone_func = ? where id_funcionario = ?";

        try {

            conn = new ConnectionFactory().createConnectionToMySQL();

            pstm = conn.prepareStatement(sql);
            pstm.setString(1, funcionariodto.getNome_func());
            pstm.setString(2, funcionariodto.getRG_func());
            pstm.setString(3, funcionariodto.getCPF_func());
            pstm.setString(4, funcionariodto.getEndereco_func());
            pstm.setString(5, funcionariodto.getSexo_func());
            pstm.setString(6, funcionariodto.getMail_func());
            pstm.setString(7, funcionariodto.getTelefone_func());
            pstm.setInt(8, funcionariodto.getId_funcionario());

            pstm.execute();
            pstm.close();

        } catch (ClassNotFoundException | SQLException erro) {
            JOptionPane.showMessageDialog(null, "FuncionarioDAO Alterar" + erro);
        }
    }

    public void deletarFuncionario(FuncionarioDTO funcionariodto) {
        String sql = "delete from funcionarios where id_funcionario = ?";

        try {

            conn = new ConnectionFactory().createConnectionToMySQL();

            pstm = conn.prepareStatement(sql);

            pstm.setInt(1, funcionariodto.getId_funcionario());

            pstm.execute();
            pstm.close();

        } catch (ClassNotFoundException | SQLException erro) {
            JOptionPane.showMessageDialog(null, "FuncionarioDAO Deletar" + erro);
        }

    }

}
