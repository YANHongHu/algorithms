/**
 *一个机器人位于一个 m x n 网格的左上角。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角。
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 * 网格中的障碍物和空位置分别用 1 和 0 来表示。
 * 说明：m 和 n 的值均不超过 100。
 *
 * 示例 1:
 * 输入:
 * [
 *   [0,0,0],
 *   [0,1,0],
 *   [0,0,0]
 * ]
 * 输出: 2
 * 解释:
 * 3x3 网格的正中间有一个障碍物。
 * 从左上角到右下角一共有 2 条不同的路径：
 * 1. 向右 -> 向右 -> 向下 -> 向下
 * 2. 向下 -> 向下 -> 向右 -> 向右
 *
 */

public class UniquePathsPro {
    public static void main(String[] args) {
        int[][] map = {{1,0}};
        System.out.println(countPath(map));
    }

    /**
     * 动态规划：由每次只能向右或者向下走，可知
     *  f(m,n) = f(m,n-1) + f(m-1,n)
     *  边界值 f(1,n) = 1, f(m,1) = 1 f(1,1) = 1
     * @param map
     * @return
     */
    private static int countPath(int[][] map){
        int m = map.length;
        int n = map[0].length;
        int[][] grap = new int[m][n];
        for (int i = 0; i < m; ++i) {
            if(map[i][0]==1){
                grap[i][0]=0;
            }else if (i!=0&&grap[i-1][0]==0){
                grap[i][0] = 0;
            }else {
                grap[i][0] = 1;
            }
        }
        for (int j = 0; j < n; ++j) {
            if(map[0][j]==1){
                grap[0][j]=0;
            }else if(j!=0&&grap[0][j-1]==0){
                grap[0][j] = 0;
            }else {
                grap[0][j] = 1;
            }
        }
        for (int i = 1; i < m; ++i) {
            for (int j = 1; j < n; ++j) {
                if(map[i][j]==1){
                    grap[i][j]=0;
                }else {
                    grap[i][j] = grap[i - 1][j] + grap[i][j - 1];
                }
            }
        }
        return grap[m-1][n-1];
    }

}
