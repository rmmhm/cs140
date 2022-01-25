class ma_lab0b {
    public static void main(String[] args) {
            System.out.println("yo, i am here, and below are the command line arguments you gave me");
            for (int i = 0; i < args.length; i++) {
            //for (int i = 0; i <= args.length; i++) { 
            // index error because of args[6], which does not exist
            //for (int i = 0; i < args.length; ++i) { 
            // no change
                    System.out.println("\t arg[" + i + "] = " + args[i]);
            }

            for (int i = 0; i < args.length; i++) {
            //for (int i = 0; i++ < args.length;) { 
            // index error because of args[6]
            //for (int i = 0; ++i < args.length;) {
            // excludes args[0]
                    int intValue = Integer.parseInt(args[i]);
                    System.out.println("\t arg[" + i + "] as an int = " + intValue);
            }
    }
}
