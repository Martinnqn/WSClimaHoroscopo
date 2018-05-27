package servidorhoroscopo;

import java.util.Random;
import javax.jws.WebService;

@WebService(endpointInterface = "servidorhoroscopo.ServicioHoroscopoAbstract")
public class ServicioHoroscopo implements ServicioHoroscopoAbstract {

    @Override
    public String askHoroscopo(String sign) {
        System.out.println("Cliente> Consulta: " + sign);

        String[] horoscopes = {
            "En este dia, le ganara la desconfianza. Tendra algunas dificultades para manifestar lo que siente y expresar sus pensamientos.",
            "No es un momento para buscar grandes emociones y aventuras. Mejor dediquese a disfrutar al maximo de los pequeños placeres diarios.",
            "No quiera abarcar mas de lo que puede. Solo reconociendo sus limitaciones superara los obstaculos que se le presenten.",
            "Reservese este dia para reunirse con amigos y compartir intereses en comun relacionados al estudio o la elaboracion de proyectos.",
            "Explote al maximo su perfeccionismo, ya que en este dia su energia personal estara puramente dirigida hacia los objetivos especificos.",
            "Sera una jornada propicia para sentarse a medir las consecuencias de sus propias acciones. Evite los exabruptos.",
            "Sepa que no siempre los obstaculos son situaciones negativas. Procure descubrir las opciones que se esconden detras de las dificultades.",
            "Debera ser mas claro a la hora de evaluar las decisiones trascendentales. Sus dudas y confusiones pueden dañar su inteligencia natural.",
            "Intente mantener una actitud optimista. Si logra desarrollar la confianza en lo que la vida le dee, todo saldra como usted lo soño.",
            "Gracias a que las energias se renovaron, tendra la posibilidad de vivir cada momento con la intensidad que desea hace tiempo.",
            "Guiese por las percepciones, ya que su agudeza psicologica estara de su lado. Superara los obstaculos que se le presenten.",
            "La Luna en posicion benefica, hara que aproveche la apertura a mundos desconocidos a los que podra ingresar sin temores."
        };

        long seed = sign.hashCode();
        Random random = new Random(seed);
        return horoscopes[random.nextInt(11)];
    }

}
