package MyHashSet_705;


import UtilDesign.BucketSet;

import java.util.ArrayList;
import java.util.List;

/**
 * 不使用任何内建的哈希表库设计一个哈希集合
 * 具体地说，你的设计应该包含以下的功能
 * add(value)：向哈希集合中插入一个值。
 * contains(value) ：返回哈希集合中是否存在这个值。
 * remove(value)：将给定值从哈希集合中删除。如果哈希集合中没有这个值，什么也不做
 */
public class MyHashSet {

    private int keyRange;
    private List<BucketSet> bucket;

    public static void main(String[] args) {
        MyHashSet hashSet = new MyHashSet();
        hashSet.add(1);
        hashSet.add(2);
        hashSet.contains(1); // 返回 true
        hashSet.contains(3); // 返回 false (未找到)
        hashSet.add(2);
        hashSet.contains(2);// 返回 true
        hashSet.remove(2);
        hashSet.contains(2); // 返回  false (已经被删除)


    }

    /** Initialize your data structure here. */
    public MyHashSet() {
        keyRange=2069;
        bucket=new ArrayList<>();
        for (int i = 0; i < keyRange; i++) {
            this.bucket.add(new BucketSet());
        }
    }

    public void add(int key) {

        int setKey=key%keyRange;
        this.bucket.get(setKey).insert(key);

    }

    public void remove(int key) {
        int setKey=key%keyRange;
        this.bucket.get(setKey).delete(key);

    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int setKey=key%keyRange;
        return this.bucket.get(setKey).exists(key);
    }


}
