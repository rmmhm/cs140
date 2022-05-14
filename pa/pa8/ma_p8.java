import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.util.*;
import java.io.*;

class ma_p8 {
    private static int frameWidth = 750;
    private static int frameHeight = 385;
    private static int buttonPanelWidth = 330;
    private static int buttonPanelHeight = 385;

    private static JButton sortIntsButton;
    private static JButton addToBinarySearchTreeButton;
    private static JButton addToTreeSetButton;
    private static JButton addToPriorityQueueButton;
    private static JButton addToHashSetButton;
    private static JButton addToArrayListButton;
    private static JButton addToSortedArrayListButton;
    private static JButton addToArrayButton;;
    private static JButton mergeSortIntsButton;

    private static JButton searchSortedIntsButton;
    private static JButton searchBinarySearchTreeButton;
    private static JButton searchTreeSetButton;
    private static JButton searchPriorityQueueButton;
    private static JButton searchHashSetButton;
    private static JButton searchArrayListButton;
    private static JButton searchSortedArrayListButton;
    private static JButton searchArrayButton;
    private static JButton searchMergeSortIntsButton;

    private static JLabel sortIntsLabel;
    private static JLabel addToBinarySearchTreeLabel;
    private static JLabel addToTreeSetLabel;
    private static JLabel addToPriorityQueueLabel;
    private static JLabel addToHashSetLabel;
    private static JLabel addToArrayListLabel;
    private static JLabel addToSortedArrayListLabel;
    private static JLabel addToArrayLabel;
    private static JLabel mergeSortIntsLabel;

    private static JLabel searchSortedIntsLabel;
    private static JLabel searchBinarySearchTreeLabel;
    private static JLabel searchTreeSetLabel;
    private static JLabel searchPriorityQueueLabel;
    private static JLabel searchHashSetLabel;
    private static JLabel searchArrayListLabel;
    private static JLabel searchSortedArrayListLabel;
    private static JLabel searchArrayLabel;
    private static JLabel searchMergeSortIntsLabel;

    private static ArrayList<JButton> rightButtons = new ArrayList<>(8);
    private static ArrayList<JLabel> rightLabels = new ArrayList<>(8);
    private static ArrayList<JButton> leftButtons = new ArrayList<>(8);
    private static ArrayList<JLabel> leftLabels = new ArrayList<>(8);

    private static int[] sortValues;
    private static int[] searchValues;
    private static int[] sortedValues;
    private static int[] unsortedValues;
    private static int[] mergeSortValues;
        
    private static ma_BinarySearchTree bst = new ma_BinarySearchTree();
    private static TreeSet<Integer> treeSetValues = new TreeSet<>();
    private static HashSet<Integer> hashSetValues = new HashSet<>();
    private static PriorityQueue<Integer> priorityQueueValues = new PriorityQueue<>();
    private static ArrayList<Integer> arrayListValues = new ArrayList<>();
    private static ArrayList<Integer> sortedArrayListValues = new ArrayList<>();

    private static String searchFile;
    private static String sortFile;

    public static void main(String[] args) {
        if(args.length == 2) {
            sortFile = args[0];
            searchFile = args[1];
        }
        createGui();
    }

    public static void createGui() {
        // frame
        JFrame f = new JFrame();
		f.setPreferredSize(new Dimension(frameWidth, frameHeight));
		f.setMinimumSize(new Dimension(frameWidth, frameHeight));
        f.setMaximumSize(new Dimension(frameWidth, frameHeight));
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // menu bar
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem readSortFile = new JMenuItem("Read sort file");
		JMenuItem readSearchFile = new JMenuItem("Read search file");
        JMenuItem exit = new JMenuItem("Exit");
        MenuItemActionListener readSortFileMenuItemActionListener = new MenuItemActionListener(readSortFile);
		MenuItemActionListener readSearchFileMenuItemActionListener = new MenuItemActionListener(readSearchFile);
        MenuItemActionListener exitFileMenuItemActionListener = new MenuItemActionListener(exit);
        readSortFile.addActionListener(readSortFileMenuItemActionListener);
        readSearchFile.addActionListener(readSearchFileMenuItemActionListener);
        exit.addActionListener(exitFileMenuItemActionListener);
        menuBar.add(fileMenu);
        fileMenu.add(readSortFile);
        fileMenu.add(readSearchFile);
        fileMenu.add(exit);

        // left button panel
        JPanel leftButtonPanel = new JPanel();
        leftButtonPanel.setBorder(new LineBorder(Color.black,2));
        GridBagLayout leftGridBagLayout = new GridBagLayout();
        leftButtonPanel.setLayout(leftGridBagLayout);
        leftButtonPanel.setPreferredSize(new Dimension(buttonPanelWidth, buttonPanelHeight));

        // left buttons+labels
        sortIntsButton = new JButton("sort ints");
        sortIntsButton.addActionListener(new ButtonActionListener(sortIntsButton));
        sortIntsLabel = new JLabel("no result");
        addToBinarySearchTreeButton = new JButton("add to bst");
        addToBinarySearchTreeButton.addActionListener(new ButtonActionListener(addToBinarySearchTreeButton));
        addToBinarySearchTreeLabel = new JLabel("no result");
        addToTreeSetButton = new JButton("add to treeset");
        addToTreeSetButton.addActionListener(new ButtonActionListener(addToTreeSetButton));
        addToTreeSetLabel = new JLabel("no result");
        addToPriorityQueueButton = new JButton("add to priority queue");
        addToPriorityQueueButton.addActionListener(new ButtonActionListener(addToPriorityQueueButton));
        addToPriorityQueueLabel = new JLabel("no result");
        addToHashSetButton = new JButton("add to hashset");
        addToHashSetButton.addActionListener(new ButtonActionListener(addToHashSetButton));
        addToHashSetLabel = new JLabel("no result");
        addToArrayListButton = new JButton("add to arraylist");
        addToArrayListButton.addActionListener(new ButtonActionListener(addToArrayListButton));
        addToArrayListLabel = new JLabel("no result");
        addToSortedArrayListButton = new JButton("add to sorted arraylist");
        addToSortedArrayListButton.addActionListener(new ButtonActionListener(addToSortedArrayListButton));
        addToSortedArrayListLabel = new JLabel("no result");
        addToArrayButton = new JButton("add to array");
        addToArrayButton.addActionListener(new ButtonActionListener(addToArrayButton));
        addToArrayLabel = new JLabel("no result");
        mergeSortIntsButton = new JButton("merge sort ints");
        mergeSortIntsButton.addActionListener(new ButtonActionListener(mergeSortIntsButton));
        mergeSortIntsLabel = new JLabel("no result");
        leftButtons.add(sortIntsButton);
        leftButtons.add(addToBinarySearchTreeButton);
        leftButtons.add(addToTreeSetButton);
        leftButtons.add(addToPriorityQueueButton);
        leftButtons.add(addToHashSetButton);
        leftButtons.add(addToArrayListButton);
        leftButtons.add(addToSortedArrayListButton);
        leftButtons.add(addToArrayButton);
        leftButtons.add(mergeSortIntsButton);
        leftLabels.add(sortIntsLabel);
        leftLabels.add(addToBinarySearchTreeLabel);
        leftLabels.add(addToTreeSetLabel);
        leftLabels.add(addToPriorityQueueLabel);
        leftLabels.add(addToHashSetLabel);
        leftLabels.add(addToArrayListLabel);
        leftLabels.add(addToSortedArrayListLabel);
        leftLabels.add(addToArrayLabel);
        leftLabels.add(mergeSortIntsLabel);
        for(JButton b : leftButtons) 
            b.setEnabled(false);

        // right button panel
        JPanel rightButtonPanel = new JPanel();
        rightButtonPanel.setBorder(new LineBorder(Color.black,2));
        GridBagLayout rightGridBagLayout = new GridBagLayout();
        rightButtonPanel.setLayout(rightGridBagLayout);
        rightButtonPanel.setPreferredSize(new Dimension(buttonPanelWidth, buttonPanelHeight));


        // right buttons+labels
        searchSortedIntsButton = new JButton("search sorted ints");
        searchSortedIntsButton.addActionListener(new ButtonActionListener(searchSortedIntsButton));
        searchSortedIntsLabel = new JLabel("no result");
        searchBinarySearchTreeButton = new JButton("search bst");
        searchBinarySearchTreeButton.addActionListener(new ButtonActionListener(searchBinarySearchTreeButton));
        searchBinarySearchTreeLabel = new JLabel("no result");
        searchTreeSetButton = new JButton("search treeset");
        searchTreeSetButton.addActionListener(new ButtonActionListener(searchTreeSetButton));
        searchTreeSetLabel = new JLabel("no result");
        searchPriorityQueueButton = new JButton("search priority queue");
        searchPriorityQueueButton.addActionListener(new ButtonActionListener(searchPriorityQueueButton));
        searchPriorityQueueLabel = new JLabel("no result");
        searchHashSetButton = new JButton("search hashset");
        searchHashSetButton.addActionListener(new ButtonActionListener(searchHashSetButton));
        searchHashSetLabel = new JLabel("no result");
        searchArrayListButton = new JButton("search arraylist");
        searchArrayListButton.addActionListener(new ButtonActionListener(searchArrayListButton));
        searchArrayListLabel = new JLabel("no result");
        searchSortedArrayListButton = new JButton("search sorted arraylist");
        searchSortedArrayListButton.addActionListener(new ButtonActionListener(searchSortedArrayListButton));
        searchSortedArrayListLabel = new JLabel("no result");
        searchArrayButton = new JButton("search array");
        searchArrayButton.addActionListener(new ButtonActionListener(searchArrayButton));
        searchArrayLabel = new JLabel("no result");
        searchMergeSortIntsButton = new JButton("search merge sort ints");
        searchMergeSortIntsButton.addActionListener(new ButtonActionListener(searchMergeSortIntsButton));
        searchMergeSortIntsLabel = new JLabel("no result");
        rightButtons.add(searchSortedIntsButton);
        rightButtons.add(searchBinarySearchTreeButton);
        rightButtons.add(searchTreeSetButton);
        rightButtons.add(searchPriorityQueueButton);
        rightButtons.add(searchHashSetButton);
        rightButtons.add(searchArrayListButton);
        rightButtons.add(searchSortedArrayListButton);
        rightButtons.add(searchArrayButton);
        rightButtons.add(searchMergeSortIntsButton);
        rightLabels.add(searchSortedIntsLabel);
        rightLabels.add(searchBinarySearchTreeLabel);
        rightLabels.add(searchTreeSetLabel);
        rightLabels.add(searchPriorityQueueLabel);
        rightLabels.add(searchHashSetLabel);
        rightLabels.add(searchArrayListLabel);
        rightLabels.add(searchSortedArrayListLabel);
        rightLabels.add(searchArrayLabel);
        rightLabels.add(searchMergeSortIntsLabel);
        for(JButton b : rightButtons) 
            b.setEnabled(false);

        // button panel layout
        GridBagConstraints buttonPanelConstraints = new GridBagConstraints();
        buttonPanelConstraints.weightx = 1;
        buttonPanelConstraints.weighty = 1;
        buttonPanelConstraints.fill = GridBagConstraints.NONE;
        buttonPanelConstraints.anchor = GridBagConstraints.LINE_START;
        for(int i = 0; i < rightButtons.size(); i++) {
            buttonPanelConstraints.gridx = 0;
            buttonPanelConstraints.gridy = i;
            buttonPanelConstraints.gridwidth = 1;
            rightGridBagLayout.setConstraints(rightButtons.get(i), buttonPanelConstraints);
            leftGridBagLayout.setConstraints(leftButtons.get(i), buttonPanelConstraints);
            buttonPanelConstraints.gridx = 1;
            buttonPanelConstraints.gridwidth = GridBagConstraints.REMAINDER;
            rightGridBagLayout.setConstraints(rightLabels.get(i), buttonPanelConstraints);
            leftGridBagLayout.setConstraints(leftLabels.get(i), buttonPanelConstraints);
        }

        // add buttons to panels
        for(int i = 0; i < rightButtons.size(); i++) {
            rightButtonPanel.add(rightButtons.get(i));
            rightButtonPanel.add(rightLabels.get(i));
            leftButtonPanel.add(leftButtons.get(i));
            leftButtonPanel.add(leftLabels.get(i));
        }

        // main button panel
        JPanel mainButtonPanel = new JPanel();
        mainButtonPanel.setBorder(new LineBorder(Color.black,2));
        BoxLayout boxLayout = new BoxLayout(mainButtonPanel, BoxLayout.X_AXIS);
		mainButtonPanel.setLayout(boxLayout);
        mainButtonPanel.add(leftButtonPanel);
        mainButtonPanel.add(rightButtonPanel);

        // main panel
        JPanel mainPanel = new JPanel();
        mainPanel.setBorder(new LineBorder(Color.black,2));
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(menuBar, BorderLayout.NORTH);
        mainPanel.add(mainButtonPanel, BorderLayout.CENTER);

        f.setContentPane(mainPanel);
		
		f.validate();
		f.setVisible(true);
    }

    private static void readData(String filename, boolean readSortValues) {
        try {
            ArrayList<Integer> data = new ArrayList<>();
            Scanner sc = new Scanner(new File(filename));
            while(sc.hasNextLine())
                data.add(Integer.parseInt(sc.nextLine()));
            if(readSortValues) {
                sortValues = new int[data.size()];
                for(int i = 0; i < data.size(); i++)
                    sortValues[i] = data.get(i);
                for(JButton b : leftButtons)
                    b.setEnabled(true);
            }
            else {
                searchValues = new int[data.size()];
                for(int i = 0; i < data.size(); i++)
                    searchValues[i] = data.get(i);
                for(JButton b : rightButtons)
                    b.setEnabled(true);
            }
        }
        catch(Exception e) {
            System.out.println(e.toString());
        }
    }

    private static boolean binarySearch(int value, int[] data) {
        int bottom = 0;
        int top = data.length - 1;
        while(bottom <= top) {
            int middle = (bottom + top) / 2;
            if(value < data[middle])
                top = middle - 1;
            else if(value > data[middle])
                bottom = middle + 1;
            else
                return true;
        }
        return false;
    }

    private static void selectionSort() {
        sortedValues = new int[sortValues.length];
        for(int i = 0; i < sortedValues.length; i++)
            sortedValues[i] = sortValues[i];

        for(int i = 0; i < sortedValues.length; i++) {
            int min = i;
            for(int j = i + 1; j < sortedValues.length; j++)
                if(sortedValues[j] < sortedValues[min])
                    min = j;
            if(min != i) {
                int temp = sortedValues[min];
                sortedValues[min] = sortedValues[i];
                sortedValues[i] = temp;
            }
        }
    }

    private static int searchInts() {
        int count = 0;
        for(int i : searchValues)
            if(binarySearch(i, sortedValues))
                count++;
        return count;
    }

    private static void addToBinarySearchTree() {
        for(int i : sortValues)
            bst.insertNode(new Node(i));
    }

    private static int searchBinarySearchTree() {
        int count = 0;
        for(int i : searchValues)
            if(bst.getNode(bst.getRoot(), i) != null)
                count++;
        return count;
    }

    private static void addToTreeSet() {
        for(int i : sortValues)
            treeSetValues.add(i);
    }

    private static int searchTreeSet() {
        int count = 0;
        for(int i : searchValues)
            if(treeSetValues.contains(i))
                count++;
        return count;
    }

    private static void addToHashSet() {
        for(int i : sortValues)
            hashSetValues.add(i);
    }

    private static int searchHashSet() {
        int count = 0;
        for(int i : searchValues)
            if(hashSetValues.contains(i))
                count++;
        return count;
    }

    private static void addToPriorityQueue() {
        priorityQueueValues.clear();
        for(int i : sortValues)
            priorityQueueValues.add(i);
    }

    private static int searchPriorityQueue() {
        int count = 0;
        for(int i : searchValues)
            if(priorityQueueValues.contains(i))
                count++;
        return count;
    }

    private static void addToArrayList() {
        arrayListValues.clear();
        for(int i : sortValues)
            arrayListValues.add(i);
    }

    private static int searchArrayList() {
        int count = 0;
        for(int i : searchValues)
            if(arrayListValues.contains(i))
                count++;
        return count;
    }

    private static void addToSortedArrayList() {
        sortedArrayListValues.clear();
        for(int i : sortValues)
            sortedArrayListValues.add(i);
        Collections.sort(sortedArrayListValues);
    }

    private static int searchSortedArrayList() {
        int count = 0;
        for(int i : searchValues)
            if(Collections.binarySearch(sortedArrayListValues, i) >= 0)
                count++;
        return count;
    }

    private static void addToArray() {
        unsortedValues = new int[sortValues.length];
        for(int i = 0; i < sortValues.length; i++)
            unsortedValues[i] = sortValues[i];
    }

    private static int searchArray() {
        int count = 0;
        for(int i : searchValues)
            for(int j : unsortedValues)
                if(i == j) {
                    count++;
                    break;
                }
        return count;
    }

    private static void mergeSort() {
        mergeSortValues = new int[sortValues.length];
        int[] temp = new int[sortValues.length];
        for(int i = 0; i < sortValues.length; i++) {
            mergeSortValues[i] = sortValues[i];
            temp[i] = sortValues[i];
        }
        for(int subLen = 1; subLen < mergeSortValues.length; subLen *= 2) {
            for(int i = 0; i < mergeSortValues.length; i += (2 * subLen))
                merge(mergeSortValues, i, Math.min(i + subLen, sortValues.length), Math.min(i + (2 * subLen), sortValues.length), temp);
            for(int i = 0; i < temp.length; i++)
                mergeSortValues[i] = temp[i];
        }
    }   
    
    private static void merge(int[] arrA, int left, int right, int end, int[] arrB) {
        int i = left;
        int j = right;
        for(int k = i; k < end; k++) {
            if(j >= end || (i < right && arrA[i] <= arrA[j])) {
                arrB[k] = arrA[i];
                i++;
            }
            else {
                arrB[k] = arrA[j];
                j++;
            }
        }
    }
    
    private static int searchMergeSortInts() {
        int count = 0;
        for(int i : searchValues)
            if(binarySearch(i, mergeSortValues))
                count++;
        return count;
    }

    static class ButtonActionListener implements ActionListener {
		private JButton b;
		
		ButtonActionListener(JButton b) {
			this.b = b;
		}
		
		public void actionPerformed(ActionEvent e) {
			System.out.println("action performed on " + b.getText() + " button");
            long t0 = 0;
            long t1 = 0;
            int count = 0;
            switch(b.getText()) {
                case "sort ints":
                    t0 = System.currentTimeMillis();
                    selectionSort();
                    t1 = System.currentTimeMillis();
                    sortIntsLabel.setText(t1 - t0 + "ms");
                    if(searchValues != null)
                        searchSortedIntsButton.setEnabled(true);
                    break;
                case "search sorted ints":
                    t0 = System.currentTimeMillis();
                    count = searchInts();
                    t1 = System.currentTimeMillis();
                    searchSortedIntsLabel.setText(String.format("%d / %dms", count, t1-t0));
                    break;
                case "add to bst":
                    t0 = System.currentTimeMillis();
                    addToBinarySearchTree();
                    t1 = System.currentTimeMillis();
                    addToBinarySearchTreeLabel.setText(t1 - t0 + "ms");
                    if(searchValues != null)
                        searchBinarySearchTreeButton.setEnabled(true);
                    break;
                case "search bst":
                    t0 = System.currentTimeMillis();
                    count = searchBinarySearchTree();
                    t1 = System.currentTimeMillis();
                    searchBinarySearchTreeLabel.setText(String.format("%d / %dms", count, t1-t0));
                case "add to treeset":
                    t0 = System.currentTimeMillis();
                    addToTreeSet();
                    t1 = System.currentTimeMillis();
                    addToTreeSetLabel.setText(t1 - t0 + "ms");
                    if(searchValues != null)
                        searchTreeSetButton.setEnabled(true);
                    break;
                case "search treeset":
                    t0 = System.currentTimeMillis();
                    count = searchTreeSet();
                    t1 = System.currentTimeMillis();
                    searchTreeSetLabel.setText(String.format("%d / %dms", count, t1-t0));
                    break;
                case "add to priority queue":
                    t0 = System.currentTimeMillis();
                    addToPriorityQueue();
                    t1 = System.currentTimeMillis();
                    addToPriorityQueueLabel.setText(t1 - t0 + "ms");
                    if(searchValues != null)
                        searchPriorityQueueButton.setEnabled(true);
                    break;
                case "search priority queue":
                    t0 = System.currentTimeMillis();
                    count = searchPriorityQueue();
                    t1 = System.currentTimeMillis();
                    searchPriorityQueueLabel.setText(String.format("%d / %dms", count, t1-t0));
                    break;
                case "add to hashset":
                    t0 = System.currentTimeMillis();
                    addToHashSet();
                    t1 = System.currentTimeMillis();
                    addToHashSetLabel.setText(t1 - t0 + "ms");
                    if(searchValues != null)
                        searchHashSetButton.setEnabled(true);
                    break;
                case "search hashset":
                    t0 = System.currentTimeMillis();
                    count = searchHashSet();
                    t1 = System.currentTimeMillis();
                    searchHashSetLabel.setText(String.format("%d / %dms", count, t1-t0));
                    break;
                case "add to arraylist":
                    t0 = System.currentTimeMillis();
                    addToArrayList();
                    t1 = System.currentTimeMillis();
                    addToArrayListLabel.setText(t1 - t0 + "ms");
                    if(searchValues != null)
                        searchArrayListButton.setEnabled(true);
                    break;
                case "search arraylist":
                    t0 = System.currentTimeMillis();
                    count = searchArrayList();
                    t1 = System.currentTimeMillis();
                    searchArrayListLabel.setText(String.format("%d / %dms", count, t1-t0));
                    break;
                case "add to sorted arraylist":
                    t0 = System.currentTimeMillis();
                    addToSortedArrayList();
                    t1 = System.currentTimeMillis();
                    addToSortedArrayListLabel.setText(t1 - t0 + "ms");
                    if(searchValues != null)
                        searchSortedArrayListButton.setEnabled(true);
                    break;
                case "search sorted arraylist":
                    t0 = System.currentTimeMillis();
                    count = searchSortedArrayList();
                    t1 = System.currentTimeMillis();
                    searchSortedArrayListLabel.setText(String.format("%d / %dms", count, t1-t0));
                    break;
                case "add to array":
                    t0 = System.currentTimeMillis();
                    addToArray();
                    t1 = System.currentTimeMillis();
                    addToArrayLabel.setText(t1 - t0 + "ms");
                    if(searchValues != null)
                        searchArrayButton.setEnabled(true);
                    break;
                case "search array":
                    t0 = System.currentTimeMillis();
                    count = searchArray();
                    t1 = System.currentTimeMillis();
                    searchArrayLabel.setText(String.format("%d / %dms", count, t1-t0));
                    break;
                case "merge sort ints":
                    t0 = System.currentTimeMillis();
                    mergeSort();
                    t1 = System.currentTimeMillis();
                    mergeSortIntsLabel.setText(t1 - t0 + "ms");
                    if(searchValues != null)
                        searchMergeSortIntsButton.setEnabled(true);
                    break;
                case "search merge sort ints":
                    t0 = System.currentTimeMillis();
                    count = searchMergeSortInts();
                    t1 = System.currentTimeMillis();
                    searchMergeSortIntsLabel.setText(String.format("%d / %dms", count, t1-t0));
                    break;
                default:
                    t0 = System.currentTimeMillis();
                    count = searchArray();
                    t1 = System.currentTimeMillis();
                    searchArrayLabel.setText(String.format("%d / %dms", count, t1-t0));
            }
		}
	}

    static class MenuItemActionListener implements java.awt.event.ActionListener {
		private javax.swing.JMenuItem m;
		
		MenuItemActionListener(javax.swing.JMenuItem m) {
			this.m = m;
		}
		
		public void actionPerformed(java.awt.event.ActionEvent e) {
			System.out.println("action performed on " + m.getText() + " menu item");
			
			switch(m.getText()) {
                case "Read sort file":
                    readData(sortFile, true);
                    break;
                case "Read search file":
                    readData(searchFile, false);
                    if(sortedValues != null)
                        searchSortedIntsButton.setEnabled(true);
                    if(bst.getRoot() != null)
                        searchBinarySearchTreeButton.setEnabled(true);
                    if(treeSetValues.size() > 0)
                        searchTreeSetButton.setEnabled(true);
                    if(priorityQueueValues.size() > 0)
                        searchPriorityQueueButton.setEnabled(true);
                    if(hashSetValues.size() > 0)
                        searchHashSetButton.setEnabled(true);
                    if(arrayListValues.size() > 0)
                        searchArrayListButton.setEnabled(true);
                    if(sortedArrayListValues.size() > 0)
                        searchSortedArrayListButton.setEnabled(true);
                    if(unsortedValues != null)
                        searchArrayButton.setEnabled(true);
                    if(mergeSortValues != null)
                        searchMergeSortIntsButton.setEnabled(true);
                    break;
                default:
                    System.exit(0);
            }
			
		}
	}

}
