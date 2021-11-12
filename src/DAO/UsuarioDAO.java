package DAO;

import DTO.UsuarioDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Felipe.Araujo
 */
public class UsuarioDAO {

    Connection conn;
    PreparedStatement pstm;
    ResultSet rs;
    ArrayList<UsuarioDTO> lista = new ArrayList<>();

    public void cadastraUsuario(UsuarioDTO usuariodto) {
        String sql = "insert into usuario (nome_usuario,senha_usuario) values (?,?)";

        try {
            conn = new ConnectionFactory().createConnectionToMySQL();

            pstm = conn.prepareStatement(sql);
            pstm.setString(1, usuariodto.getNome_usuario());
            pstm.setString(2, usuariodto.getSenha_usuario());

            pstm.execute();
            pstm.close();

        } catch (ClassNotFoundException | SQLException erro) {
            JOptionPane.showMessageDialog(null, "UsuarioDAO" + erro);
        }
    }

    public ArrayList<UsuarioDTO> listarUsuario() throws ClassNotFoundException, SQLException {
        String sql = "select * from usuario";
        conn = new ConnectionFactory().createConnectionToMySQL();
        try {

            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();

            while (rs.next()) {
                UsuarioDTO usuariodto = new UsuarioDTO();
                usuariodto.setId_usuario(rs.getInt("id_usuario"));
                usuariodto.setNome_usuario(rs.getString("nome_usuario"));
                usuariodto.setSenha_usuario(rs.getString("senha_usuario"));

                lista.add(usuariodto);
            }

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "UsuarioDAO Listar: " + erro);
        }
        return lista;
    }

    public void alterarUsuario(UsuarioDTO usuariodto) {
        String sql = "update usuario set nome_usuario = ?, senha_usuario = ? where id_usuario = ?";

        try {

            conn = new ConnectionFactory().createConnectionToMySQL();

            pstm = conn.prepareStatement(sql);
            pstm.setString(1, usuariodto.getNome_usuario());
            pstm.setString(2, usuariodto.getSenha_usuario());
            pstm.setInt(3, usuariodto.getId_usuario());

            pstm.execute();
            pstm.close();

        } catch (ClassNotFoundException | SQLException erro) {
            JOptionPane.showMessageDialog(null, "UsuarioDAO Alterar" + erro);
        }
    }

    public void deletarUsuario(UsuarioDTO usuariodto) {
        String sql = "delete from usuario where id_usuario = ?";

        try {

            conn = new ConnectionFactory().createConnectionToMySQL();

            pstm = conn.prepareStatement(sql);

            pstm.setInt(1, usuariodto.getId_usuario());

            pstm.execute();
            pstm.close();

        } catch (ClassNotFoundException | SQLException erro) {
            JOptionPane.showMessageDialog(null, "UsuarioDAO Deletar" + erro);
        }

    }

    public ResultSet autenticaUsuraio(UsuarioDTO usuariodto) throws ClassNotFoundException, SQLException {
        conn = new ConnectionFactory().createConnectionToMySQL();
        try {

            String sql = " select * from usuario where nome_usuario = ? and senha_usuario = ?";

            pstm = conn.prepareStatement(sql);
            pstm.setString(1, usuariodto.getNome_usuario());
            pstm.setString(2, usuariodto.getSenha_usuario());

            rs = pstm.executeQuery();
            return rs;

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "UsuarioDAO" + erro);
            return null;
        }

    }
}
