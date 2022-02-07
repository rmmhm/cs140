class ma_p1 {
    public ma_p1() {}

    public int[] selectionSort(int[] values, int lowerBound, int upperBound) {
        int[] result = new int[upperBound - lowerBound];
        int min = values[0];
        while (lowerBound < upperBound) {
            int index = 0;
            for(int i = lowerBound; i < upperBound; i++) {
                if(values[i] < min)
                    min = values[i];
                index = i;
            }
            result[index-lowerBound] = min;
            lowerBound++;
        }
        return result;
    }
    public int forLoopTest(int lowerBound, int upperBound, int testValue, int[] values) {
        int count = 0;
        for(int i = lowerBound; i < upperBound; i++) {
            if(values[i] > testValue)
                count++;
        }
        return count;
    } 
    public int whileLoopTest(int lowerBound, int upperBound, int testValue, int[] values) {
        int count = 0;
        int i = 0;
        while(i < lowerBound) {
            if (values[i] < testValue)
                count++;
            i++;
        }
        i = upperBound;
        while(i < values.length) {
            if (values[i] < testValue)
                count++;
            i++;
        }
        return count;
    }
    public int doWhileLoopTest(int lowerBound, int upperBound, int testValue0, int testValue1, int[] values) {
        int count = 0;
        do {
            if(values[lowerBound] > testValue0 || values[lowerBound] < testValue1)
                count++;
            lowerBound++;
        }
        while(lowerBound < upperBound);
        return count;
    }
    public int[] switchTest(int lowerBound, int upperBound, int[] values) {
        int[] cases = new int[11];
        for(int i = lowerBound; i < upperBound; i++) {
            if(values[i] <= 8)
                cases[values[i]]++;
            else if(values[i] <= 15)
                cases[9]++;
            else
                cases[10]++;
        }
        return cases;
    }
}