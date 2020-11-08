package SearchInsert_35;


/**
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。
 * 如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 你可以假设数组中无重复元素。
 */
public class SearchInsert {

    public static void main(String[] args) {
        int[] nums={1,3,5,6};
        int target=0;
        int result=new SearchInsert().searchInsert2(nums,target);
        System.out.println(result);
    }

    public int searchInsert(int[] nums,int target){
        if (target<=nums[0]) return 0;

        for (int i = 1; i < nums.length; i++) {
           if (nums[i]==target) return i;
           else if (nums[i-1]<target&&nums[i]>target){
               return i;
           }
        }
        return nums.length;
    }

    public int searchInsert2(int[] nums,int target){

       int n=nums.length;
       int left=0,right=n-1,ans=n;
       while (left<=right){
           int mid=((right-left)>>1)+left;
           if (target<=nums[mid]){
               ans=mid;
               right=mid-1;
           }else {
               left=mid+1;
           }
       }
       return ans;


    }
}
