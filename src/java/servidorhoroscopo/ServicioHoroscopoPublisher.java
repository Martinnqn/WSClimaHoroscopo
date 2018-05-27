package servidorhoroscopo;

import javax.xml.ws.Endpoint;

public class ServicioHoroscopoPublisher {

    /**
     * args[0]=ipHoroscopo, args[1]=portHoroscopo
     *
     * @param args
     */
    public static void main(String[] args) {
        if (args.length != 2) {
            System.err.println("Uso: ipHoroscopo puertoHoroscopo");
            return;
        }
        ServicioHoroscopo sv = new ServicioHoroscopo();
        Endpoint.publish("http://" + args[0] + ":" + args[1] + "/ws/horoscopo", sv);
        System.out.println("Servidor Horoscopo> Online.");
        System.out.println("Servidor Horoscopo> Esperando consultas...");
    }

}
