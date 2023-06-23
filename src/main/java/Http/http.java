package Http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public record http() {

    public static void main(String[] args) {
        try {
            // Создаем объект URL для целевого адреса
            URL url = new URL("https://api.example.com/endpoint");

            // Открываем соединение HttpURLConnection
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Устанавливаем метод запроса (GET, POST и т.д.)
            connection.setRequestMethod("GET");

            // Устанавливаем заголовки запроса (необязательно)
            connection.setRequestProperty("Content-Type", "application/json");

            // Получаем ответный код от сервера
            int responseCode = connection.getResponseCode();

            // Чтение ответа от сервера
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            StringBuilder response = new StringBuilder();

            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            // Выводим ответ
            System.out.println("Response Code: " + responseCode);
            System.out.println("Response Body: " + response.toString());

            // Закрываем соединение
            connection.disconnect();
        } catch (IOException e) {
            e.printStackTrace();

            throw new RuntimeException(e);

        }
    }
}
