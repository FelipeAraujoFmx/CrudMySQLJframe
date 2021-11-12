package DTO;
/**
 *
 * @author Felipe.Araujo
 */
public class FornecedorDTO {

    private String nome_forn;
    private String cnpj;
    private String endereco_forn;
    private String telefone_forn;
    private String mail_forn;
    private Integer id_fornecedor;

    public String getNome_forn() {
        return nome_forn;
    }

    public void setNome_forn(String nome_forn) {
        this.nome_forn = nome_forn;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getEndereco_forn() {
        return endereco_forn;
    }

    public void setEndereco_forn(String endereco_forn) {
        this.endereco_forn = endereco_forn;
    }

    public String getTelefone_forn() {
        return telefone_forn;
    }

    public void setTelefone_forn(String telefone_forn) {
        this.telefone_forn = telefone_forn;
    }

    public String getMail_forn() {
        return mail_forn;
    }

    public void setMail_forn(String mail_forn) {
        this.mail_forn = mail_forn;
    }

    public Integer getId_fornecedor() {
        return id_fornecedor;
    }

    public void setId_fornecedor(Integer id_fornecedor) {
        this.id_fornecedor = id_fornecedor;
    }
}
