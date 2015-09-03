package materialteste.com.br.porteiroadmin.vo;

/**
 * Created by glerison on 14/05/2015.
 */
public class notificacaoVO {

    private Integer _id;
    private Integer id_pessoa;
    private String descricao;
    private String data;

    public notificacaoVO(){

    }


    public Integer get_id() {
        return _id;
    }

    public void set_id(Integer _id) {
        this._id = _id;
    }

    public Integer getId_pessoa() {
        return id_pessoa;
    }

    public void setId_pessoa(Integer id_pessoa) {
        this.id_pessoa = id_pessoa;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
