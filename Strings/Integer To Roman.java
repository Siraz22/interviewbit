public class Solution {

    public String intToRoman(int A) {

        int[] number = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] roman = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        String answer = "";        

        for(int i=0;i<number.length;++i)
            while(A >= number[i]){
                //System.out.println("adding "+number[i]);
                answer+=roman[i];
                A -= number[i];
            }
        }return answer;
}}