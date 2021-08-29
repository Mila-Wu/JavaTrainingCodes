package concurrent.homework;

public class CalculateUtils {

    public static Integer fibo(int a) {
        if ( a < 2)
            return 1;
        return fibo(a-1) + fibo(a-2);
    }
}
