package linear;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liuzhongxu
 * @date 2020/4/22
 */
public class TestString {

    /**
     * 3. 无重复字符的最长子串
     * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
     *
     * 示例 1:
     *
     * 输入: "abcabcbb"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     * 示例 2:
     *
     * 输入: "bbbbb"
     * 输出: 1
     * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
     * 示例 3:
     *
     * 输入: "pwwkew"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        int maxLen = 0;
        if (null == s || s.length() == 0) {
            return maxLen;
        }
        if (s.length() == 1) {
            return 1;
        }
        System.out.println(s);
        char[] str = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0, j = 0; i < str.length && j < str.length; j++) {
            if (map.containsKey(str[j])) {
                i = map.get(str[j]) > i ? map.get(str[j]) : i;
            }
            int len = j - i + 1;
            if (len > maxLen) {
                maxLen = len;
            }
            map.put(str[j], j + 1);
            System.out.println("i=" + i + " c=" + str[i] + " j=" + j + " c=" + str[j] + " mlen=" + maxLen);
        }
        return maxLen;
    }

    @Test
    public void testLen() {
        String s = "aasdfasdfsdaf";
        int len = lengthOfLongestSubstring(s);
        System.out.println(len);
    }
}
