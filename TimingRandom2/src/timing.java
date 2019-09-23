import org.jsoup.Jsoup;
//import org.jsoup.helper.Validate;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URL;

	
public class timing {
	public static void main(String[] args) throws IOException {
		try {
			Document document = Jsoup.connect("http://35.192.236.37:8080/number.jsp").get();
			Elements elements = document.select("body");
			for(Element i: elements) {
				System.out.println(i.text());
			}
		}
		catch (Exception e){
			System.out.println("Failed to connect");
		}
	}
}
