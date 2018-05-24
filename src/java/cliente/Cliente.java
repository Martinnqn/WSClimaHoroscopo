package cliente;

import servidorcentral.ServicioCentralAbstract;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

public class Cliente {

    public static void main(String[] args) throws Exception {
        URL url = new URL("http://localhost:7777/ws/climahoroscopo?wsdl");

        //1st argument service URI, refer to wsdl document above
        //2nd argument is service name, refer to wsdl document above
        QName qname = new QName("http://servidorcentral/", "ServicioCentralService");

        Service service = Service.create(url, qname);
        ServicioCentralAbstract servidorCentral = service.getPort(ServicioCentralAbstract.class);

        System.out.println(servidorCentral.askClimaHoroscopo("Tibu"));
        System.out.println(servidorCentral.askClimaHoroscopo("Gonza"));
        System.out.println(servidorCentral.askClimaHoroscopo("asd"));

    }
}
