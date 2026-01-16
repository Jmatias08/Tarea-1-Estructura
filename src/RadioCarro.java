package src;

public class RadioCarro implements Radio{
    
    private boolean encendido;
    private boolean esFM;
    private double estacionActual;
    private double[] botonesFM;
    private int[] botonesAM;

    public RadioCarro() {
        encendido = false;
        esFM = true; // inicia en FM
        estacionActual = 87.9;

        botonesFM = new double[12];
        botonesAM = new int[12];

        // valores por defecto
        for (int i = 0; i < 12; i++) {
            botonesFM[i] = 87.9;
            botonesAM[i] = 530;
        }
    }

    
    @Override
    public void prenderRadio() {
        encendido = true;
        
    }

    @Override
    public void apagarRadio() {
        encendido = false;
    }

    @Override
    public void avanzarEstacion() {
        
        if (!encendido) return;
        // Comprueba si esta en FM, si esta en fm suma de 0.2 en 0.2 Hasta 107.9
        if (esFM) { 
            estacionActual += 0.2;
            if (estacionActual > 107.9) {
                estacionActual = 87.9;
            }
        // Si no esta en FM suma de 10 en 10 hasta 1610
        } else {
            estacionActual += 10;
            if (estacionActual > 1610) {
                estacionActual = 530;
            }
        }
 
    }

    @Override
    public void guardarEstacion(int numeroBoton) {
        if (!encendido || numeroBoton < 1 || numeroBoton > 12) return;

        int index = numeroBoton - 1;
        // Verifica en que frecuencia se encuentra
        if (esFM) {
            botonesFM[index] = estacionActual;
        } else {
            botonesAM[index] = (int) estacionActual;
        }
    }

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

    @Override
    public void cambiarFM() {
        if (encendido) {
            esFM = true;
            estacionActual = 87.9;
        }
    }

    @Override
    public void cambiarAM() {
        if (encendido) {
            esFM = false;
            estacionActual = 530;
        }
    }

     public boolean isEncendido() {
        return encendido;
    }

    public boolean isFM() {
        return esFM;
    }

    public double getEstacionActual() {
        return estacionActual;
    }
   
    

}
