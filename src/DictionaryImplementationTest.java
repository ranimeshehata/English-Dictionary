import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DictionaryImplementationTest {

    @Test
    public void time_10_n() {
        DictionaryImplementation d;
        long start1 = System.currentTimeMillis();
        for(int i=0;i<10;i++){
            String filename = String.format("cases/output_%d_%d_lines.txt", 10, i);
            DictionaryImplementation test_10_n= new DictionaryImplementation("O(n)");
            test_10_n.batchInsert(filename);
        }
        long end1 = System.currentTimeMillis();
        long duration1 = (end1 - start1)/10;
        System.out.print("Time to insert 10 elements :");
        System.out.println("\u001B[35m(" + duration1 + ") ms\u001B[0m");

    }

    @Test
    public void time_100_n(){
        long start1 = System.currentTimeMillis();
        for(int i=0;i<10;i++){
            String filename = String.format("cases/output_%d_%d_lines.txt", 100, i);
            DictionaryImplementation test_100_n= new DictionaryImplementation("O(n)");
            test_100_n.batchInsert(filename);
        }
        long end1 = System.currentTimeMillis();
        long duration1 = (end1 - start1)/10;
        System.out.print("Time to insert 100 elements :");
        System.out.println("\u001B[35m(" + duration1 + ") ms\u001B[0m");
    }
    @Test
    public void time_1000_n(){
        long start1 = System.currentTimeMillis();
        for(int i=0;i<10;i++){
            String filename = String.format("cases/output_%d_%d_lines.txt", 1000, i);
            DictionaryImplementation test_1000_n= new DictionaryImplementation("O(n)");
            test_1000_n.batchInsert(filename);
        }
        long end1 = System.currentTimeMillis();
        long duration1 = (end1 - start1)/10;
        System.out.print("Time to insert 1000 elements :");
        System.out.println("\u001B[35m(" + duration1 + ") ms\u001B[0m");
    }

    @Test
    public void time_10000_n(){
        long start1 = System.currentTimeMillis();
        for(int i=0;i<10;i++){
            String filename = String.format("cases/output_%d_%d_lines.txt", 10000, i);
            DictionaryImplementation test_10000_n= new DictionaryImplementation("O(n)");
            test_10000_n.batchInsert(filename);
        }
        long end1 = System.currentTimeMillis();
        long duration1 = (end1 - start1)/10;
        System.out.print("Time to insert 10000 elements :");
        System.out.println("\u001B[35m(" + duration1 + ") ms\u001B[0m");
    }

    @Test
    public void time_100000_n(){
        long start1 = System.currentTimeMillis();
        for(int i=0;i<10;i++){
            String filename = String.format("cases/output_%d_%d_lines.txt", 100000, i);
            DictionaryImplementation test_100000_n= new DictionaryImplementation("O(n)");
            test_100000_n.batchInsert(filename);
        }
        long end1 = System.currentTimeMillis();
        long duration1 = (end1 - start1)/10;
        System.out.print("Time to insert 100000 elements :");
        System.out.println("\u001B[35m(" + duration1 + ") ms\u001B[0m");
    }

    @Test
    public void time_1000000_n(){
        long start1 = System.currentTimeMillis();
        for(int i=0;i<10;i++){
            String filename = String.format("cases/output_%d_%d_lines.txt", 1000000, i);
            DictionaryImplementation test_1000000_n= new DictionaryImplementation("O(n)");
            test_1000000_n.batchInsert(filename);
        }
        long end1 = System.currentTimeMillis();
        long duration1 = (end1 - start1)/10;
        System.out.print("Time to insert 1000000 elements :");
        System.out.println("\u001B[35m(" + duration1 + ") ms\u001B[0m");
    }

    //    O(n^2)
    @Test
    public void time_10_n2() {
        long start1 = System.currentTimeMillis();
        for(int i=0;i<10;i++){
            String filename = String.format("cases/output_%d_%d_lines.txt", 10, i);
            DictionaryImplementation test_10_n2= new DictionaryImplementation("O(n^2)");
            test_10_n2.batchInsert(filename);
        }
        long end1 = System.currentTimeMillis();
        long duration1 = (end1 - start1)/10;
        System.out.print("Time to insert 10 elements :");
        System.out.println("\u001B[35m(" + duration1 + ") ms\u001B[0m");

    }
    @Test
    public void time_100_n2() {
        long start1 = System.currentTimeMillis();
        for(int i=0;i<10;i++){
            String filename = String.format("cases/output_%d_%d_lines.txt", 100, i);
            DictionaryImplementation test_100_n2= new DictionaryImplementation("O(n^2)");
            test_100_n2.batchInsert(filename);
        }
        long end1 = System.currentTimeMillis();
        long duration1 = (end1 - start1)/10;
        System.out.print("Time to insert 100 elements :");
        System.out.println("\u001B[35m(" + duration1 + ") ms\u001B[0m");

    }
    @Test
    public void time_1000_n2() {
        long start1 = System.currentTimeMillis();
        for(int i=0;i<10;i++){
            String filename = String.format("cases/output_%d_%d_lines.txt", 1000, i);
            DictionaryImplementation test_1000_n2= new DictionaryImplementation("O(n^2)");
            test_1000_n2.batchInsert(filename);
        }
        long end1 = System.currentTimeMillis();
        long duration1 = (end1 - start1)/10;
        System.out.print("Time to insert 1000 elements :");
        System.out.println("\u001B[35m(" + duration1 + ") ms\u001B[0m");

    }
    @Test
    public void time_10000_n2() {
        long start1 = System.currentTimeMillis();
        for(int i=0;i<10;i++){
            String filename = String.format("cases/output_%d_%d_lines.txt", 10000, i);
            DictionaryImplementation test_10000_n2= new DictionaryImplementation("O(n^2)");
            test_10000_n2.batchInsert(filename);
        }
        long end1 = System.currentTimeMillis();
        long duration1 = (end1 - start1)/10;
        System.out.print("Time to insert 10000 elements :");
        System.out.println("\u001B[35m(" + duration1 + ") ms\u001B[0m");

    }
    @Test
    public void time_100000_n2() {
        long start1 = System.currentTimeMillis();
        for(int i=0;i<10;i++){
            String filename = String.format("cases/output_%d_%d_lines.txt", 100000, i);
            DictionaryImplementation test_100000_n2= new DictionaryImplementation("O(n^2)");
            test_100000_n2.batchInsert(filename);
        }
        long end1 = System.currentTimeMillis();
        long duration1 = (end1 - start1)/10;
        System.out.print("Time to insert 100000 elements :");
        System.out.println("\u001B[35m(" + duration1 + ") ms\u001B[0m");

    }
    @Test
    public void time_1000000_n2() {
        long start1 = System.currentTimeMillis();
        for(int i=0;i<10;i++){
            String filename = String.format("cases/output_%d_%d_lines.txt", 1000000, i);
            DictionaryImplementation test_1000000_n2= new DictionaryImplementation("O(n^2)");
            test_1000000_n2.batchInsert(filename);
        }
        long end1 = System.currentTimeMillis();
        long duration1 = (end1 - start1)/10;
        System.out.print("Time to insert 1000000 elements :");
        System.out.println("\u001B[35m(" + duration1 + ") ms\u001B[0m");

    }

    @Test
    public void check_found(){
        long start1 = System.currentTimeMillis();
            String filename = String.format("cases/output_%d_%d_lines.txt", 100, 0);
            DictionaryImplementation test_100_n= new DictionaryImplementation("O(n)");
            test_100_n.batchInsert(filename);
            test_100_n.insert("youssef");
            assertEquals(true,test_100_n.search("youssef"));

    }
    @Test
    public void check_delete(){
        long start1 = System.currentTimeMillis();
        String filename = String.format("cases/output_%d_%d_lines.txt", 100, 0);
        DictionaryImplementation test_100_n= new DictionaryImplementation("O(n)");
        test_100_n.batchInsert(filename);
        test_100_n.insert("youssef");
        test_100_n.delete("youssef");
        assertEquals(false,test_100_n.search("youssef"));

    }

    @Test
    public void check_found_batch(){
        long start1 = System.currentTimeMillis();
        String filename = String.format("cases/output_%d_%d_lines.txt", 100, 0);
        String filename2 = "cases/batch_insert_test.txt";
        DictionaryImplementation test_100_n= new DictionaryImplementation("O(n)");
        test_100_n.batchInsert(filename);
        test_100_n.batchInsert(filename2);
        boolean here = test_100_n.search("youssef");
        here = here & test_100_n.search("ahmed");
        assertEquals(true,here);

    }

    @Test
    public void check_delete_batch(){
        long start1 = System.currentTimeMillis();
        String filename = String.format("cases/output_%d_%d_lines.txt", 100, 0);
        String filename2 = "cases/batch_insert_test.txt";
        DictionaryImplementation test_100_n= new DictionaryImplementation("O(n)");
        test_100_n.batchInsert(filename);
        test_100_n.batchInsert(filename2);
        test_100_n.batchDelete(filename2);
        boolean here = test_100_n.search("youssef");
        here = here & test_100_n.search("ahmed");
        assertEquals(false,here);
    }











    @Test
    public void time_10_n2_rehash() throws FileNotFoundException {
        PerfectHashing p;
        p = new HashTableN2();
        long maintime=0;
//        long start1 = System.currentTimeMillis();
        for(int i=0;i<10;i++){
            String filename = String.format("cases/output_%d_%d_lines.txt", 10, i);
            p.batchInsert(filename);
            long start1 = System.currentTimeMillis();
            p.rehash();
            long end1 = System.currentTimeMillis();
            long duration1 = (end1 - start1);
            maintime=maintime+duration1;
        }
//        long end1 = System.currentTimeMillis();
        maintime=maintime/10;
        System.out.print("Time to rehash 10 elements :");
        System.out.println("\u001B[35m(" + maintime + ") ms\u001B[0m");

    }

    @Test
    public void time_100_n2_rehash() throws FileNotFoundException {
        PerfectHashing p;
        p = new HashTableN2();
        long maintime=0;
//        long start1 = System.currentTimeMillis();
        for(int i=0;i<10;i++){
            String filename = String.format("cases/output_%d_%d_lines.txt", 100, i);
            p.batchInsert(filename);
            long start1 = System.currentTimeMillis();
            p.rehash();
            long end1 = System.currentTimeMillis();
            long duration1 = (end1 - start1);
            maintime=maintime+duration1;
        }
//        long end1 = System.currentTimeMillis();
        maintime=maintime/10;
        System.out.print("Time to rehash 100 elements :");
        System.out.println("\u001B[35m(" + maintime + ") ms\u001B[0m");

    }

    @Test
    public void time_1000_n2_rehash() throws FileNotFoundException {
        PerfectHashing p;
        p = new HashTableN2();
        long maintime=0;
//        long start1 = System.currentTimeMillis();
        for(int i=0;i<10;i++){
            String filename = String.format("cases/output_%d_%d_lines.txt", 1000, i);
            p.batchInsert(filename);
            long start1 = System.currentTimeMillis();
            p.rehash();
            long end1 = System.currentTimeMillis();
            long duration1 = (end1 - start1);
            maintime=maintime+duration1;
        }
//        long end1 = System.currentTimeMillis();
        maintime=maintime/10;
        System.out.print("Time to rehash 1000 elements :");
        System.out.println("\u001B[35m(" + maintime + ") ms\u001B[0m");

    }

    @Test
    public void time_10000_n2_rehash() throws FileNotFoundException {
        PerfectHashing p;
        p = new HashTableN2();
        long maintime=0;
//        long start1 = System.currentTimeMillis();
        for(int i=0;i<10;i++){
            String filename = String.format("cases/output_%d_%d_lines.txt", 10000, i);
            p.batchInsert(filename);
            long start1 = System.currentTimeMillis();
//            p.rehash();
            long end1 = System.currentTimeMillis();
            long duration1 = (end1 - start1);
            maintime=maintime+duration1;
        }
//        long end1 = System.currentTimeMillis();
        maintime=maintime/10;
        System.out.print("Time to rehash 10000 elements :");
        System.out.println("\u001B[35m(" + maintime + ") ms\u001B[0m");

    }

    @Test
    public void time_100000_n2_rehash() throws FileNotFoundException {
        PerfectHashing p;
        p = new HashTableN2();
        long maintime=0;
//        long start1 = System.currentTimeMillis();
        for(int i=0;i<10;i++){
            String filename = String.format("cases/output_%d_%d_lines.txt", 100000, i);
            p.batchInsert(filename);
            long start1 = System.currentTimeMillis();
            p.rehash();
            long end1 = System.currentTimeMillis();
            long duration1 = (end1 - start1);
            maintime=maintime+duration1;
        }
//        long end1 = System.currentTimeMillis();
        maintime=maintime/10;
        System.out.print("Time to rehash 100000 elements :");
        System.out.println("\u001B[35m(" + maintime + ") ms\u001B[0m");

    }

    @Test
    public void time_1000000_n2_rehash() throws FileNotFoundException {
        PerfectHashing p;
        p = new HashTableN2();
        long maintime=0;
//        long start1 = System.currentTimeMillis();
        for(int i=0;i<10;i++){
            String filename = String.format("cases/output_%d_%d_lines.txt", 1000000, i);
            p.batchInsert(filename);
            long start1 = System.currentTimeMillis();
            p.rehash();
            long end1 = System.currentTimeMillis();
            long duration1 = (end1 - start1);
            maintime=maintime+duration1;
        }
//        long end1 = System.currentTimeMillis();
        maintime=maintime/10;
        System.out.print("Time to rehash 1000000 elements :");
        System.out.println("\u001B[35m(" + maintime + ") ms\u001B[0m");

    }

    @Test
    public void time_10_n_rehash() throws FileNotFoundException {
        PerfectHashing p;
        p = new HashTableN();
        long maintime=0;
//        long start1 = System.currentTimeMillis();
        for(int i=0;i<10;i++){
            String filename = String.format("cases/output_%d_%d_lines.txt", 10, i);
            p.batchInsert(filename);
            long start1 = System.currentTimeMillis();
            p.rehash();
            long end1 = System.currentTimeMillis();
            long duration1 = (end1 - start1);
            maintime=maintime+duration1;
        }
//        long end1 = System.currentTimeMillis();
        maintime=maintime/10;
        System.out.print("Time to rehash 10 elements :");
        System.out.println("\u001B[35m(" + maintime + ") ms\u001B[0m");

    }

    @Test
    public void time_100_n_rehash() throws FileNotFoundException {
        PerfectHashing p;
        p = new HashTableN();
        long maintime=0;
//        long start1 = System.currentTimeMillis();
        for(int i=0;i<10;i++){
            String filename = String.format("cases/output_%d_%d_lines.txt", 100, i);
            p.batchInsert(filename);
            long start1 = System.currentTimeMillis();
            p.rehash();
            long end1 = System.currentTimeMillis();
            long duration1 = (end1 - start1);
            maintime=maintime+duration1;
        }
//        long end1 = System.currentTimeMillis();
        maintime=maintime/10;
        System.out.print("Time to rehash 100 elements :");
        System.out.println("\u001B[35m(" + maintime + ") ms\u001B[0m");

    }

    @Test
    public void time_1000_n_rehash() throws FileNotFoundException {
        PerfectHashing p;
        p = new HashTableN();
        long maintime=0;
//        long start1 = System.currentTimeMillis();
        for(int i=0;i<10;i++){
            String filename = String.format("cases/output_%d_%d_lines.txt", 1000, i);
            p.batchInsert(filename);
            long start1 = System.currentTimeMillis();
            p.rehash();
            long end1 = System.currentTimeMillis();
            long duration1 = (end1 - start1);
            maintime=maintime+duration1;
        }
//        long end1 = System.currentTimeMillis();
        maintime=maintime/10;
        System.out.print("Time to rehash 1000 elements :");
        System.out.println("\u001B[35m(" + maintime + ") ms\u001B[0m");

    }

    @Test
    public void time_10000_n_rehash() throws FileNotFoundException {
        PerfectHashing p;
        p = new HashTableN();
        long maintime=0;
//        long start1 = System.currentTimeMillis();
        for(int i=0;i<10;i++){
            String filename = String.format("cases/output_%d_%d_lines.txt", 10000, i);
            p.batchInsert(filename);
            long start1 = System.currentTimeMillis();
//            p.rehash();
            long end1 = System.currentTimeMillis();
            long duration1 = (end1 - start1);
            maintime=maintime+duration1;
        }
//        long end1 = System.currentTimeMillis();
        maintime=maintime/10;
        System.out.print("Time to rehash 10000 elements :");
        System.out.println("\u001B[35m(" + maintime + ") ms\u001B[0m");

    }

    @Test
    public void time_100000_n_rehash() throws FileNotFoundException {
        PerfectHashing p;
        p = new HashTableN();
        long maintime=0;
//        long start1 = System.currentTimeMillis();
        for(int i=0;i<10;i++){
            String filename = String.format("cases/output_%d_%d_lines.txt", 100000, i);
            p.batchInsert(filename);
            long start1 = System.currentTimeMillis();
            p.rehash();
            long end1 = System.currentTimeMillis();
            long duration1 = (end1 - start1);
            maintime=maintime+duration1;
        }
//        long end1 = System.currentTimeMillis();
        maintime=maintime/10;
        System.out.print("Time to rehash 100000 elements :");
        System.out.println("\u001B[35m(" + maintime + ") ms\u001B[0m");

    }

    @Test
    public void time_1000000_n_rehash() throws FileNotFoundException {
        PerfectHashing p;
        p = new HashTableN();
        long maintime=0;
//        long start1 = System.currentTimeMillis();
        for(int i=0;i<10;i++){
            String filename = String.format("cases/output_%d_%d_lines.txt", 1000000, i);
            p.batchInsert(filename);
            long start1 = System.currentTimeMillis();
            p.rehash();
            long end1 = System.currentTimeMillis();
            long duration1 = (end1 - start1);
            maintime=maintime+duration1;
        }
//        long end1 = System.currentTimeMillis();
        maintime=maintime/10;
        System.out.print("Time to rehash 1000000 elements :");
        System.out.println("\u001B[35m(" + maintime + ") ms\u001B[0m");

    }





    @Test
    public void time_10_n2_insert() throws FileNotFoundException {
        PerfectHashing p;
        p = new HashTableN2();
        long maintime=0;
//        long start1 = System.currentTimeMillis();
        for(int i=0;i<10;i++){
            String filename = String.format("cases/output_%d_%d_lines.txt", 10, i);
            p.batchInsert(filename);
            long start1 = System.currentTimeMillis();
            p.batchInsert("cases/1element");
            long end1 = System.currentTimeMillis();
            long duration1 = (end1 - start1);
            maintime=maintime+duration1;
        }
//        long end1 = System.currentTimeMillis();
        maintime=maintime/10;
        System.out.print("Time to insert in 10 elements :");
        System.out.println("\u001B[35m(" + maintime + ") ms\u001B[0m");

    }

    @Test
    public void time_100_n2_insert() throws FileNotFoundException {
        PerfectHashing p;
        p = new HashTableN2();
        long maintime=0;
//        long start1 = System.currentTimeMillis();
        for(int i=0;i<10;i++){
            String filename = String.format("cases/output_%d_%d_lines.txt", 100, i);
            p.batchInsert(filename);
            long start1 = System.currentTimeMillis();
            p.batchInsert("cases/1element");
            long end1 = System.currentTimeMillis();
            long duration1 = (end1 - start1);
            maintime=maintime+duration1;
        }
//        long end1 = System.currentTimeMillis();
        maintime=maintime/10;
        System.out.print("Time to rehash 100 elements :");
        System.out.println("\u001B[35m(" + maintime + ") ms\u001B[0m");

    }

    @Test
    public void time_1000_n2_insert() throws FileNotFoundException {
        PerfectHashing p;
        p = new HashTableN2();
        long maintime=0;
//        long start1 = System.currentTimeMillis();
        for(int i=0;i<10;i++){
            String filename = String.format("cases/output_%d_%d_lines.txt", 1000, i);
            p.batchInsert(filename);
            long start1 = System.currentTimeMillis();
            p.batchInsert("cases/1element");
            long end1 = System.currentTimeMillis();
            long duration1 = (end1 - start1);
            maintime=maintime+duration1;
        }
//        long end1 = System.currentTimeMillis();
        maintime=maintime/10;
        System.out.print("Time to rehash 1000 elements :");
        System.out.println("\u001B[35m(" + maintime + ") ms\u001B[0m");

    }

    @Test
    public void time_10000_n_insert() throws FileNotFoundException {
        PerfectHashing p;
        p = new HashTableN2();
        long maintime=0;
//        long start1 = System.currentTimeMillis();
        for(int i=0;i<10;i++){
            String filename = String.format("cases/output_%d_%d_lines.txt", 10000, i);
            p.batchInsert(filename);
            long start1 = System.currentTimeMillis();
            p.batchInsert("cases/1element");
            long end1 = System.currentTimeMillis();
            long duration1 = (end1 - start1);
            maintime=maintime+duration1;
        }
//        long end1 = System.currentTimeMillis();
        maintime=maintime/10;
        System.out.print("Time to rehash 10000 elements :");
        System.out.println("\u001B[35m(" + maintime + ") ms\u001B[0m");

    }

    @Test
    public void time_100000_n_insert() throws FileNotFoundException {
        PerfectHashing p;
        p = new HashTableN2();
        long maintime=0;
//        long start1 = System.currentTimeMillis();
        for(int i=0;i<10;i++){
            String filename = String.format("cases/output_%d_%d_lines.txt", 100000, i);
            p.batchInsert(filename);
            long start1 = System.currentTimeMillis();
            p.batchInsert("cases/1element");
            long end1 = System.currentTimeMillis();
            long duration1 = (end1 - start1);
            maintime=maintime+duration1;
        }
//        long end1 = System.currentTimeMillis();
        maintime=maintime/10;
        System.out.print("Time to rehash 100000 elements :");
        System.out.println("\u001B[35m(" + maintime + ") ms\u001B[0m");

    }

    @Test
    public void time_1000000_n_insert() throws FileNotFoundException {
        PerfectHashing p;
        p = new HashTableN2();
        long maintime=0;
//        long start1 = System.currentTimeMillis();
        for(int i=0;i<10;i++){
            String filename = String.format("cases/output_%d_%d_lines.txt", 1000000, i);
            p.batchInsert(filename);
            long start1 = System.currentTimeMillis();
            p.batchInsert("cases/1element");
            long end1 = System.currentTimeMillis();
            long duration1 = (end1 - start1);
            maintime=maintime+duration1;
        }
//        long end1 = System.currentTimeMillis();
        maintime=maintime/10;
        System.out.print("Time to rehash 1000000 elements :");
        System.out.println("\u001B[35m(" + maintime + ") ms\u001B[0m");

    }













}