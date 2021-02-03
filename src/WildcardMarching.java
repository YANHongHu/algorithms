/**
 * 给定一个字符串 (s) 和一个字符模式 (p) ，实现一个支持 '?' 和 '*' 的通配符匹配。
 * '?' 可以匹配任何单个字符。
 * '*' 可以匹配任意字符串（包括空字符串）。
 * 两个字符串完全匹配才算匹配成功。
 *
 * 说明:
 * s 可能为空，且只包含从 a-z 的小写字母。
 * p 可能为空，且只包含从 a-z 的小写字母，以及字符 ? 和 *。
 *
 * 示例 1:
 * 输入:
 * s = "aa"
 * p = "a"
 * 输出: false
 * 解释: "a" 无法匹配 "aa" 整个字符串。
 *
 * 示例 2:
 * 输入:
 * s = "aa"
 * p = "*"
 * 输出: true
 * 解释: '*' 可以匹配任意字符串。
 *
 * 示例 3:
 * 输入:
 * s = "cb"
 * p = "?a"
 * 输出: false
 * 解释: '?' 可以匹配 'c', 但第二个 'a' 无法匹配 'b'。
 *
 * 示例 4:
 * 输入:
 * s = "adceb"
 * p = "*a*b"
 * 输出: true
 * 解释: 第一个 '*' 可以匹配空字符串, 第二个 '*' 可以匹配字符串 "dce".
 *
 * 示例 5:
 * 输入:
 * s = "acdcb"
 * p = "a*c?b"
 * 输入: falsed
 */
public class WildcardMarching {
    public static void main(String[] args) {
        String s = "adceb";
        String p = "*a*b";
        System.out.println(isMatch(s, p));
    }

    /**
     * 动态规划
     * 执行用时：44 ms
     * 内存消耗：39.1 MB
     * @param s
     * @param p
     * @return
     */
    public static boolean isMatch(String s, String p){
        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        for(int i = 0; i<=s.length();i++){
            for (int j = 0;j<=p.length();j++){
                if (i==0&&j==0){
                    dp[i][j]=true;
                }else if (i == 0){
                    if (p.charAt(j-1)=='*') {
                        dp[i][j] = dp[i][j-1];
                    }
                }else if (j == 0) {
                    dp[i][j]=false;
                }else {
                    if (p.charAt(j-1)=='?'){
                        dp[i][j]=dp[i-1][j-1];
                    }else if (s.charAt(i-1)==p.charAt(j-1)){
                        dp[i][j]=dp[i-1][j-1];
                    }else if (p.charAt(j-1)=='*') {
                        dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                    }
                }
            }
        }
        return dp[s.length()][p.length()];
    }

}
