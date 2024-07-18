package org.example.uber.section1;


//3. Vote for contestants. Assume contestants are named 'a' to 'z'.
// Votes are coming in the form of string, find the contestant having maximum and minimum votes.
// Ex: Votes = "aaaaaabbccccddddd"   Output: Winner: a and Looser: b
public class VoteCounting {
    public static void main(String[] args) {
        String votes = "aaaaaabbccccddddddd";
        char[] result = findWinnerAndLooser(votes);
        System.out.println("Winner is: "+result[0]);
        System.out.println("Looser is: "+ result[1]);

    }

    private static char[] findWinnerAndLooser(String votes) {
        int[] voteCount = new int[26];

        for(int i = 0; i< votes.length(); i++){
            char currentChar = votes.charAt(i);
            voteCount[currentChar - 'a']++;
        }

        char winner = 'a';
        char looser = 'a';
        int maxVote = voteCount[0];
        int minVote = voteCount[0];

        for(int i = 1; i < 26; i++){
            if(maxVote < voteCount[i]){
                maxVote = voteCount[i];
                winner = (char) (i+'a');
            }
            if(minVote > voteCount[i] && voteCount[i] !=0){
                minVote = voteCount[i];
                looser  =  (char) ( i + 'a');
            }
        }
        return new char[]{winner, looser};
    }
}
