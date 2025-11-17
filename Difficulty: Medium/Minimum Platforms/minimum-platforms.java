class Solution {
    public int minPlatform(int[] arr, int[] dep) {
    Arrays.sort(arr);
    Arrays.sort(dep);

    int i = 0, j = 0;
    int platforms = 0, maxPlatforms = 0;

    while (i < arr.length && j < dep.length) {

        if (arr[i] <= dep[j]) { 
            platforms++;
            maxPlatforms = Math.max(maxPlatforms, platforms);
            i++;
        } else {                 
            platforms--;
            j++;
        }
    }
    return maxPlatforms;
}

}
