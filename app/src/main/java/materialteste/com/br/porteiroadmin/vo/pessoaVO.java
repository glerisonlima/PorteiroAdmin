package materialteste.com.br.porteiroadmin.vo;

/**
 * Created by glerison on 13/05/2015.
 */
public class pessoaVO {

    private Integer _id;
    private String nome;
    private String bloco_ap;
    private String sexo;
    private String status;
    private String veiculo;

    public pessoaVO(){

    }

    public Integer get_id() {
        return _id;
    }

    public void set_id(Integer _id) {
        this._id = _id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getBloco_ap() {
        return bloco_ap;
    }

    public void setBloco_ap(String bloco_ap) {
        this.bloco_ap = bloco_ap;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(String veiculo) {
        this.veiculo = veiculo;
    }
}
