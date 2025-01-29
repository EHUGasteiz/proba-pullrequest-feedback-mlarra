package ingenieriasoftware;

import java.util.ArrayList;
import java.util.List;
import static java.util.stream.Collectors.*;

public class Alumno {

    private String nombre;
    private String apellido;
    private String mail;
    private double notaExamen;
    private String pais;
    private List<Entregable> lEntregables = new ArrayList<Entregable>();

    public Alumno(String pNombre, String pApellido, String pMail, String pPais) {
        nombre = pNombre;
        apellido = pApellido;
        mail = pMail;
        pais = pPais;

    }

    //////////////////// GETTERS/////////////////////////
    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getPais() {
        return pais;
    }

    //////////////////////////////////////////////

    public void setNotaExamen(double pNotaExamen) {
        notaExamen = pNotaExamen;
    }

    public void addEntregable(Entregable pEnt) {
        lEntregables.add(pEnt);
    }

    public boolean haSuspendido() {
        return calcularNotaFinal() < 5;
    }

    public String toString() {
        return String.format("Nombre: %s\nApellidos: %s\nEmail: %s\nNota final: %.2f\n", getNombre(), apellido, mail,
                calcularNotaFinal());
    }

    /**
     * calcularMediaEntregables
     *
     * @return la nota media de los entregables (0 si no ha realizado ningún
     *         entregable)
     */
    public double calcularMediaEntregables() {
        // TODO: Ejercicio 1
        return 0.0;
    }

    /**
     * calcularNotaFinal
     *
     * @return devuelve la nota media de la asignatura utilizando la fórmula del
     *         enunciado
     */
    public double calcularNotaFinal() {
        // TODO: Ejercicio 2
        return 0.0;
    }

    /**
     * haAprobadoTodosLosEntreagables
     */
    public boolean haAprobadoTodosLosEntregables() {
        // TODO: Ejercicio 3
        return false;
    }

    /**
     * superaNotaEnAlgunEntregable
     *
     * @return true si el alumno ha obtenido una calificación superior en alguno de
     *         los entregables y false en caso contrario
     */
    public boolean superaNotaEnAlgunEntregable(double pNota) {
        // TODO: Ejercicio 4
        return false;
    }

}
