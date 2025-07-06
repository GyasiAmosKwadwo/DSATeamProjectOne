import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * GUI implementation for the DSA Team Project One - Search and Sort Algorithms
 * Provides a modern graphical interface for running various search and sort
 * algorithms
 */
public class DSAGui extends JFrame {
    private JTextArea inputArea;
    private JTextArea outputArea;
    private JTextField targetField;
    private JButton linearSearchBtn, binarySearchBtn, interpolationSearchBtn, bubbleSortBtn;
    private JButton clearBtn, aboutBtn;
    private JPanel algorithmPanel;
    private JScrollPane inputScroll, outputScroll;

    // Colors for modern UI
    private final Color PRIMARY_COLOR = new Color(63, 81, 181);
    private final Color SECONDARY_COLOR = new Color(92, 107, 192);
    private final Color SUCCESS_COLOR = new Color(76, 175, 80);
    private final Color ERROR_COLOR = new Color(244, 67, 54);
    private final Color BACKGROUND_COLOR = new Color(245, 245, 245);
    private final Color CARD_COLOR = Color.WHITE;

    public DSAGui() {
        initializeGUI();
        setupEventListeners();
    }

    private void initializeGUI() {
        setTitle("DSA Team Project One - Search & Sort Algorithms");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 700);
        setLocationRelativeTo(null);
        getContentPane().setBackground(BACKGROUND_COLOR);

        // Main layout
        setLayout(new BorderLayout(10, 10));

        // Header
        JPanel headerPanel = createHeaderPanel();
        add(headerPanel, BorderLayout.NORTH);

        // Main content
        JPanel mainPanel = createMainPanel();
        add(mainPanel, BorderLayout.CENTER);

        // Footer
        JPanel footerPanel = createFooterPanel();
        add(footerPanel, BorderLayout.SOUTH);

        // Apply modern styling
        applyModernStyling();
    }

    private JPanel createHeaderPanel() {
        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setBackground(PRIMARY_COLOR);
        headerPanel.setBorder(new EmptyBorder(15, 20, 15, 20));

        JLabel titleLabel = new JLabel("DSA Algorithm Visualizer");
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 24));
        titleLabel.setForeground(Color.WHITE);

        JLabel subtitleLabel = new JLabel("Search and Sort Algorithms Demo");
        subtitleLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        subtitleLabel.setForeground(Color.WHITE);

        JPanel titlePanel = new JPanel(new BorderLayout());
        titlePanel.setBackground(PRIMARY_COLOR);
        titlePanel.add(titleLabel, BorderLayout.NORTH);
        titlePanel.add(subtitleLabel, BorderLayout.SOUTH);

        headerPanel.add(titlePanel, BorderLayout.WEST);

        return headerPanel;
    }

    private JPanel createMainPanel() {
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBackground(BACKGROUND_COLOR);
        mainPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

        // Left panel - Input and controls
        JPanel leftPanel = createLeftPanel();

        // Right panel - Output and results
        JPanel rightPanel = createRightPanel();

        // Split pane for responsive design
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, leftPanel, rightPanel);
        splitPane.setDividerLocation(400);
        splitPane.setResizeWeight(0.4);
        splitPane.setBorder(null);

        mainPanel.add(splitPane, BorderLayout.CENTER);

        return mainPanel;
    }

    private JPanel createLeftPanel() {
        JPanel leftPanel = new JPanel(new BorderLayout(10, 10));
        leftPanel.setBackground(BACKGROUND_COLOR);

        // Input section
        JPanel inputPanel = createInputPanel();
        leftPanel.add(inputPanel, BorderLayout.NORTH);

        // Algorithm buttons
        algorithmPanel = createAlgorithmPanel();
        leftPanel.add(algorithmPanel, BorderLayout.CENTER);

        // Control buttons
        JPanel controlPanel = createControlPanel();
        leftPanel.add(controlPanel, BorderLayout.SOUTH);

        return leftPanel;
    }

    private JPanel createInputPanel() {
        JPanel inputPanel = new JPanel(new BorderLayout(10, 10));
        inputPanel.setBackground(CARD_COLOR);
        inputPanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createTitledBorder(
                        BorderFactory.createLineBorder(PRIMARY_COLOR, 2),
                        "Data Input",
                        TitledBorder.DEFAULT_JUSTIFICATION,
                        TitledBorder.DEFAULT_POSITION,
                        new Font("Segoe UI", Font.BOLD, 14),
                        PRIMARY_COLOR),
                new EmptyBorder(10, 10, 10, 10)));

        // Input area
        inputArea = new JTextArea(4, 30);
        inputArea.setFont(new Font("Consolas", Font.PLAIN, 12));
        inputArea.setLineWrap(true);
        inputArea.setWrapStyleWord(true);
        inputArea.setBorder(new EmptyBorder(5, 5, 5, 5));
        inputArea.setText("Enter values separated by commas or spaces...");
        inputArea.setForeground(Color.GRAY);

        // Add focus listener for placeholder behavior
        inputArea.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                if (inputArea.getText().equals("Enter values separated by commas or spaces...")) {
                    inputArea.setText("");
                    inputArea.setForeground(Color.BLACK);
                }
            }

            public void focusLost(java.awt.event.FocusEvent evt) {
                if (inputArea.getText().trim().isEmpty()) {
                    inputArea.setText("Enter values separated by commas or spaces...");
                    inputArea.setForeground(Color.GRAY);
                }
            }
        });

        inputScroll = new JScrollPane(inputArea);
        inputScroll.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));

        JPanel inputFieldPanel = new JPanel(new BorderLayout(5, 5));
        inputFieldPanel.setBackground(CARD_COLOR);
        inputFieldPanel.add(new JLabel("Data:"), BorderLayout.WEST);
        inputFieldPanel.add(inputScroll, BorderLayout.CENTER);

        // Target value field
        JPanel targetPanel = new JPanel(new BorderLayout(5, 5));
        targetPanel.setBackground(CARD_COLOR);
        targetPanel.add(new JLabel("Target:"), BorderLayout.WEST);

        targetField = new JTextField(15);
        targetField.setFont(new Font("Consolas", Font.PLAIN, 12));
        targetField.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.LIGHT_GRAY),
                new EmptyBorder(5, 5, 5, 5)));
        targetPanel.add(targetField, BorderLayout.CENTER);

        inputPanel.add(inputFieldPanel, BorderLayout.CENTER);
        inputPanel.add(targetPanel, BorderLayout.SOUTH);

        return inputPanel;
    }

    private JPanel createAlgorithmPanel() {
        JPanel algorithmPanel = new JPanel(new GridLayout(2, 2, 10, 10));
        algorithmPanel.setBackground(CARD_COLOR);
        algorithmPanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createTitledBorder(
                        BorderFactory.createLineBorder(PRIMARY_COLOR, 2),
                        "Algorithms",
                        TitledBorder.DEFAULT_JUSTIFICATION,
                        TitledBorder.DEFAULT_POSITION,
                        new Font("Segoe UI", Font.BOLD, 14),
                        PRIMARY_COLOR),
                new EmptyBorder(15, 15, 15, 15)));

        // Create algorithm buttons
        linearSearchBtn = createAlgorithmButton("Linear Search", "O(n)", SUCCESS_COLOR);
        binarySearchBtn = createAlgorithmButton("Binary Search", "O(log n)", new Color(33, 150, 243));
        interpolationSearchBtn = createAlgorithmButton("Interpolation Search", "O(log log n)", new Color(156, 39, 176));
        bubbleSortBtn = createAlgorithmButton("Bubble Sort", "O(n²)", new Color(255, 152, 0));

        algorithmPanel.add(linearSearchBtn);
        algorithmPanel.add(binarySearchBtn);
        algorithmPanel.add(interpolationSearchBtn);
        algorithmPanel.add(bubbleSortBtn);

        return algorithmPanel;
    }

    private JButton createAlgorithmButton(String name, String complexity, Color color) {
        JButton button = new JButton();
        button.setLayout(new BorderLayout());
        button.setBackground(color);
        button.setForeground(Color.WHITE);
        button.setFont(new Font("Segoe UI", Font.BOLD, 12));
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));

        JLabel nameLabel = new JLabel(name, SwingConstants.CENTER);
        nameLabel.setFont(new Font("Segoe UI", Font.BOLD, 12));
        nameLabel.setForeground(Color.WHITE);

        JLabel complexityLabel = new JLabel(complexity, SwingConstants.CENTER);
        complexityLabel.setFont(new Font("Segoe UI", Font.PLAIN, 10));
        complexityLabel.setForeground(Color.WHITE);

        button.add(nameLabel, BorderLayout.CENTER);
        button.add(complexityLabel, BorderLayout.SOUTH);

        // Hover effect
        button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBackground(color.darker());
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(color);
            }
        });

        return button;
    }

    private JPanel createControlPanel() {
        JPanel controlPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        controlPanel.setBackground(BACKGROUND_COLOR);

        clearBtn = createControlButton("Clear", PRIMARY_COLOR);
        aboutBtn = createControlButton("About", SECONDARY_COLOR);

        controlPanel.add(clearBtn);
        controlPanel.add(aboutBtn);

        return controlPanel;
    }

    private JButton createControlButton(String text, Color color) {
        JButton button = new JButton(text);
        button.setBackground(color);
        button.setForeground(Color.WHITE);
        button.setFont(new Font("Segoe UI", Font.BOLD, 12));
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));

        button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBackground(color.darker());
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(color);
            }
        });

        return button;
    }

    private JPanel createRightPanel() {
        JPanel rightPanel = new JPanel(new BorderLayout(10, 10));
        rightPanel.setBackground(BACKGROUND_COLOR);

        // Output area
        outputArea = new JTextArea();
        outputArea.setFont(new Font("Consolas", Font.PLAIN, 12));
        outputArea.setEditable(false);
        outputArea.setBackground(CARD_COLOR);
        outputArea.setBorder(new EmptyBorder(10, 10, 10, 10));
        outputArea.setText("Welcome to DSA Algorithm Visualizer!\n\n" +
                "Instructions:\n" +
                "1. Enter your data in the input field (numbers, text, or mixed)\n" +
                "2. For search algorithms, specify a target value\n" +
                "3. Click on any algorithm button to execute\n" +
                "4. Results will appear here\n\n" +
                "Examples:\n" +
                "• Numbers: 1, 2, 3, 4, 5\n" +
                "• Mixed: apple, 42, 3.14, banana\n" +
                "• Spaces: 10 20 30 40 50\n");

        outputScroll = new JScrollPane(outputArea);
        outputScroll.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createTitledBorder(
                        BorderFactory.createLineBorder(PRIMARY_COLOR, 2),
                        "Output & Results",
                        TitledBorder.DEFAULT_JUSTIFICATION,
                        TitledBorder.DEFAULT_POSITION,
                        new Font("Segoe UI", Font.BOLD, 14),
                        PRIMARY_COLOR),
                new EmptyBorder(5, 5, 5, 5)));

        rightPanel.add(outputScroll, BorderLayout.CENTER);

        return rightPanel;
    }

    private JPanel createFooterPanel() {
        JPanel footerPanel = new JPanel(new BorderLayout());
        footerPanel.setBackground(PRIMARY_COLOR);
        footerPanel.setBorder(new EmptyBorder(10, 20, 10, 20));

        JLabel footerLabel = new JLabel("DSA Team Project One © 2025");
        footerLabel.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        footerLabel.setForeground(Color.WHITE);

        footerPanel.add(footerLabel, BorderLayout.WEST);

        return footerPanel;
    }

    private void applyModernStyling() {
        // Apply modern styling
        SwingUtilities.updateComponentTreeUI(this);
    }

    private void setupEventListeners() {
        linearSearchBtn.addActionListener(_ -> runLinearSearch());
        binarySearchBtn.addActionListener(_ -> runBinarySearch());
        interpolationSearchBtn.addActionListener(_ -> runInterpolationSearch());
        bubbleSortBtn.addActionListener(_ -> runBubbleSort());
        clearBtn.addActionListener(_ -> clearAll());
        aboutBtn.addActionListener(_ -> showAbout());
    }

    private ArrayList<Object> parseInput() {
        String input = inputArea.getText().trim();
        if (input.equals("Enter values separated by commas or spaces...") || input.isEmpty()) {
            showError("Please enter some data first!");
            return null;
        }

        ArrayList<Object> list = new ArrayList<>();
        String[] tokens = input.split("[,\\s]+");

        for (String token : tokens) {
            if (token.isEmpty())
                continue;
            try {
                list.add(Integer.parseInt(token));
            } catch (NumberFormatException e1) {
                try {
                    list.add(Float.parseFloat(token));
                } catch (NumberFormatException e2) {
                    list.add(token);
                }
            }
        }

        return list;
    }

    private void runLinearSearch() {
        ArrayList<Object> list = parseInput();
        if (list == null)
            return;

        String targetStr = targetField.getText().trim();
        if (targetStr.isEmpty()) {
            showError("Please enter a target value!");
            return;
        }

        Object target = InputUtils.parseObjectValue(targetStr);

        outputArea.setText("=== LINEAR SEARCH ===\n");
        outputArea.append("Input: " + list + "\n");
        outputArea.append("Target: " + target + "\n");
        outputArea.append("Searching...\n\n");

        // Use the same comparison logic as the console version
        int result = performLinearSearchAlgorithm(list, target);

        if (result != -1) {
            outputArea.append("✓ SUCCESS: Element '" + target + "' found at index " + result + "\n");
            outputArea.append("Time Complexity: O(n)\n");
            outputArea.append("Space Complexity: O(1)\n");
        } else {
            outputArea.append("✗ NOT FOUND: Element '" + target + "' not found in the list\n");
        }
    }

    /**
     * Linear search algorithm using the same logic as linearSearch.java
     */
    private int performLinearSearchAlgorithm(ArrayList<Object> list, Object target) {
        for (int i = 0; i < list.size(); i++) {
            if (compareElements(list.get(i), target)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Element comparison using the same logic as linearSearch.java
     */
    private boolean compareElements(Object element, Object target) {
        // Direct equality check
        if (element.equals(target)) {
            return true;
        }

        // String representation check
        if (element.toString().equals(target.toString())) {
            return true;
        }

        // Numeric comparison for numbers
        if (InputUtils.isNumeric(element) && InputUtils.isNumeric(target)) {
            double val1 = InputUtils.getNumericValue(element);
            double val2 = InputUtils.getNumericValue(target);
            return val1 == val2;
        }

        return false;
    }

    private void runBinarySearch() {
        ArrayList<Object> list = parseInput();
        if (list == null)
            return;

        String targetStr = targetField.getText().trim();
        if (targetStr.isEmpty()) {
            showError("Please enter a target value!");
            return;
        }

        outputArea.setText("=== BINARY SEARCH ===\n");
        outputArea.append("Input: " + list + "\n");

        // Filter numeric values
        ArrayList<Object> numericList = new ArrayList<>();
        for (Object obj : list) {
            if (obj instanceof Integer || obj instanceof Float) {
                numericList.add(obj);
            } else {
                try {
                    numericList.add(Integer.parseInt(obj.toString()));
                } catch (NumberFormatException e1) {
                    try {
                        numericList.add(Float.parseFloat(obj.toString()));
                    } catch (NumberFormatException e2) {
                        outputArea.append("Warning: '" + obj + "' is not numeric and will be ignored\n");
                    }
                }
            }
        }

        if (numericList.isEmpty()) {
            showError("No numeric values found! Binary search requires numeric data.");
            return;
        }

        // Sort the list
        numericList.sort((a, b) -> {
            double aVal = InputUtils.getNumericValue(a);
            double bVal = InputUtils.getNumericValue(b);
            return Double.compare(aVal, bVal);
        });

        outputArea.append("Sorted array: " + numericList + "\n");

        // Parse target
        Object target = InputUtils.parseObjectValue(targetStr);
        double targetValue;
        try {
            targetValue = Double.parseDouble(target.toString());
        } catch (NumberFormatException e) {
            showError("Target value must be numeric for binary search!");
            return;
        }

        outputArea.append("Target: " + InputUtils.formatNumber(targetValue) + "\n");
        outputArea.append("Searching...\n\n");

        // Perform binary search
        int result = binarySearchList(numericList, targetValue);

        if (result != -1) {
            outputArea.append("✓ SUCCESS: Element '" + InputUtils.formatNumber(targetValue) + "' found at index "
                    + result + "\n");
            outputArea.append("Time Complexity: O(log n)\n");
            outputArea.append("Space Complexity: O(1)\n");
        } else {
            outputArea.append("✗ NOT FOUND: Element '" + InputUtils.formatNumber(targetValue)
                    + "' not found in the sorted list\n");
        }
    }

    private int binarySearchList(ArrayList<Object> list, double target) {
        int low = 0;
        int high = list.size() - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            double midValue = InputUtils.getNumericValue(list.get(mid));

            if (midValue == target) {
                return mid;
            } else if (midValue < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    private void runInterpolationSearch() {
        ArrayList<Object> list = parseInput();
        if (list == null)
            return;

        String targetStr = targetField.getText().trim();
        if (targetStr.isEmpty()) {
            showError("Please enter a target value!");
            return;
        }

        outputArea.setText("=== INTERPOLATION SEARCH ===\n");
        outputArea.append("Input: " + list + "\n");

        // Filter integer values only
        ArrayList<Integer> intList = new ArrayList<>();
        for (Object obj : list) {
            if (obj instanceof Integer) {
                intList.add((Integer) obj);
            } else {
                try {
                    intList.add(Integer.parseInt(obj.toString()));
                } catch (NumberFormatException e) {
                    outputArea.append("Warning: '" + obj + "' is not an integer and will be ignored\n");
                }
            }
        }

        if (intList.isEmpty()) {
            showError("No integer values found! Interpolation search requires integer data.");
            return;
        }

        // Sort the list
        intList.sort(Integer::compareTo);
        outputArea.append("Sorted array: " + intList + "\n");

        // Parse target
        int target;
        try {
            target = Integer.parseInt(targetStr);
        } catch (NumberFormatException e) {
            showError("Target value must be an integer for interpolation search!");
            return;
        }

        outputArea.append("Target: " + target + "\n");
        outputArea.append("Searching...\n\n");

        // Perform interpolation search
        int result = interpolationSearchList(intList, target);

        if (result != -1) {
            outputArea.append("✓ SUCCESS: Element '" + target + "' found at index " + result + "\n");
            outputArea.append("Time Complexity: O(log log n) average, O(n) worst case\n");
            outputArea.append("Space Complexity: O(1)\n");
        } else {
            outputArea.append("✗ NOT FOUND: Element '" + target + "' not found in the sorted list\n");
        }
    }

    private int interpolationSearchList(ArrayList<Integer> list, int target) {
        int low = 0;
        int high = list.size() - 1;

        while (low <= high && target >= list.get(low) && target <= list.get(high)) {
            if (low == high) {
                if (list.get(low) == target)
                    return low;
                return -1;
            }

            int pos = low + (((target - list.get(low)) * (high - low)) / (list.get(high) - list.get(low)));

            if (list.get(pos) == target) {
                return pos;
            } else if (list.get(pos) < target) {
                low = pos + 1;
            } else {
                high = pos - 1;
            }
        }
        return -1;
    }

    private void runBubbleSort() {
        ArrayList<Object> list = parseInput();
        if (list == null)
            return;

        outputArea.setText("=== BUBBLE SORT ===\n");
        outputArea.append("Input: " + list + "\n");
        outputArea.append("Sorting...\n\n");

        // Create a copy for sorting
        ArrayList<Object> sortedList = new ArrayList<>(list);

        // Bubble sort implementation
        int n = sortedList.size();
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (InputUtils.compareObjects(sortedList.get(j), sortedList.get(j + 1)) > 0) {
                    // Swap elements
                    Object temp = sortedList.get(j);
                    sortedList.set(j, sortedList.get(j + 1));
                    sortedList.set(j + 1, temp);
                    swapped = true;
                }
            }
            if (!swapped)
                break; // Array is already sorted
        }

        outputArea.append("✓ SORTED: " + sortedList + "\n");
        outputArea.append("Time Complexity: O(n²)\n");
        outputArea.append("Space Complexity: O(1)\n");
        outputArea.append("Sorting Order: Numbers first (ascending), then strings (alphabetical)\n");
    }

    private void clearAll() {
        inputArea.setText("Enter values separated by commas or spaces...");
        inputArea.setForeground(Color.GRAY);
        targetField.setText("");
        outputArea.setText("Welcome to DSA Algorithm Visualizer!\n\n" +
                "Instructions:\n" +
                "1. Enter your data in the input field (numbers, text, or mixed)\n" +
                "2. For search algorithms, specify a target value\n" +
                "3. Click on any algorithm button to execute\n" +
                "4. Results will appear here\n\n" +
                "Examples:\n" +
                "• Numbers: 1, 2, 3, 4, 5\n" +
                "• Mixed: apple, 42, 3.14, banana\n" +
                "• Spaces: 10 20 30 40 50\n");
    }

    private void showAbout() {
        JDialog aboutDialog = new JDialog(this, "About DSA Algorithm Visualizer", true);
        aboutDialog.setSize(500, 400);
        aboutDialog.setLocationRelativeTo(this);

        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(new EmptyBorder(20, 20, 20, 20));
        panel.setBackground(CARD_COLOR);

        JLabel titleLabel = new JLabel("DSA Algorithm Visualizer", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));
        titleLabel.setForeground(PRIMARY_COLOR);

        JTextArea infoArea = new JTextArea();
        infoArea.setEditable(false);
        infoArea.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        infoArea.setBackground(CARD_COLOR);
        infoArea.setText(
                "DSA Team Project One\n" +
                        "Search and Sort Algorithms Visualizer\n\n" +
                        "This application demonstrates various search and sort algorithms:\n\n" +
                        "SEARCH ALGORITHMS:\n" +
                        "• Linear Search - O(n) time complexity\n" +
                        "• Binary Search - O(log n) time complexity\n" +
                        "• Interpolation Search - O(log log n) average case\n\n" +
                        "SORTING ALGORITHMS:\n" +
                        "• Bubble Sort - O(n²) time complexity\n\n" +
                        "FEATURES:\n" +
                        "• Mixed data type support\n" +
                        "• Real-time algorithm execution\n" +
                        "• Modern graphical interface\n" +
                        "• Detailed results and complexity analysis\n\n" +
                        "© 2025 DSA Team Project One");

        JScrollPane scrollPane = new JScrollPane(infoArea);
        scrollPane.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));

        JButton closeButton = new JButton("Close");
        closeButton.setBackground(PRIMARY_COLOR);
        closeButton.setForeground(Color.WHITE);
        closeButton.setFont(new Font("Segoe UI", Font.BOLD, 12));
        closeButton.setFocusPainted(false);
        closeButton.addActionListener(_ -> aboutDialog.dispose());

        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.setBackground(CARD_COLOR);
        buttonPanel.add(closeButton);

        panel.add(titleLabel, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        aboutDialog.add(panel);
        aboutDialog.setVisible(true);
    }

    private void showError(String message) {
        JOptionPane.showMessageDialog(this, message, "Input Error", JOptionPane.ERROR_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new DSAGui().setVisible(true);
        });
    }
}
