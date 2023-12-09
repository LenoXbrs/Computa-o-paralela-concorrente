package av3questao2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Ecommerce {

	public static void main(String[] args) {
		String serverUrl = "https://belmondojr.dev/compra.php?";

		try {
			// Dados simulados da compra
			String[] produtos = { "Item1", "Item2" };
			double[] quantidades = { 10.50, 20.75 };

			// Enviar dados para o servidor e obter a resposta
			String resposta = enviarCompra(serverUrl, produtos, quantidades);
			System.out.println("Resposta do servidor: " + resposta);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static String enviarCompra(String serverUrl, String[] produtos, double[] quantidades) throws Exception {
		// Construir a URL com os parâmetros da compra
		StringBuilder urlWithParams = new StringBuilder(serverUrl);
		for (int i = 0; i < produtos.length; i++) {
			urlWithParams.append("&products[]=").append(produtos[i]);
			urlWithParams.append("&values[]=").append(quantidades[i]);
		}

		// Criar URL e abrir a conexão
		URL url = new URL(urlWithParams.toString());
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();

		// Configurar método de requisição e cabeçalhos
		connection.setRequestMethod("GET");

		// Obter a resposta do servidor
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
			StringBuilder resposta = new StringBuilder();
			String linha;
			while ((linha = reader.readLine()) != null) {
				resposta.append(linha);
			}
			return resposta.toString();
		}
	}

}
