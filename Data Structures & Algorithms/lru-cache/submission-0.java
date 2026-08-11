class LRUCache {

    public class node{
        int key;
        int val;
        node next;
        node prev;

        public node(int k, int v){
            key=k;
            val=v;
        }
    }

    int capacity;
    HashMap<Integer, node> map;
    node tail;
    node head;

    public LRUCache(int capacity) {
     this.capacity= capacity;
     map= new HashMap<>();
     tail= new node(-1,-1);
     head= new node(-1,-1);

     head.next=tail;
     tail.prev= head;   
    }
    
    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }
        node n= map.get(key);
         n.next.prev= n.prev;
            n.prev.next= n.next;

            n.next=head.next;
            head.next=n;
            n.prev=head;
            n.next.prev=n;

        return n.val;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            node n= map.get(key);
            n.val= value;
            n.next.prev= n.prev;
            n.prev.next= n.next;

            n.next=head.next;
            head.next=n;
            n.prev=head;
             n.next.prev=n;

            return;
        }

       
        if(map.size()==capacity){
            map.remove(tail.prev.key);
            
            tail.prev.prev.next= tail;
            tail.prev= tail.prev.prev;
        }

        node nn= new node(key, value);
        nn.next=head.next;
        nn.prev=head;
        nn.next.prev=nn;
        head.next=nn;
    map.put(key, nn);
        
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */