import java.io.BufferedReader;

class ma_lab1 {
    public static void main(String[] args) {
        if (args.length == 0)
            System.out.println("Args is empty");
        else {
            java.text.DecimalFormat df = new
            java.text.DecimalFormat("###,###,###,###,###");
            try {
                java.io.BufferedReader input = new java.io.BufferedReader(new java.io.InputStreamReader(new java.io.FileInputStream(args[0])));
                String line;
                int lineCounter = 0;
                int tokenCounter = 0;
                int intCounter = 0;
                int intSum = 0;
                String[] compares = new String[args.length - 1];
                int[] count = new int[args.length - 1];
                if(args.length > 1) 
                    for(int i = 0; i < args.length - 1; i++)
                        compares[i] = args[i+1]; 
                while ((line = input.readLine()) != null) {
                    if(line.trim().length() > 0) {
                        String[] tokens = line.trim().split("\\s+");
                        for (int i = 0; i < tokens.length; i++) {
                            try {
                                intSum += Integer.parseInt(tokens[i]);
                                intCounter++;
                            }
                            catch (Exception e) {}
                            if(compares.length > 0) {
                                for(int j = 0; j < compares.length; j++) {
                                    if(compares[j].equals(tokens[i])) 
                                        count[j]++;
                                }
                            }
                            tokenCounter++; 
                        }
                    }
                    lineCounter++;
                }
                input.close();
                System.out.println("lineCount = " + df.format(lineCounter));
                System.out.println("tokenCount = " + df.format(tokenCounter));
                System.out.println("intCount = " + df.format(intCounter));
                System.out.println("intSum = " + df.format(intSum));
                if(compares.length > 0)
                    for(int i = 0; i < compares.length; i++)
                        System.out.println(compares[i] + " = " + count[i]);
            }
            catch(Exception e) {
                System.out.println(e.toString());
            }
        }
    }
}