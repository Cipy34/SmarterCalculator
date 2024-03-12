package org.example;

public class Romb extends Paralelogram{
    private int diag1, diag2;
    public Romb(){
        super();
    }

    public Romb(int diag1, int diag2){
        this.diag1 = diag1;
        this.diag2 = diag2;
    }

    public Romb(int latura1, int latura2, int latura3, int latura4, int diag1, int diag2){
        super(latura1, latura2, latura3, latura4);
        this.diag1 = diag1;
        this.diag2 = diag2;
    }

    public Romb(double unghi1, double unghi2, double unghi3, double unghi4, int diag1, int diag2){
        super(unghi1, unghi2, unghi3, unghi4);
        this.diag1 = diag1;
        this.diag2 = diag2;
    }

    public Romb(int latura1, int latura2, int latura3, int latura4,
                double unghi1, double unghi2, double unghi3, double unghi4,
                int diag1, int diag2){
        super(latura1, latura2, latura3, latura4, unghi1, unghi2, unghi3, unghi4);
        this.diag1 = diag1;
        this.diag2 = diag2;
    }

    public double Arie(){
        return (double) (diag1 * diag2) /2;
    }
}
