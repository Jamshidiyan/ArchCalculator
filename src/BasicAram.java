public class BasicAram {
    static void calcCPI() {
        System.out.print("Clock Cycles: "); double cc = ArchCalculator.sc.nextDouble();
        System.out.print("Instructions: "); double ic = ArchCalculator.sc.nextDouble();
        System.out.printf("CPI = %.4f%n", cc / ic);
    }
    static void calcIPC() {
        System.out.print("CPI: "); double cpi = ArchCalculator.sc.nextDouble();
        System.out.printf("IPC = %.4f%n", 1.0 / cpi);
    }

    // CPU Time = IC × CPI / ClockRate
    static void calcCPUTime() {
        System.out.print("Instruction Count: "); double ic = ArchCalculator.sc.nextDouble();
        System.out.print("CPI: "); double cpi = ArchCalculator.sc.nextDouble();
        System.out.print("Clock Rate (Hz): "); double cr = ArchCalculator.sc.nextDouble();
        System.out.printf("CPU Time = %.6f seconds%n", ic * cpi / cr);
    }

    // S(N) = 1 / (alpha + (1-alpha)/N)
    static void calcAmdahl() {
        System.out.print("Serial fraction (α, 0-1): "); double alpha = ArchCalculator.sc.nextDouble();
        System.out.print("Number of processors (N): "); int n = ArchCalculator.sc.nextInt();
        System.out.printf("Speedup S(%d) = %.4f%n", n, 1.0 / (alpha + (1.0 - alpha) / n));
    }

    // S(∞) = 1/alpha
    static void calcMaxSpeedup() {
        System.out.print("Serial fraction (α, 0-1): "); double alpha = ArchCalculator.sc.nextDouble();
        System.out.printf("Max Speedup S(∞) = %.4f%n", 1.0 / alpha);
    }

    // Pipeline cycle time = max(stages) + register overhead
    static void calcPipelineCycleTime() {
        System.out.print("Number of pipeline stages: "); int n = ArchCalculator.sc.nextInt();
        double max = 0;
        for (int i = 1; i <= n; i++) {
            System.out.print("Stage " + i + " time (ns): "); double t = ArchCalculator.sc.nextDouble();
            if (t > max) max = t;
        }
        System.out.print("Register overhead (ns): "); double overhead = ArchCalculator.sc.nextDouble();
        double cycleTime = max + overhead;
        System.out.printf("Pipeline Cycle Time = %.2f ns%n", cycleTime);
    }

    // Pipeline Speedup = T_unpipelined / T_pipelined_cycle
    static void calcPipelineSpeedup() {
        System.out.print("Unpipelined execution time (ns): "); double tu = ArchCalculator.sc.nextDouble();
        System.out.print("Pipeline cycle time (ns): "); double tp = ArchCalculator.sc.nextDouble();
        System.out.printf("Pipeline Speedup = %.4f×%n", tu / tp);
    }

    // Actual CPI = Ideal CPI + Stall CPI
    static void calcActualCPI() {
        System.out.print("Ideal CPI: "); double ideal = ArchCalculator.sc.nextDouble();
        System.out.print("Stall CPI: "); double stall = ArchCalculator.sc.nextDouble();
        System.out.printf("Actual CPI = %.4f%n", ideal + stall);
    }

    // Exec Time = IC × Actual CPI × Pipeline Cycle Time
    static void calcExecTime() {
        System.out.print("Instruction Count: "); double ic = ArchCalculator.sc.nextDouble();
        System.out.print("Actual CPI: "); double cpi = ArchCalculator.sc.nextDouble();
        System.out.print("Pipeline Cycle Time (ns): "); double ct = ArchCalculator.sc.nextDouble();
        System.out.printf("Execution Time = %.2f ns%n", ic * cpi * ct);
    }

    static void calcEffectiveAddress() {
        System.out.print("Base register value: "); long base = ArchCalculator.sc.nextLong();
        System.out.print("Offset (immediate): "); long offset = ArchCalculator.sc.nextLong();
        System.out.printf("Effective Address = %d (0x%X)%n", base + offset, base + offset);
    }

    static void calcJumpTarget() {
        System.out.print("PC (current instruction address): "); long pc = ArchCalculator.sc.nextLong();
        System.out.print("Instruction[25:0] (jump field): "); long jumpField = ArchCalculator.sc.nextLong();
        long pcPlus4 = pc + 4;
        long target = (pcPlus4 & 0xF0000000L) | ((jumpField & 0x3FFFFFFL) << 2);
        System.out.printf("Jump Target = %d (0x%X)%n", target, target);
    }
}
