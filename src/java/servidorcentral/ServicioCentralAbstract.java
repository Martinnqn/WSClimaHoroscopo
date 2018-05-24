package servidorcentral;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.WebMethod;
import javax.jws.soap.SOAPBinding.Style;

/**
 *
 * @author Martin
 */
@WebService
@SOAPBinding(style = Style.DOCUMENT)
public interface ServicioCentralAbstract {

    @WebMethod
    String askClimaHoroscopo(String s);

}
