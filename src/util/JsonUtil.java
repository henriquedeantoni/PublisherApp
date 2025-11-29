package util;

import model.Client;

public class JsonUtil {

	public static String clientModelToJson(Client client) {
		return "{"
                + "\"firstName\":\"" + sanitizeValue(client.getFirstName()) + "\","
                + "\"lastName\":\"" + sanitizeValue(client.getLastName()) + "\","
                + "\"address\":\"" + sanitizeValue(client.getAddress()) + "\","
                + "\"telNumber\":\"" + sanitizeValue(client.getTelNumber()) + "\","
                + "\"cpf\":\"" + sanitizeValue(client.getCpf()) + "\","
                + "\"gender\":\"" + sanitizeValue(client.getGender()) + "\","
                + "}";
	}
	
	
	
	private static String sanitizeValue(String value) {
		if(value == null) return "";
		return value.replace("\"","\\\"");
	}
	
}
