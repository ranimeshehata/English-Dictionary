import java.util.InputMismatchException;
import java.util.Scanner;

public class App {

    // this method starts program
    public void start() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\u001B[40mEnter a number corresponding to the type of the backend tree of the dictionary: " + "\u001B[0m");
        System.out.print("\u001B[33m1)'O(n)'\n2)'O(n^2)'\u001B[0m\nAnswer >> ");
        String typeD;
       PerfectHashing d;
        typeD = scanner.next();
        while (true) {
            try {
                if (Integer.parseInt(typeD) == 1 || Integer.parseInt(typeD) == 2) {
                    if (Integer.parseInt(typeD) == 1) {
                        typeD = "O(n)";
                    } else {
                        typeD = "O(n^2)";
                    }
                    break;
                } else {
                    System.out.print("\u001B[31mError!! Please enter a valid option\n\u001B[0mAnswer >> ");
                    typeD = scanner.next();
                }
            } catch (Exception e) {
                System.out.print("\u001B[31mError!! Please enter a valid option\n\u001B[0mAnswer >> ");
                typeD = scanner.next();
            }
        }
        //String backendType = scanner.nextLine();

        operations();
    }
    private static void operations() {
        while (true) {
            System.out.println("-------------------------------------------------------------" + "\n\u001B[40mDictionary Menu: \u001B[0m");
            System.out.println("\u001B[33m1) Insert a string\u001B[0m");
            System.out.println("\u001B[33m2) Delete a string\u001B[0m");
            System.out.println("\u001B[33m3) Search for a string\u001B[0m");
            System.out.println("\u001B[33m4) Batch insert a list of strings\u001B[0m");
            System.out.println("\u001B[33m5) Batch delete a list of strings\u001B[0m");
            System.out.println("\u001B[33m6) Exit\u001B[0m");
            System.out.print("Operation Number >> ");
            Scanner scanner = new Scanner(System.in);
            try {
                int operationNum = scanner.nextInt();
                //Bounded options
                if (operationNum < 0 || operationNum > 7) {
                    System.out.print("\u001B[31mError!! Please enter a valid option\n\u001B[0m");
                    operations();
                }
                //INSERT WORD
                else if (operationNum == 1) {
                    System.out.print("Enter the string to insert >> ");
                    String toInsert = scanner.next();
                    //function call
                }
                //DELETE WORD
                else if (operationNum == 2) {
                    System.out.print("Enter the string to delete >> ");
                    String toDelete = scanner.next();
                    //function call
                }
                //SEARCH
                else if (operationNum == 3) {
                    System.out.print("Enter the string to search >> ");
                    String toSearch = scanner.next();
                    //function call
                }
                //BATCH INSERT
                else if (operationNum == 4) {
                    System.out.print("Enter the path of the file to insert >> ");
                    String fileToInsert = scanner.next();
                    //function call
                }
                //BATCH DELETE
                else if (operationNum == 5) {
                    System.out.print("Enter the path of the file to delete >> ");
                    String fileToDelete = scanner.next();
                    //function call
                }
                //EXIT
                else if (operationNum == 6) {
                    System.out.println("\u001B[40mExiting the program...\u001B[0m");
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.print("\u001B[31mError!! Please enter a valid option\n\u001B[0m");
            }
        }
    }
}
