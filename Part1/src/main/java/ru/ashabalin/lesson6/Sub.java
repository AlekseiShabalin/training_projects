package ru.ashabalin.lesson6;

/**
 * Created by Aleksei Shabalin on 01.07.2016.
 */
public class Sub {
    /*
    * метод contains определяет содержится ли подстрока в строке;
    * переменная result содержит результат поискаа подстроки в строке;
    * tempSub приведение подстроки к массиву типа char;
    * tempOrigin приведение строки к массиву типа char;
    * переменная j счетчик соответствия символов подстроки в строке;
    */
    public boolean contains(String origin, String sub){
        boolean result = false;
        char[] tempSub = sub.toCharArray();
        char[] tempOrigin = origin.toCharArray();
        int j = 0;

            for ( int i = 0; i < tempOrigin.length; i++) {
                if(j < tempSub.length){
                    if(tempSub[j] == tempOrigin[i]){
                        result = true;
                        j++;
                    }else{
                        result = false;
                        j = 0;
                    }
                }
            }
        return result;
    }

    public static void main(String[] args){
        String subString = "dg";
        String originString = "abcdfgcde";

        Sub subTest = new Sub();
        boolean result = subTest.contains(originString, subString);
            if(result == true) {
                System.out.printf("String origin %s contains sub string %s", originString, subString);
            }else{
                System.out.printf("String origin %s does not contains sub string %s", originString, subString);
            }
        }
}
