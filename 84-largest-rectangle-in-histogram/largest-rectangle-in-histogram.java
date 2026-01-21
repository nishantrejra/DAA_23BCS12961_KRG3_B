class Solution {
    public static int[] leftNearest(int[] arr){
        Stack<Integer> s = new Stack<>();
        int [] left = new int[arr.length];

        for(int i = 0 ; i < arr.length ; i++){
            while( !s.isEmpty() && arr[s.peek()] >= arr[i] ){
                s.pop();
            }
            left[i] = s.isEmpty()? -1 : s.peek();
            s.push(i);
        }

        return left;
    }

    public static int[] rightNearest(int[] arr){
        Stack<Integer> s = new Stack<>();
        int [] right = new int[arr.length];

        for(int i = arr.length -1 ; i >= 0 ; i--){
            while( !s.isEmpty() && arr [s.peek()] >= arr[i] ){
                s.pop();
            }
            right[i] = s.isEmpty()? arr.length : s.peek();
            s.push(i);
        }

        return right;
    }

    public int largestRectangleArea(int[] arr) {
        int[] left = leftNearest(arr);
        int[] right = rightNearest(arr);
        int maxArea = 0;

        for(int i = 0 ; i < arr.length ; i++){
            int width = right[i] - left[i] -1;
            int currArea = arr[i] * width;
            maxArea = Math.max(currArea,maxArea);
        }
        return maxArea;
    }
}