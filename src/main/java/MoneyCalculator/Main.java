package MoneyCalculator;

public class Main {
    public static void main(String[] args) {
        CurrencyLoader loader = new FileCurrencyLoader("loadertest.txt");
        System.out.println(loader.load());
    }
}
