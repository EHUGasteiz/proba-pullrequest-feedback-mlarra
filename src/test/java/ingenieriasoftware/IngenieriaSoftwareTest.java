package ingenieriasoftware;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class IngenieriaSoftwareTest {

    private IngenieriaSoftware ing;
    private Alumno a1;
    private Alumno a2;
    private Alumno a3;
    private Alumno a4;
    private Alumno a5;
    private Alumno a6;
    private Alumno a7;

    @BeforeEach
    void setUp() {
        // Alumno1
        Entregable e11 = new Entregable("Entregable1");
        e11.setRespuestaUrl("Respuesta 11");
        e11.setNota(5.4);

        Entregable e12 = new Entregable("Entregable2");
        e12.setRespuestaUrl("Respuesta 12");
        e12.setNota(6.8);

        Entregable e13 = new Entregable("Entregable3");
        e13.setRespuestaUrl("Respuesta 13");
        e13.setNota(4.6);

        a1 = new Alumno("Markel", "Alberdi", "markel@ehu.eus", "Euskal Herria");
        a1.setNotaExamen(2.5);
        a1.addEntregable(e11);
        a1.addEntregable(e12);
        a1.addEntregable(e13);

        // Alumno2
        Entregable e21 = new Entregable("Entregable1");
        e21.setRespuestaUrl("Respuesta 21");
        e21.setNota(6.0);

        Entregable e22 = new Entregable("Entregable2");
        e22.setRespuestaUrl("Respuesta 22");
        e22.setNota(9.3);

        Entregable e23 = new Entregable("Entregable3");
        e23.setRespuestaUrl("Respuesta 23");
        e23.setNota(5.6);

        a2 = new Alumno("Maria", "Vaquero", "maria@ehu.eus", "Euskal Herria");
        a2.setNotaExamen(5.5);
        a2.addEntregable(e21);
        a2.addEntregable(e22);
        a2.addEntregable(e23);

        // Alumno3
        Entregable e31 = new Entregable("Entregable1");
        e31.setRespuestaUrl("Respuesta 31");
        e31.setNota(4.0);

        Entregable e32 = new Entregable("Entregable2");
        e32.setRespuestaUrl("Respuesta 32");
        e32.setNota(5.3);

        Entregable e33 = new Entregable("Entregable3");
        e33.setRespuestaUrl("Respuesta 33");
        e33.setNota(5.6);

        a3 = new Alumno("Garazi", "Bikandi", "garazi@ehu.eus", "Euskal Herria");
        a3.setNotaExamen(3.5);
        a3.addEntregable(e31);
        a3.addEntregable(e32);
        a3.addEntregable(e33);

        // Alumno4
        Entregable e41 = new Entregable("Entregable1");
        e41.setRespuestaUrl("Respuesta 41");
        e41.setNota(7.0);

        Entregable e42 = new Entregable("Entregable2");
        e42.setRespuestaUrl("Respuesta 42");
        e42.setNota(5.3);

        Entregable e43 = new Entregable("Entregable3");
        e43.setRespuestaUrl("Respuesta 43");
        e43.setNota(5.6);

        a4 = new Alumno("Pedro", "Aragon", "pedro@ehu.eus", "Francia");
        a4.setNotaExamen(7.5);
        a4.addEntregable(e41);
        a4.addEntregable(e42);
        a4.addEntregable(e43);

        // Alumno5
        Entregable e51 = new Entregable("Entregable1");
        e51.setRespuestaUrl("Respuesta 51");
        e51.setNota(7.0);

        Entregable e52 = new Entregable("Entregable2");
        e52.setRespuestaUrl("Respuesta 52");
        e52.setNota(8.3);

        Entregable e53 = new Entregable("Entregable3");
        e53.setRespuestaUrl("Respuesta 53");
        e53.setNota(2.6);

        a5 = new Alumno("Angel", "Alonso", "angel@ehu.eus", "Portugal");
        a5.setNotaExamen(6.8);
        a5.addEntregable(e51);
        a5.addEntregable(e52);
        a5.addEntregable(e53);

        // Alumno6
        Entregable e61 = new Entregable("Entregable1");
        e61.setRespuestaUrl("Respuesta 61");
        e61.setNota(7.0);

        Entregable e62 = new Entregable("Entregable2");
        e62.setRespuestaUrl("Respuesta 62");
        e62.setNota(5.3);

        Entregable e63 = new Entregable("Entregable3");
        e63.setRespuestaUrl("Respuesta 63");
        e63.setNota(2.6);

        a6 = new Alumno("Irati", "Alberdi", "irati@ehu.eus", "Portugal");
        a6.setNotaExamen(3.7);
        a6.addEntregable(e61);
        a6.addEntregable(e62);
        a6.addEntregable(e63);

        // Alumno 7
        a7 = new Alumno("Juana", "Acosta", "juaga@gmail.com", "Argentina");


        ing = IngenieriaSoftware.getIngenieriaSoftware();
        ing.eliminarAlumnos();
        ing.addAlumno(a1);
        ing.addAlumno(a2);
        ing.addAlumno(a3);
        ing.addAlumno(a4);
        ing.addAlumno(a5);
        ing.addAlumno(a6);
        ing.addAlumno(a7);
    }

    @Test
    void getAlumnosSuspendidos() {
        List<Alumno> suspendidosReales = List.of(a1, a3, a6, a7);
        List<Alumno> suspendidosCalculados = ing.getAlumnosSuspendidos();
        assertTrue(suspendidosCalculados.containsAll(suspendidosReales));
        assertTrue(suspendidosReales.containsAll(suspendidosCalculados));
    }

    @Test
    void getListaAlumnosAprobadosOrdenadaPorNombre() {
        List<Alumno> aprobadosReales = List.of(a5, a2, a4);
        List<Alumno> aprobadosCalculados = ing.getListaAlumnosAprobadosOrdenadaPorNombre();
        assertIterableEquals(aprobadosReales, aprobadosCalculados);
    }

    @Test
    void getListaAlumnosAprobadosOrdenadaPorNombreYApellidos() {
        // Alumno5
        Entregable e81 = new Entregable("Entregable1");
        e81.setRespuestaUrl("Respuesta 81");
        e81.setNota(7.0);

        Entregable e82 = new Entregable("Entregable2");
        e82.setRespuestaUrl("Respuesta 82");
        e82.setNota(8.3);

        Entregable e83 = new Entregable("Entregable3");
        e83.setRespuestaUrl("Respuesta 83");
        e83.setNota(2.6);

        Alumno a8 = new Alumno("Angel", "Perez", "angelp@ehu.eus", "Portugal");
        a8.setNotaExamen(6.8);
        a8.addEntregable(e81);
        a8.addEntregable(e82);
        a8.addEntregable(e83);

        ing.addAlumno(a8);

        List<Alumno> aprobadosReales = List.of(a5, a8, a2, a4);
        List<Alumno> aprobadosCalculados = ing.getListaAlumnosAprobadosOrdenadaPorNombre();
        assertIterableEquals(aprobadosReales, aprobadosCalculados);
    }

    @Test
    void getPorcentajeAprobados() {
        assertEquals(300.0 / 7, ing.getPorcentajeAprobados());
    }

    @Test
    void getPaisesRepresentados() {
        List<String> paisesReales = List.of("Euskal Herria", "Francia", "Portugal", "Argentina");
        List<String> paisesCalculados = ing.getPaisesRepresentados();
        assertTrue(paisesCalculados.containsAll(paisesReales));
        assertTrue(paisesReales.containsAll(paisesCalculados));
    }

    @Test
    void getAlumnosQueHanAprobadoTodosEntregables() {
        List<Alumno> alumnosReales = List.of(a2, a4);
        List<Alumno> alumnosCalculados = ing.getAlumnosQueHanAprobadoTodosEntregables();
        assertTrue(alumnosReales.containsAll(alumnosCalculados));
        assertTrue(alumnosCalculados.containsAll(alumnosReales));
    }

    @Test
    void getAlumnosQueSuperanNotaEnEntregable() {
        List<Alumno> alumnosReales = List.of(a2, a5);
        List<Alumno> alumnosCalculados = ing.getAlumnosQueSuperanNotaEnEntregable(7.5);
        assertTrue(alumnosReales.containsAll(alumnosCalculados));
        assertTrue(alumnosCalculados.containsAll(alumnosReales));
    }

    @Test
    void getEstadisticas() {
        var estadisticas = ing.getEstadisticas();
        assertEquals(7, estadisticas.getCount());
        assertEquals(6.58, estadisticas.getMax(), 0.01);
        assertEquals(0, estadisticas.getMin());
        assertEquals(4.63, estadisticas.getAverage(), 0.01);
        assertEquals(32.46, estadisticas.getSum());
    }

    @Test
    void getListaAprobadosSuspendidos() {
        var respuestaEsperada = Map.of(false, List.of(a2, a4, a5),
                true, List.of(a1, a3, a6,a7));
        var respuesta = ing.getListaAprobadosSuspendidos();
        respuestaEsperada.forEach((grupo, alumnosEsperados) -> {
            assertTrue(alumnosEsperados.containsAll(respuesta.get(grupo)));
            assertTrue(respuesta.get(grupo).containsAll(alumnosEsperados));
        });
    }

    @Test
    void getAlumnosPorPais() {
        var respuestaEsperada = Map.of("Euskal Herria", List.of(a1, a2, a3),
                "Francia", List.of(a4),
                "Portugal", List.of(a5, a6),
                "Argentina", List.of(a7)
                );
        var respuesta = ing.getAlumnosPorPais();
        respuestaEsperada.forEach((grupo, alumnosEsperados) -> {
            assertTrue(alumnosEsperados.containsAll(respuesta.get(grupo)));
            assertTrue(respuesta.get(grupo).containsAll(alumnosEsperados));
        });
    }

    @Test
    void getNotaMediaPorPais() {
        var respuestaEsperada = Map.of("Euskal Herria", 5.04,
                "Francia", 6.58,
                "Portugal", 5.38,
                "Argentina", 0.0
        );
        var respuesta = ing.getNotaMediaPorPais();
        respuestaEsperada.forEach((grupo, notaEsperada) -> {
           assertEquals(notaEsperada, respuesta.get(grupo), 0.01);
        });
    }

    @Test
    void getAlumnoConMejorNotaPorPais() {
        var respuestaEsperada = Map.of("Euskal Herria", a2,
                "Francia", a4,
                "Portugal", a5,
                "Argentina", a7
        );
        var respuesta = ing.getAlumnoConMejorNotaPorPais();
        respuestaEsperada.forEach((grupo, alumnoEsperado) -> {
            assertEquals(alumnoEsperado, respuesta.get(grupo));
        });
    }

    @Test
    void getMejorNotaPorPais() {
        var respuestaEsperada = Map.of("Euskal Herria", 6.38,
                "Francia", 6.58,
                "Portugal", 6.30,
                "Argentina", 0.0
        );
        var respuesta = ing.getMejorNotaPorPais();
        respuestaEsperada.forEach((grupo, notaEsperada) -> {
            assertEquals(notaEsperada, respuesta.get(grupo), 0.01);
        });
    }
}