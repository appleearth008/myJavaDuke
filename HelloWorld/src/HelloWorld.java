import java.util.Arrays;
import edu.duke.*;

public class HelloWorld {
//    private static int a;
    public static void main(String[] args) {;
//        System.out.println(a);
        FileResource fr = new FileResource("src/hello.txt",true);
        for(String line : fr.lines()){
            System.out.println(line);
        }
        fr.write("this is my last line!");
    }
}
