/**
 * Created by Liming Teng on 2018/10/9.
 */

public class Assignment4 {

    /**
     * The deadline of assignment4 is 10/12/2018 23:59 PST.
     * Please feel free to contact Zane and Amanda for any questions.
     */

    /*
     * Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.
     * s = "leetcode" return 0.
     * s = "loveleetcode" return 2.
     */

    public int firstUniqChar(String s) {
        // 1st step: getting the count of all characters in the String
        // 2nd step: compare the input String characters to our key/value pairs.
        // step 1:
        Map<Character, Integer> countMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char letter = s.charAt(i);
            if (countMap.containsKey(letter)) {
                countMap.put(letter, countMap.get(letter) + 1);
            } else {
                countMap.put(letter, 1);
            }
        }
        // step 2:
        for (int i = 0; i < s.length(); i++) {
            char letter = s.charAt(i);
            if (countMap.get(letter) == 1) {
                return i;
            }
        }
        return -1;
    }

    /*
     *Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.
     * Input: 38 Output: 2
     * Explanation: The process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it.
     */
    public int addDigits(int n) {
        int sum = 0;
        while (n != 0) {
            sum = sum + n % 10;
            n = n / 10;
        }
        if (sum >= 10) {
            return addDigits(sum);
        } else {
            return sum;
        }
    }

    /*
     *  Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
     *  Input: [0,1,0,3,12] Output: [1,3,12,0,0]
     */
    public void moveZeroes(int[] nums) {
        // Tow pointers: fast pointer, slow pointer
        // Time: O(n) ; Space: O(N)
        if (nums == null || nums.length == 0) return;
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != 0) {
                nums[slow] = nums[fast];
                slow++;
            }
        }
        for (int i = slow; i < nums.length; i++) {
            nums[i] = 0;
        }
        return;
    }

    /*
     * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
     * Input: "babad" Output: "bab" Note: "aba" is also a valid answer.
     */
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;

    }

    /*
     * You are given an n x n 2D matrix representing an image. Rotate the image by 90 degrees (clockwise).
     * Given input matrix = [ [1,2,3],
                  [4,5,6],
                  [7,8,9] ],
     * rotate the input matrix in-place such that it becomes: [  [7,4,1],
                                 [8,5,2],
                                  [9,6,3] ],
     */
    public int[][] rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - 1 - j];
                matrix[i][n - 1 - j] = temp;
            }
        }
        return matrix;
    }
}
