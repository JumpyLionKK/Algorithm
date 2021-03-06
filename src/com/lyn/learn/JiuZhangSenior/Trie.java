package com.lyn.learn.JiuZhangSenior;

import java.util.HashMap;

class TrieNode {
    char c;
    HashMap<Character, TrieNode> children = new HashMap<Character, TrieNode>();
    boolean hasWord;

    public TrieNode() {

    }

    public TrieNode(char c){
        this.c = c;
    }
}
public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word){
        TrieNode cur = root;
        HashMap<Character, TrieNode> curChildren = root.children;
        char[] wordArray = word.toCharArray();
        for(int i = 0; i < wordArray.length; i++){
            char wc = wordArray[i];
            if(curChildren.containsKey(wc)){
                cur = curChildren.get(wc);
            }else {
                TrieNode newNode = new TrieNode(wc);
                curChildren.put(wc, newNode);
                cur = newNode;
            }
            curChildren = cur.children;
            if(i == wordArray.length - 1){
                cur.hasWord = true;
            }

        }
    }

    public boolean search(String word){
        if(searchWordNodePos(word) == null){
            return false;
        }else if(searchWordNodePos(word).hasWord){
            return true;
        }else {
            return false;
        }
    }

    public TrieNode searchWordNodePos(String s){
        HashMap<Character, TrieNode> children = root.children;
        TrieNode cur = null;
        char[] sArray = s.toCharArray();
        for(int i = 0; i < sArray.length; i++){
            char c = sArray[i];
            if(children.containsKey(c)){
                cur = children.get(c);
                children = cur.children;
            }else {
                return null;
            }
        }
        return cur;
    }

}
