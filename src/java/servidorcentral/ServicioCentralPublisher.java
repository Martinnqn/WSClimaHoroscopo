package servidorcentral;

import java.util.HashMap;
import javax.xml.ws.Endpoint;

public class ServicioCentralPublisher {

    /**
     * args[0]=ipCentral, args[1]=portCentral, args[2]=ipClima,
     * args[3]=portClima, args[4]=ipHoroscopo ,args[5]=portHoroscopo ,
     *
     * @param args
     */
    public static void main(String[] args) {
        if (args.length != 6) {
            System.err.println("Uso: ipCentral puertoCentral ipClima puertoClima "
                    + "ipHoroscopo puertoHoroscopo");
            return;
        }
        //caches
        HashMap<String, String> cacheWeather = new HashMap<>();
        HashMap<String, String> cacheHoroscope = new HashMap<>();

        ServicioCentral sv = new ServicioCentral(args[2], args[3], args[4], args[5],
                cacheHoroscope, cacheWeather);
        Endpoint.publish("http://" + args[0] + ":" + args[1] + "/ws/climahoroscopo", sv);
        System.out.println("Servidor> Online.");
        System.out.println("Servidor> Esperando consultas...");
    }

}
