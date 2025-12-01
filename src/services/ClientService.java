package services;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import model.Client;
import util.JsonUtil;

public class ClientService {

	private static final String API_DEVELOP = "http://localhost:8080/api/clients";
	
	private final HttpClient httpClient =  HttpClient.newHttpClient();
	
	private String statusMessage;
	
	private String bodyResponse;
	
	private int statusCode;
	
	public boolean registerClientData(Client client) {
		try {
			
			String json = JsonUtil.clientModelToJson(client);
			
			HttpRequest request = HttpRequest.newBuilder()
					.uri(URI.create(API_DEVELOP))
					.header("Content-Type", "application/json")
					.POST(HttpRequest.BodyPublishers.ofString(json))
					.build();
			
			HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
			
			setStatusMessage(HttpUtils.msgStatusResponse(response.statusCode()));
			setBodyResponse(response.body());
			
			try {
				setStatusCode(response.statusCode());
			} catch(Exception statusException)
			{
				statusException.getStackTrace();
			}
			
			return response.statusCode() == 200 || response.statusCode() == 201;
			
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public String getStatusMessage() {
		return statusMessage;
	}

	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}

	public String getBodyResponse() {
		return bodyResponse;
	}

	public void setBodyResponse(String bodyResponse) {
		this.bodyResponse = bodyResponse;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

}
