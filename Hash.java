package UrlSimilarity;

public class Hash{
    
    HashNode[] array;
    HashIterator it;
    Boolean empty;
    String url;
    int size;
    int pointer;
    
    public Hash(String url, int defsize){
        array = new HashNode[defsize];
        size = defsize;
        empty =true;
        this.url = url;
    }
   
    public Hash(String url){
        size = 103;
        array = new HashNode[size];
        empty = true;
        this.url = url;
    }
    
    public void makeIterator(){
        it = new HashIterator(this);
    }
    
    public void put(String key){
        empty = false;
        pointer = hash(key)%size;
        if(array[pointer] == null){
            array[pointer] = new HashNode(key);
            it.grow();
        }else{
            if(array[pointer].put(key)){
                it.grow();
            }
        }
    }
    
    public HashNode get(String key){
        return array[hash(key)];  
    }
    
    public int hash(String key){
        return Math.abs(key.hashCode()%size);
    }
    
    public void resetIt(){
        it.restart();
    }
    
    public HashNode getNext(){
        if(it.hasNext()){
            return it.next();
        }
        return null;
    }
    
    
    public HashNode[] getAll(){
        HashNode[] tempArray = new HashNode[it.getSize()];
        if(!empty){
            it.restart();
            while(it.hasNext()){
                tempArray[it.position] = it.next();
            }
            it.restart();
        }
        return tempArray;
    }
    
    
    
    public Boolean isEmpty(){
        return empty;
    }
    
    public String getUrl(){
        return url;
    }
    
    public boolean contains(String target){
        HashNode[] totes = getAll();
        for(HashNode nod : totes){
            if(nod.key.equals(target)){
                return true;
            }
        }
        return false;
    }
    
    
    
    
    
}
