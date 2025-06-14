package local.leetcode;

public class MaximumNumberofVowelsinaSubstringofGivenLength_1456 {
    public int maxVowels(String s, int k) {
        int max=0;
        int vowelCount=0;
        int i=0;
        while(i<k){
            if(isVowel(s.charAt(i++)))
                vowelCount++;
        }
        max= Math.max(max, vowelCount);
        while (i<s.length()){
            if(isVowel(s.charAt(i-k)))
                vowelCount--;
            if(isVowel(s.charAt(i++)))
                vowelCount++;
            max= Math.max(max, vowelCount);
        }
        return max;
    }
    private boolean isVowel(Character character){
        return character=='a' || character=='e' || character=='i' || character=='o' || character=='u';
    }

    public static void main(String[] args) {
        String s="leetcode";
        int k=3;
        System.out.println(new MaximumNumberofVowelsinaSubstringofGivenLength_1456().maxVowels(s, k));
    }
}
