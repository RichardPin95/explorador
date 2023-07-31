
import java.io.*;
import static java.lang.System.in;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        ArrayList<String> arr = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        String file = "archivo.txt";
        String opc = "";
        int totPuntos=0;
        System.out.println("INGRESE UNA LISTA DE FRASES O PALABRAS\nO ESCRIBA exit PARA FINALIZAR");
        do {
            System.out.print(">");
            opc = sc.nextLine();
            arr.add(opc);
        } while (!opc.equals("exit"));

        System.out.println(arr);
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(new FileInputStream(file), StandardCharsets.ISO_8859_1))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                totPuntos += buscarOcurrencias(arr, linea);
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    public static int buscarOcurrencias(ArrayList<String> listaPalabras, String frase) {
        for (String text : listaPalabras) {
            Pattern pattern = Pattern.compile(text + "-(\\d+)");
            Matcher matcher = pattern.matcher(frase);
            if (matcher.find()) {
                // Si se encuentra la ocurrencia, retornamos el número encontrado
                String numeroEnTexto = matcher.group(1);
                return Integer.parseInt(numeroEnTexto);
            }
        }
        return 0;
    }
}
