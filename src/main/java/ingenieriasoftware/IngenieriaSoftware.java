package ingenieriasoftware;

import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.function.Function;


import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.*;

public class IngenieriaSoftware {

    private static final IngenieriaSoftware mIngenieriaSoftware = new IngenieriaSoftware();
    private final List<Alumno> lMatriculados;

    private IngenieriaSoftware() {
        lMatriculados = new ArrayList<>();
    }

    public static IngenieriaSoftware getIngenieriaSoftware() {
        return mIngenieriaSoftware;
    }

    public void addAlumno(Alumno pAl) {
        lMatriculados.add(pAl);
    }

    /**
     * mostrarNotasTAlumnos Muestra en la salida estándar el nombre, apellidos y la
     * nota final de cada uno de los estudiantes
     */
    public void mostrarNotasAlumnos() {
        lMatriculados.forEach(System.out::println);
    }

    /**
     * getAlumnosSuspendidos
     *
     * @return devuelve la lista de alumnos que no han aprobado la asignatura
     */
    public List<Alumno> getAlumnosSuspendidos() {

        return lMatriculados
                .stream()
                .filter(Alumno::haSuspendido)
                .toList();
    }

    /**
     * getListaAlumnosAprobadosOrdenadaPorNombre
     *
     * @return la lista de alumnos aprobados, ordenada por nombre
     */
    public List<Alumno> getListaAlumnosAprobadosOrdenadaPorNombre() {
        return lMatriculados
                .stream()
                .filter(a -> !a.haSuspendido())
                .sorted(comparing(Alumno::getNombre))
                .toList();
    }

    /**
     * getListaAlumnosAprobadosOrdenadaPorNombreYApellidos
     *
     * @return la lista de alumnos aprobados, ordenada por nombre y Apellidos
     */
    public List<Alumno> getListaAlumnosAprobadosOrdenadaPorNombreYApellidos() {
        return lMatriculados
                .stream()
                .filter(a -> !a.haSuspendido())
                .sorted(comparing(Alumno::getNombre)
                        .thenComparing(Alumno::getApellido))
                .toList();
    }

    /**
     * getPorcentajeAprobados
     *
     * @return devuelve el porcentaje de aprobados de la asignatura
     */
    public double getPorcentajeAprobados() {
        return 100.0 * lMatriculados
                .stream()
                .filter(a ->!a.haSuspendido())
                .count() / lMatriculados.size();
    }

    /**
     * getPaisesRepresentados
     *
     * @return devuelve la lista de paises representados por el alumnado de la
     *         asignatura (sin valores repetidos)
     */
    public List<String> getPaisesRepresentados() {
        return lMatriculados
                .stream()
                .map(Alumno::getPais)
                .distinct()
                .toList();
    }

    /**
     * getAlumnosQueHanAprobadoTodosEntregables
     *
     * @return la lista de alumnos que han aprobado todos los entregables
     */
    public List<Alumno> getAlumnosQueHanAprobadoTodosEntregables() {
        return lMatriculados
                .stream()
                .filter(Alumno::haAprobadoTodosLosEntregables)
                .toList();
    }

    /**
     * getAlumnosQueSuperanNotaEnEntregable
     *
     * @param pNota la nota
     * @return la lista de alumnos que han obtenido una nota superior a pNota en
     *         algún entregable
     */
    public List<Alumno> getAlumnosQueSuperanNotaEnEntregable(double pNota) {
        return lMatriculados
                .stream()
                .filter(a -> a.superaNotaEnAlgunEntregable(pNota))
                .toList();
    }

    /**
     * getEstadisticas
     *
     * @return devuelve las estadísticas de la asignatura (número de alumnos, suma
     *         de las notas, nota mínima, nota máxima y nota media)
     */
    public DoubleSummaryStatistics getEstadisticas() {
        return lMatriculados
                .stream()
                .mapToDouble(Alumno::calcularNotaFinal)
                .summaryStatistics();
    }

    /**
     * getListaAprobadosSuspendidos
     *
     * @return un mapa que contiene la lista de alumnos suspendidos (true) y lista
     *         de alumnos aprobados (false)
     */
    public Map<Boolean, List<Alumno>> getListaAprobadosSuspendidos() {
        return lMatriculados
                .stream()
                .collect(partitioningBy(Alumno::haSuspendido));
    }

    /**
     * getAlumnosPorPais
     *
     * @return devuelve la lista de alumnos de cada país
     */
    public Map<String, List<Alumno>> getAlumnosPorPais() {
        return lMatriculados
                .stream()
                .collect(groupingBy(Alumno::getPais));
    }

    /**
     * getNotaMediaPorPais
     *
     * @return devuelve un mapa que, para cada pais, indica la nota media de los
     *         alumnos de dicho pais
     */
    public Map<String, Double> getNotaMediaPorPais() {
        return lMatriculados
                .stream()
                .collect(groupingBy(Alumno::getPais,
                        averagingDouble(Alumno::calcularNotaFinal)));
    }

    /**
     * getAlumnoConMejorNotaPorPais
     *
     * @return devuelve un mapa que contiene el alumno que mejor ha obtenido por
     *         cada país
     */
    public Map<String, Alumno> getAlumnoConMejorNotaPorPais() {
        return lMatriculados
                .stream()
                .collect(toMap(Alumno::getPais,
                        Function.identity(),
                        BinaryOperator.maxBy(comparing(Alumno::calcularNotaFinal))));
    }

    /**
     * getMejorNotaPorPais
     *
     * @return devuelve un mapa que contiene la mejor nota obtenida por cada país
     */
    public Map<String, Double> getMejorNotaPorPais() {
        return lMatriculados
                .stream()
                .collect(toMap(Alumno::getPais,
                        Alumno::calcularNotaFinal,
                        BinaryOperator.maxBy(comparing(Double::doubleValue))));
    }

    /**
     * eliminarAlumnos
     * Elimina los alumnos de la lista
     */
    public void eliminarAlumnos() {
        lMatriculados.clear();
    }
}
