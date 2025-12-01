package services;

public class HttpUtils {
	
	protected static String msgStatusResponse(int status) {
		String msg="";
		
		switch(status) {
			case 200:
			case 201:
				msg = "Sucesso: Dados enviados com sucesso.";
				break;
			case 400:
				msg = "Requisição inválida: Verifique os campos enviados ou contate o administrador do serviço.";
				break;
			case 401:
				msg = "Falha de autorização no envio. Contate o administrador do serviço.";
				break;
			case 403:
				msg = "Acesso proibido. Contate o administrador do serviço.";
				break;
			case 404:
				msg = "Endereço do endpoint não localizado. Contate o administrador do serviço.";
				break;
			case 500:
				msg = "Erro interno no servidor. Contate o administrador do serviço.";
				break;
			default:
				msg = "Erro desconhecido. Contate do técnico da aplicação. Telefone () \n" + "Status: " + status;
				break;
		}

		return msg;
	}
}
