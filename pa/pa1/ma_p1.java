class ma_p1 {
    public ma_p1() {}

    public int[] selectionSort(int[] values, int lowerBound, int upperBound) {
        for(int i = lowerBound - 1; i <= upperBound; i++) {
            int min = i;
            for(int j = i+1; j < upperBound + 1; j++)
                if(values[j] < values[min])
                    min = j;
            int temp = values[i];
            values[i] = values[min];
            values[min] = temp;
        }
        return values;
    }
    public int forLoopTest(int lowerBound, int upperBound, int testValue, int[] values) {
        int count = 0;
        for(int i = lowerBound; i < upperBound; i++) {
            if(values[i] >= testValue)
                count++;
        }
        return count;
    } 
    public int whileLoopTest(int lowerBound, int upperBound, int testValue, int[] values) {
        int count = 0;
        int i = 0;
        while(i < lowerBound) {
            if (values[i] <= testValue)
                count++;
            i++;
        }
        i = upperBound + 1;
        while(i < values.length) {
            if (values[i] <= testValue)
                count++;
            i++;
        }
        return count;
    }
    public int doWhileLoopTest(int lowerBound, int upperBound, int testValue1, int testValue2, int[] values) {
        int count = 0;
        do {
            int check = values[lowerBound];
            if(testValue1 > testValue2) {
                if(check >= testValue2 && check <= testValue1)
                    count++;
                lowerBound++;
            }
            else {
                if(check >= testValue1 && check <= testValue2)
                    count++;
                lowerBound++;
            }
        }  
        while(lowerBound <= upperBound);
        return count;
    }
    public int[] switchTest(int lowerBound, int upperBound, int[] values) {
        int[] cases = new int[11];
        for(int i = lowerBound; i <= upperBound; i++) {
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