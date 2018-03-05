/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diem;

/**
 *
 * @author Ngoan Tran
 */
public class SDDiem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Diem A = new Diem(3,4);
        
        System.out.print("A = ");
        A.hienThi();
        
        Diem B = new Diem();
        
        System.out.println("Nhap B:");
        B.nhapDiem();
        
        Diem C = new Diem(-B.giaTriX(),-B.giaTriY());
        
        System.out.print("C = ");
        C.hienThi();
        
        Diem O = new Diem(0,0);
        
        System.out.println("Khoang cach BO = " + B.khoangCach(O));
        
        System.out.println("Khoang cach AB = " + A.khoangCach(B));
                
    }
    
}
