package SortArrayByParityII_922;


/*
难度简单125给定一个非负整数数组 A， A 中一半整数是奇数，一半整数是偶数。

        对数组进行排序，以便当 A[i] 为奇数时，i 也是奇数；当 A[i] 为偶数时，
        i 也是偶数。

        你可以返回任何满足上述条件的数组作为答案。
*/
public class SortArrayByParityII {

    public static void main(String[] args) {


        int[] A = {4, 2, 5, 7};
        int[] result = new SortArrayByParityII().sortArrayByParityII(A);
        for (int i : result) {
            System.out.println(i);
        }
    }

    public int[] sortArrayByParityII(int[] A) {

        int[] ans = new int[A.length];
        int odd = 1;
        int even = 0;

        for (int i = 0; i < A.length; i++) {

            if (A[i] % 2 == 0) {

                ans[even] = A[i];
                even += 2;

            } else {
                ans[odd] = A[i];
                odd+=2;

            }

        }

        return ans;

    }

    public int[] sortArrayByParityII2(int[] A) {
        int j = 1;
        for (int i = 0; i < A.length; i += 2)
            if (A[i] % 2 == 1) {
                while (A[j] % 2 == 1)
                    j += 2;

                // Swap A[i] and A[j]
                int tmp = A[i];
                A[i] = A[j];
                A[j] = tmp;
            }

        return A;
    }


}
