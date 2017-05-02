package UrlSimilarity;

public class HashFactory {
    
    public HashFactory(){
        
    }
    
    public Hash getHash(String url){
        Hash hash = new Hash(url);
        hash.makeIterator();
        return hash;
    }
    
    public Hash getHash(String url,int i){
        Hash hash = new Hash(url,i);
        hash.makeIterator();
        return hash;
    }
    
    
    
}
