package servidorhoroscopo;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT)
public interface ServicioHoroscopoAbstract {

    @WebMethod
    String askHoroscopo(String s);

}
