// 208. Implement Trie (Prefix Tree)

class Trie {
    
    private class TrieNode {
        // R Links to node children
        private TrieNode[] links;
        
        private final int R = 26;
        
        private boolean isEnd;
        
        public TrieNode() {
            links = new TrieNode[R];
        }
        
        public boolean containsKey(char ch) {
            return links[ch - 'a'] != null;
        }
        
        public TrieNode get(char ch) {
            return links[ch - 'a'];
        }
        
        public void put(char ch, TrieNode node) {
            links[ch - 'a'] = node;
        }
        
        public void setEnd() {
            isEnd = true;
        }
        
        public boolean isEnd() {
            return isEnd;
        }
    }
    
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char currentChar = word.charAt(i);
            if (!node.containsKey(currentChar)) {
                node.put(currentChar, new TrieNode());
            }
            node = node.get(currentChar);
        }
        node.setEnd();
    }
    
    /** Returns if the word is in the trie. */
    private TrieNode searchPrefix(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
           char curLetter = word.charAt(i);
           if (node.containsKey(curLetter)) {
               node = node.get(curLetter);
           } else {
               return null;
           }
        }
        return node;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
       TrieNode node = searchPrefix(word);
       return node != null && node.isEnd();
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode node = searchPrefix(prefix);
        return node != null;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */

/*

Trie or predix tree - data structure, which is used for retrieval of a key in a dataset of strings
1. Autocomplete
2. Spell checker
3. IP Routing (Longest prefix matching)
4. Word Games

Balanced Trees and Hash Tables give us the possibility to search for a word in a dataset of strings
Although HashTable has O(1) time complexity looking for a key, not efficient for the following:
- Finding all keys with a common prefix
- Enumerating a dataset of strings in lexicographical order

Also Trie outperforms hash table is that as hash table increases in size, lots of hash collisions
and the time complexity could deterioate to O(n), n keys inserted

Trie could use less space compared to HashTbale when storing many keys with the same prefix
O(M) time complexity, where m is the key length
Search for a key in a balanced tree costs O(m log n) time complexity
*/

/*
Trie node structure

Trie is a rooted tree. Its nodes have the following fields:
- Maximum of R links to its children, where each link corresponds to one of R character values
from dataset alphabet. 
- Boolean field which specifies whether the node coresponds to the end of the key, or is just a 
key prefix
*/


/*
class TrieNode {
    // R links to node children
    private TrieNode[] links;
    
    private final int R = 26;
    
    private boolean isEnd;
    
    public TrieNode() {
        links = new TrieNode[R];
    }
    
    public boolean containsKey(char ch) {
        return links[ch - 'a'] != null;
    }
    
    public TrieNode get(char ch){
        return links[ch - 'a'];
    }
    
    public void put(char ch, TrieNode node) {
        links[ch - 'a'] = node;
    }
    public void setEnd() {
        isEnd = true;
    }
    public boolean isEnd() {
        return isEnd;
    }
}
*/

/*

Insertion of a key to a trie

- Start from the root and search a link -> corresponds to the first key character
(1) Link exists. Move down the tree following the link to the next child level -> continues searching
(2) Link does not exists -> new node and link it with parent's link matching current key cahracter, repeat until last char then we mark the current node as an end node

*/

/*

class Trie {
    private TrieNode root;
    
    public Trie() {
        root = new TrieNode();
    }
    
    // Inserts a word into the trie
    public void insert(String word) {
        TrieNode node = root;
        for(int i = 0; i < word.length(); i++) {
            char currentChar = word.charAt(i);
            if(!node.containsKey(currentChar)) {
                node.put(currentChar, new TrieNode());
            }
            node = node.get(currentChar);
        }
        node.setEnd();
    }
}


class Trie {
    ...

    // search a prefix or whole key in trie and
    // returns the node where search ends
    private TrieNode searchPrefix(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
           char curLetter = word.charAt(i);
           if (node.containsKey(curLetter)) {
               node = node.get(curLetter);
           } else {
               return null;
           }
        }
        return node;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
       TrieNode node = searchPrefix(word);
       return node != null && node.isEnd();
    }
}

class Trie {
    ...

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode node = searchPrefix(prefix);
        return node != null;
    }
}

*/