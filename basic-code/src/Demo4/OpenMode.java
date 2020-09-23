package Demo4;

import java.util.ArrayList;
import java.util.Objects;

public class OpenMode<M> {



    <O> void divide(O o)
    {

    };

    M  str;

    public M getStr() {
        return str;
    }

    public void setStr(M str) {
        this.str = str;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OpenMode<?> openMode = (OpenMode<?>) o;
        return Objects.equals(str, openMode.str);
    }

    @Override
    public int hashCode() {
        return Objects.hash(str);
    }

    public static void main(String[] args) {

        ArrayList<String> a=new ArrayList<>();

        test(a);

    }

    public static void test(ArrayList<?> e){


        for (Object i:e){
            System.out.println(i);
        }


    }


}
