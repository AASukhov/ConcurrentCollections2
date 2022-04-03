import java.util.List;
import java.util.Map;
import java.util.Random;

public class Maps {
    private static final int SIZE = 10;
    private static final int LOW_BOUND = 0;
    private static final int HIGH_BOUND = 2000;
    private static final List<Integer> rnd = new Random().ints(SIZE, LOW_BOUND, HIGH_BOUND).boxed().toList();
    public static Map<Integer, Integer> map;

    public void timeToPut() {
        long start = System.nanoTime();
        for (int i = 0; i < rnd.size(); i++) {
            map.put(i, rnd.get(i));
        }
        long stop = System.nanoTime();
        long difference = stop - start;
        System.out.println("Время записи " + map + " в " + Thread.currentThread().getName() + " составляет " + difference);
    }

    public void timeToRead() {
        long start = System.nanoTime();
        for (int i = 0; i <map.size(); i++) {
            map.get(i);
        }
        long stop = System.nanoTime();
        long difference = stop - start;
        System.out.println("Время чтения " + map + " в " + Thread.currentThread().getName() + " составляет " + difference);
    }
}
