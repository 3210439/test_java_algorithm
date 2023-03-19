package programmers.level1;

public class 바탕화면_정리 {

    class Solution {
        public int[] solution(String[] wallpaper) {

            char[][] charArray = new char[wallpaper.length][];

            for(int i=0; i< wallpaper.length; i++){
                charArray[i] = wallpaper[i].toCharArray();
            }

            int a = Integer.MAX_VALUE, b = Integer.MAX_VALUE;
            int c = Integer.MIN_VALUE, d = Integer.MIN_VALUE;

            for(int i=0; i< charArray.length; i++){
                for(int j=0; j< charArray[i].length; j++){
                    if(charArray[i][j] == '#'){
                        a = Math.min(a,i);
                        b = Math.min(b,j);
                        c = Math.max(c,i);
                        d = Math.max(d,j);
                    }
                }
            }

            return new int[] {a, b, c+1, d+1};
        }
    }

    public static void main(String[] args){

    }
}
