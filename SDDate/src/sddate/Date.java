/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sddate;

import java.util.Scanner;

/**
 *
 * @author Ngoan Tran
 */
public class Date {
    
    int ngay, thang, nam;
    
    public Date(){
        ngay = 1; thang = 1; nam = 2000;
    }
    
    public Date(int ng, int th, int na){
        ngay = ng; thang = th; nam = na;
    }
    
    public Date(Date d){
        ngay = d.ngay;
        thang = d.thang;
        nam = d.nam;
    }
    
    public void hienThi(){
        System.out.println("Ngay " + ngay + " thang " + thang + " nam " + nam);
    }
    
    public boolean hopLe(){
        switch (thang) {
                    case 1: 
                        if (ngay > 31) return false;
                        break;
                    case 2: 
                        if (ngay > 28) return false;
                        break;
                    case 3: 
                        if (ngay > 31) return false;
                        break;
                    case 4: 
                        if (ngay > 30) return false;
                        break;
                    case 5: 
                        if (ngay > 31) return false;
                        break;
                    case 6: 
                        if (ngay > 30) return false;
                        break;
                    case 7: 
                        if (ngay > 31) return false;
                        break;
                    case 8: 
                        if (ngay > 31) return false;
                        break;
                    case 9: 
                        if (ngay > 30) return false;
                        break;
                    case 10: 
                        if (ngay > 31) return false;
                        break;
                    case 11: 
                        if (ngay > 30) return false;
                        break;
                    case 12: 
                        if (ngay > 31) return false;
                        break;
                    default: return false;
            }
        return ngay >= 1;
    }
    
    public void nhap(){
        Scanner sc = new Scanner(System.in);
        
            System.out.print("Ngay: ");
            ngay = sc.nextInt();

            System.out.print("Thang: ");
            thang = sc.nextInt();

            System.out.print("Nam: ");
            nam = sc.nextInt();

        while (!hopLe()){
            System.out.println("Khong hop le! Vui long nhap lai.");
        
            System.out.print("Ngay: ");
            ngay = sc.nextInt();

            System.out.print("Thang: ");
            thang = sc.nextInt();

            System.out.print("Nam: ");
            nam = sc.nextInt();
        }
    }
    
    public Date ngayHomSau(){
        switch (thang) {
                    case 1: 
                        if (ngay == 31) 
                            return new Date(1, 2, nam);
                        break;
                    case 2: 
                        if (ngay == 28) 
                            return new Date(1, 3, nam);
                        break;
                    case 3: 
                        if (ngay == 31) 
                            return new Date(1, 4, nam);
                        break;
                    case 4: 
                        if (ngay == 30)
                            return new Date(1, 5, nam);
                        break;
                    case 5: 
                        if (ngay == 31)
                            return new Date(1, 6, nam);
                        break;
                    case 6: 
                        if (ngay == 30) 
                            return new Date(1, 7, nam);
                        break;
                    case 7: 
                        if (ngay == 31)
                            return new Date(1, 8, nam);
                        break;
                    case 8: 
                        if (ngay == 31) 
                            return new Date(1, 9, nam);
                        break;
                    case 9: 
                        if (ngay == 30) 
                            return new Date(1, 10, nam);
                        break;
                    case 10: 
                        if (ngay == 31) 
                            return new Date(1, 11, nam);
                        break;
                    case 11: 
                        if (ngay == 30) 
                            return new Date(1, 12, nam);
                        break;
                    case 12: 
                        if (ngay == 31)
                            return new Date(1, 1, nam+1);
                        break;
            }
        return new Date(ngay +1, thang, nam);
    }
    
    public Date congNgay(int n){
        
        Date tmp = new Date(this);
        for (int i=0; i<n; i++)
            tmp = tmp.ngayHomSau();
        return tmp;
        
    }
    
    //return 1 if a>b, 0 if a = b, -1 if a<b
    public static int soSanh(Date a, Date b){
        if (a.nam > b.nam)
            return 1;
        if (a.nam < b.nam)
            return -1;
        if (a.thang > b.thang)
            return 1;
        if (a.thang < b.thang)
            return -1;
        if (a.ngay > b.ngay)
            return 1;
        if (a.ngay < b.ngay)
            return -1;
        return 0;
    }
}
