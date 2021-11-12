package DTO;
/**
 *
 * @author Felipe.Araujo
 */
public class FuncionarioDTO {

    private String nome_func, RG_func, CPF_func, endereco_func, sexo_func, mail_func, telefone_func;
    private Integer id_funcionario;

    public String getNome_func() {
        return nome_func;
    }

    public void setNome_func(String nome_func) {
        this.nome_func = nome_func;
    }

    public String getRG_func() {
        return RG_func;
    }

    public void setRG_func(String RG_func) {
        this.RG_func = RG_func;
    }

    public String getCPF_func() {
        return CPF_func;
    }

    public void setCPF_func(String CPF_func) {
        this.CPF_func = CPF_func;
    }

    public String getEndereco_func() {
        return endereco_func;
    }

    public void setEndereco_func(String endereco_func) {
        this.endereco_func = endereco_func;
    }

    public String getSexo_func() {
        return sexo_func;
    }

    public void setSexo_func(String sexo_func) {
        this.sexo_func = sexo_func;
    }

    public String getMail_func() {
        return mail_func;
    }

    public void setMail_func(String mail_func) {
        this.mail_func = mail_func;
    }

    public String getTelefone_func() {
        return telefone_func;
    }

    public void setTelefone_func(String telefone_func) {
        this.telefone_func = telefone_func;
    }

    public Integer getId_funcionario() {
        return id_funcionario;
    }

    public void setId_funcionario(Integer id_funcionario) {
        this.id_funcionario = id_funcionario;
    }

}
