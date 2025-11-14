import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;

public class mainApp {
    public static void main(String[] args) {
        var file = new File("src\\main\\java");
        System.out.println(Arrays.toString(Arrays.stream(file.listFiles()).map(File::getName).toArray()));
        Scanner fileContain = new Scanner(System.in);
        System.out.println("Введите название файла");
        String fileName = fileContain.nextLine();
        String filePath = "src\\main\\java\\" + fileName;
        try(BufferedInputStream in = new BufferedInputStream(new FileInputStream(filePath))){
            int n = in.read();
            while (n!=-1){
                System.out.print((char) n);
                n = in.read();
            }
            System.out.println();
        }   catch (IOException e){
            e.printStackTrace();
        }
        Scanner fileEdit = new Scanner(System.in);
        System.out.println("Введите слово");
        String word = fileEdit.nextLine();
        try(BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(filePath, true))){
            byte[] buffer = word.getBytes(StandardCharsets.UTF_8);
            for (int i = 0; i < buffer.length; i++) {
                out.write(buffer[i]);
            }
        }   catch (IOException e){
            e.printStackTrace();
        }
    }
}
