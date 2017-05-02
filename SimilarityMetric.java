package UrlSimilarity;

public class SimilarityMetric {
    
    Hash[] hashTable;
    String[] results;
    HashNode[] tags;
    int[] highest;
    
    public SimilarityMetric(Hash[] hashTable){
        this.hashTable = hashTable;
        highest = new int[3];
        highest[0] = 0;
        highest[1] = 0;
        highest[2] = 0;
        results = new String[3];
        results[0] = ";";
        results[1] = ";";
        results[2] = ";";
    }
    
    public String[] logic(Hash userUrl){
        highest[0] = 0;
        highest[1] = 0;
        highest[2] = 0;
        results[0] = ";";
        results[1] = ";";
        results[2] = ";";
        int count = 0;
        tags = userUrl.getAll();
        for(int i=0;i<hashTable.length;i++){
            count = 0;
            for(int j=0;j<tags.length;j++){
                if(hashTable[i].contains(tags[j].key)){
                    count++;
                }
            }
            compare(hashTable[i].getUrl(),userUrl.getUrl(),count);
        }
        return results;
    }
    
    private void compare(String url,String targetUrl, int count){
        if(!url.equals(targetUrl)){
        if(count > highest[0]){
            highest[2] = highest[1];
            highest[1] = highest[0];
            highest[0] = count;
            results[2] = results[1];
            results[1] = results[0];
            results[0] = url;
        }else if(count> highest[1]){
            highest[2] = highest[1];
            highest[1] = count;
            results[2] = results[1];
            results[1] = url;
        }else if(count>highest[2]){
            highest[2] = count;
            results[2] = url; 
        }
        }
    }
    
    
}
