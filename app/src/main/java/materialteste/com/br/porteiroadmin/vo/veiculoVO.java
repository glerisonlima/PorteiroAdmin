package materialteste.com.br.porteiroadmin.vo;

/**
 * Created by glerison on 14/05/2015.
 */
public class veiculoVO {

    private Integer _id;
    private Integer id_proprietario;
    private String tipo;
    private String marca;
    private String modelo;
    private String cor;
    private String placa;

    public void veiculoVO(){}


    public Integer get_id() {
        return _id;
    }

    public void set_id(Integer _id) {
        this._id = _id;
    }

    public Integer getId_proprietario() {
        return id_proprietario;
    }

    public void setId_proprietario(Integer id_proprietario) {
        this.id_proprietario = id_proprietario;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }
}
