// For Problems 1 and 2

public class Loops {  // O(1)

    public static int f01() {
        int sum = 0;
        for (int i = 0; i < 1000; i++) {
            sum++;
        }
        return sum;
    }


    public static int f02(int n) { // O(n)
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum++;
        }
        return sum;
    }


    public static int f03(int n) { // n squared
        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sum++;
            }
        }
        return sum;
    }


    public static int f04(int n) { // n
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum++;
        }
        for (int j = 0; j < n; j++) {
            sum++;
        }
        return sum;
    }


    public static int f05(int n) { // n cubed
        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    sum++;
                }
            }
        }
        return sum;
    }


    public static int f06(int n) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n*n; j++) {
                sum++;
            }
        }
        return sum;
    }


    public static int f07(int n) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 100*i; j++) {
                sum++;
            }
        }
        return sum;
    }


    // Assume n is a multiple of 2
    public static int f08(int n) {
        int sum = 0;
        for (int i = 1; i < n; i = i*2) {
            sum++;
        }
        return sum;
    }


    public static int f09(int n) {
        int sum = 0;
        for (int i = n; i > 0; i = i/2) { //log base 2 n
            sum++;
        }
        return sum;
    }


    public static int f10(int n) {
        int sum = 0;
        for (int i = 1; i < n; i = i*10) { // log base 10 n
            sum++;
        }
        return sum;
    }

}