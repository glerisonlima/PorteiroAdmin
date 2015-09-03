package materialteste.com.br.porteiroadmin.vo;

/**
 * Created by glerison on 05/05/2015.
 */
public class portariaVO {
    private Integer id;
    private String nome;
    private String observacao;
    private String tipo;
    private String data;
    private String hora;
    private Integer acompanhantes;
    private int status;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public Integer getAcompanhantes() {
        return acompanhantes;
    }

    public void setAcompanhantes(Integer acompanhantes) {
        this.acompanhantes = acompanhantes;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
