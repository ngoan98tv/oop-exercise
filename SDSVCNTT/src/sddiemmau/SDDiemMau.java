/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sddiemmau;

/**
 *
 * @author Ngoan_Tran
 */
public class SDDiemMau {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DiemMau A = new DiemMau(5,10,"White");
        A.hienThi();
        
        DiemMau B = new DiemMau();
        
        B.nhap();
        
        B.doiDiem(10, 8);
        
        B.hienThi();
        
        B.ganMau("Yellow");
        
        B.hienThi();
    }
    
}
