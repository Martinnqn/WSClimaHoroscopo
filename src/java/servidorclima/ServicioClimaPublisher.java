package servidorclima;

import javax.xml.ws.Endpoint;

public class ServicioClimaPublisher {

    /**
     * args[0]=ipClima, args[1]=portClima
     *
     * @param args
     */
    public static void main(String[] args) {
        if (args.length != 2) {
            System.err.println("Uso: ipClima puertoClima");
            return;
        }
        ServicioClima sv = new ServicioClima();
        Endpoint.publish("http://" + args[0] + ":" + args[1] + "/ws/clima", sv);
        System.out.println("Servidor Clima> Online.");
        System.out.println("Servidor Clima> Esperando consultas...");
    }

}
