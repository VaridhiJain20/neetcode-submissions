class Solution {
    public int[] findRedundantConnection(int[][] edges) {

        int n= edges.length;

        int[]parent= new int[n+1];
        for(int i=0; i<=n; i++){
            parent[i]=i;
        }
        for(int[]e: edges){
            int u= e[0];
            int v= e[1];
            if(find(u, parent)== find(v, parent)){
                return e;
            }

            union(u,v, parent);
        }

        return null;
    }

    public int find(int n,int[]parent){
        if(parent[n]==n){
            return n;
        }
        parent[n]= find(parent[n], parent);
        return parent[n];
    }

    public void union(int u, int v,int[]parent){
        int ru= find(u, parent);
        int rv= find(v, parent);

        parent[ru]= rv;
    }
}
