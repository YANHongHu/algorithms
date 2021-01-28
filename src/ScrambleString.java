
/**
 * 给定一个字符串 s1，我们可以把它递归地分割成两个非空子字符串，从而将其表示为二叉树。
 * 下图是字符串 s1 = "great" 的一种可能的表示形式。
 *     great
 *    /    \
 *   gr    eat
 *  / \    /  \
 * g   r  e   at
 *            / \
 *           a   t
 *
 * 在扰乱这个字符串的过程中，我们可以挑选任何一个非叶节点，然后交换它的两个子节点。
 * 例如，如果我们挑选非叶节点 "gr" ，交换它的两个子节点，将会产生扰乱字符串 "rgeat" 。
 *     rgeat
 *    /    \
 *   rg    eat
 *  / \    /  \
 * r   g  e   at
 *            / \
 *           a   t
 *
 * 我们将 "rgeat” 称作 "great" 的一个扰乱字符串。
 * 同样地，如果我们继续将其节点 "eat" 和 "at" 进行交换，将会产生另一个新的扰乱字符串 "rgtae" 。
 *     rgtae
 *    /    \
 *   rg    tae
 *  / \    /  \
 * r   g  ta  e
 *        / \
 *       t   a
 *
 * 我们将 "rgtae” 称作 "great" 的一个扰乱字符串。
 * 给出两个长度相等的字符串 s1 和 s2，判断 s2 是否是 s1 的扰乱字符串。
 *
 * 示例 1：
 * 输入: s1 = "great", s2 = "rgeat"
 * 输出: true
 *
 * 示例 2:
 * 输入: s1 = "abcde", s2 = "caebd"
 * 输出: false
 */
public class ScrambleString {
    public static void main(String[] args) {
        String s1 = "great";
        String s2 = "rgeat";
        System.out.println(isScramble1(s1, s2));
        System.out.println(isScramble2(s1, s2));
    }

    /**
     * 执行用时：11 ms
     * 内存消耗：38.6 MB
     * @param s1
     * @param s2
     * @return
     */
    public static boolean isScramble1(String s1, String s2) {
        if(s1.length()!=s2.length()){
            return false;
        }
        int len = s1.length();
        boolean[][][] dp = new boolean[len][len][len+1];
        // 初始化单个字符的情况
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    dp[i][j][1] = true;
                }
            }
        }
        // 枚举区间长度 2～n
        for(int k=2;k<=len;k++){
            // 枚举 S 中的起点位置
            for (int i=0;i<=len-k;i++){
                // 枚举 T 中的起点位置
                for(int j=0;j<=len-k;j++){
                    // 枚举划分位置
                    for(int m=1;m<=k-1;m++){
                        dp[i][j][k]=(dp[i][j][m]&&dp[i+m][j+m][k-m])||(dp[i][j+k-m][m]&&dp[i+m][j][k-m]);
                        if(dp[i][j][k]){
                            break;
                        }
                    }
                }
            }
        }
        return dp[0][0][len];
    }

    /**
     * 执行用时：2 ms
     * 内存消耗：38.6 MB
     * @param s1
     * @param s2
     * @return
     */
    public static boolean isScramble2(String s1, String s2) {
        // 如果是空，返回false
        if (s1 == null || s2 == null) return false;
        // 如果两个字符串的长度不相等，返回false
        if (s1.length() != s2.length()) return false;
        int len = s1.length();
        // 如果两个字符串的值相等，返回true
        if (s1.equals(s2)) return true;
        // 定义一个长度为26的一维数组，下标0-25分别代表了26个字母和字母a的差值，相当于代表了26个字母
        int[] letters = new int[26];
        // 循环遍历s1和s2，s1里出现的就给对应的字母+1，s2出现的就给对应的字母-1
        for (int i = 0; i < len; i++) {
            letters[s1.charAt(i) - 'a']++;
            letters[s2.charAt(i) - 'a']--;
        }
        // 判断每个字母对应的值是否是0，如果不是，说明s1和s2里的字符不相同，返回false
        for (int i = 0; i < 26; i++) {
            if (letters[i] != 0) {
                return false;
            }
        }
        // 当两个字符串长度小于等于3时，各个字符串拥有的字符都相同就一定能转换
        if(len<=3){
            return true;
        }else {
            // 对s1和s2划分区间
            for (int i = 1; i < len; i++) {
                // 选取s1和s2的前i个字符进行递归比较，并且将两个字符串剩下的字符进行递归比较，如果两个比较的结果都是true则返回true
                if (isScramble2(s1.substring(0, i), s2.substring(0, i)) && isScramble2(s1.substring(i), s2.substring(i)))
                    return true;
                // 选取s1的前i个字符和s2的后i个字符进行递归比较，并且将两个字符串剩下的字符进行递归比较，如果两个比较的结果都是true则返回true
                if (isScramble2(s1.substring(0, i), s2.substring(len - i)) && isScramble2(s1.substring(i), s2.substring(0, len - i)))
                    return true;
            }
        }
        return false;
    }
}
