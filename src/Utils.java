import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
public class Utils {
    public static void remove(Object o, Object[] obs){
        int entryIndex = findFirst(o, obs);
        if(entryIndex >= 0) {
            obs[entryIndex] = obs[obs.length - 1];
            obs = Arrays.copyOf(obs, obs.length - 1);
        }
    }
    public static void append(Object[] o1, Object[] o2){
        int s = o1.length-1;
        o1 = Arrays.copyOf(o1,o1.length+o2.length);
        for(int i =0;i<o2.length;i++){
            o1[s+i]=o2[i];
        }
    }
    public static int findFirst(Object o, Object[] obs){
        for (int i = 0; i< obs.length; i++){
            Object a = obs[i];
            if (a.equals(o))
                return i;
        }
        return -1;
    }
    /////
    public static String intArrayToString(int[] arr){
        if(arr.length == 0){
            return("");
        }
        StringBuilder ret = new StringBuilder();
        for(int i = 0;i < arr.length - 1;i++){
            ret.append(arr[i]).append(" ");
        }
        ret.append(arr[arr.length-1]);
        return(ret.toString());
    }
    public static String longArrayToString(long[] arr){
        if(arr.length == 0){
            return("");
        }
        StringBuilder ret = new StringBuilder();
        for(int i = 0;i < arr.length - 1;i++){
            ret.append(arr[i]).append(" ");
        }
        ret.append(arr[arr.length-1]);
        return(ret.toString());
    }
    public static String strArrayToString(String[] arr){
        if(arr.length == 0){
            return("");
        }
        StringBuilder ret = new StringBuilder();
        for(int i = 0;i < arr.length - 1;i++){
            ret.append(arr[i]).append(" ");
        }
        ret.append(arr[arr.length-1]);
        return(ret.toString());
    }
    public static String intMatrixToString(int[][] matrix){
        if(matrix == null){
            return "";
        }
        StringBuilder ret = new StringBuilder();
        for(int i = 0;i< matrix.length;i++){
            ret.append(intArrayToString(matrix[i])+"\n");
        }
        return(ret.toString());
    }
    public static int[] generateRandomIntArray(int length,int lowerBound,int upperBound){
        int[] arr = new int[length];
        Random rand = new Random();
        for(int i = 0;i < arr.length;i++){
            arr[i] = rand.nextInt(upperBound-lowerBound+1)+lowerBound;
        }
        return arr;
    }
    public static String[] typeInStrArray(int length) throws IOException {
        String[] arr = new String[length];
        for(int i = 0;i<arr.length; i++){
            arr[i] = DataInput.getString("Введіть елемент по індексу: і "+i);
        }
        return arr;
    }
    public static String[] typeInStrArray(int length,int minLength) throws IOException {
        String[] arr = new String[length];
        for(int i = 0;i<arr.length; i++){
            while (arr[i]==null||arr[i].length()<minLength){
                arr[i] = DataInput.getString("Введіть елемент по індексу: і "+i);
            }
        }
        return arr;
    }
    public static int[] typeInIntArray(int length){
        int[] arr = new int[length];
        for(int i = 0;i<arr.length; i++){
            arr[i] = DataInput.getInt("Введіть елемент по індексу: і "+i);
        }
        return arr;
    }
    public static int[] typeInArray(int length,int loverBound,int upperBound){
        int[] arr = new int[length];
        for(int i = 0;i<arr.length; i++){
            arr[i] = DataInput.getInt("Введіть елемент по індексу: і "+i,loverBound,upperBound);
        }
        return arr;
    }
    public static int[] typeInArray(int arr[],int start,int finish){
        for(int i = start;i<finish; i++){
            arr[i] = DataInput.getInt("Введіть елемент по індексу: і "+i);
        }
        return arr;
    }
    public static int[] typeInArray(int arr[],int start,int finish,int loverBound,int upperBound){
        for(int i = start;i<finish; i++){
            arr[i] = DataInput.getInt("Введіть елемент по індексу: і "+i,loverBound,upperBound);
        }
        return arr;
    }
    public static int[] generateRandomIntArray(){
        int[] arr = new int[DataInput.getInt("Введіть бажану довжину списку",0,Integer.MAX_VALUE-8)];
        int lowerBound = DataInput.getInt("Введіть найменше значення для згенерованих чисел");
        int upperBound = DataInput.getInt("Введіть найбільше значення для згенерованих чисел");
        Random rand = new Random();
        for(int i = 0;i < arr.length;i++){
            arr[i] = rand.nextInt(upperBound-lowerBound+1)+lowerBound;
        }
        return arr;
    }
    public static int[][] generateRandomMatrix(int length1Dimension,int length2Dimension,int lowerBound,int upperBound){
        int[][] matrix = new int[length1Dimension][length2Dimension];
        Random rand = new Random();
        for (int i = 0;i < matrix.length;i++){
            matrix[i] = generateRandomIntArray(matrix[i].length,lowerBound,upperBound);
        }
        return matrix;
    }
    public static int[][] generateRandomMatrix(int length1Dimension,int length2Dimension){
        int[][] matrix = new int[length1Dimension][length2Dimension];
        int lowerBound = DataInput.getInt("Введіть найменше значення для згенерованих чисел");
        int upperBound = DataInput.getInt("Введіть найбільше значення для згенерованих чисел");
        Random rand = new Random();
        for (int i = 0;i < matrix.length;i++){
            matrix[i] = generateRandomIntArray(matrix[i].length,lowerBound,upperBound);
        }
        return matrix;
    }
    public static int[][] generateRandomMatrix(){
        int[][] matrix = new int[DataInput.getInt("Введіть розмір першого виміру матриці",0,Integer.MAX_VALUE-8)][DataInput.getInt("Введіть розмір другого виміру матриці",0,Integer.MAX_VALUE-8)];
        int lowerBound = DataInput.getInt("Введіть найменше значення для згенерованих чисел");
        int upperBound = DataInput.getInt("Введіть найбільше значення для згенерованих чисел");
        Random rand = new Random();
        for (int i = 0;i < matrix.length;i++){
            matrix[i] = generateRandomIntArray(matrix[i].length,lowerBound,upperBound);
        }
        return matrix;
    }
    public static int[][] typeInMatrix(int length1Dimension,int length2Dimension){
        int[][] matrix = new int[length1Dimension][length2Dimension];
        Random rand = new Random();
        for (int i = 0;i < matrix.length;i++){
            for (int j = 0;j < matrix[i].length; j++){
                matrix[i][j] = DataInput.getInt("Введіть елемент по індексу: і "+i+" j "+j);
            }
        }
        return matrix;
    }
    public static int[][] typeInMatrix(){
        int[][] matrix = new int[DataInput.getInt("Введіть розмір першого виміру матриці",0,Integer.MAX_VALUE-8)][DataInput.getInt("Введіть розмір другого виміру матриці",0,Integer.MAX_VALUE-8)];
        for (int i = 0;i < matrix.length;i++){
            for (int j = 0;j < matrix[i].length; j++){
                matrix[i][j] = DataInput.getInt("Введіть елемент по індексу: і "+i+" j "+j);
            }
        }
        return(matrix);
    }
    public static int[][] generateOrTypeInMatrix() throws IOException {
        switch (DataInput.getString("Згенерувати матрицю/заповнити вручну|(1/2)")){
            case "1":
                return(generateRandomMatrix());
            case "2":
                return (typeInMatrix());
            default:
                System.out.println("невірне значення, спробуйте ще раз");
                generateOrTypeInMatrix();
                break;
        }
        return null;
    }
    public static int[][] generateOrTypeInMatrix(int dimension1,int dimension2) throws IOException {
        switch (DataInput.getString("Згенерувати матрицю/заповнити вручну|(1/2)")){
            case "1":
                return(generateRandomMatrix(dimension1,dimension2));
            case "2":
                return (typeInMatrix(dimension1,dimension2));
            default:
                System.out.println("невірне значення, спробуйте ще раз");
                generateOrTypeInMatrix(dimension1,dimension2);
                break;
        }
        return null;
    }
    public static int[][] changeMatrixAxes(int[][] initial){
        if(initial.length == 0){
            return(new int[0][]);
        }else if(initial[0].length == 0){
            return(new int[0][]);
        }
        int[][] matrix = new int[initial[0].length][initial.length];
        for (int i = 0;i < initial.length;i++){
            for (int j = 0;j < initial[i].length; j++){
                matrix[j][i] = initial[i][j];
            }
        }
        return matrix;
    }
    public static int[][] rearrangeMatrix(int[][] initial,int[] keys){
        if(initial.length == 0){
            return(new int[0][]);
        }else if(initial[0].length == 0){
            return(new int[0][]);
        }
        int[][] matrix = new int[initial.length][initial[0].length];
        for(int i = 0; i <keys.length; i++){
            int ind = getIndexMinFromArray(keys);
            keys[ind]=Integer.MAX_VALUE;
            matrix[i] = initial[ind];
        }
        return matrix;
    }
    public static int getIndexMinFromArray(int[] arr)
    {
        int res = 0;
        for (int i = 0; i < arr.length; i++)
            if(arr[res]>arr[i]){
                res = i;
            }
        return res;
    }
    public static int getMinFromArray(int[] arr)
    {
        int res = 0;
        for (int i = 0; i < arr.length; i++)
            if(res>arr[i]){
                res = arr[i];
            }
        return res;
    }
    public static int getIndexMaxFromArray(int[] arr)
    {
        int res = 0;
        for (int i = 0; i < arr.length; i++)
            if(arr[res]<arr[i]){
                res = i;
            }
        return res;
    }
    public static int getMaxFromArray(int[] arr)
    {
        int res = 0;
        for (int i = 0; i < arr.length; i++)
            if(res<arr[i]){
                res = arr[i];
            }
        return res;
    }
    public static int arraySum(int[] arr){
        int sum = 0;
        for(int i = 0;i<arr.length;i++){
            sum += arr[i];
        }
        return sum;
    }
    public static int[] mergeSort(int[] arr){
        return(sortArray(arr,0,arr.length - 1));
    }
    public static int[] mergeSortReversed(int[] arr){
        return(reverseIntArray(sortArray(arr,0,arr.length - 1)));
    }

    public static boolean isIntArraySorted(int[] arr){
        for(int i = 0;i<arr.length-1;i++){
            if(arr[i]>arr[i+1]){
                return false;
            }
        }
        return true;
    }
    public static int[] reverseIntArray(int[] arr){
        int[] ret = new int[arr.length];
        for(int i = 0; i< ret.length;i++){
            ret[i] = arr[arr.length-1-i];
        }
        return ret;
    }
    private static int[] sortArray(int[] arr,int left,int right){
        if(left<right){
            int middle = left+(right-left)/2;
            sortArray(arr,left,middle);
            sortArray(arr,middle+1,right);

            mergeArray(arr,left,middle,right);
        }
        return arr;
    }
    private static void mergeArray(int[] arr,int left,int middle,int right){
        int leftArrLength = middle-left + 1;
        int rightArrLength = right - middle;
        int[] leftTempArr = new int[leftArrLength];
        int[] rightTempArr = new int[rightArrLength];
        int i,j = 0;

        for (i = 0; i<leftArrLength;++i){
            leftTempArr[i] = arr[left+i];
        }
        for (j = 0; j<rightArrLength;++j){
            rightTempArr[j] = arr[middle+1+j];
        }

        i = 0;
        j = 0;
        int k = left;

        while (i<leftArrLength&&j<rightArrLength){
            if(leftTempArr[i]<=rightTempArr[j]){
                arr[k++] = leftTempArr[i++];
            } else {
                arr[k++] = rightTempArr[j++];
            }
        }
        while (i < leftArrLength){
            arr[k++] = leftTempArr[i++];
        }
        while (j < rightArrLength){
            arr[k++] = rightTempArr[j++];
        }
    }
}
