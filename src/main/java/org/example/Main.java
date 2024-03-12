package org.example;
public class Main {
    public static void main(String[] args) {
        Paralelogram p  = new Paralelogram(1, 2, 3, 4, 90, 90, 90, 90);
        Romb r = new Romb(1, 2);
        Dreptunghi d = new Dreptunghi(1, 2);
        Patrat pa = new Patrat(1);
        System.out.println(pa.Arie());
        System.out.println(d.Arie());
        System.out.println(r.Arie());
        System.out.println(p.Arie());
    }
}