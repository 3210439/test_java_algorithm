package programmers.level2;

import java.util.Arrays;

public class 전화번호목록 {

    class Solution {
        public boolean solution(String[] phone_book)
        {

            Arrays.sort(phone_book);

            String beforeString = "x";
            for(String phone: phone_book){
                if(phone.startsWith(beforeString)) return false;
                if(beforeString.startsWith(phone)) return false;
                beforeString = phone;
            }

            return true;
        }
    }
}
