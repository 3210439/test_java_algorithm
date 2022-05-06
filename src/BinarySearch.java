import java.util.ArrayList;
import java.util.Collections;

public class BinarySearch {
    public boolean searchFunc(ArrayList<Integer> dataList, Integer searchItem){
        if (dataList.size() == 1 && dataList.get(0) == searchItem){
            return true;
        }
        if (dataList.size() == 1 && dataList.get(0) != searchItem){
            return false;
        }
        if (dataList.size() == 0) {
            return false;
        }

        int medium = dataList.size() / 2;

        if (searchItem == dataList.get(medium)){
            return true;
        }else{
            if(searchItem < dataList.get(medium)){
                return searchFunc(new ArrayList<Integer>(dataList.subList(0, medium)), searchItem);
            } else {
                return searchFunc(new ArrayList<Integer>(dataList.subList(medium, dataList.size())), searchItem);
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> testData = new ArrayList<Integer>();

        for (int index = 0; index < 100; index++) {
            testData.add((int)(Math.random() * 100));
        }
        Collections.sort(testData);

        System.out.println(testData);
        BinarySearch binarySearch = new BinarySearch();
        System.out.println(binarySearch.searchFunc(testData, 2));
    }
}
