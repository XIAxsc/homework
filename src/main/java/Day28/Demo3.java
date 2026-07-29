package Day28;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Demo3 {

    private static final SecureRandom SECURE_RANDOM = new SecureRandom();

    private static List<Integer> generateRedBalls(int min, int max, int count, SecureRandom random) {
        // 生成完整范围列表
        List<Integer> all = new ArrayList<>((int) ((long) max - min + 1));
        for (int i = min; i <= max; i++) {
            all.add(i);
        }
        // Fisher-Yates 洗牌，只洗前 count 个
        for (int i = 0; i < count; i++) {
            int j = random.nextInt(i, all.size());
            // 交换
            int temp = all.get(i);
            all.set(i, all.get(j));
            all.set(j, temp);
        }
        return all.subList(0, count);
    }

    public static void main(String[] args) {
        int maxBlue = 16;
        int maxRed = 33;
        int min = 1;

        List<Integer> redBalls = generateRedBalls(min, maxRed, 6, SECURE_RANDOM);
        Integer[] redNums = new Integer[6];
        redBalls.toArray(redNums);
        Integer blue = SECURE_RANDOM.nextInt(min, maxBlue + 1);
        DoubleColorBall doubleColorBall = new DoubleColorBall(redNums, blue);
        System.out.println("doubleColorBall = " + doubleColorBall);

        ArrayList<DoubleColorBall> list = new ArrayList<>();
        list.add(doubleColorBall);
        System.out.println("list = " + list);
    }
}

class DoubleColorBall {
    Integer[] redNums;
    Integer blueNum;

    public DoubleColorBall(Integer[] redNums, Integer blueNum) {
        this.redNums = redNums;
        this.blueNum = blueNum;
    }

    @Override
    public String toString() {
        return "DoubleColorBall{" +
                "redNums=" + Arrays.toString(redNums) +
                ", blueNum=" + blueNum +
                '}';
    }
}
