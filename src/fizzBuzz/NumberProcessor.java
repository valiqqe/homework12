package fizzBuzz;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Consumer;

public class NumberProcessor extends Thread {

    private int number;

    private Consumer<Integer> processor;

    private AtomicBoolean isNumberProcessed = new AtomicBoolean(true);

    public NumberProcessor(Consumer<Integer> processor) {
        this.processor = processor;
    }

    public boolean isNumberProcessed() {
        return isNumberProcessed.get();
    }

    public void process(int number) {
        this.number = number;
        this.isNumberProcessed.set(false);
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            if (isNumberProcessed.get()) {
                continue;
            }

            processor.accept(number);
//            (n) -> {
//                if (n % 5 != 0 && n % 3 != 0) {
//                    System.out.println(n);
//                }
//            }

            isNumberProcessed.set(true);
        }
    }
}