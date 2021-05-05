import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ThePriceOfPerfection {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        String str = sc.next();

    }

    public static boolean impossible(int len, String str){
        Map<Character, Integer> hashMap = new HashMap<>();
        for(int i = 0; i<len ;i++){
            if (hashMap.containsKey(str.charAt(i))){
                hashMap.put(str.charAt(i),hashMap.get(str.charAt(i))+1);
            }else {
                hashMap.put(str.charAt(i),1);
            }
        }
        if(len%2==0){
            for(int v:hashMap.values()){
                if(v%2!=0){
                    return false;
                }
            }
        }else {
            int count = 0;
            for(int v:hashMap.values()){
                if(v%2!=0){
                    count++;
                }
            }
            if(count!=1)
                return false;
        }
        return true;
    }

    public static int changeTimes(int len, String str){
        char[] st = new char[len];
        for (int i = 0;i<len;i++) {
            st[i] = str.charAt(i);
        }
        int count = 0;
        for(int i=0;i<(len+1)/2;i++){
            int flag = 0;
            for(int j=i+1;j>len;j++){
                if(st[i]==st[j]){
                    char stack = st[j];
                    for (int k=j+1;k<len-1-i;k++){
                        st[k]=st[k+1];
                    }
                    st[len-1-i]=stack;
                    count=(len-1-i-j);
                    flag++;
                    break;
                }
            }
        }
        return 0;
    }
}
