package taller9.pkg10;

public class Ejercicio3 {
}

abstract class Mensaje {

    public String remitente;
    public String destinatario;

    public Mensaje(String remitente, String destinatario) {
        this.remitente = remitente;
        this.destinatario = destinatario;
    }

    // Método abstracto para enviar el mensaje
    public abstract void enviarMensaje();

    // Método abstracto para visualizar el mensaje
    public abstract void visualizarMensaje();

    public static void main(String[] args) {
        // Crear móviles
        Movil movil1 = new Movil("123456789", "Juan");
        Movil movil2 = new Movil("987654321", "María");

        // Crear y enviar un SMS
        SMS sms = new SMS(movil1.getNombre(), movil2.getNombre(), "Hola, ¿cómo estás?");
        sms.enviarMensaje();

        // Crear y enviar un MMS
        MMS mms = new MMS(movil2.getNombre(), movil1.getNombre(), "vacaciones.jpg");
        mms.enviarMensaje();

        // Visualizar los mensajes
        System.out.println("\nVisualizando mensajes:");
        sms.visualizarMensaje();
        mms.visualizarMensaje();
    }
}

// Clase para representar un mensaje de texto (SMS)
class SMS extends Mensaje {

    private String texto;

    public SMS(String remitente, String destinatario, String texto) {
        super(remitente, destinatario);
        this.texto = texto;
    }

    @Override
    public void enviarMensaje() {
        System.out.println("Enviando SMS de " + remitente + " a " + destinatario);
        // Aquí iría la lógica real para enviar un SMS
        System.out.println("Mensaje: " + texto);
        System.out.println("SMS enviado correctamente.");
    }

    @Override
    public void visualizarMensaje() {
        System.out.println("Mensaje: " + texto);
    }
}

// Clase para representar un mensaje multimedia (MMS)
class MMS extends Mensaje {

    private String nombreImagen;

    public MMS(String remitente, String destinatario, String nombreImagen) {
        super(remitente, destinatario);
        this.nombreImagen = nombreImagen;
    }

    @Override
    public void enviarMensaje() {
        System.out.println("Enviando MMS de " + remitente + " a " + destinatario);
        // Aquí iría la lógica real para enviar un MMS
        System.out.println("Imagen: " + nombreImagen);
        System.out.println("MMS enviado correctamente.");
    }

    @Override
    public void visualizarMensaje() {
        System.out.println("Aqui de vacaciones");
        System.out.println("Imagen: " + nombreImagen);
        System.out.println("y tu?");
    }
}

// Clase para representar un móvil con un número y opcionalmente un nombre
class Movil {

    private String numero;
    private String nombre;

    public Movil(String numero, String nombre) {
        this.numero = numero;
        this.nombre = nombre;
    }

    public String getNumero() {
        return numero;
    }

    public String getNombre() {
        return nombre;
    }
}
