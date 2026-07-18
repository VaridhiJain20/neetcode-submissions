/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
       if(node== null){
        return null;
       } 
       HashMap<Node, Node> vis= new HashMap<>();
       return clone(node, vis);
      
    }

    public Node clone(Node node, HashMap<Node, Node> vis){
         if(node== null){
        return null;
       } 

       if(vis.containsKey(node)){
        return vis.get(node);
       }


         Node nn =new Node(node.val);
         vis.put(node, nn);

    
        List<Node> nbrs= node.neighbors;

        for(Node nbr:nbrs){
            Node a= clone(nbr, vis);
            nn.neighbors.add(a);
        }

     return nn;
    }
}