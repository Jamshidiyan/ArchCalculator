import java.util.Scanner;

public class ArchCalculator {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n=== Computer Architecture Calculator ===");
            System.out.println("1)  CPI");
            System.out.println("2)  IPC");
            System.out.println("3)  CPU Time");
            System.out.println("4)  Speedup (Amdahl's Law)");
            System.out.println("5)  Max Speedup (Amdahl)");
            System.out.println("6)  Pipeline Cycle Time");
            System.out.println("7)  Pipeline Speedup");
            System.out.println("8)  Actual CPI (with stalls)");
            System.out.println("9)  Execution Time (pipeline)");
            System.out.println("10) Load/Store Effective Address");
            System.out.println("11) Jump Target Address");
            System.out.println("0)  exit");
            System.out.print("select: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 0 -> { return; }
                case 1 -> BasicAram.calcCPI();
                case 2 -> BasicAram.calcIPC();
                case 3 -> BasicAram.calcCPUTime();
                case 4 -> BasicAram.calcAmdahl();
                case 5 -> BasicAram.calcMaxSpeedup();
                case 6 -> BasicAram.calcPipelineCycleTime();
                case 7 -> BasicAram.calcPipelineSpeedup();
                case 8 -> BasicAram.calcActualCPI();
                case 9 -> BasicAram.calcExecTime();
                case 10 -> BasicAram.calcEffectiveAddress();
                case 11 -> BasicAram.calcJumpTarget();
                default -> System.out.println("select invalid choice");
            }
        }
    }


}