package SearchMatrix_74;

public class SearchMatrix {

    public static void main(String[] args) {
        int[][] ans={
                {1,3,5,7},
        {10,11,16,20},
        {23,30,34,60}

        };
        boolean res=new SearchMatrix().searchMatrix(ans,13);

    }


    public boolean searchMatrix(int[][] matrix, int target) {
        int end=matrix.length-1;

        int begin=-1;
        while (begin<end){
            int mid= (end-begin+1)/2+begin;
            if (matrix[mid][0] <= target) {
                begin = mid;
            } else {
                end = mid - 1;
            }
        }

        if (begin<0){
            return false;
        }

        return isExist(matrix[begin],target);

    }


    public boolean isExist(int[] matrix,int target){
        int end = matrix.length-1;
        int begin = 0;
        while (begin<=end){

            int mid = (end - begin) / 2 + begin;
            if (target==matrix[mid]){
                return true;
            }else if (target<matrix[mid]){
                end=mid-1;
            }else if(target>matrix[mid]){
                begin=mid+1;
            }
        }
        return false;
    }
}
