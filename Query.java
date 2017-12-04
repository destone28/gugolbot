package gugolbot;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;


public class Query {

    //We need a real browser user agent or Google will block our request with a 403 - Forbidden
    public static final String USER_AGENT = "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/45.0.2454.101 Safari/537.36";
    public static String ricerca;
    public static String main(String ricerca) throws Exception {
    	String risultato ="";

    	if (ricerca.equals("/start"))
    		risultato = ("Welcome! Use Google Search without browser...you'll see, it will be faster ;-)");
    	else if (ricerca.equals("/stop"))
    		risultato = ("Ok, block me or just don't ask me anything, I'll stay quiet! :-)");
    	else {
        //Fetch the page
        final Document doc = Jsoup.connect("https://google.it/search?q=+"+ricerca).userAgent(USER_AGENT).get();

        //Traverse the results
        for (Element result : doc.select("h3.r a")){

            final String title = result.text();
            final String url = result.attr("href");

            //Now do something with the results (maybe something more useful than just printing to console)

            risultato += (title + " -> " + url+"\n\n");
        	 }
        }
        return risultato;
    }
}
