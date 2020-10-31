package MyHashMap_706;


import UtilDesign.Bucket;


import java.util.ArrayList;
import java.util.List;

/**
 * 不使用任何内建的哈希表库设计一个哈希映射
 * 具体地说，你的设计应该包含以下的功能
 * put(key, value)：向哈希映射中插入(键,值)的数值对。如果键对应的值已经存在，更新这个值。
 * get(key)：返回给定的键所对应的值，如果映射中不包含这个键，返回-1。
 * remove(key)：如果映射中存在这个键，删除这个数值对。
 *
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
public class MyHashMap {

    private int key_Space;
    private List<Bucket> hash_table;

    /** Initialize your data structure here. */
    public MyHashMap() {

        this.key_Space=2069;
        this.hash_table=new ArrayList<>();
        for (int i = 0; i < key_Space; i++) {
            this.hash_table.add(new Bucket());
        }
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {

        int hash_key=key%key_Space;
        this.hash_table.get(hash_key).update(key,value);
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int hash_key=key%key_Space;
        return this.hash_table.get(hash_key).get(key);
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int hash_key=key%key_Space;
        this.hash_table.get(hash_key).remove(key);
    }

}
