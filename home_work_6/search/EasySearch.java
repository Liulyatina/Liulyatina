package home_work_6.search;

import home_work_6.ISearchEngine;

import java.util.Set;

public class EasySearch implements ISearchEngine {

    private Set<Character> splitChar = Set.of(
            ',', ';', '!',
            '.', ':', '\'',
            '"', ')', '(',
            ' ', '-'
    );

    @Override
    public long search(String text, String word) {
        int lengthWord = word.length();
        long count = 0;

        int position = -1;
        while ((position = text.indexOf(word, position)) > -1){
            if(checkSplitChar(text, position - 1) && checkSplitChar(text, position + lengthWord)){
                count++;
            }
            position += lengthWord;
        }
        return count;
    }

    private boolean checkSplitChar(String text, int position){
        if(position < 0){
            return true;
        }
        if(position >= text.length()){
            return true;
        }

        if(!checkSpecialSplitChar(text, position)){
            return false;
        }

        return splitChar.contains(text.charAt(position));
    }
    private boolean checkSpecialSplitChar(String text, int position){
        char charAt = text.charAt(position);

        if(charAt == '-'){
            int nextCheckLetter = position - 1;
            if(nextCheckLetter >= 0){
                char nextCharAt = text.charAt(nextCheckLetter);
                if(nextCharAt == '-' || Character.isLetter(nextCharAt)){
                    return false;
                }
            }
        }

        return true;
    }
}
