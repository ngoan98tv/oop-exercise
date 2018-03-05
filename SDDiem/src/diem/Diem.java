/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diem;

import java.util.Scanner;

/**
 *
 * @author Ngoan Tran
 */
public class Diem {
    
    private int x,y;
    
    public Diem(){
        x = 0; y = 0;
    };
    
    public Diem(int a, int b){
        x = a; y = b;
    }
    
    public void nhapDiem(){
        Scanner sc = new Scanner(System.in);
        System.out.print("x = ");
        x = sc.nextInt();
        System.out.print("y = ");
        y = sc.nextInt();
    }
    
    public void hienThi(){
        System.out.println("(" + x + "," + y + ")");
    }
    
    public void doiDiem(int dx, int dy){
        x += dx;
        y += dy;
    }
    
    public int giaTriX(){
        return x;
    }
    
    public int giaTriY(){
        return y;
    }
    
    public double khoangCach(){
        return Math.sqrt(x*x + y*y);
    }
    
    public double khoangCach(Diem d){
        return Math.sqrt((x - d.giaTriX())*(x - d.giaTriX()) + (y - d.giaTriY())*(y - d.giaTriY()));
    }
    
}

