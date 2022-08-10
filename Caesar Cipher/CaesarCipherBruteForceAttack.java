import java.util.*;
import java.io.*;

public class CaesarCipherBruteForceAttack extends CaesarCipherAlgorithm{
    private static List<String> bruteForceAttack(String cipherText){
        List<String> possibleTexts = new ArrayList<>();
        for(int i=0; i<26; i++){
            String text = CaesarCipherAlgorithm.encryption(cipherText,i);
            possibleTexts.add(text);
        }
        return possibleTexts;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter Cipher Text : ");
        String cipherText = reader.readLine();
        List<String> possibleTexts = bruteForceAttack(cipherText);
        for(String text : possibleTexts){
            System.out.println(text);
        }
        
    }
}
