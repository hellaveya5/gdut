
import java.util.Scanner;

/**
 * @Author:98333
 * @Date:2021/5/5
 * @Description:PACKAGE_NAME
 */
public class Main {
    public static int capacity;
    public static void main(String[] args) {
        Knapsack knapsack = new Knapsack();
        System.out.println("背包问题，请输入背包可容纳物品数量和总承重");
        newKnapsack(knapsack);
        soutKnapsack(knapsack);
        selectMaxValue(knapsack);
        System.out.println("输入任意键退出");
        Scanner scanner=new Scanner(System.in);
        scanner.next();

    }

    private static void soutKnapsack(Knapsack knapsack) {
        System.out.println("重量:");
        Utils.printArrays(knapsack.getWeight());
        System.out.println("价值:");
        Utils.printArrays(knapsack.getValue());
    }

    private static void selectMaxValue(Knapsack knapsack) {
        System.out.println("tiaoxuan");

    int maxValue=dp(knapsack.getValue().length,knapsack.getValue(),knapsack.getWeight(),knapsack.getMaxCapacity());
        System.out.println("最优价值:"+maxValue);
    }
    //动态规划
    private static int dp(int num, int[] value , int[] weight , int maxCapacity) {
        String[] a = new String[value.length*value.length];
       if(num ==1){
           if(maxCapacity>=weight[num-1]){
               return value[num-1];
           }else {
               return 0;
           }

       }
        if(maxCapacity>=weight[num-1]){

                return Math.max(dp(num - 1, value, weight, maxCapacity - weight[num-1]) + value[num-1], dp(num - 1, value, weight, maxCapacity));
        }else {
                return dp(num-1, value ,weight , maxCapacity) ;
        }
    }


    private static void newKnapsack(Knapsack knapsack) {
        String n ;
        System.out.println("物品总数");
        Scanner scanner = new Scanner(System.in);
        n=scanner.next();
        System.out.println("总承重");
        String c = scanner.next();
        capacity =Integer.parseInt(n);
        int i = Integer.parseInt(c);
        int[] weight = new int[capacity];
        int[] value = new int[capacity];
        knapsack.setMaxCapacity(i);
        knapsack.setWeight(weight);
        knapsack.setValue(value);
        createKnapsack(knapsack);
    }

    private static void createKnapsack(Knapsack knapsack) {
        int[] weight = new int[capacity];
        int[] value = new int[capacity];
        Utils.setArrays(weight,knapsack,"weight");
        Utils.setArrays(value,knapsack,"value");
    }
}
