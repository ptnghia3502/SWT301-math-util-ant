/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trongnghia.mathutil.core;

import static com.trongnghia.mathutil.core.MathUtil.getFactorial;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

//import static ... tên-class.tên-hàm thì sau này khi gọi static bỏ luôn dâu chấm nhầm gọi tên class
//code gọi như hàm của C
//.* là đại diện cho tất cả các hàm static trong class vừa import
//nếu rảnh thì chấm từng tên hàm static (ko có dấu ngoặc)

/**
 *
 * @author Nghia
 */

//kĩ thuật DDT - DATA DRIVEN TESTING
//         TDD - TEST DRIVEN DEVELOPMENT
//DDT là kĩ thuật tổ chức các test case cho gọn gàng
//tách các câu lệnh kiểm thử và bộ data dùng để test riêng ra 2 nơi
//phiên bản test JUnit vừa học đang trộn đata test và gọi hàm
//lẫn lộn với nhau, ko sai, nhưng nhìn ko rõ ràng

//nếu ta muốn check hàm getF() với các giá trị đầu vào và có trả về đầu ra mong đợi hay ko
// 0 -> 1
// 1 -> 1
// 2 -> 2
// 3 -> 6
// 4 -> 24
// 5 -> 120
// 6 -> 720
//...
//có chỗ nào định nghĩa riêng cái đám data này
//ta sẽ dễ dàng nhận dc các case đã đủ hay chưa, đã đại diện đủ hay chưa
//đưa đám data này vào hàm assertEquals(? getF(?))
//cảm giác viết code để test hàm nhìn rõ ràng hơn 
//kĩ thuật đẩy data test ra 1 chỗ khác ròi nhồi ngược lại vào chỗ gọi hàm
//gọi là DDT - viết test case theo kiểu hướng về tách data cho dễ đọc, còn gọi là PARAMETERIZED TESTING

@RunWith(value = Parameterized.class)
public class MathUtilDDTTest {
    
    //chuẩn bị data để nhồi vào hàm test
    //quy ước hàm chuẩn bị data phải là static - nằm ở 1 chỗ cố định
    @Parameterized.Parameters
    public static Object[][] initData() {
        
        return new Integer[][] {
                                    {0, 1},
                                    {1, 1},
                                    {2, 2},
                                    {3, 6},
                                    {4, 24},
                                    {5, 120},
                                    {6, 7720},
                                };
    }
    
    @Parameterized.Parameter(value = 0) //map biến này vào cột 0
    public int n;
    
    @Parameterized.Parameter(value = 1) //map biến này vào cột 1
    public long expected; //2 biến này sẽ map vào 2 cột tương ứng của hàm initData
    //sau nó đưa 2 biến này vào assertEquals() như cũ
    
    @Test
    public void testFactorialGivenRightArgumentReturnsWell() {
        assertEquals(expected, getFactorial(n));
    }
}

//kết luận chung
//Xanh: tất cả các case đều phải xanh, expected == actual
//Đỏ: chỉ cần 1 đỏ, tất cả là đỏ

//Xanh khi tất cả cùng xanh
//Chỉ 1 đỏ, tất cả coi như đỏ

//lí do: hàm đc gọi là đúng thì phải đúng hết với các case
// hàm có 1 thg sai, đám còn lại đúng, thì hàm ko ổn định
// do 1 thg sai -> kết luận chung hàm sai 

//chỉ cần 1 đỏ, kết luận code ko ổn định, ko cho đi tiếp code khác
//phải sửa cho xong -> phần lý thuyết cốt lõi của CI
//tích hợp liên tục - continuous intergration