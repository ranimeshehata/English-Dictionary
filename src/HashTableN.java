public class HashTableN extends  PerfectHashing{
    /**
     * @return
     */
    @Override
    public int rehash() {

        return 0;
    }

    /**
     * @param newSize
     * @return 0 if successfully completed and 1 new size is less than current size
     */
    @Override
    public int rehash(int newSize) {
        return 0;
    }

    /**
     * @param key
     * @return 0 if successfully completed and 1 otherwise
     */
    @Override
    public int insert(String key) {
        return 0;
    }

    /**
     * @param key
     * @return 0 if successfully completed and 1 if key does not exist
     */
    @Override
    public int delete(String key) {
        return 0;
    }

    /**
     * @param key
     * @return 0 if exists and 1 if not
     */
    @Override
    public int search(String key) {
        return 0;
    }

    /**
     * @param filePath
     * @return [no. newly added keys , no. already existing keys]
     */
    @Override
    public int[] batchInsert(String filePath) {
        return new int[0];
    }

    /**
     * @param filePath
     * @return [no. deleted keys,no. non-existing keys]
     */
    @Override
    public int[] batchDelete(String filePath) {
        return new int[0];
    }
}
