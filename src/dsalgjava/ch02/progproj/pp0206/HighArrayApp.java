package dsalgjava.ch02.progproj.pp0206;

public class HighArrayApp {

    public static void main(String[] args) {
        HighArray arr = new HighArray(10);
        
        arr.insert(77);
        arr.insert(99);
        arr.insert(77);
        arr.insert(55);
        arr.insert(22);
        arr.insert(88);
        arr.insert(11);
        arr.insert(22);
        arr.insert(66);
        arr.insert(22);
        
        arr.display();
        
        arr.noDups();
        arr.display();
    }

}
