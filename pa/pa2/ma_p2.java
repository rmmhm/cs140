class ma_p2 {
    public ma_p2() {}

    public void encodeToBinary(String inputFileName, String outputFileName) {
        try {
            java.io.BufferedReader input = new java.io.BufferedReader(new java.io.InputStreamReader(new java.io.FileInputStream(inputFileName)));
            java.io.DataOutputStream output = new java.io.DataOutputStream(new java.io.FileOutputStream(outputFileName));

            int lines = 0;
            while(input.readLine() != null)
                lines++;
            output.writeInt(lines);
            output.writeChars("\n");

            String line;
            while((line = input.readLine()) != null) {
                String[] tokens = line.split("\\t");
                if(tokens[0].charAt(0) == 'i') {
                    output.writeChars("i");
                    output.writeInt(Integer.parseInt(tokens[1]));
                }
                if(tokens[0].charAt(0) == 'l') {
                    output.writeChars("l");
                    output.writeLong(Long.parseLong(tokens[1]));
                }
                if(tokens[0].charAt(0) == 'h') {
                    output.writeChars("h");
                    output.writeShort(Short.parseShort(tokens[1]));
                }
                if(tokens[0].charAt(0) == 'f') {
                    output.writeChars("f");
                    output.writeFloat(Float.parseFloat(tokens[1]));
                }
                if(tokens[0].charAt(0) == 'd') {
                    output.writeChars("d");
                    output.writeDouble(Double.parseDouble(tokens[1]));
                }
                if(tokens[0].charAt(0) == 'a') {
                    output.write("a".getBytes());
                    String[] values = tokens[1].split(",");
                    output.writeInt(values.length);
                    for(int i = 0; i < values.length; i++) {
                        output.writeInt(Integer.parseInt(values[i]));
                    }
                }
                if(tokens[0].charAt(0) == 's') {
                    output.writeChars("s");
                    output.writeInt(tokens[1].length());
                    for(int i = 0; i < tokens[1].length(); i++) 
                        output.writeChar(tokens[1].charAt(i));
                }
                if(tokens[0].charAt(0) == 'e') {
                    output.writeChars("e");
                    String[] values = tokens[1].split(",");
                    output.writeInt(values.length);
                    for(int i = 0; i < tokens[1].length(); i++)
                        output.writeDouble(Double.parseDouble(values[i]));
                }
                output.writeChars("\n");
            }
            input.close();
            output.close();
        }
        catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    public void decodeToText(String inputFileName, String outputFileName) {
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
                    for(int j = 0; j < length; j++)
                        output.print(input.readInt());
                }
                if(c == 's') {
                    output.print("string");
                    output.print("\t");
                    int length = input.readInt();
                    String s = "";
                    for(int j = 0; j < length; j++)
                        s += Character.toString(input.readChar());
                    output.print(s);
                }
                if(c == 'e') {
                    output.print("double array");
                    output.print("\t");
                    int length = input.readInt();
                    for(int j = 0; j < length; j++)
                        output.print(input.readDouble());
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