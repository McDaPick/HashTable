package UrlSimilarity;

public class HashNode {
    
    String key;
    int frequency;
    HashNode next;
    
    public HashNode(String key){
        this.key = key;
        frequency = 1;
        next = null;
    }
    
     public boolean put(String key){
        if(key.equals(this.key)){
            this.increment();
            return false;
        }else if(next == null){
            next = new HashNode(key);
            return true;
        }else{
            return next.put(key);
        }
    }
    
    public void increment(){
        frequency++;
    }
    
    public HashNode get(String key){
        if(key.equals(this.key)){
            return this;
        }
        return next.get(key);
    }
       
    
    public Boolean hasNext(){
        return !(next == null);
    }
    
    public HashNode getNext(){
        return next;
    }
    
    @Override
    public String toString(){
        return key + "\t" + frequency;
    }
    
    
    
}
