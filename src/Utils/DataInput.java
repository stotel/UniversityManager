package Utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public final class DataInput {

    public static Long getLong(String text) throws IOException{
        String s = getString(text);
        Long value = Long.valueOf(s);
        return value;
    }

    public static char getChar(String text) throws IOException{
        String s = getString(text);
        if(s.isEmpty()){
            return getChar("пустий рядок не дозволено, спробуйте ще раз!");
        }
        return s.charAt(0);
    }

    public static Integer getInt(String text){
        String s = "";
        Integer value;
        try {
            s = getString(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            value = Integer.valueOf(s);
        }catch (Exception e){
            getInt("Це не ціле число!, спробуйте ще раз");
            value = 0;
        }
        return value;

    }
    public static Integer getInt(String text,int lowerBound, int upperBound){
        String s = "";
        Integer value = 0;
        try {
            s = getString(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            value = Integer.valueOf(s);
        }catch (Exception e){
            getInt("Це не ціле число!, спробуйте ще раз");
        }
        if(value<lowerBound||value>upperBound){
            value = getInt("Число не входить в межі ("+lowerBound+";"+upperBound+")",lowerBound,upperBound);
        }
        return value;
    }

    public static String getString(String text) throws IOException{
        System.out.println(text);
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }

}
