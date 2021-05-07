import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @Author:98333
 * @Date:2021/5/6
 * @Description:PACKAGE_NAME
 */
public class Main {
    public static void main(String[] args) {
        int[] M1 = new int[]{5,3,6,4,8,9,6};
        int[] M2 = new int[]{2,4,7,2,9,7,3};
        System.out.println("M1");
        printArrarys(M1);
        System.out.println("M2");
        printArrarys(M2);
        int num =  M1.length;
        //将流水线问题转化为johnson问题
        int minTime=johnson(M1,M2,num);
        System.out.println("最少时间"+minTime);
        System.out.println("输入任意字符加空格退出");
        Scanner sc = new Scanner(System.in);
        sc.next();

    }


    private static void printArrarys(int[] m) {
        for (int i :
                m) {
            System.out.print(i+" ");
        }
        System.out.println();
    }

    private static int johnson(int[] m1, int[] m2, int num) {
       int[] m1_1= new int[m1.length];
       int[] m2_1= new int[m2.length];
       int[] m1_2= new int[m1.length];
       int[] m2_2= new int[m2.length];
       for(int i =0 ,j=0,n=0 ; i< m1.length ;i++)
       {
           if(m1[i]<m2[i]){
               m1_1[n] = m1[i];
               m2_1[n] = m2[i];
               n++;
           }else {
               m1_2[j] = m1[i];
               m2_2[j] = m2[i];
               j++;
           }
       }
       //给m1_1 排序
        for(int i =0 ;i < m1_1.length ; i++){
            for(int j = i ;j < m1_1.length ; j++ ){
                // 如果有更小的 ，将m1 m2 同时交换
                if(m1_1[i] > m1_1[j] ){
                    m1_1[i] = m1_1[i] + m1_1[j];
                    m1_1[j] = m1_1[i] - m1_1[j];
                    m1_1[i] = m1_1[i] - m1_1[j];
                    m2_1[i] = m2_1[i] + m2_1[j];
                    m2_1[j] = m2_1[i] - m2_1[j];
                    m2_1[i] = m2_1[i] - m2_1[j];
                }
            }
        }
        //给m2_1 排序
        for(int i=0 ; i < m1_2.length ; i++){
            for(int j = i ; j < m1_2.length ; j++){
                if(m2_2[i] < m2_2[j]){
                    m1_2[i] = m1_2[i] + m1_2[j];
                    m1_2[j] = m1_2[i] - m1_2[j];
                    m1_2[i] = m1_2[i] - m1_2[j];
                    m2_2[i] = m2_2[i] + m2_2[j];
                    m2_2[j] = m2_2[i] - m2_2[j];
                    m2_2[i] = m2_2[i] - m2_2[j];
                }
            }
        }
        //合并
        int j = 0;
        for(int i =0 ;i < m1_1.length ; i++){
            if(m1_1[i]!=0){
                m1[j] = m1_1[i];
                m2[j++] = m2_1[i];
            }
        }
        for(int i =0 ;i < m1_1.length ; i++){
            if(m1_2[i]!=0){
                m1[j] = m1_2[i];
                m2[j++] = m2_2[i];
            }
        }

        return sum(m1,m2);
    }

    private static int sum(int[] m1 ,int[] m2) {
       int sum=0;
       sum += m1[0];
       for(int i = 0; i < m1.length-1 ; i++){
           sum += m2[i]+Math.max(m1[i+1]-m2[i],0);
       }
       sum += m2[m2.length-1];
        return sum;
    }


}
