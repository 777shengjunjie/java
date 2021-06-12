package Search_53_1;

public class Search {

    public static void main(String[] args) {

    }


    public int search(int[] nums, int target) {
        if (nums.length == 0) return 0;
        int count = 0;
        int begin = 0, end = nums.length - 1;
        int middle = (begin + end) / 2;
        while (nums[middle] != target) {
            if (begin >= end) return 0;
            if (nums[middle] > target) {
                end = middle - 1;
            } else {
                begin = middle + 1;
            }
            middle = (begin + end) / 2;
        }
        int pre = middle - 1, host = middle + 1;
        count++;
        if (pre >= 0) {
            while (nums[pre] == target) {
                count++;
                pre -= 1;
                if (pre < 0) break;
            }
        }
        if (host < nums.length) {
            while (nums[host] == target) {
                count++;
                host++;
                if (host >= nums.length) break;
            }
        }


        return count;
    }
}
