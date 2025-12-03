package services.utils;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.Client;

public class ParseJson {
	
	
	public static Map<String, Object> parseJsonMethod(String json) throws Exception{
		
		Map<String, Object> resultJson = new HashMap<>();
		json = json.trim();
		
		if(json.startsWith("{") && json.endsWith("}"))
		{
			if(json.contains("[") && json.contains("]")) {
				int colchetPosStart = json.indexOf("[");
				int colchetPosEnds = json.lastIndexOf("]");
				String subJson = json.substring(colchetPosStart, colchetPosEnds);
				Map<String, Object> subObj = parseJsonMethod(subJson);
			} else {
				String[] pairs = json.split(",");
				for(String pair : pairs) {
					if(pair.contains(" ")) {
						throw new Exception();
					} else {
						String[] keyValue = pair.split(":");
						String key = keyValue[0].trim().replace("\"", "");
						String value = keyValue[1].trim();
						
			            if (value.startsWith("\"") && value.endsWith("\"")) {
			            	resultJson.put(key, value.substring(1, value.length() - 1));
			            } else if (value.equals("true") || value.equals("false")) {
			            	resultJson.put(key, Boolean.parseBoolean(value));
			            } else if (value.equals("null")) {
			            	resultJson.put(key, null);
			            } else {
			                try {
			                    if (value.contains(".")) {
			                    	resultJson.put(key, Double.parseDouble(value));
			                    } else {
			                    	resultJson.put(key, Integer.parseInt(value));
			                    }
			                } catch (NumberFormatException e) {
			                	resultJson.put(key, value);
			                }
			            }
					}
				}
			}
		} else {
			throw new Exception();
		}
		
		return resultJson;
	}
	
	public static Client mapperClient(Map<String, Object> object){
		
		Field[] fields = Client.class.getDeclaredFields();
		boolean noPresent = false;
		
		for (Field field : fields) {
			String fieldName = field.getName();
			if(!object.containsKey(fieldName)) {
				noPresent = true;
			}
		}
		
		if(noPresent) {
			return null;
		}
		
		for (Field field : fields) {
			String fieldName = field.getName();
			
		}
		
		return null;
	}
	
	public static List<Client>  mapperClientList(Map<String, Object> object){
		
		
		
		return null;
	}	
	
	public static String clientJsonList = "{\"content\":[{\"clientId\":1,\"firstName\":\"John\",\"lastName\":\"Fruciantte\",\"address\":\"AlamedaStreet,458,Stpters\",\"telNumber\":\"05511332154875\",\"cellNumber\":\"0551195487454\",\"cpf\":\"4654635132465\",\"gender\":\"M\"},{\"clientId\":2,\"firstName\":\"Peter\",\"lastName\":\"Fredton\",\"address\":\"ParkAvenue,985,NewCity\",\"telNumber\":\"05511321549876\",\"cellNumber\":\"05511956447842\",\"cpf\":\"89432135435\",\"gender\":\"M\"},{\"clientId\":3,\"firstName\":\"Sara\",\"lastName\":\"Alburquerue\",\"address\":\"ParkAvenue,Yorkton\",\"telNumber\":\"05511321549876\",\"cellNumber\":\"05511956447842\",\"cpf\":\"89432135435\",\"gender\":\"F\"},],\"pageNumber\":0,\"pageSize\":60,\"totalElements\":3,\"totalPages\":1,\"lastPage\":true}";

	public static String clientJson = "\"clientId\":1,\"firstName\":\"John\",\"lastName\":\"Fruciantte\",\"address\":\"AlamedaStreet,458,Stpters\",\"telNumber\":\"05511332154875\",\"cellNumber\":\"0551195487454\",\"cpf\":\"4654635132465\",\"gender\":\"M\"}";
}
