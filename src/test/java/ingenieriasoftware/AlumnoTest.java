package ingenieriasoftware;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AlumnoTest {


    private Alumno a1;
    private Alumno a2;
    private Alumno a3;
    private Alumno a4;

    private Alumno a5;

    @BeforeEach
    void setUp() {
        // Alumno1 - entregables 5,6 - Examen 2,5 --> nota 4,36
        // Entregables
        Entregable e11 = new Entregable("Entregable1");
        e11.setRespuestaUrl("Respuesta 1");
        e11.setNota(5.4);

        Entregable e12 = new Entregable("Entregable2");
        e12.setRespuestaUrl("Respuesta 2");
        e12.setNota(6.8);

        Entregable e13 = new Entregable("Entregable3");
        e13.setRespuestaUrl("Respuesta 3");
        e13.setNota(4.6);


        a1 = new Alumno("Markel", "Alberdi", "markel@ehu.eus", "Euskal Herria");
        a1.setNotaExamen(2.5);
        a1.addEntregable(e11);
        a1.addEntregable(e12);
        a1.addEntregable(e13);

        // Alumno2 - entregables 6.97 - Examen 5,5 --> nota 6,38
        Entregable e21 = new Entregable("Entregable1");
        e21.setRespuestaUrl("Respuesta 1");
        e21.setNota(6.0);

        Entregable e22 = new Entregable("Entregable2");
        e22.setRespuestaUrl("Respuesta 2");
        e22.setNota(9.3);

        Entregable e23 = new Entregable("Entregable3");
        e23.setRespuestaUrl("Respuesta 3");
        e23.setNota(5.6);

        a2 = new Alumno("Maria", "Vaquero", "maria@ehu.eus", "Euskal Herria");
        a2.setNotaExamen(5.5);
        a2.addEntregable(e21);
        a2.addEntregable(e22);
        a2.addEntregable(e23);

        // Alumno3 - entregables 4.97 - Examen 3,5 --> nota 4,38
        Entregable e31 = new Entregable("Entregable1");
        e31.setRespuestaUrl("Respuesta 1");
        e31.setNota(4.0);

        Entregable e32 = new Entregable("Entregable2");
        e32.setRespuestaUrl("Respuesta 2");
        e32.setNota(5.3);

        Entregable e33 = new Entregable("Entregable3");
        e33.setRespuestaUrl("Respuesta 3");
        e33.setNota(5.6);

        a3 = new Alumno("Garazi", "Bikandi", "garazi@ehu.eus", "Euskal Herria");
        a3.setNotaExamen(3.5);
        a3.addEntregable(e31);
        a3.addEntregable(e32);
        a3.addEntregable(e33);

        // Alumno4 - entregables 5.97 - Examen 7,5 --> nota 6,58
        Entregable e41 = new Entregable("Entregable1");
        e41.setRespuestaUrl("Respuesta 1");
        e41.setNota(7.0);

        Entregable e42 = new Entregable("Entregable2");
        e42.setRespuestaUrl("Respuesta 2");
        e42.setNota(5.3);

        Entregable e43 = new Entregable("Entregable3");
        e43.setRespuestaUrl("Respuesta 3");
        e43.setNota(5.6);

        a4 = new Alumno("Pedro", "Aragon", "pedro@ehu.eus", "Francia");
        a4.setNotaExamen(7.5);
        a4.addEntregable(e41);
        a4.addEntregable(e42);
        a4.addEntregable(e43);

        // Alumno 5
        a5 = new Alumno("Juana", "Acosta", "juaga@gmail.com","Argentina");
    }

    @Test
    void haSuspendido() {
        assertTrue(a1.haSuspendido());
        assertFalse(a2.haSuspendido());
        assertTrue(a3.haSuspendido());
        assertFalse(a4.haSuspendido());
        assertTrue(a5.haSuspendido());
    }

    @Test
    void calcularMediaEntregables() {
        assertEquals(5.6, a1.calcularMediaEntregables(), 0.01);
        assertEquals(6.97, a2.calcularMediaEntregables(), 0.01);
        assertEquals(4.97, a3.calcularMediaEntregables(), 0.01);
        assertEquals(5.97, a4.calcularMediaEntregables(), 0.01);
        assertEquals(0, a5.calcularMediaEntregables());
    }

    @Test
    void calcularNotaFinal() {
        assertEquals(4.36, a1.calcularNotaFinal(), 0.01);
        assertEquals(6.38, a2.calcularNotaFinal(), 0.01);
        assertEquals(4.38, a3.calcularNotaFinal(), 0.01);
        assertEquals(6.57, a4.calcularNotaFinal(), 0.01);
        assertEquals(0, a5.calcularNotaFinal());
    }

    @Test
    void haAprobadoTodosLosEntreagables() {
        assertFalse(a1.haAprobadoTodosLosEntregables());
        assertTrue(a2.haAprobadoTodosLosEntregables());
        assertFalse(a3.haAprobadoTodosLosEntregables());
        assertTrue(a4.haAprobadoTodosLosEntregables());
        assertFalse(a5.haAprobadoTodosLosEntregables());
    }

    @Test
    void superaNotaEnAlgunEntregable() {
        assertTrue(a1.superaNotaEnAlgunEntregable(4.0));
        assertFalse(a1.superaNotaEnAlgunEntregable(9.0));
        assertTrue(a2.superaNotaEnAlgunEntregable(4.0));
        assertTrue(a2.superaNotaEnAlgunEntregable(7.0));
        assertFalse(a2.superaNotaEnAlgunEntregable(9.5));
        assertTrue(a3.superaNotaEnAlgunEntregable(4.0));
        assertTrue(a3.superaNotaEnAlgunEntregable(5.0));
        assertFalse(a3.superaNotaEnAlgunEntregable(6));
        assertTrue(a4.superaNotaEnAlgunEntregable(4.0));
        assertTrue(a4.superaNotaEnAlgunEntregable(6.9));
        assertFalse(a4.superaNotaEnAlgunEntregable(7));
        assertFalse(a5.superaNotaEnAlgunEntregable(0));
    }
}