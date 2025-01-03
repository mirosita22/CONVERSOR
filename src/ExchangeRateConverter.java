import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import com.google.gson.Gson;

// Clase principal
public class ExchangeRateConverter {

    // Clase interna para mapear el JSON de respuesta
    static class ExchangeRateResponse {
        String base_code;
        String time_last_update_utc;
        Rates conversion_rates;
    }

    // Clase interna para mapear las tasas de cambio
    static class Rates {
        double USD;
        double EUR;
        double MXN;
        // Agrega más monedas si es necesario
    }

    public static void main(String[] args) {
        // URL de la API
        String apiKey = "f8e5cbb67ef5772b401a6609"; // Reemplaza con tu API Key
        String baseCurrency = "USD"; // Moneda base
        String apiUrl = "https://v6.exchangerate-api.com/v6/" + apiKey + "/latest/" + baseCurrency;

        try {
            // Configurar la conexión HTTP
            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            // Verificar el código de respuesta
            int responseCode = connection.getResponseCode();
            if (responseCode == 200) { // Código 200 significa éxito
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder response = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                reader.close();

                // Parsear el JSON
                Gson gson = new Gson();
                ExchangeRateResponse data = gson.fromJson(response.toString(), ExchangeRateResponse.class);

                // Mostrar resultados
                System.out.println("Base currency: " + data.base_code);
                System.out.println("Last update: " + data.time_last_update_utc);
                System.out.println("Rates:");
                System.out.println("USD: " + data.conversion_rates.USD);
                System.out.println("EUR: " + data.conversion_rates.EUR);
                System.out.println("MXN: " + data.conversion_rates.MXN);
            } else {
                System.out.println("Error: " + responseCode);
            }

        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}
