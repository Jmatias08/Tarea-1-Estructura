package src;

/**
 * Clase que implementa el comportamiento de una radio de carro.
 * Permite encender/apagar la radio, cambiar entre AM y FM,
 * avanzar estaciones y guardar/cargar estaciones en botones.
 */
public class RadioCarro implements Radio {

    /** Indica si la radio está encendida */
    private boolean encendido;

    /** Indica si la radio está en frecuencia FM (true) o AM (false) */
    private boolean esFM;

    /** Estación actual de la radio */
    private double estacionActual;

    /** Arreglo de botones para estaciones FM */
    private double[] botonesFM;

    /** Arreglo de botones para estaciones AM */
    private int[] botonesAM;

    /**
     * Constructor de la clase RadioCarro.
     * Inicializa la radio apagada, en FM y con valores por defecto.
     */
    public RadioCarro() {
        encendido = false;
        esFM = true; // inicia en FM
        estacionActual = 87.9;

        botonesFM = new double[12];
        botonesAM = new int[12];

        // Valores por defecto de los botones
        for (int i = 0; i < 12; i++) {
            botonesFM[i] = 87.9;
            botonesAM[i] = 530;
        }
    }

    /**
     * Enciende la radio.
     */
    @Override
    public void prenderRadio() {
        encendido = true;
    }

    /**
     * Apaga la radio.
     */
    @Override
    public void apagarRadio() {
        encendido = false;
    }

    /**
     * Avanza a la siguiente estación disponible.
     * <ul>
     *   <li>En FM avanza de 0.2 en 0.2 desde 87.9 hasta 107.9</li>
     *   <li>En AM avanza de 10 en 10 desde 530 hasta 1610</li>
     * </ul>
     * Si se sobrepasa el límite, vuelve al inicio.
     */
    @Override
    public void avanzarEstacion() {
        if (!encendido) return;

        if (esFM) {
            estacionActual += 0.2;
            if (estacionActual > 107.9) {
                estacionActual = 87.9;
            }
        } else {
            estacionActual += 10;
            if (estacionActual > 1610) {
                estacionActual = 530;
            }
        }
    }

    /**
     * Guarda la estación actual en el botón indicado.
     *
     * @param numeroBoton número del botón (1 a 12)
     */
    @Override
    public void guardarEstacion(int numeroBoton) {
        if (!encendido || numeroBoton < 1 || numeroBoton > 12) return;

        int index = numeroBoton - 1;

        if (esFM) {
            botonesFM[index] = estacionActual;
        } else {
            botonesAM[index] = (int) estacionActual;
        }
    }

    /**
     * Carga la estación guardada en el botón indicado.
     *
     * @param numeroBoton número del botón (1 a 12)
     */
    @Override
    public void cargarEstacion(int numeroBoton) {
        if (!encendido || numeroBoton < 1 || numeroBoton > 12) return;

        int index = numeroBoton - 1;

        if (esFM) {
            estacionActual = botonesFM[index];
        } else {
            estacionActual = botonesAM[index];
        }
    }

    /**
     * Cambia la frecuencia de la radio a FM.
     * Reinicia la estación a 87.9.
     */
    @Override
    public void cambiarFM() {
        if (encendido) {
            esFM = true;
            estacionActual = 87.9;
        }
    }

    /**
     * Cambia la frecuencia de la radio a AM.
     * Reinicia la estación a 530.
     */
    @Override
    public void cambiarAM() {
        if (encendido) {
            esFM = false;
            estacionActual = 530;
        }
    }

    /**
     * Indica si la radio está encendida.
     *
     * @return true si está encendida, false si está apagada
     */
    public boolean isEncendido() {
        return encendido;
    }

    /**
     * Indica si la radio está en FM.
     *
     * @return true si está en FM, false si está en AM
     */
    public boolean isFM() {
        return esFM;
    }

    /**
     * Obtiene la estación actual.
     *
     * @return estación actual de la radio
     */
    public double getEstacionActual() {
        return estacionActual;
    }
}
