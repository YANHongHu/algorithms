import java.util.Scanner;

public class MoveNums {
    public static void main(String[] args) {
//        int x=20,y=5;
//        System.out.println(x+y+""+(x+y)+y);
        Scanner sc = new Scanner(System.in);
        //String str = sc.nextLine();
        //System.out.println(toLowerCase(str));
        int[] nums = {1,34,3,5,4};
        int k = sc.nextInt();
        rotate(nums,k);
        for (int i : nums) {
            System.out.println(i);
        }
    }

    public static String toLowerCase(String str){
        StringBuffer str_n = new StringBuffer();
        for (int i = 0;i<str.length();i++){
            char ch = str.charAt(i);
            if(ch>='A'&&ch<='Z')
                ch = (char) (ch -'A'+'a');
            str_n.append(ch);
        }
        return str_n.toString();
    }

    public static void rotate(int[] nums, int k){
        int len = nums.length;
        for(int i=0;i<k;i++) {
            int a = 0;
            a = nums[len-1];
            for(int j = len-2;j>=0;j--){
                nums[j+1]=nums[j];
            }
            nums[0] = a;
        }
    }

    public static int removeElement(int[] nums, int val){
        if (nums == null || nums.length == 0)
            return 0;
        int j = 0;
        // 用for循环来遍历，如果当前元素与 val相同
        // 只要nums[i] != val 就复制 nums[j] = nums[i]同时递增两个索引
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
    }
}
