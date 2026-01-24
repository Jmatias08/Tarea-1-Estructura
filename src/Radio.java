package src;

/**
 * Interfaz que define el comportamiento básico de una radio.
 * Establece los métodos necesarios para controlar una radio AM/FM.
 */
public interface Radio {

    /**
     * Enciende la radio.
     */
    void prenderRadio();

    /**
     * Apaga la radio.
     */
    void apagarRadio();

    /**
     * Avanza a la siguiente estación disponible según la frecuencia actual.
     */
    void avanzarEstacion();

    /**
     * Guarda la estación actual en un botón específico.
     *
     * @param numeroBoton número del botón (1 a 12)
     */
    void guardarEstacion(int numeroBoton);

    /**
     * Carga la estación guardada en un botón específico.
     *
     * @param numeroBoton número del botón (1 a 12)
     */
    void cargarEstacion(int numeroBoton);

    /**
     * Cambia la frecuencia de la radio a FM.
     */
    void cambiarFM();

    /**
     * Cambia la frecuencia de la radio a AM.
     */
    void cambiarAM();
}
