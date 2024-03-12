package org.example;

public class Dreptunghi extends Paralelogram{
    public Dreptunghi(int latime, int lungime){
        super(latime, lungime, latime, lungime);
    }

    public double Arie(){
        return latura1*latura2;
    }
}
