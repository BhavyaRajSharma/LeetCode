package local.leetcode;

public class MinimumDeletionstoMakeStringKSpecial_3085 {
    public int minimumDeletions(String word, int k) {
        int[] freqMap= new int[26];
        int maxFreq=0;
        for(Character character: word.toCharArray()) {
            freqMap[character-'a']++;
            maxFreq= Math.max(maxFreq, freqMap[character-'a']);
        }
        int minDel=word.length();
        for(int i=0;i<26;i++){
            int temp=0;
            for(int j=0;j<26;j++){
                if(freqMap[j]>0 && freqMap[j]<freqMap[i]){
                    temp+= Math.abs(freqMap[j]);
                }
                if(freqMap[j]>freqMap[i]+k){
                    temp+= Math.abs(freqMap[j]-freqMap[i]-k);
                }
            }
            minDel= Math.min(minDel, temp);
        }
        return minDel;
    }

    public static void main(String[] args) {
        String word="a";
        int k=2;
        System.out.println(new MinimumDeletionstoMakeStringKSpecial_3085().minimumDeletions(word, k));
    }
}
