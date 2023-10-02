class Solution {
    public boolean winnerOfGame(String colors) {
        int aCnt=0,bCnt=0;
        int aTemp=0,bTemp=0;
        for(char c : colors.toCharArray()){
            if(c=='A'){
                bTemp=0;
                aTemp++;
                if(aTemp>=3){
                    aCnt++;
                }
            }
            else{
                aTemp=0;
                bTemp++;
                if(bTemp>=3){
                    bCnt++;
                }
            }
        }
        if(aCnt>bCnt)
            return true;
        else
        return false;
        
    }
}