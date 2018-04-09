/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sddiemmau;
import diem.Diem;
import java.util.Scanner;
/**
 *
 * @author Ngoan_Tran
 */
public class DiemMau extends Diem {
    
    private String mau;
    
    DiemMau(){
        super();
        mau = "None";
    }
    
    DiemMau(int a, int b, String m){
        super(a,b);
        mau = m;
    }
    
    public void ganMau(String m){
        mau = m;
    }
    
    public void nhap(){
        int a,b;
        String m;
        Scanner sc = new Scanner(System.in);
        
        super.nhapDiem();
        
        System.out.print("Nhap mau cua diem:");
        mau = sc.nextLine();
        
    }
    
    @Override
    public void hienThi(){
        super.hienThi();
        System.out.println(mau);
    }
}
