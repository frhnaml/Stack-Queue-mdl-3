package Latihann1;

import java.util.LinkedList;
import java.util.Queue;
import javax.crypto.interfaces.PBEKey;

public class Latihan2 {
    public static void main(String[] args) {
        Queue q = new LinkedList<>();

        q.add("Bebek");
        q.add("Angsa");
        q.add("Kuda");
        q.add("Buaya");
        q.add("Buaya");
        q.add("Tikus");

        System.out.println("Peek: " + q.peek());
        System.out.println("Animals: " + q);

        q.poll();
        q.poll();

        System.out.println("Animals: " + q);
    }
}
