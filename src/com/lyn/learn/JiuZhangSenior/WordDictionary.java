package com.lyn.learn.JiuZhangSenior;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class WordDictionary {
    class TrieNode{
        public Map<Character, TrieNode> children;
        public boolean hasWord;
        public TrieNode() {
            children = new HashMap<>();
            hasWord = false;
        }
    }
    TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode cur = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            TrieNode nextNode = cur.children.get(c);
            if(nextNode == null){
                nextNode = new TrieNode();
                cur.children.put(c, nextNode);

            }
            cur = nextNode;
        }
        cur.hasWord = true;

    }

    public boolean search(String word){
        Queue<TrieNode> nexts = new LinkedList<>();
        nexts.add(root);
        int index = 0;
        while(!nexts.isEmpty()){
            int size = nexts.size();
            char c = word.charAt(index);
            boolean flag = false;
            for(int i = 0; i < size; i++){
                TrieNode cur = nexts.poll();
                if(c == '.'){
                    for(TrieNode tempNode: cur.children.values()){
                        nexts.add(tempNode);
                        flag |=tempNode.hasWord;
                    }
                }else if(cur.children.containsKey(c)){
                    TrieNode nextNode = cur.children.get(c);
                    flag |= nextNode.hasWord;
                    nexts.add(nextNode);
                }

            }
            index ++;
            if(index >= word.length()) return flag;
        }
        return false;
    }

}
