package dsalgjava.ch11.lst1101;

import dsalgjava.ch11.shared.HashTableBase;
import dsalgjava.ch11.shared.HashTableBaseApp;

public class HashTableLinearProbingApp {

    public static void main(String[] args) {
        int size = HashTableBaseApp.getInt("Enter size of hash table: ");
        HashTableBase hashTable = new HashTableLinearProbing(size);
        HashTableBaseApp app = new HashTableBaseApp(hashTable); 
        app.doApp();
    }

}
