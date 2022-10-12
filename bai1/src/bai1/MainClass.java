package bai1;

import java.util.Scanner;

import bai1.Fraction;

public class MainClass {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Fraction ps1 = new Fraction();
        Fraction ps2 = new Fraction();
        Fraction psTong = new Fraction();

        // nhap phan so
        System.out.println("Nhap vao phan so thu nhat:");
        ps1.nhapPS(sc);
        System.out.println("Nhap vao phan so thu hai:");
        ps2.nhapPS(sc);

        // tinh tong 2 phan so
        psTong=ps1.congPS(ps2);

        // hien thi phan so
        System.out.println("\nPhan so thu nhat la:");
        ps1.hienthiPS();
        System.out.println("\nPhan so thu hai la:");
        ps2.hienthiPS();
        System.out.println("\nPhan so tong la:");
        psTong.hienthiPS();

        sc.close();
    }
}
