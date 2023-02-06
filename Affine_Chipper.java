package ITER;
import java.util.Scanner;
public class Affine_Chipper {
    public static String encrypt(String plaintext){
        String chipertext="";
        for(int i=0;i<plaintext.length();i++){
            char ch=plaintext.charAt(i);
         int a=(int)(ch);
         if(a<97){
             int b=a;
             b=b-65;
             b=((b*7)+2)%26;
             b+=65;
             char ch1=(char)b;
             chipertext+=ch1;
         }
         else{
             int b=a-32;
             b=b-65;
             b=((b*7)+2)%26;
             b+=97;
             char ch1=(char)b;
             chipertext+=ch1;
         }
        }
        return chipertext;
    }
    public static String decrypt(String chipertext) {
        String decrypted_plaintext="";
        for(int i=0;i<chipertext.length();i++){
            char ch=chipertext.charAt(i);
            int a=(int)(ch);
            if(a<97){
                int b=a;
                b=b-65;
                int c=b-2;
                if(c==-1){
                    c=25;
                }
                else if(c==-2){
                    c=24;
                }
                b=(c*15)%26;
                b+=65;
                char ch1=(char)b;
                decrypted_plaintext+=ch1;
            }
            else{
                int b=a-32;
                b=b-65;
                int c=b-2;
                if(c==-1){
                    c=25;
                }
                else if(c==-2){
                    c=24;
                }
                b=(c*15)%26;
                b+=97;
                char ch1=(char)b;
                decrypted_plaintext+=ch1;
            }
        }
        return decrypted_plaintext;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter plaintext :");
        String ab=sc.nextLine();
        String ac=(encrypt(ab));
        System.out.println("Chipertext is:"+ac);
        System.out.println("Decrypted plaintext :"+decrypt(ac));
    }
}
