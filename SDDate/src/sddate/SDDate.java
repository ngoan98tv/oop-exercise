/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sddate;

import java.util.Random;

/**
 *
 * @author Ngoan Tran
 */
public class SDDate {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /* testing
        Date sn = new Date(7, 11, 1998);
        System.out.print("Sinh nhat cua toi: ");
        sn.hienThi();

        Date vi = new Date();
        System.out.println("Nhap sinh nhat Vicuc:");
        vi.nhap();

        Date today = new Date(31, 3, 2018);
        System.out.println("Sau ngay 31.3.2018 la: ");
        today.ngayHomSau().hienThi();

        Date day = new Date(15, 6, 2000);
        System.out.println("15.6.2000 +20 = ");
        day.congNgay(20).hienThi();
         */
        Random rand = new Random();

        //Nhap 1 mang Date
        Date[] arr;
        arr = new Date[10];

        for (int i = 0; i < 10; i++) {
            arr[i] = new Date(rand.nextInt(25) + 1, rand.nextInt(12) + 1, rand.nextInt(2000) + 1000);
            //arr[i].nhap();
        }
        System.out.println("---Danh sach ngay chua sap xep:");
        for (int i = 0; i < 10; i++) {
            arr[i].hienThi();
        }

        //Sap xep theo thoi gian.
        sapXep(arr);
        
        System.out.println("---Danh sach ngay sau khi sap xep:");
        for (int i = 0; i < 10; i++) {
            arr[i].hienThi();
        }
    }

    public static void sapXep(Date[] arr) {
        Date tmp;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                if (Date.soSanh(arr[i], arr[j]) == 1) {
                    tmp = new Date(arr[i]);
                    arr[i] = new Date(arr[j]);
                    arr[j] = new Date(tmp);
                }
            }
        }
    }
}
