import java.lang.reflect.Field;
import java.util.Random;

/**
 * @Author:98333
 * @Date:2021/5/5
 * @Description:PACKAGE_NAME
 */
public class Utils {
    public static void printArrays(int[] i){

            for (int n :
                    i) {
                System.out.print(n + "  ");
            }
            System.out.println("");

    }

    public static void setArrays(int[] arrays, Knapsack knapsack, String type)  {
        int flag=-0;
        Random random = new Random();
        for (int i :
                arrays) {
            for (int j =0;j < arrays.length;j++) {
                int rd = random.nextInt(10);
                arrays[j] = rd+1;
            }
            if("value".equalsIgnoreCase(type)){
                knapsack.setValue(arrays);
            }else {
                knapsack.setWeight(arrays);
            }
        }

    }
}
