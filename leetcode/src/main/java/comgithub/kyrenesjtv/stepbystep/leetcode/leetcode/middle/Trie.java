package comgithub.kyrenesjtv.stepbystep.leetcode.leetcode.middle;

/**
 * @ProjectName: stepByStep
 * @Author: AlbertW
 * @CreateDate: 2020/11/4 9:53
 */
public class Trie {
    private Trie root;
    private char val;
    private Boolean isWord = false;
    private Trie[] children = new Trie[26];

    /** Initialize your data structure here. */
    public Trie() {
        root = new Trie();
        root.val = ' ';
    }
    public Trie(char c) {
        Trie trie = new Trie();
        trie.val = ' ';
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        Trie ws = root;
        for(int i = 0 ; i <word.length(); i++){
            char c = word.charAt(i);
            if(ws.children[c - 'a'] == null){
                ws.children[c - 'a'] = new Trie(c);
            }
            ws = ws.children[c - 'a'];
        }
        ws.isWord = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Trie ws = root;
        for(int i = 0 ; i <word.length(); i++){
            char c = word.charAt(i);
            if(ws.children[c - 'a'] == null){
                return false;
            }
            ws = ws.children[c - 'a'];
        }
        return ws.isWord;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Trie ws = root;
        for(int i = 0 ; i <prefix.length(); i++){
            char c = prefix.charAt(i);
            if(ws.children[c - 'a'] == null){
                return false;
            }
            ws = ws.children[c - 'a'];
        }
        return true;
    }

}
