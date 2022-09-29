package codingTestReady;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static java.lang.Integer.parseInt;

class Solution {

    static String[][] graph = new String[51][51];
    static String[][] merge = new String[51][51];
    static boolean[][] visit = new boolean[51][51];
    static List<String> list = new ArrayList<>();

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static void dfs_update(String value, int x, int y, String id){
        visit[x][y] = true;
        graph[x][y] = value;

        for(int i=0; i<4; i++){
            int nx = x+dx[i];
            int ny = y+dy[i];
            if( 0 <= nx && nx < graph.length){
                if(0 <= ny && ny < graph.length){
                    if(merge[nx][ny] == null) merge[nx][ny] = " ";
                    if(visit[nx][ny] == false && merge[nx][ny].equals(id)){
                        dfs_update(value, nx, ny, id);
                    }
                }
            }
        }
    }

    static void dfs_merge(int x, int y, String id1, String id2, String value){
        if(merge[x][y] == null) merge[x][y] = " ";

        visit[x][y] = true;
        merge[x][y] = id1;
        graph[x][y] = value;

        for(int i=0; i<4; i++){
            int nx = x+dx[i];
            int ny = y+dy[i];
            if( 0 <= nx && nx < graph.length){
                if(0 <= ny && ny < graph.length){
                    if(visit[nx][ny] == false){
                        if(merge[nx][ny] == null) merge[nx][ny] = " ";


                        if(merge[nx][ny].equals(id1) || merge[nx][ny].equals(id2)) {
                            dfs_merge(nx, ny, id1, id2, value);
                        }
                    }
                }
            }
        }
    }

    static void dfs_unmerge(int x, int y, String id1){
        visit[x][y] = true;
        merge[x][y] = " ";

        for(int i=0; i<4; i++){
            int nx = x+dx[i];
            int ny = y+dy[i];
            if( 0 <= nx && nx < graph.length){
                if(0 <= ny && ny < graph.length){
                    if(visit[nx][ny] == false){
                        if(merge[nx][ny].equals(id1)) {
                            dfs_unmerge(nx, ny, id1);
                        }
                    }
                }
            }
        }
    }

    public static String[] solution(String[] commands) {
        String[] answer = {};

        for(int i=1; i< merge.length; i++){
            for(int j=1; j<merge.length; j++){
                merge[i][j] = " ";
                graph[i][j] = " ";
            }
        }


        for(String command : commands){
            queryExcute(command);
        }

        if(!list.isEmpty()){
            answer = list.toArray(String[]::new);
        }


        return answer;
    }

    static void print(String querys){
        String[] query = querys.split(" ");
        int x = parseInt(query[1]);
        int y = parseInt(query[2]);
        list.add(graph[x][y]);
    }

    public static boolean isNumeric(String s) {
        try {
            parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    static void update(String querys){
        String[] query = querys.split(" ");

        if(isNumeric(query[1])) {
            int x = parseInt(query[1]);
            int y = parseInt(query[2]);
            graph[x][y] = query[3];
            dfs_update(query[3], x, y, merge[x][y]);
        }
        else{
            for(int i=1; i< graph.length; i++){
                for(int j=1; j<graph.length; j++){
                    if(query[1].equals(graph[i][j]))
                        graph[i][j] = query[2];
                }
            }
        }
    }

    static void setMerge(String querys){
        String[] query = querys.split(" ");
        int x = parseInt(query[1]);
        int y = parseInt(query[2]);
        int r = parseInt(query[3]);
        int c = parseInt(query[4]);
        if(merge[x][y] == " " && merge[r][c] == " "){
            merge[x][y] = String.valueOf(UUID.randomUUID());
            merge[r][c] = String.valueOf(UUID.randomUUID());

            if(graph[x][y] != " "){
                graph[r][c] = graph[x][y];
            }
            else if(graph[r][c] != " "){
                graph[x][y] = graph[r][c];
            }

        } else{

            if(graph[x][y] != " "){
                graph[r][c] = graph[x][y];
            }
            else if(graph[r][c] != " "){
                graph[x][y] = graph[r][c];
            }

            if(merge[x][y] != " "){
                dfs_merge(x, y, merge[x][y], merge[r][c], graph[x][y]);
            }else{
                dfs_merge(x, y, merge[r][c], merge[x][y], graph[x][y]);
            }
        }

    }

    static void setUnmerge(String querys){
        String[] query = querys.split(" ");
        int x = parseInt(query[1]);
        int y = parseInt(query[2]);
        String temp = graph[x][y];
        dfs_unmerge(x,y,merge[x][y]);
        graph[x][y] = temp;
    }

    static void queryExcute(String querys){
        if(querys.contains("UPDATE")){
            update(querys);
        }

        else if(querys.contains("UNMERGE")){
            setUnmerge(querys);
        }
        else if(querys.contains("MERGE") && !querys.contains("UNMERGE")){
            setMerge(querys);
        }
        else if(querys.contains("PRINT")){
            print(querys);

        }

    }


    public static void main(String[] args) {
        String [] strs = {"UPDATE 1 1 menu", "UPDATE 1 2 category", "UPDATE 2 1 bibimbap", "UPDATE 2 2 korean", "UPDATE 2 3 rice", "UPDATE 3 1 ramyeon", "UPDATE 3 2 korean", "UPDATE 3 3 noodle", "UPDATE 3 4 instant", "UPDATE 4 1 pasta", "UPDATE 4 2 italian", "UPDATE 4 3 noodle", "MERGE 1 2 1 3", "MERGE 1 3 1 4", "UPDATE korean hansik", "UPDATE 1 3 group", "UNMERGE 1 4", "PRINT 1 3", "PRINT 1 4"};
        solution(strs);
    }
}