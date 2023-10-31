package home_work_4;

import java.util.Comparator;

public class StringLengthComparator implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        if(o1 == o2){
            return 0;
        }

        if(o1 == null && o2 != null){
            return 1;
        }

        if(o1 != null && o2 == null){
            return -1;
        }

        if(o1.length() == o2.length()){
            return 0;
        }

        if(o1.length() < o2.length()){
            return -1;
        }

        return 1;
    }
}