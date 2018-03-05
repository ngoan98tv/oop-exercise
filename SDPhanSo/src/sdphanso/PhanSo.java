/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sdphanso;

import java.util.Scanner;

/**
 *
 * @author Ngoan Tran
 */
public class PhanSo {
    
    int tu, mau;
    
    public PhanSo(){
        tu = 0; mau = 1;
    }
    
    public PhanSo(int t, int m){
        tu = t; mau = m;
    }
    
    public void nhap(){
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Nhap tu so: ");
        tu = sc.nextInt();
        System.out.print("Nhap mau so: ");
        mau = sc.nextInt();

        while (mau == 0) {
            System.out.println("Mau so phai khac khong! Vui long nhap lai.");
            System.out.print("Nhap tu so: ");
            tu = sc.nextInt();
            System.out.print("Nhap mau so: ");
            mau = sc.nextInt();
        }
    }
    
    public void hienthi(){
        if (tu == 0)
            System.out.println("0");
        else if (mau == 1)
            System.out.println(tu);
        else 
            System.out.println(tu + "/" + mau);
    }
    
    public void nghichDao(){
        int tmp;
        tmp = tu;
        tu = mau;
        mau = tmp;
    }
    
    
}
