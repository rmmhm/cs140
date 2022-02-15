class ma_lab3 {
    public static void main(String[] args) {
        if(args.length > 2)
            encode(args[0], args[1], args[2].equals("y"));
        else
            encode(args[0], args[1], false);
    }
    public static void encode(String inputFileName, String outputFileName, boolean order) {
        try {
            java.io.BufferedReader input = new java.io.BufferedReader(new java.io.InputStreamReader(new java.io.FileInputStream(inputFileName)));
            java.io.PrintWriter output = new java.io.PrintWriter(new java.io.BufferedWriter(new java.io.FileWriter(outputFileName)));
            String line;
            int lineCount = 0;
            int wordCount = 0;
            int charCount = 0;
            java.util.ArrayDeque<String> dq = new java.util.ArrayDeque<String>();
            java.util.TreeSet<String> ts = new java.util.TreeSet<String>();
            while((line = input.readLine()) != null) {
                String[] words = line.split("\\s+");
                for(String w : words) {
                    ts.add(w);
                    String reverse = "";
                    for(int i = w.length() - 1; i >= 0; i--) {
                        reverse += w.charAt(i);
                        charCount++;
                    }
                    dq.push(reverse);
                    wordCount++;
                }
                String temp = "";
                while(dq.size() > 0) {
                    temp += dq.remove();
                    temp += " ";
                }
                temp = temp.substring(0, temp.length() - 1);
                output.print(temp);
                output.print("\n");
                lineCount++;
            }
            input.close();
            output.close();
            System.out.println("lines = " + lineCount);
            System.out.println("words = " + wordCount);
            System.out.println("characters in words = " + charCount);
            System.out.println("unique words = " + ts.size());
            if(order)
                for(String w : ts)
                    System.out.println(w);
        }
        catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}