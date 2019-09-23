import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


class TimingThread extends Thread 
{ 

	public void start(String string) {
		try {
    		long beginning = System.nanoTime();
			Document document = Jsoup.connect(string).get();
			Elements elements = document.select("body");
			/*for(Element i: elements) {
				System.out.println(i.text());
			}*/
			long ending = System.nanoTime();
			double total =(double)(ending - beginning)/1000000000;
			System.out.println(string +" took "+total+ " seconds to run.");
		}
		catch (Exception e){
			System.out.println(string+ " Failed to connect");
		}
	}
} 
  
// Main Class 
public class Threading 
{ 
	public static String[] sites = { 
	"http://35.192.236.37:8080/number.jsp",
	"http://35.222.240.90/",
	"next"};
    public static void main(String[] args) 
    { 
        int n = 8; // Number of threads 
        for (int i=0; i<sites.length; i++) 
        { 
            TimingThread object = new TimingThread(); 
            object.start(sites[i]); 
        } 
    } 
}
