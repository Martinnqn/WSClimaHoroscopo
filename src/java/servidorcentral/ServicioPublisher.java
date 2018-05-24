package servidorcentral;

import java.util.HashMap;
import javax.xml.ws.Endpoint;

/**
 *
 * @author Martin
 */
public class ServicioPublisher {

    /**
     * args[0]=ipServicioCentral, args[1]=portServicioCentral , args[2]=ipClima,
     * args[3]=portClima ,args[4]=ipHorosc ,args[5]=portHorosc ,
     *
     * @param args
     */
    public static void main(String[] args) {
        //caches
        HashMap<String, String> cacheWeather;
        HashMap<String, String> cacheHoroscope;
        //inicializar las caches
        cacheWeather = new HashMap<>();
        cacheHoroscope = new HashMap<>();

        //ServicioCentral sv = new ServicioCentral(args[2], args[3], args[4], args[5],
        //        cacheHoroscope, cacheWeather);
        //Endpoint.publish("http://" + args[0] + ":" + args[1] + "/ws/climahoroscopo", sv);
        ServicioCentral sv = new ServicioCentral("localhost", "7778", "locahost", "7779",
                cacheHoroscope, cacheWeather);
        Endpoint.publish("http://localhost:7777/ws/climahoroscopo", sv);
    }
}
