import java.io.IOException;

public class DictionaryImplementation {
    private final PerfectHashing dictionary ;

    public DictionaryImplementation(String typeD) {
        if (typeD.equals("O(n)")) {
            dictionary = new HashTableN();
        } else if (typeD.equals("O(n^2)")) {
            dictionary = new HashTableN2();
        } else {
            throw new IllegalArgumentException("Invalid dictionary type.");
        }
    }

    public synchronized void insert(String toInsert) {
        int res = dictionary.insert(toInsert);
        if(res == 0)
            System.out.println("(" + toInsert + ")" + "\u001B[32m Successfully INSERTED ✅\u001B[0m");
        else if(res == 1) {
            System.out.println("(" + toInsert + ")" + "\u001B[32m Successfully INSERTED ✅\u001B[0m");
            System.out.println("\u001B[33m Table Rehashed\u001B[0m");
        }
        else System.out.println("\u001B[33m Already Exist\u001B[0m ");
    }

    public synchronized void delete(String toDelete) {
        if (dictionary.delete(toDelete) == 0) {
            System.out.println("(" + toDelete + ")" + "\u001B[32m Successfully DELETED ✅\u001B[0m");
        } else {
            System.out.println("(" + toDelete + ")" + "\u001B[31m Not found ❌\u001B[0m");
        }
    }

    public boolean search(String toSearch) {
        if (dictionary.search(toSearch) == 0) {
            System.out.println("\u001B[32m Found in dictionary ✅\u001B[0m");
        } else {
            System.out.println("\u001B[31m Not found in dictionary ❌\u001B[0m");
        }
        return false;
    }

    public void batchInsert(String fileToInsert) {
        try {
            int[] result = dictionary.batchInsert(fileToInsert);
            int insertedCount = result[0];
            int failedCount = result[1];
            int rehashCount = result[2];
            System.out.println("Inserted successfully: " + insertedCount + " strings.");
            if (failedCount != 0) {
                System.out.println("Failed to insert: " + failedCount + " strings.");
            }
            if (rehashCount != 0) {
                System.out.println("table Rehashed: " + rehashCount + " time(s).");
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }

    public void batchDelete(String fileToDelete) {
        try {
            int[] result = dictionary.batchDelete(fileToDelete);
            int deletedCount = result[0];
            int failedCount = result[1];
            System.out.println("Deleted successfully: " + deletedCount + " strings.");
            if (failedCount != 0) {
                System.out.println("Failed to delete: " + failedCount + " strings.");
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}
