package src.test;


import org.junit.Test;
import src.RadioCarro;

import static org.junit.Assert.*;

public class RadioCarroTest {

    @Test
    public void testPrenderRadio() {
        RadioCarro radio = new RadioCarro();
        radio.prenderRadio();
        assertTrue(radio.isEncendido());
    }
    @Test
    public void testFallaPrenderRadio() {
        RadioCarro radio = new RadioCarro();
        radio.prenderRadio();

        // La radio SÍ está encendida, pero afirmamos lo contrario
        assertFalse(radio.isEncendido());
    }

    @Test
    public void testCambiarAMyFM() {
        RadioCarro radio = new RadioCarro();
        radio.prenderRadio();

        radio.cambiarAM();
        assertFalse(radio.isFM());

        radio.cambiarFM();
        assertTrue(radio.isFM());
    }

    @Test
    public void testGuardarYCargarEstacionFM() {
        RadioCarro radio = new RadioCarro();
        radio.prenderRadio();
        radio.cambiarFM();

        radio.avanzarEstacion(); // 88.1
        radio.guardarEstacion(1);

        radio.avanzarEstacion(); // 88.3
        radio.cargarEstacion(1);

        assertEquals(88.1, radio.getEstacionActual(), 0.01);
    }

    @Test
    public void testFallaGuardarYCargarEstacion() {
        RadioCarro radio = new RadioCarro();
        radio.prenderRadio();
        radio.cambiarFM();

        radio.avanzarEstacion(); // 88.1
        radio.guardarEstacion(1);

        radio.avanzarEstacion(); // 88.3
        radio.cargarEstacion(1);

        // La estación real es 88.1, pero esperamos otra
        assertEquals(95.5, radio.getEstacionActual(), 0.01);
    }

}
