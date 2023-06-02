public class App {
    public static void main(String[] args) throws Exception {
        trie t=new trie();
        t.append("hello");
        System.out.println(t.search("hello"));
    }
}
class node{
    boolean check;
    node [] children;
    node(){
        check=false;
        children=new node[26];
    }
}
class trie{
    node root=new node();
    public void append(String word){
        node curr=root;
        for(int i=0;i<word.length();i++){
            int idx=word.charAt(i)-'a';
            if(curr.children[idx]==null){
                curr.children[idx]=new node();
            }
            if(idx==word.length()-1){
                curr.children[idx].check=true;
            }
            curr=curr.children[idx];
        }
    }
    public boolean search(String word){
        node curr=root;
        for(int i=0;i<word.length();i++){
            int idx=word.charAt(i)-'a';
            if(curr.children[idx]==null){
                return false;
            }
            if(idx==word.length() && curr.children[idx].check==false){
                return false;
            }
            curr=curr.children[idx];
        }
        return true;
    }
}
