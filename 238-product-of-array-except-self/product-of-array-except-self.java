class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] product = new int[nums.length];
        int[] leftProduct = new int[nums.length];
        int[] rightProduct = new int[nums.length];

        leftProduct[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            leftProduct[i] = leftProduct[i - 1] * nums[i - 1];
        }

        rightProduct[nums.length - 1] = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            rightProduct[i] = rightProduct[i + 1] * nums[i + 1];
        }

        for (int i = 0; i < nums.length; i++) {
            product[i] = leftProduct[i] * rightProduct[i];
        }

        return product;
    }
}

// class Solution {
//     public int[] productExceptSelf(int[] nums) {
//         int[] product = new int[nums.length];
//         int[] leftProduct = new int [nums.length];
//         int[] rightProduct = new int [nums.length];

//         leftProduct[0] = 1;
//         for(int i = 1 ;i < nums.length ; i++){
//             leftProduct[i] = nums[i-1]*leftProduct[i-1];
//         }

//         rightProduct[nums.length -1] = 1;
//         for(int i = nums.length -2 ;i >= 0 ; i--){
//             rightProduct[i] = nums[i+1]*rightProduct[i+1];
//         }

//         for(int i = 0;i<product.length;i++){
//             product[i] = leftProduct[i] * rightProduct[i];
//         }

//         return product;
//     }
// }

// Brute Force Solution for small Array O(n^2)
// class Solution {
//     public int[] productExceptSelf(int[] nums) {
//         int[] product = new int[nums.length];
//         for(int i = 0 ; i < nums.length ; i++){
//             product[i] = 1;
//             for(int j = 0 ; j < nums.length; j++){
//                 if(j != i){
//                     product[i] *= nums[j];
//                 }
//             }
//         }
//         return product;
//     }
// }