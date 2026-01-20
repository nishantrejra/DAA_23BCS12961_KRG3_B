class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[] merged = new int[m + n];

        int i = 0, j = 0, k = 0;

        while (i < m && j < n) {
            if (nums1[i] < nums2[j]) {
                merged[k++] = nums1[i++];
            } else {
                merged[k++] = nums2[j++];
            }
        }

        while (i < m) {
            merged[k++] = nums1[i++];
        }
        while (j < n) {
            merged[k++] = nums2[j++];
        }

        // for (int z = 0; z < merged.length; z++) {
        //     System.out.print(merged[z] + " ");
        // }
        // System.out.println();

        int len = merged.length;
        if (len % 2 == 1) {
            return merged[len / 2]; // odd length
        } else {
            return (merged[(len / 2) - 1] + merged[len / 2]) / 2.0; // even length
        }
    }
}
