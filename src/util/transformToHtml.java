package util;

public class transformToHtml {

	public static String textToParagraph(String text) {
		return "<p>" + text + "</p>";
	}
	
	public static String textToTitleH(String title, Integer height) {
		return "<h" + height.toString() + ">" + title + "<h" + height + ">";
	}
	
	public String textToLink(String refUrl, String text) {
		return "<a href=" + "\"" + refUrl + "\"" + ">" + text + "</a>";
	}
	
	public String textToLinkBlank(String refUrl, String text) {
		return "<a href=" + "\"" + refUrl + "\"" + "target=\"_blank\"" + ">" + text + "</a>";
	}
	
	public String linkToButton(String refUrl, String text) {
		return "<a href=\" "+ refUrl + "\"" + "class=\"btn\">" + text + "</a>\r\n"
		+ "\r\n"
		+ "<!-- CSS -->\r\n"
		+ "<style>\r\n"
		+ "  .btn {\r\n"
		+ "    display: inline-block;\r\n"
		+ "    padding: 10px 16px;\r\n"
		+ "    border-radius: 6px;\r\n"
		+ "    text-decoration: none;\r\n"
		+ "    font-weight: 600;\r\n"
		+ "    border: 1px solid #333;\r\n"
		+ "  }\r\n"
		+ "  .btn:hover { opacity: 0.9; }\r\n"
		+ "</style>";
	}
	
	public String image(String imageSource, String altText) {
		return "<img src=\"" + imageSource + "\"" + " alt=" + "\"" + altText + "\"" + ">";
	}
	
	public String image(String imageSource, String altText, Integer height, Integer width) {
		return "<img src=\"" + imageSource + "\"" + " alt=" + "\"" + altText + "\""  + " height=\"" + height + "\""  + "width=\"" + width + "\"" + ">";
	}
}
