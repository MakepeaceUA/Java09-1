public class Main {
    @FunctionalInterface
    interface NumberProcessor
    {
        int process(int number);
    }

    public static void main(String[] args) {
        int[] numbers = {-5, -2, 0, 3, 7, 12, 10, -1, 50};

        int sumGreateThan10 = sumCondition(numbers, n -> (n > 10) ? n : 0);
        System.out.println("1. Сумма чисел > 10: " + sumGreateThan10);

        int а = 0;
        int b = 10;
        int sumOutOfRange = sumCondition(numbers, n -> (n < а || n > b) ? n : 0);
        System.out.println("2. Сумма чисел вне диапазона [" + а + ".." + b + "]: " + sumOutOfRange);

        int sumPositive = sumCondition(numbers, n -> (n > 0) ? n : 0);
        System.out.println("3. Сумма положительных чисел: " + sumPositive);

        int sumNegative = sumCondition(numbers, n -> (n < 0) ? n : 0);
        System.out.println("4. Сумма отрицательных чисел: " + sumNegative);

        int sumDoubled = sumCondition(numbers, n -> n * 2);
        System.out.println("5. Сумма удвоенных элементов массива: " + sumDoubled);
    }

    public static int sumCondition(int[] array, NumberProcessor processor)
    {
        int sum = 0;
        for (int number : array)
        {
            sum += processor.process(number);
        }
        return sum;
    }
}