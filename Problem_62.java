class Solution {
    public String getPermutation(int n, int k) {
        // Step 1: Build the list of numbers from 1 to n
        java.util.List<Integer> numbers = new java.util.ArrayList<>();
        for (int i = 1; i <= n; i++) {
            numbers.add(i);
        }

        // Step 2: Precompute factorials
        int[] fact = new int[n + 1];
        fact[0] = 1;
        for (int i = 1; i <= n; i++) {
            fact[i] = fact[i - 1] * i;
        }

        // Step 3: Convert k to zero-based index
        k--;

        // Step 4: Build the permutation string
        StringBuilder result = new StringBuilder();
        for (int i = n; i >= 1; i--) {
            int index = k / fact[i - 1];
            result.append(numbers.get(index));
            numbers.remove(index);
            k %= fact[i - 1];
        }

        return result.toString();
    }

    // Quick test
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.getPermutation(3, 3)); // Output: "213"
        System.out.println(sol.getPermutation(4, 9)); // Output: "2314"
        System.out.println(sol.getPermutation(3, 1)); // Output: "123"
    }
}
