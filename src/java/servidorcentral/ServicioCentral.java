package servidorcentral;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import javax.jws.WebService;
import servidorclima.ServicioClimaAbstract;
import servidorhoroscopo.ServicioHoroscopoAbstract;

/**
 *
 * @author Martin
 */
@WebService(endpointInterface = "servidorcentral.ServicioCentralAbstract")
public class ServicioCentral implements ServicioCentralAbstract {

    private String ipClima;
    private String portClima;
    private String ipHorosc;
    private String portHorosc;

    private HashMap<String, String> cacheWeather;
    private HashMap<String, String> cacheHoroscope;

    public ServicioCentral() {
    }

    public ServicioCentral(String ipClima, String portClima, String ipHorosc, String portHorosc,
            HashMap<String, String> cacheHorosc, HashMap<String, String> cacheClima) {
        this.ipClima = ipClima;
        this.portClima = portClima;
        this.ipHorosc = ipHorosc;
        this.portHorosc = portHorosc;
        this.cacheHoroscope = cacheHorosc;
        this.cacheWeather = cacheClima;
    }

    @Override
    public String askClimaHoroscopo(String query) {
        /*String answer;

         System.out.println("Cliente> Consulta: " + query);

         //extraer fecha y horoscopo de query
         try {
         String date = query.split(",")[0].substring(1);
         String hAux = query.split(",")[1];
         String sign = hAux.substring(0, hAux.length() - 1);
         String answerW = askClima(date);
         String answerH = askHoroscopo(sign);
         answer = "Horóscopo: " + answerH + "\nClima: " + answerW;
         } catch (Exception e) {
         answer = "Formato de consulta invalido, pruebe: (fecha,signo).";
         }

         return answer;*/
        return "OlaKeAseh "+query;
    }

    private String askHoroscopo(String sign) {
        String answerH;
        boolean isValidSign = isValidSign(sign);

        if (isValidSign) {
            //busca la consulta en la cache.
            answerH = cacheHoroscope.get(sign);
            //si no tiene dato entonces se lo pregunta al servidor
            if (answerH == null) {
                System.out.println("Servidor> Consultando a servidor de horoscopo...");
                //consultar el horoscopo
                ServicioHoroscopoAbstract srv;
                try {
                    //srv = (ServiciosHoroscopoAbstract) Naming.lookup("//" + ipHorosc + ":" + portHorosc + "/ServiciosHoroscopo");
                    //answerH = srv.askHoroscopo(sign);
                    cacheHoroscope.put(sign, answerH);
                } catch (Exception ex) {
                    answerH = "El servidor de horoscopo no esta disponible, consulte mas tarde.";
                    System.out.println("Servidor> Servidor de horoscopo no responde.");
                }
            } else {
                System.out.println("Servidor> Cache hit.");
            }
        } else {
            answerH = "Signo no válido";
        }

        return answerH;
    }

    private String askClima(String date) {
        String answerW;
        boolean isValidDate = isValidDate(date);

        //consultar el clima
        //chequea si es un dato valido para consultar el clima o el horoscopo
        if (isValidDate) {
            //busca la consulta en la cache.
            answerW = cacheWeather.get(date);
            //si no tiene dato entonces se lo pregunta al servidor
            if (answerW == null) {
                System.out.println("Servidor> Consultando a servidor de clima...");
                ServicioClimaAbstract srv;
                try {
                    //srv = (ServiciosClimaAbstract) Naming.lookup("//" + ipClima + ":" + portClima + "/ServiciosClima");
                    //answerW = srv.askClima(date);
                    cacheWeather.put(date, answerW);
                } catch (Exception ex) {
                    answerW = "El servidor de clima no esta disponible, consulte mas tarde.";
                    System.out.println("Servidor> Servidor de clima no responde.");
                }
            } else {
                System.out.println("Servidor> Cache hit.");
            }
        } else {
            answerW = "Fecha no válida";
        }

        return answerW;
    }

    private boolean isValidDate(String text) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setLenient(false);
        try {
            dateFormat.parse(text.trim());
        } catch (ParseException pe) {
            return false;
        }
        return true;
    }

    private boolean isValidSign(String text) {
        String[] signs = {"aries", "tauro", "geminis", "cancer", "leo", "virgo",
            "libra", "escorpio", "sagitario", "capricornio", "acuario", "piscis"};
        for (int i = 0; i < signs.length; i++) {
            if (text.equals(signs[i])) {
                return true;
            }
        }
        return false;
    }

}
