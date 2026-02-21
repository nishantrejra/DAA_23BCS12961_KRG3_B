class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0 || ((x % 10 == 0) && (x != 0))) //negative, last digit zero
            return false;

        int rev = 0;
        while (x > rev) { // no need to reverse whole number
            rev = rev * 10 + (x % 10);
            x /= 10;
        }

        return (x == rev || x == rev / 10); // for both odd and even
    }
}


// class Solution {
//     public boolean isPalindrome(int x) {
//         if (x < 0 || ((x % 10 == 0) && (x != 0)))
//             return false;

//         int rev = 0;
//         int n = x;
//         while (n > rev) {
//             rev = rev * 10 + (n % 10);
//             n /= 10;
//         }

//         if (n == rev || n == rev / 10) {
//             return true;
//         }

//         return false;
//     }
// }