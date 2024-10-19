import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;

class Process {
    String name;
    int remainingTime;

    public Process(String name, int executionTime) {
        this.name = name;
        this.remainingTime = executionTime;
    }
}

public class RoundRobin {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.print("Enter the quantum value: ");
        int quantum = scanner.nextInt();

        System.out.print("Enter the number of processes: ");
        int processNumber = scanner.nextInt();

        Queue<Process> processQueue = new LinkedList<>();

        for (int i = 1; i <= processNumber; i++) {
            String name = "Process " + i;
            int executionTime = random.nextInt(500) + 1;

            processQueue.add(new Process(name, executionTime));

            System.out.println(name + " - Execution time generated: " + executionTime + "time units");
        }

        System.out.println("Starting processes execution with Round Robin algorithm...");

        while (!processQueue.isEmpty()) {
            Process process = processQueue.poll();

            System.out.println("Executing process: " + process.name);

            if (process.remainingTime > quantum) {
                process.remainingTime -= quantum;
                System.out.println(process.name + " did not finish. Remaining time: " + process.remainingTime);

                processQueue.add(process);
            } else {
                System.out.println(process.name + " finished");
            }

            scanner.close();
        }
    }
}