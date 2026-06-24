package Week1.FinancialForecasting;

public class FinancialForecaster {

    public double forecastConstant(double currentValue, double growthRate, int periodsAhead) {
        if (periodsAhead == 0) {
            return currentValue;
        }
        double nextValue = currentValue * (1 + growthRate); // i used the recurrence formula, it was pretty ambiguous in
                                                            // the document, so i ended using this
        return forecastConstant(nextValue, growthRate, periodsAhead - 1);
    }

    public double forecastVariable(double currentValue, double[] historicalRates) {
        return forecastVariable(currentValue, historicalRates, 0);
    }

    private double forecastVariable(double currentValue, double[] rates, int index) { // if we know the rates series
                                                                                      // like all the rates are not
                                                                                      // constant
        if (index == rates.length) {
            return currentValue;
        }
        double nextValue = currentValue * (1 + rates[index]); // again base value + the current growth in the value
                                                              // based on the growth rate
        return forecastVariable(nextValue, rates, index + 1);
    }

    public static void main(String[] args) {
        FinancialForecaster forecaster = new FinancialForecaster();

        double initial = 100000;
        double rate = 0.05;
        int periods = 3;

        double constantResult = forecaster.forecastConstant(initial, rate, periods);
        System.out.println("constant 5% growth rate for 3 years for the initisl of 100000: " + constantResult);

        double[] historicalRates = { 0.04, 0.06, 0.05 };
        double variableResult = forecaster.forecastVariable(initial, historicalRates);
        System.out.println("varying rates [4%, 6%, 5%]: " + variableResult);
    }
}
