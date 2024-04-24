import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class DictionaryImplementation {
    private Map<String, Integer> dictionary;

    public DictionaryImplementation(String typeD) {
        if (typeD.equals("O(n)")) {
            dictionary = new HashMap<>();
        } else if (typeD.equals("O(n^2)")) {
            dictionary = new HashMap<>();
        } else {
            throw new IllegalArgumentException("Invalid dictionary type.");
        }
    }

    public synchronized void insert(String toInsert) {
        dictionary.put(toInsert, 1);
        System.out.println("(" + toInsert + ")" + "\u001B[32m Successfully inserted ✅\u001B[0m");
    }

    public synchronized void delete(String toDelete) {
        if (dictionary.remove(toDelete) != null) {
            System.out.println("(" + toDelete + ")" + "\u001B[32m Successfully DELETED ✅\u001B[0m");
        } else {
            System.out.println("(" + toDelete + ")" + "\u001B[31m Not found ❌\u001B[0m");
        }
    }

    public void search(String toSearch) {
        if (dictionary.containsKey(toSearch)) {
            System.out.println("\u001B[32m Found in dictionary ✅\u001B[0m");
        } else {
            System.out.println("\u001B[31m Not found in dictionary ❌\u001B[0m");
        }
    }

    public void batchInsert(String fileToInsert) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileToInsert))) {
            String line;
            while ((line = br.readLine()) != null) {
                insert(line.trim());
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }

    public void batchDelete(String fileToDelete) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileToDelete))) {
            String line;
            while ((line = br.readLine()) != null) {
                delete(line.trim());
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }

}
