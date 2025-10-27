class Solution {
    public ArrayList<ArrayList<Integer>> kSmallestPair(int[] arr1, int[] arr2, int k) {
        // code here
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        if (arr1.length == 0 || arr2.length == 0 || k == 0) return ans;

        // Min-heap storing [arr1[i], arr2[j], j]
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> (a[0] + a[1]) - (b[0] + b[1])
        );

        // Push first element of arr2 with each arr1[i]
        for (int i = 0; i < arr1.length && i < k; i++) {
            pq.offer(new int[]{arr1[i], arr2[0], 0});
        }

        while (k-- > 0 && !pq.isEmpty()) {
            int[] cur = pq.poll();
            int num1 = cur[0], num2 = cur[1], j = cur[2];

            ArrayList<Integer> pair = new ArrayList<>();
            pair.add(num1);
            pair.add(num2);
            ans.add(pair);

            // Push next pair with arr2[j + 1]
            if (j + 1 < arr2.length) {
                pq.offer(new int[]{num1, arr2[j + 1], j + 1});
            }
        }

        return ans;
    }
}
