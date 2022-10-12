package bai1;

import java.util.Scanner;

public class Fraction {
    // thuoc tinh
    private int tuSo;
    private int mauSo;

    // phuong thuc
    // ham khoi tao khong doi so
    public Fraction() {
        tuSo=0;
        mauSo=1;
    }

    // ham khoi tao co doi so
    public Fraction(int tuSo, int mauSo) {
        this.tuSo=tuSo;
        this.mauSo=mauSo;
    }
    // ham nhap phan so
    public void nhapPS(Scanner sc) {
        int a;
        int b;

        do{
            System.out.print("\tNhap vap tu so: ");
            a=sc.nextInt();

            System.out.print("\tNhap vap mau so: ");
            b=sc.nextInt();

            // kiem tra
            if(b==0){
                System.out.println("Mau so khong duoc bang 0, Hay nhap lai!");
            } else {
                tuSo=a;
                mauSo=b;
            }
        }
        while (b==0);
    }

    // ham hien thi
    public void hienthiPS() {
        if(tuSo*mauSo<0) {
            System.out.println("\t-"+Math.abs(tuSo)+"/"+Math.abs(mauSo));
        } else {
            System.out.println("\t"+Math.abs(tuSo)+"/"+Math.abs(mauSo));
        }
    }

    // ham cong
    public Fraction congPS(Fraction ps2) {
        int a=tuSo*ps2.mauSo+ps2.tuSo*mauSo;
        int b=mauSo*ps2.mauSo;

        return new Fraction(a, b);
    }

    // ham tru
    public Fraction truPS(Fraction ps2) {
        int a=tuSo*ps2.mauSo-ps2.tuSo*mauSo;
        int b=mauSo*ps2.mauSo;

        return new Fraction(a, b);
    }

    // ham nhan
    public Fraction nhanPS(Fraction ps2) {
        int a=tuSo*ps2.tuSo;
        int b=mauSo*ps2.mauSo;

        return new Fraction(a, b);
    }

    // ham chia
    public Fraction chiaPS(Fraction ps2) {
        int a=tuSo*ps2.mauSo;
        int b=mauSo*ps2.tuSo;

        return new Fraction(a, b);
    }

    // ham tim uscln
    private int timUSCLN(int a, int b){
        int r=a%b;

        while(r!=b) {
            a=b;
            b=r;
            r=a%b;
        }

        return b;
    }

    // ham kiem tra phan so toi gian
    public boolean kiemTraToiGian() {
        if(timUSCLN(tuSo, mauSo)==1) {
            return true;
        }
        return false;
    }

    // ham toi gian
    public void toiGianPS() {
        int x=timUSCLN(tuSo, mauSo);

        tuSo/=x;
        mauSo/=x;
    }
}
