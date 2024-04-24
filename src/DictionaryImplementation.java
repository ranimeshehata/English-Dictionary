import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class DictionaryImplementation {
    private PerfectHashing dictionary ;

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
        dictionary.insert(toInsert);
        System.out.println("(" + toInsert + ")" + "\u001B[32m Successfully inserted ✅\u001B[0m");
    }

    public synchronized void delete(String toDelete) {
        if (dictionary.delete(toDelete) != 0) {
            System.out.println("(" + toDelete + ")" + "\u001B[32m Successfully DELETED ✅\u001B[0m");
        } else {
            System.out.println("(" + toDelete + ")" + "\u001B[31m Not found ❌\u001B[0m");
        }
    }

    public void search(String toSearch) {
        if (dictionary.search(toSearch) == 0) {
            System.out.println("\u001B[32m Found in dictionary ✅\u001B[0m");
        } else {
            System.out.println("\u001B[31m Not found in dictionary ❌\u001B[0m");
        }
    }

    public void batchInsert(String fileToInsert) {
        try{
            dictionary.batchInsert(fileToInsert);
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }

    public void batchDelete(String fileToDelete) {
        try {
            dictionary.batchDelete(fileToDelete);
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }

}
