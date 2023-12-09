import java.util.Timer;
import java.util.TimerTask;

public class TimeTracker {
    private static int elapsedSeconds = 0;

    public static void main(String[] args) {
        // Створення об'єкта Timer
        Timer timer = new Timer();

        // Розпочинання відліку часу кожну секунду
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                elapsedSeconds++;
                System.out.println("Пройшло " + elapsedSeconds + " секунд");
            }
        }, 0, 1000); // Починаємо відлік одразу, потім кожну секунду (1000 мілісекунд)

        // Створення і запуск другого потоку
        new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(5000); // Почекайте 5 секунд
                    System.out.println("Минуло 5 секунд");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
