package materialteste.com.br.porteiroadmin.vo;

import java.util.Date;

/**
 * Created by glerison on 23/05/2015.
 */
public class reservaVO {

    private Integer id;
    private String local;
    private Date data;
    private Integer id_pessoa;
    private Integer periodo;

    public reservaVO(){}


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Integer getId_pessoa() {
        return id_pessoa;
    }

    public void setId_pessoa(Integer id_pessoa) {
        this.id_pessoa = id_pessoa;
    }

    public Integer getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Integer periodo) {
        this.periodo = periodo;
    }
}
