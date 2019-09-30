import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


class TimingThread extends Thread 
{ 

	public void start(String info,String string) {
		try {
    		long beginning = System.nanoTime();
			Document document = Jsoup.connect(string).get();
			Elements elements = document.select("body");
			
			long ending = System.nanoTime();
			double total =(double)(ending - beginning)/1000000000;
			for(Element i: elements) {
				System.out.println(info +string +" "+total+ "s "+ i.text());
			}
			
		}
		catch (Exception e){
			System.out.println(string+ " Failed to connect");
		}
	}
} 
  
// Main Class 
public class Threading 
{ 
	/* OLD IP ADDRESS FOR US CENTRAL REGION
	public static String[] sites = { 
	"http://35.192.236.37:8080/number.jsp",
	"http://35.222.240.90/",
	"http://rng-python.appspot.com"};
	*/
	public static String[] sites = { 
			"http://34.97.25.195",
			"http://34.97.51.216:8080/number.jsp",
			"http://rng-python-asiane2.appspot.com",
			"https://number-254315.appspot.com/hello"};
	public static String[] info = {
			"asia-northeast_2a_VM_Python@",
			"asia-northeast2_a_VM_Java@",
			"asia-northeast2_a_app_Python@",
			"asia-northeast2_a_App_Java@"
	};
	
	
    public static void main(String[] args) 
    { 
        
        for (int i=0; i<sites.length; i++) 
        { 
            TimingThread object = new TimingThread(); 
            object.start(info[i], sites[i]); 
        } 
    } 
}
