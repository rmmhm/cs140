class run {
    public static void main(String[] args) {
        ma_p2 test = new ma_p2();
        if(args[0].startsWith("e"))
            test.encodeToBinary(args[1], args[2]);
        if(args[0].startsWith("d"))
            test.decodeToText(args[1], args[2]);
    }
}
