class WordDictionary {
    public class node{
    char c;
    HashMap<Character, node> children= new HashMap<>();
    boolean isWord;
}
node root;

    public WordDictionary() {
         root= new node();
         root.c='*';
    }

    public void addWord(String word) {
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
        return search2(word, root);
     }

    public boolean search2(String word, node root){
node nn= root;


        for(int i=0; i<word.length();i++){
            char ch= word.charAt(i);
            if(ch=='.'){
                
                for(char child: nn.children.keySet()){
                    // if(i==word.length()-1){
                    //     return true;
                    // }
                    boolean b= search2(word.substring(i+1,word.length()),nn.children.get(child));
                    if(b){
                        return true;
                    }
                }
                return false;
            }
            if(nn.children.containsKey(ch)){
                nn= nn.children.get(ch);
            }
            else{
               return false;
            }
        }
        return nn.isWord; 
    }}

