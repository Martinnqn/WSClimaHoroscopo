package servidorclima;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT)
public interface ServicioClimaAbstract {

    @WebMethod
    String askClima(String s);

}
