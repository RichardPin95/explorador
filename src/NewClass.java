import java.util.ArrayList;

public class NewClass {

    public static int buscarNumeroEnLista(ArrayList<String> lista, String palabraBuscada) {
        for (String texto : lista) {
            if (texto.startsWith(palabraBuscada + "-")) {
                // Extraer el número que está después del guion ("-")
                String numeroEnTexto = texto.substring(palabraBuscada.length() + 1);
                try {
                    return Integer.parseInt(numeroEnTexto);
                } catch (NumberFormatException e) {
                    // En caso de que el número no sea válido, retornamos -1
                    return -1;
                }
            }
        }

        // Si no se encuentra la ocurrencia, retornamos -1
        return -1;
    }

    public static void main(String[] args) {
        ArrayList<String> lista = new ArrayList<>();
        lista.add("Paypal-2");
        lista.add("Google-5");
        lista.add("Facebook-10");

        String palabraBuscada = "Google";
        int numeroEncontrado = buscarNumeroEnLista(lista, palabraBuscada);

        if (numeroEncontrado != -1) {
            System.out.println("El número encontrado para " + palabraBuscada + " es: " + numeroEncontrado);
        } else {
            System.out.println("La palabra " + palabraBuscada + " no fue encontrada en la lista.");
        }
    }
}
