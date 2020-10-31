package UtilDesign;


import java.util.LinkedList;
import java.util.List;


public class Bucket {

    private List<Pair<Integer,Integer>> bucket;

    public Bucket() {

        this.bucket = new LinkedList<>();

    }

    public Integer get(Integer key){
        for (Pair<Integer, Integer> pair : this.bucket) {
            if (pair.first.equals(key))
                return pair.second;
        }

        return -1;
    }


    public void update(Integer key,Integer value){

        boolean found=false;
        for (Pair<Integer, Integer> pair : this.bucket) {
            if (pair.first.equals(key)){
                pair.second=value;
                found=true;
            }
        }

        if (!found){
            this.bucket.add(new Pair<Integer, Integer>(key,value));
        }
    }

    public void remove(Integer key){


        this.bucket.removeIf(pair -> pair.first.equals(key));
      /*  for (Pair<Integer, Integer> pair : this.bucket) {
            if (pair.first.equals(key)){
                this.bucket.remove(pair);
                break;
            }
        }*/
    }

}
