package es.fplumara.dam1.campeonato.model;

public class Resultado implements Puntuable {

    @Override
    public int getPuntos() {
        return 0;
    }
    private String id;
    private String idPrueba;
    private String idDeportista;
    private Integer posicion;
    private TipoPrueba tipoPrueba;

    public Resultado(String id, String idPrueba, String idDeportista, Integer posicion, TipoPrueba tipoPrueba) {
        this.id = id;
        this.idPrueba = idPrueba;
        this.idDeportista = idDeportista;
        this.posicion = posicion;
        this.tipoPrueba = tipoPrueba;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdPrueba() {
        return idPrueba;
    }

    public void setIdPrueba(String idPrueba) {
        this.idPrueba = idPrueba;
    }

    public String getIdDeportista() {
        return idDeportista;
    }

    public void setIdDeportista(String idDeportista) {
        this.idDeportista = idDeportista;
    }

    public Integer getPosicion() {
        return posicion;
    }

    public void setPosicion(Integer posicion) {
        this.posicion = posicion;
    }

    public TipoPrueba getTipoPrueba() {
        return tipoPrueba;
    }

    public void setTipoPrueba(TipoPrueba tipoPrueba) {
        this.tipoPrueba = tipoPrueba;
    }
}
