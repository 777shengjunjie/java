package Trap_17;

public class Trap {

    public static void main(String[] args) {
        int[] trap={0,1,0,2,1,0,1,3,2,1,2,1};
        int result=new Trap().trap(trap);
    }

    public int trap(int[] height) {
        int sum=0;
        for (int i : height) {
            sum+=i;
        }
        int volume=0;
        int high=1;
        int left=0;
        int right=height.length-1;
        while (left<=right){
            while (left<=right&&height[left]<high){
                left++;
            }
            while (left<=right&&height[right]<high){
                right--;
            }
            volume+=right-left+1;
            high++;
        }

        return volume-sum;


    }



}
