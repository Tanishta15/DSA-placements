class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
    }
}

class Solution {
    private static final long MOD = 1_000_000_007;

    public long multiplyTwoLists(Node first, Node second) {
        Node l1 = first;
        Node l2 = second;
        long m = 0;
        long n = 0;

        while (l1 != null) {//formation of first number
            m = (m * 10 + l1.data) % MOD;
            l1 = l1.next;
        }

        while (l2 != null) {//formation of second number
            n = (n * 10 + l2.data) % MOD;
            l2 = l2.next;
        }

        return (m * n) % MOD;
    }
}