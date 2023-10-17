class Solution {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        Set<Integer> uniqueNode = new HashSet();
        for(int left : leftChild){
            if(left!=-1)
                uniqueNode.add(left);
        }
        for(int right : rightChild){
            if(right!=-1)
                uniqueNode.add(right);
        }
        int rootNode = -1;
        for(int i=0; i<n; i++){
            if(uniqueNode.contains(i))
                continue;
            rootNode = i;
            break;
        }
        if(rootNode==-1){
            return false;
        }
        Queue<Integer> queue = new LinkedList();
        Set<Integer> visitedSet = new HashSet();
        queue.add(rootNode);
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size>0){
                int node = queue.poll();
                if(visitedSet.contains(node))
                    return false;
                visitedSet.add(node);
                if(leftChild[node]!=-1){
                    queue.add(leftChild[node]);
                }
                if(rightChild[node]!=-1){
                    queue.add(rightChild[node]);
                }
                size--;
            }
        }
        return visitedSet.size()==n;
    }


}