import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class DictionaryImplementation {
    private HashMap<String, Integer> dictionaryN;
    private HashMap<String, Integer> dictionaryN2;
    public DictionaryImplementation(String typeD) {
        if (typeD.equals("O(n)")) {
            // Implement O(n) dictionary
            dictionaryN = new HashMap<>();
        } else {
            // Implement O(n^2) dictionary
            dictionaryN2 = new HashMap<>();
        }
    }

    public void insert(String toInsert) {
        if (dictionaryN != null){
            dictionaryN.put(toInsert, 1);
            System.out.print("(" + toInsert + ")" + "\u001B[32m Succefully inserted ✅\n\u001B[0m");
        } else {
            dictionaryN2.put(toInsert, 1);
            System.out.print("(" + toInsert + ")" + "\u001B[32m Succefully inserted ✅\n\u001B[0m");
        }
    }

    public void delete(String toDelete) {
        if (dictionaryN != null) {
            dictionaryN.remove(toDelete);
            System.out.print("(" + toDelete + ")" + "\u001B[32m Succefully DELETED ✅\n\u001B[0m");
        } else {
            // O(n^2) deletion logic
            if (dictionaryN2.containsKey(toDelete)) {
                dictionaryN2.remove(toDelete);
                System.out.print("(" + toDelete + ")" + "\u001B[32m Succefully DELETED ✅\n\u001B[0m");
            }
        }
    }

    public void search(String toSearch) {
        if (dictionaryN != null) {
            System.out.println(dictionaryN.containsKey(toSearch) ? "Found in O(n) dictionary" : "Not found in O(n) dictionary");
        } else {
            System.out.println(dictionaryN2.containsKey(toSearch) ? "Found in O(n^2) dictionary" : "Not found in O(n^2) dictionary");
        }
    }

    public void batchInsert(String fileToInsert) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileToInsert))) {
            String line;
            while ((line = br.readLine()) != null) {
                insert(line.trim());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void batchDelete(String fileToDelete) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileToDelete))) {
            String line;
            while ((line = br.readLine()) != null) {
                delete(line.trim());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
