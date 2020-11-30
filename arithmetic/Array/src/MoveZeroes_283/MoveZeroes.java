package MoveZeroes_283;


/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 */
public class MoveZeroes {

    public static void main(String[] args) {

        int[] nums={0,1,0,3,12};
        new MoveZeroes().moveZeroes(nums);
    }

    public void moveZeroes(int[] nums){

        int pre=0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]!=0){
                nums[pre]=nums[i];
                pre++;
            }
        }
        for (int i = pre ; i < nums.length; i++) {
            nums[i]=0;
        }

        for (int num : nums) {
            System.out.println(num);
        }
    }

    public void moveZeroes2(int[] nums)  {
        int length;
        if (nums == null || (length = nums.length) == 0) {
            return;
        }
        int j = 0;
        for (int i = 0; i < length; i++) {
            if (nums[i] != 0) {
                if (i > j) {// #1
                    nums[j] = nums[i];
                    nums[i] = 0;
                }
                j++;
            }
        }
    }

    /**
     * 这里参考了快速排序的思想，快速排序首先要确定一个待分割的元素做中间点x，
     * 然后把所有小于等于x的元素放到x的左边，大于x的元素放到其右边。
     * nums[i]!=0，我们就交换nums[i]和nums[j]
     * @param nums
     */
    public void moveZeroes3(int[] nums) {
        if(nums==null) {
            return;
        }
        //两个指针i和j
        int j = 0;
        for(int i=0;i<nums.length;i++) {
            //当前元素!=0，就把其交换到左边，等于0的交换到右边
            if(nums[i]!=0) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j++] = tmp;
            }
        }
    }

}
