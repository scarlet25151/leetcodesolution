import java.util.Arrays;

public class KConcatenationMaximumSum {
    int mod  = (int) Math.pow(10,9)+7;
    public int kConcatenationMaxSum(int[] ar, int k) {
        long kadanes= kadanesAlgo(ar);
        if(k==1){
            return (int)kadanes;
        }
        long prefixSum= prefixSum(ar);
        long suffixSum=suffixSum(ar);
        long sum=0;
        for (int i1 : ar) {
            sum += i1;
        }
        if(sum>0){
            return (int)(Math.max(((sum*(k-2))%mod+suffixSum%mod+prefixSum%mod)%mod,kadanes%mod));
        }
        else{
            return (int)(Math.max((prefixSum%mod+suffixSum%mod)%mod,kadanes%mod));
        }

    }
    public  long kadanesAlgo(int[] ar){

        long currentSum=0;
        long maxSum=Integer.MIN_VALUE;
        for(int i=0;i<ar.length;i++){
            currentSum=currentSum>0?(currentSum+ar[i])%mod:ar[i];
            maxSum=Math.max(currentSum,maxSum);
        }
        return maxSum<0?0:maxSum%mod;

    }


    public  long prefixSum(int[] ar){

        long currentSum=0;
        long maxSum=Integer.MIN_VALUE;
        for(int i=0;i<ar.length;i++){
            currentSum= (currentSum+ar[i])%mod;
            maxSum=Math.max(maxSum,currentSum);
        }
        return maxSum;


    }

    public  long suffixSum(int[] ar){


        long currentSum=0;
        long maxSum=Integer.MIN_VALUE;
        for(int i=ar.length-1;i>=0;i--){
            currentSum=(currentSum+ar[i])%mod;
            maxSum=Math.max(currentSum,maxSum);
        }
        return maxSum;

    }

}
