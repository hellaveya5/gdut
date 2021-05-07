import java.util.Arrays;

/**
 * @Author:98333
 * @Date:2021/5/5
 * @Description:PACKAGE_NAME
 */
public class Knapsack {
    private int[] weight;
    private int[] value;

    @Override
    public String toString() {
        return "Knapsack{" +
                "weight=" + Arrays.toString(weight) +
                ", value=" + Arrays.toString(value) +
                ", maxCapacity=" + maxCapacity +
                '}';
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    private int maxCapacity;


    public int[] getWeight() {
        return weight;
    }

    public void setWeight(int[] weight) {
        this.weight = weight;
    }

    public int[] getValue() {
        return value;
    }

    public void setValue(int[] value) {
        this.value = value;
    }

}
