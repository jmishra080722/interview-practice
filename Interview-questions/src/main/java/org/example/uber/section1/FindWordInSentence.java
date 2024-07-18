package org.example.uber.section1;

//2. Check whether the given word is present in the sentence.
// Don't use the String out of the box method. You can use the char method.
public class FindWordInSentence {
    public static void main(String[] args) {
        String sentence = "Hello worlds";
        String word = "world";
        boolean isPresent = isWordPresent(sentence, word);
        if(isPresent){
            System.out.println("Word is present");
        }
    }

    private static boolean isWordPresent(String sentence, String word) {
        int sentenceLength = sentence.length();
        int wordLength = word.length();
        if(wordLength > sentenceLength){
            return false;
        }

        for (int i = 0; i <= sentenceLength - wordLength; i++){
            int j;
            for(j = 0; j < wordLength ; j++){
                if(sentence.charAt(i + j) != word.charAt(j)){
                    break;
                }
            }
            if(j == wordLength){
                return true;
            }
        }
        return false;
    }


}
