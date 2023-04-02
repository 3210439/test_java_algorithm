package programmers.level3;

import org.jetbrains.annotations.NotNull;

import java.util.*;

public class 베스트앨범 {

    static class Solution {
        public int[] solution(String[] genres, int[] plays) {
            int[] answer = {};
            List<Integer> answerList = new ArrayList<>();

            List<Genre> list = new ArrayList();

            for(int i=0; i< genres.length; i++){
                addGenre(genres[i], new Song(i, plays[i]), list);
            }

            Collections.sort(list);

            for(Genre g : list){
                Collections.sort(g.list);
                for(Song s : g.list){
                    answerList.add(s.index);
                }
            }

            answer = answerList.stream().mapToInt(Integer::intValue).toArray();

            return answer;
        }

        void addGenre(String name, Song song, List<Genre> list){
            boolean result = false;
            for(Genre g : list){
                if(g.genreName.equals(name)) {
                    g.addSong(song);
                    result = true;
                }
            }
            if(!result){
                list.add(new Genre(name, song));
            }
        }


        class Genre implements Comparable<Genre>{
            int total = 0;
            String genreName;
            List<Song> list = new ArrayList<>();

            Genre(String genreName, Song song){
                this.genreName = genreName;
                list.add(song);
            }

            @Override
            public int compareTo(@NotNull Genre o) {
                if(this.total > o.total) return -1;
                else return 1;
            }

            void addSong(Song song){

                if(list.size() ==2){
                    int minIndex = 1;
                    if(list.get(0).play < list.get(1).play) minIndex = 0;
                    if(list.get(minIndex).play < song.play){
                        total -= list.get(minIndex).play;
                        list.remove(minIndex);
                        total += song.play;
                        list.add(song);
                    }
                } else{
                    total += song.play;
                    list.add(song);
                }

            }

        }

        class Song implements Comparable<Song>{
            int index;
            int play;

            Song(int index, int play){
                this.play = play;
                this.index = index;
            }

            @Override
            public int compareTo(@NotNull Song o) {
                if(this.play > o.play) return -1;
                else if(this.play == o.play) {
                    if(this.index > o.index) return 1;
                    else return -1;
                }
                else return 1;
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] genres = {"classic", "pop", "classic", "pop", "classic", "classic"};
        int[] plays = {400, 600, 150, 2500, 500, 500};
        System.out.println(solution.solution(genres, plays));
    }
}
