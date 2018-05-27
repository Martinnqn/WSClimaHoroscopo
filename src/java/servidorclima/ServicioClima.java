package servidorclima;

import java.util.Random;
import javax.jws.WebService;

@WebService(endpointInterface = "servidorclima.ServicioClimaAbstract")
public class ServicioClima implements ServicioClimaAbstract {

    @Override
    public String askClima(String date) {
        System.out.println("Cliente> Consulta: " + date);

        String[] weathers = {"Soleado", "Lluvioso", "Ventoso", "Nublado"};
        String[] dmy = date.split("/");
        int seed = Integer.parseInt(dmy[0])
                + Integer.parseInt(dmy[1])
                + Integer.parseInt(dmy[2]) / 1000;
        Random random = new Random(seed);
        return weathers[random.nextInt(3)];
    }

}
