class PrefixTree {

public class node{
    char c;
    HashMap<Character, node> children= new HashMap<>();
    boolean isWord;
}
node root;
    public PrefixTree() {
         root= new node();
         root.c='*';
    }

    public void insert(String word) {
node nn= root;

        for(char ch: word.toCharArray()){
            if(nn.children.containsKey(ch)){
                nn= nn.children.get(ch);
            }
            else{
                nn.children.put(ch, new node());
                nn= nn.children.get(ch);
            }
        }
        nn.isWord= true;
    }

    public boolean search(String word) {
        node nn= root;

        for(char ch: word.toCharArray()){
            if(nn.children.containsKey(ch)){
                nn= nn.children.get(ch);
            }
            else{
               return false;
            }
        }
        return nn.isWord;
    }

    public boolean startsWith(String prefix) {
 node nn= root;

        for(char ch: prefix.toCharArray()){
            if(nn.children.containsKey(ch)){
                nn= nn.children.get(ch);
            }
            else{
               return false;
            }
        }
        return true;
    }
}
