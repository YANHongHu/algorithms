import java.util.Scanner;
import java.util.Stack;

/**
 * Roland是一个高中数学教师，每天他都会发一大堆作业让学生做。
 * 　　每一份作业，他会认真地批改并给出一个等级："A"或"B"或"C"。(Roland的学生都是学霸，不管怎么乱涂都不会拿"D"或"F")。
 * 　　每次Roland评定完所有等级，都会把那些作业交给他的助手(你)，你的任务是帮Roland完成成绩的登记。
 *
 * 　　不幸的是，你只有一台非常低能的打字机，但是这个打字机有一些功能可以使用。
 * 　　这是一个栈式的打字机，支持下面三种操作：
 * 　　(1)把一个字母加到栈顶。
 * 　　(2)打印栈顶的字母。
 * 　　(3)删除栈顶字母。
 *
 * 　　给出你需要打印的字母等级序列，你需要算出打印这个序列的最小操作数。
 * 　　为了方便下一次工作，栈一开始是空的，当你工作完成后也要使栈是空的。
 *
 * 输入格式
 * 第一行，一个正整数T，表示数据组数。
 * 接下来T行，每行一个由"A""B""C"组成的字符串S。
 *
 * 输出格式
 * 对于每组数据输出一行"Case #x: N"，x为数据编号(从1开始)，N是最小操作数。
 */
public class LetterStamper {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] strs = new String[n];
        for (int i = 0; i<n; i++){
            strs[i] = sc.next();
        }
        for (int i = 0; i<n; i++){
            int count = count(strs[i]);
            System.out.println("Case #"+(i+1)+"："+count);
        }
    }

    public static int count(String str){
        int len = str.length();
        Stack<Character> st = new Stack<>();
        int count = 0;
        for (int i=0;i<len;i++){
            char ch = str.charAt(i);
            if(st.contains(ch)&&ch==st.peek()){
                count++;
            }else if (!st.contains(ch)){
                st.push(ch);
                count+=2;
            }else if (st.contains(ch)&&ch!=st.peek()){
                int num = st.search(ch);
                count+=num;
                while (num!=1){
                    st.pop();
                    num--;
                }
            }
        }
        count+=st.size();
        return count;
    }
}
