package dmytro.haiovyi.encoder;

public class Solution {
    public static void main(String[] args) {
        for (int i = 0; i < /*Integer.MAX_VALUE*/65535; i++) {
            if (i % 20 == 0) {
                System.out.println();
            }
            System.out.print("(" + (char)i + "|" + i + ")" + " ");
        }
    }
}