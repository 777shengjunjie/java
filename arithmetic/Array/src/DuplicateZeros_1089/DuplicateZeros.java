package DuplicateZeros_1089;

/**
 * 给你一个长度固定的整数数组arr，
 * 请你将该数组中出现的每个零都复写一遍，并将其余的元素向右平移。
 * 注意：请不要在超过该数组长度的位置写入元素。
 * 要求：请对输入的数组就地进行上述修改，不要从函数返回任何东西。
 */
public class DuplicateZeros {

    public static void main(String[] args) {
        int[] arr={1,0,2,3,0,4,5,0};
        new DuplicateZeros().duplicateZeros(arr);
    }

    public void duplicateZeros(int[] arr) {

        int dups=0;
        int length=arr.length-1;
        for (int left=0;left<=length-dups;left++){
            if (arr[left]==0){
                if (left==length-dups){
                    arr[length]=0;
                    length-=1;
                    break;
                }
                dups++;
            }
        }

        int last=length-dups;

        for (int i=last;i>=0;i--){
            if (arr[i]==0){
                arr[i+dups]=0;
                dups--;
                arr[i+dups]=0;
            }else {
                arr[i+dups]=arr[i];
            }
        }

        for (int i : arr) {
            System.out.println(i);
        }
    }
}
