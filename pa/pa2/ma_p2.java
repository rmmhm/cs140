class ma_p2 {
    public static void main(String[] args) {
        if(args.length == 3) {
            if(args[0].equals("t2b"))
                convertTextToBinary(args[1], args[2]);
            else if(args[0].equals("b2t"))
                convertBinaryToText(args[1], args[2]);
            else
                System.out.println("Invalid arguments");
        }
        else  
            System.out.println("Invalid arguments");
    }

    public static void convertTextToBinary(String inputFileName, String outputFileName) {
        try {
            java.io.BufferedReader input = new java.io.BufferedReader(new java.io.InputStreamReader(new java.io.FileInputStream(inputFileName)));
            java.io.BufferedReader input1 = new java.io.BufferedReader(new java.io.InputStreamReader(new java.io.FileInputStream(inputFileName)));   
            java.io.DataOutputStream output = new java.io.DataOutputStream(new java.io.FileOutputStream(outputFileName));
            int lines = 0;
            while(input1.readLine() != null)
                lines++;
            output.writeInt(lines);
            input1.close();

            String line;
            while((line = input.readLine()) != null) {
                String[] tokens = line.split("\t");
                if(tokens[0].equals("int")) {
                    output.writeChars("i"); 
                    output.writeInt(Integer.parseInt(tokens[1]));
                }
                if(tokens[0].equals("long")) {
                    output.writeChars("l");
                    output.writeLong(Long.parseLong(tokens[1]));
                }
                if(tokens[0].equals("short")) {
                    output.writeChars("h");
                    output.writeShort(Short.parseShort(tokens[1]));
                }
                if(tokens[0].equals("float")) {
                    output.writeChars("f");
                    output.writeFloat(Float.parseFloat(tokens[1]));
                }
                if(tokens[0].equals("double")) {
                    output.writeChars("d");
                    output.writeDouble(Double.parseDouble(tokens[1]));
                }
                if(tokens[0].equals("int array")) {
                    output.writeChars("a");
                    String[] values = tokens[1].split(",");
                    output.writeInt(values.length);
                    for(int i = 0; i < values.length; i++) {
                        output.writeInt(Integer.parseInt(values[i]));
                    }
                }
                if(tokens[0].equals("string")) {
                    output.writeChars("s");
                    output.writeInt(tokens[1].length());
                    for(int i = 0; i < tokens[1].length(); i++) 
                        output.writeChar(tokens[1].charAt(i));
                }
                if(tokens[0].equals("double array")) {
                    output.writeChars("e");
                    String[] values = tokens[1].split(",");
                    output.writeInt(values.length);
                    for(int i = 0; i < values.length; i++)
                        output.writeDouble(Double.parseDouble(values[i]));
                }
            }
            input.close();
            output.close();
        }
        catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    public static void convertBinaryToText(String inputFileName, String outputFileName) {
        try {
            java.io.DataInputStream input = new java.io.DataInputStream(new java.io.FileInputStream(inputFileName));
            java.io.PrintWriter output = new java.io.PrintWriter(outputFileName);
            int blocks = input.readInt();
            for(int i = 0; i < blocks; i++) {
                char c = input.readChar(); 
                if(c == 'i') {
                    output.print("int");
                    output.print("\t");
                    output.print(input.readInt());
                }
                if(c == 'l') {
                    output.print("long");
                    output.print("\t");
                    output.print(input.readLong());
                }
                if(c == 'h') {
                    output.print("short");
                    output.print("\t");
                    output.print(input.readShort());
                }
                if(c == 'f') {
                    output.print("float");
                    output.print("\t");
                    output.print(input.readFloat());
                }
                if(c == 'd') {
                    output.print("double");
                    output.print("\t");
                    output.print(input.readDouble());
                }
                if(c == 'a') {
                    output.print("int array");
                    output.print("\t");
                    int length = input.readInt();
                    for(int j = 0; j < length; j++) {
                        output.print(input.readInt());
                        if(j < length-1)
                            output.print(",");
                    }
                }
                if(c == 's') {
                    output.print("string");
                    output.print("\t");
                    int length = input.readInt();
                    for(int j = 0; j < length; j++)
                        output.print(input.readChar());
                }
                if(c == 'e') {
                    output.print("double array");
                    output.print("\t");
                    int length = input.readInt();
                    for(int j = 0; j < length; j++) {
                        output.print(input.readDouble());
                        if(j < length-1)
                            output.print(",");
                    }
                }
                output.print("\n");   
            }
            input.close();
            output.close();
        } 
        catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}