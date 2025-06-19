package financialforecasting;

public class ForecastTool {

    // Recursive method to calculate future value
    public static double futureValueRecursive(double initialValue, double growthRate, int year) {
        if (year == 0) return initialValue;
        return futureValueRecursive(initialValue, growthRate, year - 1) * (1 + growthRate);
    }

    // Optimized using memoization to avoid recomputation
    public static double futureValueMemo(double initialValue, double growthRate, int year, double[] memo) {
        if (year == 0) return initialValue;
        if (memo[year] != 0.0) return memo[year];
        memo[year] = futureValueMemo(initialValue, growthRate, year - 1, memo) * (1 + growthRate);
        return memo[year];
    }

    public static void main(String[] args) {
        double initialValue = 1000.0; // initial investment
        double growthRate = 0.10; // 10% growth
        int year = 5;

        // Simple recursive
        double future1 = futureValueRecursive(initialValue, growthRate, year);
        System.out.println("Future Value (Recursive): ₹" + future1);

        // Optimized recursive (memoization)
        double[] memo = new double[year + 1];
        double future2 = futureValueMemo(initialValue, growthRate, year, memo);
        System.out.println("Future Value (Memoized): ₹" + future2);
    }
}
