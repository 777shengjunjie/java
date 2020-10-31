package UtilDesign;


import java.util.LinkedList;

public class BucketSet {

        private LinkedList<Integer> container;

        public BucketSet() {
        this.container = new LinkedList<>();
    }

    public void insert(Integer key){

            int index=container.indexOf(key);
            if (index==-1){
                container.add(key);
            }

    }

    public void delete(Integer key){
            container.remove(key);
    }

    public boolean exists(Integer key){
            int index=container.indexOf(key);
            return (index!=-1);
    }
}
