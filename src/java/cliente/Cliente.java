package cliente;

import servidorcentral.ServicioCentralAbstract;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

public class Cliente {

    /**
     * args[0]=ipCentral, args[1]=portCentral, args[2]=(fecha,signo)
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        if (args.length != 3) {
            System.err.println("Uso: ipCentral puertoCentral (fecha,signo).");
            return;
        }
        URL url = new URL("http://" + args[0] + ":" + args[1] + "/ws/climahoroscopo?wsdl");
        QName qname = new QName("http://servidorcentral/", "ServicioCentralService");

        Service service = Service.create(url, qname);
        ServicioCentralAbstract servidorCentral = service.getPort(ServicioCentralAbstract.class);

        System.out.println(servidorCentral.askClimaHoroscopo(args[2]));
    }
}
