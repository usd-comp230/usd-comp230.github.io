import java.util.Arrays;

class Swap2 {
    public static void swap_arrays(int[] x, int[] y)
    {
        int[] temp = y;
        y = x;
        x = temp;
    }


    public static void main(String[] args)
    {
        int[] x = {1, 2, 3};
        int[] y = {4, 5, 6};

        Swap2.swap_arrays(x, y);

        System.out.println(x);
        for (int item : x)
            System.out.println(item);

        System.out.println(y);
        for (int item : y)
            System.out.println(item);

        System.out.println(Arrays.toString(x));
        System.out.println(Arrays.toString(y));
    }
}  