package ingenieriasoftware;

public class Entregable {

    private String enunciado;
    private String respUrl;
    private double nota;

    /**
     * Entregable
     * Crea una nueva instancia de Entregable con el enunciado especificado
     * @param pEnunciado - enunciado del entregable
     */
    public Entregable(String pEnunciado)
    {
        enunciado = pEnunciado;
    }

    /**
     * setNota
     * Establece la nota asignada al entregable
     * @param pNota - la nota
     */
    public void setNota(double pNota)
    {
        if (nota < 0 || nota > 10) {
            throw new IllegalArgumentException();
        }
        nota = pNota;
    }

    /**
     * setRespuestaUrl
     * Establece la respuesta al entregable
     * @param pRespUrl - la respuesta
     */
    public void setRespuestaUrl(String pRespUrl)
    {
        respUrl = pRespUrl;
    }

    /**
     * getNota
     * Devuelve la nota asignada al entregable
     * @return - la nota
     */
    public double getNota()
    {
        return nota;
    }

}
