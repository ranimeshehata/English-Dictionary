public abstract class PerfectHashing {


    public String[] getKeys(String filepath){
        return null;
    }

    protected int[] hashing(int[][] h, int[] x){
        int[] hx = new int[x.length];

        for(int r = 0; r < h.length; r++){
            hx[r] = 0;
            for(int i = 0; i < x.length; i++)
                    hx[r]+= h[r][i] * x[i];
        }
        return  hx;
    }

    // abstract methods

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
    abstract public int Search (String key);

    /**
     * @return [no. newly added keys , no. already existing keys]
     * */
    abstract public int[] batchInsert (String filePath);

    /**
     * @param filePath
     * @return [no. deleted keys,no. non-existing keys]
     * */
    abstract public int[] batchDelete (String filePath);
}
