package av3questao1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class EnviaSensor {

	public static void main(String[] args) {

		double temperature = 25.5;

		String serverBaseUrl = "https://belmondojr.dev/comunicacao.php";

		StringBuilder urlWithParams = new StringBuilder(serverBaseUrl);
		urlWithParams.append("?sensors[]=").append(URLEncoder.encode("temperature", StandardCharsets.UTF_8));
		urlWithParams.append("&temperature=").append(temperature);

		try {

			URL url = new URL(urlWithParams.toString());
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();

			connection.setRequestMethod("GET");

			try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
				String line;
				StringBuilder response = new StringBuilder();
				while ((line = reader.readLine()) != null) {
					response.append(line);
				}
				System.out.println("Resposta do servidor: " + response.toString());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
