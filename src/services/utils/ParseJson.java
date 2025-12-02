package services.utils;

import java.util.HashMap;
import java.util.Map;

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

}
