public class Solution {

    public int[] sieve(int end) {
        int[] primes = new int[end + 1];

        for (int i = 0; i < primes.length; ++i) {
            primes[i] = 1;
        }

        for (int iter = 2; iter <= end; ++iter) {

            if (primes[iter] == 0)
                continue;

            int multiple = iter * 2;
            while (multiple <= end) {
                primes[multiple] = 0; // these are not primes
                multiple += iter;
            }
        }

        return primes;

    }

    public ArrayList<Integer> primesum(int A) {

        int[] primes = sieve(A);
        ArrayList<Integer> answer = new ArrayList<Integer>();

        // for(int i=0;i<primes.length;++i){
        // System.out.print(primes[i]+" ");
        // }
        // System.out.println();

        for (int i = 2; i <= A / 2; ++i) {
            if (primes[i] == 1 && primes[A - i] == 1) {
                answer.add(i);
                answer.add(A - i);
                break;
            }
        }

        return answer;
    }
}
