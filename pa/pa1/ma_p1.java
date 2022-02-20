class ma_p1 {
    public ma_p1() {}

    public int[] selectionSort(int[] values, int lowerBound, int upperBound) {
        for(int i = lowerBound; i < upperBound; i++) {
            int min = i;
            for(int j = i+1; j <= upperBound; j++)
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
        for(int i = lowerBound; i <= upperBound; i++) {
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
            switch (values[i]) {
                case 0: cases[0]++;
                        break;
                case 1: cases[1]++;
                        break; 
                case 2: cases[2]++;
                        break;
                case 3: cases[3]++;
                        break;
                case 4: cases[4]++;
                        break;
                case 5: cases[5]++;
                        break;
                case 6: cases[6]++;
                        break;
                case 7: cases[7]++;
                        break;
                case 8: cases[8]++;
                        break;
                case 10:
                case 11:
                case 12:
                case 13:
                case 14:
                case 15:
                        cases[9]++;
                        break;
                default: cases[10]++;
                        break;
            }
        }
        return cases;
    }
}