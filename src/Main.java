import javax.swing.plaf.TableHeaderUI;
import java.util.Collections;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class Main {

    public static final int PAUSE = 100;

    public static void main(String[] args) {
        Maps maps = new Maps();
        Maps.map = new ConcurrentHashMap<>();
        try {
            new Thread(null, maps::timeToPut, "ConcurrentHashMap").start();
            new Thread(null, maps::timeToRead, "ConcurrentHashMap").start();
            Thread.sleep(PAUSE);
            Maps.map = Collections.synchronizedMap(new HashMap<>());
            new Thread(null, maps::timeToPut, "SynchronizedMap").start();
            new Thread(null, maps::timeToRead, "SynchronizedMap").start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // Расшифровки комментариев:
    // CHM = ConcurrentHashMap
    // SM = SynchronizedMap

    // При малых размерах MAP скорость чтения в CHM > скорости чтения в SM (при больших размерах - наоборот)
    // При малых размерах MAP скорость записи в CHM < скорости чтения в SM (при больших размерах - то же самое)

    // Рейтинг по затратам времени при 20 элементах MAP:
    // 1. Время чтения в CHM составляет 11900;
    // 2. Время чтения в SM составляет 13300;
    // 3. Время записи в SM составляет 22400;
    // 4. Время записи в CHM составляет 55800;

    // Рейтинг по затратам времени при 100 элементах MAP:
    // 1. Время чтения в SM составляет 19200;
    // 2. Время чтения в CHM составляет 21000;
    // 3. Время записи в SM составляет 40800;
    // 4. Время записи в CHM составляет 192200;

    // Рейтинг по затратам времени при 10 элементах MAP:
    // 1. Время чтения в CHM составляет 7300;
    // 2. Время чтения в SM составляет 7900;
    // 3. Время записи в SM составляет 11900;
    // 4. Время записи в CHM составляет 37900;

}
