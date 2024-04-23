import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class PerfectHashing {


    public String[] getKeys(String filepath){
        List<String> arr = new ArrayList<>();
        try {
            filepath = filepath.replaceAll("'", "").replaceAll("\"", "");
            Scanner scan = new Scanner(new File(filepath));
            while (scan.hasNextLine())
                arr.add(scan.nextLine().replaceAll("\n", ""));

            // System.out.println(this.mainList + "\n");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return arr.toArray(new String[0]);
    }

    protected  int[] convertToASCII(String str){
        int[] bin= new int[70];
        byte[] ascii;

        // Converting string to byte array
        ascii = str.getBytes(StandardCharsets.US_ASCII);

        int f = 0;
        for (byte b : ascii) {
            int[] binWord = this.toBinary(b);
            for (int j = 0; j < 7; j++, f++) {
                bin[f] = binWord[j];
            }
        }

        return bin;
    }

    protected int[] toBinary(byte b) {
        int[] output = new int[7];
        for (int i = 6; i > -1; i--) {
            output[i] = b % 2;
            b /=2;
        }
        return output;
    }

    protected int getIndex(int[] bin){
        int index = 0;
        for (int i = 0; i <bin.length; i++) {
         index += (int) (bin[i] * (Math.pow(2,i)));
        }
        return index;
    }

    protected int[] hashing(int[][] h, int[] x){
        int[] hx = new int[h.length];

        for(int r = 0; r < h.length; r++){
            hx[r] = 0;
            for(int i = 0; i < x.length; i++)
                    hx[r] ^= h[r][i] * x[i];
        }
        return  hx;
    }

    // abstract methods

    /**
     * @return 0 if successfully completed and 1 if a rehashing in side the rehashing and have to call function again
     * */

    abstract public int rehash();

    /**
     * @return 0 if successfully completed ,-1  if new size is less than current size
     * and 1 if a rehashing in side the rehashing and have to call function again
     * */
    abstract public int rehash(int newSize);
    /**
    * @return 0 if successfully completed and 1 otherwise
    * */
    abstract public  int insert (String key);

    /**
     * @return 0 if successfully completed and 1 if key does not exist
     * */
    abstract public int delete (String key);

    /**
     * @return 0 if exists and 1 if not
     * */
    abstract public int search (String key);

    /**
     * @return [no. newly added keys , no. already existing keys, no. rehashing]
     * */
    abstract public int[] batchInsert (String filePath);

    /**
     * @return [no. deleted keys,no. non-existing keys]
     * */
    abstract public int[] batchDelete (String filePath);
}
