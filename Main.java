import java.util.Scanner;
import src.Radio;
import src.RadioCarro;
import src.RadioGrupoX;

/**
 * Clase principal que permite interactuar con la radio desde consola.
 * Muestra un menú de opciones para encender, cambiar frecuencia,
 * avanzar estaciones y guardar/cargar estaciones.
 */
public class Main {

    /**
     * Método principal del programa.
     *
     * @param args argumentos de línea de comandos (no utilizados)
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Se usa la interfaz para aplicar polimorfismo
        Radio radio = new RadioCarro();

        int opcion = 0;

        /**
         * Ciclo principal del menú
         */
        while (opcion != 6) {
            System.out.println("\n===== RADIO =====");
            System.out.println("1. Prender radio");
            System.out.println("2. Cambiar AM / FM");
            System.out.println("3. Avanzar estacion");
            System.out.println("4. Guardar estacion");
            System.out.println("5. Cargar estacion");
            System.out.println("6. Apagar radio");
            System.out.print("Seleccione una opcion: ");

            opcion = sc.nextInt();

            switch (opcion) {

                case 1:
                    radio.prenderRadio();
                    System.out.println("Radio encendido");
                    break;

                case 2:
                    /**
                     * Se hace cast para verificar si está en FM o AM
                     * y alternar correctamente la frecuencia
                     */
                    RadioCarro r = (RadioCarro) radio;

                    if (r.isFM()) {
                        radio.cambiarAM();
                        System.out.println("Cambiado a AM");
                    } else {
                        radio.cambiarFM();
                        System.out.println("Cambiado a FM");
                    }
                    break;

                case 3:
                    radio.avanzarEstacion();
                    System.out.println("Avanzando estacion");
                    break;

                case 4:
                    System.out.print("Ingrese numero de boton (1-12): ");
                    int botonGuardar = sc.nextInt();
                    radio.guardarEstacion(botonGuardar);
                    System.out.println("Estacion guardada");
                    break;

                case 5:
                    System.out.print("Ingrese numero de boton (1-12): ");
                    int botonCargar = sc.nextInt();
                    radio.cargarEstacion(botonCargar);
                    System.out.println("Estacion cargada");
                    break;

                case 6:
                    radio.apagarRadio();
                    System.out.println("Radio apagado");
                    break;

                default:
                    System.out.println("Opcion invalida");
            }
        }

        sc.close();
    }
}
