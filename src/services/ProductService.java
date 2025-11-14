package services;

import java.util.List;

import model.Product;

public class ProductService {
	
	private final ApiClient apiClient = new ApiClient();
	
	public List<Product> getAllProducts() throws Exception {
		String responseJson = apiClient.get("/products");
		return JsonUtil.fromJsonList(responseJson, Product.class);
	}
	
	public Product registerProduct(Product product) throws Exception{
		String jsonBody = JsonUtil.toJson(product);
		String response = apiClient.post("/products", jsonBody);
		return JsonUtil.fromJson(response, Product.class);
	}
}
