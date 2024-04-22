import java.util.Random;

public class HashTableN2 extends PerfectHashing {

    private final Random rand = new Random();
    private String[] table;
    private int[][] hash;
    private int size ;

    public HashTableN2(){
        size = 10;
        table = new String[size * size];
        this.setHash();
        size = 0;
    }

    private void setHash() {
        int rows = (int) Math.ceil(Math.log(size*size) / Math.log(2));
        int cols = 70;
        this.hash = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                this.hash[i][j] = (rand.nextInt(10)) % 2;
            }
        }
    }

    /**
     * @return 0 if successfully completed , 1 if rehashing happened and 2 if the element is existed
     */
    @Override
    public int insert(String key) {

        int[] x = super.convertToASCII(key);
        int[] binIndex = super.hashing(this.hash,x);

        int index = super.getIndex(binIndex);

        if(key.equals(this.table[index])){
            return 0;
        }

        if(this.table[index] != null){
            this.rehash();
            this.insert(key);
            return  1;
        }

        size++;
        this.table[index] = key;

        return 0;
    }


    @Override
    public void rehash() {
        String[] t = this.table;
        this.table = new String[size * size];
        this.setHash();
        this.size = 0;

        for (String s : t) {
            if (s != null)
                this.insert(s);
        }
    }

    /**
     * @return 0 if successfully completed and 1 new size is less than current size
     */
    @Override
    public int rehash(int newSize) {

        String[] t = this.table;

        if (newSize < (this.size*this.size)) return 1;

        this.size = newSize;
        this.table = new String[size * size];
        this.setHash();
        this.size = 0;

        for (String s : t) {
            if (s != null)
                this.insert(s);
        }
        return 0;
    }

    /**
     * @return 0 if successfully completed and 1 if key does not exist
     */
    @Override
    public int delete(String key) {
        int[] x = super.convertToASCII(key);
        int[] binIndex = super.hashing(this.hash,x);

        int index = super.getIndex(binIndex);

        if(key.equals(this.table[index])){
            this.table[index] = null;
            return 0;
        }

        return 1;
    }

    /**
     * @return 0 if exists and 1 if not
     */
    @Override
    public int Search(String key) {
        int[] x = super.convertToASCII(key);
        int[] binIndex = super.hashing(this.hash,x);

        int index = super.getIndex(binIndex);

        if(key.equals(this.table[index])){
            this.table[index] = null;
            return 0;
        }

        return 1;
    }

    /**
     * @return [no. newly added keys , no. already existing keys, no. rehashing]
     */
    @Override
    public int[] batchInsert(String filePath) {
        int[] output = {0,0,0};

        String[] keys = super.getKeys(filePath);

        this.size += keys.length;
        this.rehash();

        for (String key : keys) {
            int res = this.insert(key);
            if (res == 0) output[0]++;
            else if (res == 1) output[1]++;
            else {
                output[0]++;
                output[2]++;
            }
        }
        return output;
    }

    /**
     * @return [no. deleted keys,no. non-existing keys]
     */
    @Override
    public int[] batchDelete(String filePath) {
        int[] output = {0,0};

        String[] keys = super.getKeys(filePath);
        for (String key : keys) {
            int res = this.delete(key);
            if (res == 0) output[0]++;
            else if (res == 1) output[1]++;
        }

        return output;
    }
}
