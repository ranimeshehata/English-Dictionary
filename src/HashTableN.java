import java.util.Arrays;
import java.util.Random;

public class HashTableN extends  PerfectHashing{
    /**
     * bucket
    
     */
    private class bucket {
        Random rand = new Random();
        private int MAX_DEPTH= 10;
        String[] vals;
        int [][] hash;
        int size;
        int count;
        int mod;
    
        public bucket(){
            this.count = 0;
            this.vals = new String[2];
            this.size = 2;
            this.setHash();
            this.mod=1;
        }
        private void setHash() {
            int rows = (int) Math.ceil(Math.log(size*size) / Math.log(2));
            int cols = 70;
            this.hash = new int[rows][cols];
    
            for (int i = 0; i < cols; i++) {
                for (int j = 0; j < rows; j++) {
                    this.hash[j][i] = (rand.nextInt(1000) % 2 );
                }
            }
        }
    
    
        int insert(String key,int depth){
            if (depth > MAX_DEPTH) {
                return -1; // or throw an exception or handle overflow case
            }
            int []x=HashTableN.super.convertToASCII(key);
            int index=HashTableN.super.getIndex(HashTableN.super.hashing(this.hash,x))%this.mod;
            if(key.equals(this.vals[index])){
                return 2;
            }
            else if(this.vals[index]!=null){
                rehash();
                insert(key,depth+1);
                return 1;
            }
            else{
                this.vals[index]=key;
                count++;
                mod=count;
                return 0; 
            }
        }
        int delete(String key){
            int []x=HashTableN.super.convertToASCII(key);
            int index=HashTableN.super.getIndex(HashTableN.super.hashing(this.hash,x))%this.mod;
            if(key.equalsIgnoreCase(this.vals[index])){
                this.vals[index]=null;
                return 0;
            }
            else{
                return 1;
            }
        }
        int search(String key){
            int []x=HashTableN.super.convertToASCII(key);
            int index=HashTableN.super.getIndex(HashTableN.super.hashing(this.hash,x))%this.mod;
            if(key.equalsIgnoreCase(this.vals[index])){
                return 0;
            }
            else{
                return 1;
            }
        }
        int rehash(){
            String[]items=this.vals;
            this.vals=new String[count*count];
            this.count=0;
            this.setHash();
            for(String s:items){
                if(s!=null){
                    if(this.insert(s,0)==1){
                        return 1;
                    }
                }
            }
            return 0;
        }
        int rehash(int newSize){
            String[]items=this.vals;
            if(newSize<this.count*this.count){
                return -1;
            }
            this.size=newSize;
            this.vals=new String[this.count*this.count];
            this.count=0;
            this.setHash();
            for(String s:items){
                if(s!=null){
                    if(this.insert(s,0)==1){
                        return 1;
                    }
                }
            }
            return 0;
        }
    }
    
    private bucket[] table;
    private int capacity;
    private int count;
    private int[][] hash;
    Random rand = new Random();
    
    public HashTableN(){
        this.table=new bucket[1000];
        this.capacity=1000;
        this.count=0;
        for(int i=0;i<capacity;i++){
            this.table[i]=new bucket();
        }
        this.setHash();
    }    
    public HashTableN(int size){
        this.table=new bucket[size];
        this.capacity=size;
        this.count=0;
        for(int i=0;i<size;i++){
            this.table[i]=new bucket();
        }
        this.setHash();
    }    
    private void setHash() {
        int rows = (int) Math.ceil(Math.log(capacity*capacity) / Math.log(2));
        int cols = 70;
        this.hash = new int[rows][cols];
    
        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                this.hash[j][i] = (rand.nextInt(1000) % 2 );
            }
        }
    }


    /**
     *
     * @return
     */
    @Override
    public int rehash() {
        for(bucket b:table){
            if(b!=null){
                if(b.rehash()==1){
                    return 1;
                }
            }
        }
        return 0;
    }

    /**
     * @param newSize
     * @return 0 if successfully completed and 1 new size is less than current size
     */
    @Override
    public int rehash(int newSize) {
        if(newSize<this.capacity){
            return 1;
        }
        for(bucket b:table){
            if(b!=null){
                if(b.rehash(newSize)==1){
                    return 1;
                }
            }
        }
        return 0;
    }

    /**
     * @param key
     * @return 0 if successfully completed and 1 otherwise
     */
    @Override
    public int insert(String key) {
        int []x=super.convertToASCII(key);
        int index=super.getIndex(super.hashing(this.hash,x))%this.capacity;
        if(this.table[index]!=null){
            if(this.table[index].insert(key,0)==2){
                return 2;
            }
        }
        else{
            this.table[index]=new bucket();
            if(this.table[index].insert(key,0)==1){
                return 1;
            }
        }
        return 0;
    }

    /**
     * @param key
     * @return 0 if successfully completed and 1 if key does not exist
     */
    @Override
    public int delete(String key) {
        int []x=super.convertToASCII(key);
        int index=super.getIndex(super.hashing(this.hash,x))%this.capacity;
        if(this.table[index]!=null){
            if(this.table[index].delete(key)==1){
                return 1;
            }
        }
        else{
            return 1;
        }
        return 0;
    }

    /**
     * @param key
     * @return 0 if exists and 1 if not
     */
    @Override
    public int search(String key) {
        int index=super.getIndex(super.hashing(this.hash,super.convertToASCII(key)))%this.capacity;
        if(this.table[index]!=null){
            if(this.table[index].search(key)==0){
                return 0;
            }
            else{
                return 1;
            }
        }
        else{
            return 1;
        }
    }

    /**
     * @param filePath
     * @return [no. newly added keys , no. already existing keys, no. rehashing]
     */
    @Override
    public int[] batchInsert(String filePath) {
            String[] keys = super.getKeys(filePath);
            int[] output = {0,0,0};
            for(String s:keys){
                int x=this.insert(s);
                if(x==1){
                    this.rehash();
                    output[0]++;
                    output[2]++;
                }
                else if(x==0){
                    output[0]++;
                }
                else{
                    output[1]++;
                }
            }
        return output ;
    }

    /**
     * @param filePath
     * @return [no. deleted keys,no. non-existing keys]
     */
    @Override
    public int[] batchDelete(String filePath) {
        String[] keys = super.getKeys(filePath);
        int[] output = {0,0};
        for(String s:keys){
            int x=this.delete(s);
            if(x==0){
                output[0]++;
            }
            else{
                output[1]++;
            }
        }
        return output;
    }


       public static void main(String[] args){
       String[] str = {"aaa", "bbb", "aba", "case", "aaa", "baa"};
        PerfectHashing h1 = new HashTableN();
        PerfectHashing h2 = new HashTableN(str.length);
        
        System.out.println("Insertion:");
        for(String s: str){
            System.out.println(s);
            System.out.println(h1.insert(s));
            System.out.println(h2.insert(s));
        }
       str = new String[]{"aaa", "bbb", "case", "baa","966461"};

       System.out.println("Search:");
       for(String s: str){
           System.out.println(s);
           System.out.println(h1.search(s));
           System.out.println(h2.search(s));
       }

       System.out.println("Deletion:");
       for(String s: str){
           System.out.println(s);
           System.out.println(h1.delete(s));
           System.out.println(h2.delete(s));
       }

   }


}
