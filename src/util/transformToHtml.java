package util;

public class transformToHtml {

	public static String textToParagraph(String text) {
		return "<p>" + text + "</p>";
	}
	
	public static String textToTitleH(String title, Integer height) {
		return "<h" + height.toString() + ">" + title + "<h" + height.toString() + ">";
	}
	
	public String textToLink(String refUrl, String text) {
		return "<a href=" + "\"" + refUrl + "\"" + ">" + text + "</a>";
	}
}
