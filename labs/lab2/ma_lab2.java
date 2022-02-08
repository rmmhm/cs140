import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.PrintWriter;

class ma_lab2 {

    public static void main(String[] args) {
        if (args.length > 0) {
            if(args[0].startsWith("b"))
                convertBinaryToText(args[1], args[2]);
            else if(args[0].startsWith("t"))
                convertTextToBinary(args[1], args[2]);
            else
                System.out.println("First letter of args[0] does not start with b or t");
        }
        else
            System.out.println("Args is empty");
    }

    public static void convertBinaryToText(String inputFileName, String outputFileName) {
        System.out.println("convertBinaryToText");
        try {
            FileInputStream input = new FileInputStream(inputFileName);
            PrintWriter pw = new PrintWriter(outputFileName);
            File f = new File(inputFileName);
            byte[] byteRead = new byte[(int)f.length()];
            input.read(byteRead);
            String s = new String(byteRead);
            pw.print(s);
            input.close();
            pw.close();
        }
        catch(Exception e) {
            System.out.println(e.toString());
            System.exit(0);
        }
    }

    public static void convertTextToBinary(String inputFileName, String outputFileName) {
        System.out.println("convertTextToBinary");
        try {
            java.io.BufferedReader br = new java.io.BufferedReader(new java.io.InputStreamReader(new java.io.FileInputStream(inputFileName)));
            BufferedOutputStream bo = new java.io.BufferedOutputStream(new java.io.FileOutputStream(outputFileName));
            String line;
            while ((line = br.readLine()) != null) {
                if (line.length() > 0) 
                    bo.write(line.getBytes());
                    bo.write("\n".getBytes());
            }
            bo.close();
            br.close();
        }
        catch(Exception e) {
            System.out.println(e.toString());
            System.exit(0);
        }
    }
}