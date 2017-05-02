package UrlSimilarity;

import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;

public class urlParse {

    public static void main(String[] args) throws IOException {
        int urlsToRun = 10;

        PreLoader pre = new PreLoader();
        pre.setVisible(true);
        
        
        try{
        tagBank compTags = new tagBank();
        String[] urls = compTags.getURLs();
        String[] tags = compTags.getTags();
        HashFactory hashfactory = new HashFactory();
        Hash[] hashMaster = new Hash[urlsToRun];
        Element[] elms = new Element[750];
        
        
        for(int i=0; i< urlsToRun;i++){
            elms[i] = Jsoup.connect(urls[i]).get().select("body").first();
        }
        
        String parsedDoc;
        
        for(int i = 0; i< urlsToRun; i++){
            parsedDoc = Jsoup.parse(elms[i].toString()).text();
            hashMaster[i] = hashfactory.getHash(elms[i].baseUri());
            
            for (String tag : tags) {
                if (parsedDoc.contains(" " + tag + " ")) {
                    hashMaster[i].put(tag);
                        }
                    }
                }
               
        Gui gui = new Gui(hashMaster,tags,pre);
        gui.setVisible(true);
        
        
        }catch(Exception e){
            pre.error();
        }
    }
       
}
