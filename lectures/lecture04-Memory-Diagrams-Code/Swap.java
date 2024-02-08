class Swap {
    public static void swap_primitives(int x, int y)
    {
        int temp = y;
        y = x;
        x = temp;
    }


    public static void main(String[] args)
    {
        int x = 10;
        int y = 8;
        Swap.swap_primitives(x, y);
        System.out.println(x);
        System.out.println(y);
    }
}