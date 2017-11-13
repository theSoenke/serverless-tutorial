import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Handler {

    public static void main(String[] args) {
        try {

            String input = readStdin();
            int count = Integer.parseInt(input);
            int fib = fibonacci(count);
            System.out.print(fib);

        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    private static int fibonacci(int count){
        int n1 = 0, n2 = 1, n3 = 0;
        for(int i = 2; i < count; ++i){
            n3=n1+n2;
            n1=n2;
            n2=n3;
        }

        return n3;
    }

    private static String readStdin() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = "";
        while(true) {
            String line = br.readLine();
            if(line==null) {
                break;
            }
            input = input + line + "\n";
        }
        return input;
    }
}
