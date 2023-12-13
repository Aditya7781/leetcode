class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map <Integer, Integer> ai = new HashMap<>();
        Stack <Integer> st = new Stack<>();
        int ans [] = new int[nums1.length];
        for(int i=nums2.length-1; i>=0; i--){
            if(st.isEmpty())
            ai.put(nums2[i], -1);
            if(!st.isEmpty() && st.peek()>nums2[i])
            ai.put(nums2[i], st.peek());
            if(st.size()!=0 && st.peek()<=nums2[i]){
                while(!st.isEmpty() && st.peek()<=nums2[i]){
                    st.pop();
                }
                if(st.isEmpty())
                ai.put(nums2[i], -1);
                else
                ai.put(nums2[i], st.peek());
            }
            st.push(nums2[i]); 
        }
        for(int i=0; i<nums1.length; i++){
            ans[i] = ai.get(nums1[i]);
        }
        return ans;
    }
}