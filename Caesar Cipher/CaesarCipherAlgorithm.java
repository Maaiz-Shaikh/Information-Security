import java.util.Scanner;
import java.io.*;

public class CaesarCipherAlgorithm {
    public static String alphabets = "abcdefghijklmnopqrstuvwxyz";
    public static String encryption(String plainText, int key){
        String cipherText = "";
        plainText = plainText.toLowerCase();
        
        System.out.println(plainText);
        for(int i=0; i<plainText.length(); i++){
            if(plainText.charAt(i)!=' '){
                int index = (alphabets.indexOf(plainText.charAt(i)) + key) % 26;
                cipherText = cipherText + alphabets.charAt(index);
            }else{
                cipherText+=" ";
            }

        }
        return cipherText;
    }

    private static String decryption(String cipherText, int key){
        String plainText = "";
        for(char character : cipherText.toCharArray()){
            if(character == ' ') {
                plainText+=" ";
                continue;
            }
            int index = (alphabets.indexOf(character) - key)%26;
            if(index<0) index = index + 26;
            plainText+=alphabets.charAt(index);
        }
        return plainText;

    }
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Encryption Operation");
        System.out.println("Enter Key : ");
        int encryptionKey = sc.nextInt();
        System.out.println("Enter Plain Text : ");
        String plainText = reader.readLine();
        String cipherText = encryption(plainText, encryptionKey);
        System.out.println("Cipher Text : "+cipherText);

        System.out.println("Decryption Operation");
        System.out.println("Enter Key : ");
        int decryptionKey = sc.nextInt();
        System.out.println("Plain Text : "+decryption(cipherText, decryptionKey));
        sc.close();
    }
}
