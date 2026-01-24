package src.test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import src.RadioCarro;

public class RadioCarroTest {

    @Test
    public void testPrenderRadio() {
        RadioCarro radio = new RadioCarro();
        radio.prenderRadio();
        assertTrue(radio.isEncendido());
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
}
