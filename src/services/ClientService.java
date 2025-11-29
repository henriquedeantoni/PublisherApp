package services;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import model.Client;
import util.JsonUtil;

public class ClientService {

	private static final String API_DEVELOP = "http://localhost:8080";
	
	private final HttpClient httpClient =  HttpClient.newHttpClient();
	
	public boolean sendClientData(Client client) {
		try {
			String json = JsonUtil.clientModelToJson(client);
			
			HttpRequest request = HttpRequest.newBuilder()
					.uri(URI.create(API_DEVELOP))
					.header("Content-Type", "application/json")
					.POST(HttpRequest.BodyPublishers.ofString(json))
					.build();
			
			HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
			
			return response.statusCode() == 200 || response.statusCode() == 201;
			
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
