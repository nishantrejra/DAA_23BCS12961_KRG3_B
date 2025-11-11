class Solution {
public:
    double answer(double x, long n){
        if(n == 0){
            return 1;
        }
        else if(n == 1){
            return x;
        }
        else if(n<0){
            n = n*(-1);
            return 1/ answer(x,n);
        }

        if(n% 2 == 1){
            return x * answer(x*x, (n-1)/2);
        }
        else{
            return answer(x*x, n/2);
        }
    }

    double myPow(double x, int n) {
        return answer(x,n);
    }
};