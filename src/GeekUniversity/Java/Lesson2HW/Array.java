package GeekUniversity.Java.Lesson2HW;

public class Array {
    private int[] arr;
    private int size;
    private boolean isSorted;

    private Array() {
        isSorted = false;
    }

    public Array(int size) {
        this();
        this.size = 0;
        arr = new int[size];
    }

    public Array(int... args) { // int[] args = new int[args.length];
        this();
        size = args.length;
        arr = args;
    }

    public boolean isSorted() {
        return isSorted;
    }

    public int length() {
        return size;
    }

    public int get(int index) {
        if (index < 0 || index >= size)
            throw new ArrayIndexOutOfBoundsException("WTF!");
        return arr[index];
    }

    public void set(int index, int value) {
        if (index < 0 || index >= size)
            throw new ArrayIndexOutOfBoundsException("WTF!");
        arr[index] = value;
    }

    public void append(int value) {
        if (size >= arr.length - 1) {
            int[] temp = arr;
            arr = new int[size * 2];
            System.arraycopy(temp, 0, arr, 0, size);
        }
        arr[size++] = value;
    }

    public boolean remove() {
        if (size == 0)
            return false;
        size--;
        return true;
    }

    // homework
    public boolean delete(int index) {
        if (index > size || index <= -1) return false;
        for (int i = index; i < size; i++) {
            if (i <= size){
                arr[i] = arr[i + 1];
            }
        }
        remove();
        return true;
    }

    public boolean deleteAll(int value) {
        boolean isallgood = false;
        for (int i = 0; i < size; i++) {
            if(arr[i] == value) {
                delete(i);
                i--;
                isallgood = true;
            }
        }
        return isallgood;
    }

    public boolean deleteAll() {
        if (size == 0) return false;
        size = 0;
        return true;
    }

    public boolean isInArray(int value) {
        for (int i = 0; i < size; i++) {
            if (arr[i] == value) {
                return true;
            }
        }
        return false;
    }
    // k << n == k * 2 ^ n
// k >> n == k / 2 ^ n
    public int find(int value) {
        if (!isSorted)
            throw new RuntimeException("Trying to search in unsorted array");
        int l = 0;
        int r = size;
        int m;
        while (l < r) {
            m = (l + r) >> 1; // 8 = 00001000 >> 2 = 00000010 = 2
            if (value == arr[m]) {
                return m;
            } else {
                if (value < arr[m]) {
                    r = m;
                } else {
                    l = m + 1;
                }
            }
        }
        return -1;
    }

    private void swap(int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    private void quickSort(int min, int max) {
        if (arr.length == 0)
            return;

        if (min >= max)
            return;

        int middle = arr[min + (max - min) / 2];

        int i = min, j = max;
        while (i <= j) {
            while (arr[i] < middle) {
                i++;
            }

            while (arr[j] > middle) {
                j--;
            }

            if (i <= j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }

        if (min < j)
            quickSort(min, j);

        if (max > i)
            quickSort(i, max);
    }

    public void sortBubble() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size - 1; j++) {
                if (arr[j] > arr[j + 1])
                    swap(j, j + 1);

            }
        }
        isSorted = true;
    }

    public void sortSelect() {
        int f;
        for (int i = 0; i < size; i++) {
            f = i;
            for (int j = i + 1; j < size; j++) {
                if (arr[j] < arr[f])
                    f = j;
            }
            swap(i, f);
        }
        isSorted = true;
    }

    public void countSort() {
        int[] countArray = new int[arr.length];
        int k;
        for(int i = 0; i < arr.length; i++) {
            k = 0;
            for(int j = 0; j < arr.length; j++) {
                if(arr[i] > arr[j]) {
                    k++;
                }
            }
            countArray[k] = arr[i];
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = countArray[i];
        }
    }

    private void displayArray(int[] a)
    {
        for(int i = 0; i < a.length; i++)
            System.out.println(a[i] + " ");
    }

    public void sortInsert() {
        for (int i = 1; i < size; i++) {
            int temp = arr[i];
            int j = i;
            while (j > 0 && arr[j - 1] >= temp) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = temp;
        }
        isSorted = true;
    }

    @Override
    public String toString() {
        int iMax = size - 1;
        if (iMax == -1)
            return "[]";

        StringBuilder b = new StringBuilder();
        b.append('[');
        for (int i = 0; ; i++) {
            b.append(arr[i]);
            if (i == iMax)
                return b.append(']').toString();
            b.append(", ");
        }
    }
}