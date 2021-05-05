import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Arrays;
// 1:无需package
// 2: 类名必须Main, 不可修改

public class GetWater {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int x = n/m;
        int y = n%m;
        int[][] seq = null;
        if(y>0) {
            x++;
            seq = new int[x][m];
            for (int i = 0; i < x - 1; i++) {
                for (int j = 0; j < m; j++) {
                    seq[i][j] = sc.nextInt();
                }
            }
            for (int j = 0; j < y; j++) {
                seq[x - 1][j] = sc.nextInt();
            }
        }else {
            seq = new int[x][m];
            for (int i = 0; i < x; i++) {
                for (int j = 0; j < m; j++) {
                    seq[i][j] = sc.nextInt();
                }
            }
        }
        if (n <= m) {
            Arrays.sort(seq[0]);
            System.out.println(seq[0][n - 1]);
        }else {
            Arrays.sort(seq[0]);
            for (int i = 1; i < x; i++) {
                for (int j = 0; j < m; j++) {
                    seq[0][0] = seq[0][0] + seq[i][j];
                    Arrays.sort(seq[0]);
                }
            }
            System.out.println(seq[0][m - 1]);
        }
        sc.close();
    }
}
