import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Iterator;

class ma_ManageCarData implements ManageCarDataFunctions {
    private final ArrayList<CarFunctions> carList;
    private final PriorityQueue<CarFunctions> carListByTotalRange;
    private final PriorityQueue<CarFunctions> carListByRemainingRange;

    public ma_ManageCarData() {
        carList = new ArrayList<>();
        carListByTotalRange = new PriorityQueue<>(new TotalRangeComparator());
        carListByRemainingRange = new PriorityQueue<>(new RemainingRangeComparator());
    }

    public void readData(String filename) {
        try {
            java.io.BufferedReader reader = new java.io.BufferedReader(new java.io.InputStreamReader(new java.io.FileInputStream(filename)));
            String line;
            while((line = reader.readLine()) != null) {
                String[] tokens = line.split("\t");
                ma_Car car = new ma_Car(tokens[0], Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2]), Double.parseDouble(tokens[3]));
                carList.add(car);
                carListByTotalRange.add(car);
                carListByRemainingRange.add(car);
            }
            reader.close();
        }
        catch(Exception e) {
            System.out.println(e.toString());
        }
    }

    public ArrayList<CarFunctions> getCarList() {
        ArrayList<CarFunctions> returnList = new ArrayList<>();
        for(CarFunctions c : carList)
            returnList.add(c);
        return returnList;
    }

    public PriorityQueue<CarFunctions> getCarListByTotalRange() {
        PriorityQueue<CarFunctions> returnQueue = new PriorityQueue<>(new TotalRangeComparator());
        for(CarFunctions c : carListByTotalRange)
            returnQueue.add(c);
        return returnQueue;
    }

    public ArrayList<CarFunctions> getCarListByTotalRangeUsingIterator() {
        ArrayList<CarFunctions> returnList = new ArrayList<>();
        Iterator<CarFunctions> iter = carListByTotalRange.iterator();
        while(iter.hasNext())
            returnList.add(iter.next());
        return returnList;
    }

    public PriorityQueue<CarFunctions> getCarListByRemainingRange() {
        PriorityQueue<CarFunctions> returnQueue = new PriorityQueue<>(new RemainingRangeComparator());
        for(CarFunctions c : carListByRemainingRange) 
            returnQueue.add(c);
        return returnQueue;
    }

    public ArrayList<CarFunctions> getCarListByRemainingRangeUsingIterator() {
        ArrayList<CarFunctions> returnList = new ArrayList<>();
        Iterator<CarFunctions> iter = carListByRemainingRange.iterator();
        while(iter.hasNext())
            returnList.add(iter.next());
        return returnList;
    }

    public ArrayList<String> getCarListByTotalRangeViaPoll(double minTotalRange, double maxTotalRange) {
        ArrayList<String> returnList = new ArrayList<>();
        while(!carListByTotalRange.isEmpty()) {
            CarFunctions currentCar = carListByTotalRange.poll();
            if(currentCar.getTotalRangeInMiles() > minTotalRange && currentCar.getTotalRangeInMiles() < maxTotalRange) {
                String currentCarString = currentCar.toString();
                currentCarString += "\t" + carList.indexOf(currentCar);
                for(int i = 0; i < carList.size(); i++)
                    if(currentCar.getFuelEconomyInMilesPerGallon() == carList.get(i).getFuelEconomyInMilesPerGallon())
                        currentCarString += "\t" + i;
                returnList.add(currentCarString);
            }
        }
        for(CarFunctions c : carList)
            carListByTotalRange.add(c);
        return returnList;
    }

    public ArrayList<String> getCarListByRemainingRangeViaPoll(double minRemainingRange, double maxRemainingRange) {
        ArrayList<String> returnList = new ArrayList<>();
        while(!carListByRemainingRange.isEmpty()) {
            CarFunctions currentCar = carListByRemainingRange.poll();
            if(currentCar.getRemainingRangeInMiles() > minRemainingRange && currentCar.getRemainingRangeInMiles() < maxRemainingRange) {
                String currentCarString = currentCar.toString();
                currentCarString += "\t" + carList.indexOf(currentCar);
                for(int i = 0; i < carList.size(); i++) 
                    if(currentCar.getFuelEconomyInMilesPerGallon() == carList.get(i).getFuelEconomyInMilesPerGallon())
                        currentCarString += "\t" + i;
                returnList.add(currentCarString);
            }
        }
        for(CarFunctions c : carList)
            carListByRemainingRange.add(c);
        return returnList;
    }


}
