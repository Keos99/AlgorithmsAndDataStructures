package GeekUniversity.Java.Lesson1HW;

public class Algoritm {
    long minnumber = 0;

    public long standartPow(long number, long degree){
        long answer = number;
        for (long i = degree; i > 1 ; i-- ){
            answer *= number;
        }
        return answer;
    }

    public long fastPow (long number, long degree){
        long answer = 0;
        if (degree == 0) {
            return 1;
        } else if (degree == 1){
            return number;
        } else if ((degree % 2) == 0) {
            answer = fastPow(number, degree / 2);
            answer *= answer;
        } else if ((degree % 2) == 1){
            answer = fastPow(number, (degree - 1)/2);
            answer = answer * answer * number;
        }
        return answer;
    }

    public long minNumber (long[] array){
        long min = 0;
        for (int i = 0; i < array.length; i++) {
            if (i == 0){
                min = array[i];
            } else if (array[i] < min){
                min = array[i];
            }
        }
        return  min;
    }

    public long recursMinNumber (long[] array, int arraylenth){
        if (arraylenth == 1) {
            return minnumber;
        }
        if (array.length == arraylenth){
            minnumber = array[arraylenth - 1];
        } else if (array[arraylenth-1] < minnumber){
            minnumber = array[arraylenth - 1];
        }
        return recursMinNumber(array,arraylenth - 1);
    }

    public double avgNumber(long[] array){
        double sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        return sum / array.length;
    }
}
