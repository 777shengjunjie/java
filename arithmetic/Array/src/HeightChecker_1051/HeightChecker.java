package HeightChecker_1051;

/**
 * 学校在拍年度纪念照时，一般要求学生按照 非递减 的高度顺序排列。
 * 请你返回能让所有学生以 非递减 高度排列的最小必要移动人数。
 * 注意，当一组学生被选中时，他们之间可以以任何可能的方式重新排序，
 * 而未被选中的学生应该保持不动。
 */
public class HeightChecker {

    public static void main(String[] args) {
        int[] heights={1,1,4,2,1,3};
        int result=new HeightChecker().heightChecker(heights);
        System.out.println(result);
    }

    public int heightChecker(int[] heights) {
        int[] arr = new int[101];
        int count=0;
        for (int i = 0; i < heights.length; i++) {
            arr[heights[i]]++;
        }
        for (int i = 1,j=0; i < arr.length; i++) {
            while (arr[i]-->0){
                if (heights[j++]!=i) count++;
            }
        }
        return count;
    }
}
