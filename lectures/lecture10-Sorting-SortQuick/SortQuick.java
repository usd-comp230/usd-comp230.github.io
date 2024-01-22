public class SortQuick {
  public static void swap(String[] array, int i1, int i2) {
    String temp = array[i1];
    array[i1] = array[i2];
    array[i2] = temp;
  }
  public static int partition(String[] array, int low, int high) {
	  
	  // Version for you to fill out :) see Sort.java for solution
	  return 0; // placeholder
	  
    
  }

  // QuickSort
  public static void qsort(String[] array, int low, int high) {
    
  }

  public static void sort(String[] array) {
    qsort(array, 0, array.length);
  }
}