package dev.IESFranciscodelosRios.Utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {
    /**
     * Si en args se ha establecido algun parametro . Este metodo buscara dentro del array de args hasta encontrar una
     * posicion en el array que contenga una ruta al directorio Rooms
     * <br><br>
     * <h3>Objetivo:</h1><p>El objetivo principal es almacenar una referencia a la hubicacion de las ROOMS para de este modo</p>
     * permitir a los DAOS buscar a traves del directorio todos los XML
     *
     * @param args Argumento del metodo main del objeto App.
     * @return
     */
    public static String IpAddress(String[] args) {

        if (args.length > 0 && !args[0].isEmpty()) {
            String patron = "^(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$";

            String result = null;
            Pattern pattern = Pattern.compile(patron);
            Matcher matcher = null;

            for (int i = 0; i < args.length && result==null; i++) {
                matcher = pattern.matcher(args[i]); //se realizara la comparacion en base al patron establecido
                result = (matcher.matches() ? args[i] : null); //Si matcher es true.(?) se devolvera ip. (:) si no se devolvera null

            }
        }

        return null;
    }

    /**
     * Este metodo comprobara si el String pasado por parametro es el nombre de un fichero XML
     * @return un booleano segun sea un fichero xml o no
     */

    public static boolean isXMLFile(String filePath){
        if(!filePath.isEmpty()){
            String patron = "^*.XML";

            Pattern pattern = Pattern.compile(patron);
            return pattern.matcher(filePath).matches();
        }
        return false;
    }
}
