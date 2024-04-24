import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Random;

/**
 * InnerHashTableN
 */
// public class s1 {
// int[] values;
// int size;
// int count;

// public s1 (){
    
// }
    
// }

public class HashTableN extends  PerfectHashing{
    
    private HashTableN2[] table;
    private int capacity;
    private int count;
    private int[][] hash;
    Random rand = new Random();

    public HashTableN(){
      this(10);
        this.setHash();
    }
    public HashTableN(int size){
        this.table=new HashTableN2[size];
        this.capacity=size;
        this.count=0;
        for(int i=0;i<size;i++){
            this.table[i]=new HashTableN2(2);
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
        for(HashTableN2 b:table){
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
        for(HashTableN2 b:table){
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
        table[index].hn=true;
        if(this.table[index]!=null){
            if(this.table[index].insert(key)==2){
                return 2;
            }
        }
        else{
            count++;
            if(this.table[index].insert(key)==1){
                return 1;
            }
        }
        count++;
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
    public int[] batchInsert(String filePath) throws FileNotFoundException {
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
    public int[] batchDelete(String filePath) throws FileNotFoundException {
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