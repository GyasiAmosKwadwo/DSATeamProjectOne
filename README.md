# DSA Algorithm Visualizer 🚀

A comprehensive Java application that demonstrates fundamental Data Structures and Algorithms (DSA) through both modern GUI and console interfaces. This project implements various search and sorting algorithms with user-friendly visualizations and detailed complexity analysis.

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![Swing](https://img.shields.io/badge/Swing-GUI-blue?style=for-the-badge)
![Algorithms](https://img.shields.io/badge/Algorithms-DSA-green?style=for-the-badge)

## 🌟 Features

### 🎨 **Dual Interface**

- **Modern GUI**: Beautiful Swing-based graphical interface with real-time visualization
- **Console Interface**: Clean command-line interface for quick testing and debugging

### 🔍 **Search Algorithms**

- **Linear Search** - O(n) | Sequential element checking
- **Binary Search** - O(log n) | Efficient sorted array searching
- **Interpolation Search** - O(log log n) | Smart position estimation for uniform data

### 📊 **Sorting Algorithms**

- **Bubble Sort** - O(n²) | Educational step-by-step sorting with element swapping

### 🛠️ **Advanced Features**

- **Mixed Data Types**: Supports integers, floats, and strings in the same dataset
- **Robust Input Parsing**: Intelligent type detection and conversion
- **Error Handling**: User-friendly error messages and input validation
- **Complexity Analysis**: Real-time time and space complexity information
- **Professional UI**: Modern design with hover effects and visual feedback

## 📋 Table of Contents

- [Installation](#-installation)
- [Usage](#-usage)
- [Algorithm Details](#-algorithm-details)
- [Project Structure](#-project-structure)
- [Examples](#-examples)
- [Contributing](#-contributing)
- [License](#-license)

## 🚀 Installation

### Prerequisites

- Java Development Kit (JDK) 8 or higher
- Windows OS (for batch files) or any OS with Java support

### Quick Start

1. **Clone the repository**

   ```bash
   git clone https://github.com/yourusername/DSATeamProjectOne.git
   cd DSATeamProjectOne
   ```

2. **Navigate to source directory**

   ```bash
   cd Search-Sort-Algorithms/src
   ```

3. **Run the application**

   **GUI Version (Recommended):**

   ```bash
   # Windows
   run_gui.bat

   # Or PowerShell
   .\run_gui.ps1

   # Manual
   javac -d "out/production/Search-Sort-Algorithms" *.java
   java -cp "out/production/Search-Sort-Algorithms" DSAGui
   ```

   **Console Version:**

   ```bash
   # Windows
   run_console.bat

   # Manual
   javac -d "out/production/Search-Sort-Algorithms" *.java
   java -cp "out/production/Search-Sort-Algorithms" Main
   ```

## 📖 Usage

### GUI Interface

1. **Launch** the GUI using `run_gui.bat`
2. **Enter data** in the input field (e.g., `1, 2, 3, 4, 5` or `apple, 42, banana`)
3. **Set target** value for search algorithms
4. **Click algorithm** button to execute
5. **View results** with detailed analysis in the output panel

### Console Interface

1. **Launch** the console using `run_console.bat`
2. **Select** algorithm from the numbered menu
3. **Enter data** when prompted
4. **Specify target** for search algorithms
5. **View results** in the terminal

### Input Formats

- **Comma-separated**: `1, 2, 3, 4, 5`
- **Space-separated**: `1 2 3 4 5`
- **Mixed types**: `apple, 42, 3.14, banana`

## 🧮 Algorithm Details

| Algorithm                | Time Complexity              | Space Complexity | Best Use Case                        |
| ------------------------ | ---------------------------- | ---------------- | ------------------------------------ |
| **Linear Search**        | O(n)                         | O(1)             | Small datasets, unsorted data        |
| **Binary Search**        | O(log n)                     | O(1)             | Large sorted datasets                |
| **Interpolation Search** | O(log log n) avg, O(n) worst | O(1)             | Uniformly distributed sorted data    |
| **Bubble Sort**          | O(n²)                        | O(1)             | Educational purposes, small datasets |

### 🔍 Search Algorithm Details

#### Linear Search

- **Description**: Checks each element sequentially until target is found
- **Data Types**: Mixed (integers, floats, strings)
- **Requirements**: None (works with unsorted data)

#### Binary Search

- **Description**: Repeatedly divides sorted array in half
- **Data Types**: Numeric (integers, floats)
- **Requirements**: Sorted array (automatically sorted)

#### Interpolation Search

- **Description**: Estimates position based on value distribution
- **Data Types**: Integers only
- **Requirements**: Sorted, uniformly distributed data

### 📊 Sorting Algorithm Details

#### Bubble Sort

- **Description**: Repeatedly swaps adjacent elements if in wrong order
- **Data Types**: Mixed (numbers sorted numerically, strings alphabetically)
- **Behavior**: Numbers first, then strings in alphabetical order

## 🗂️ Project Structure

```
DSATeamProjectOne/
├── README.md
└── Search-Sort-Algorithms/
    └── src/
        ├── DSAGui.java              # Main GUI application
        ├── Main.java                # Console interface
        ├── InputUtils.java          # Shared input/parsing utilities
        ├── linearSearch.java        # Linear search implementation
        ├── binarySearch.java        # Binary search implementation
        ├── interporationSearch.java # Interpolation search implementation
        ├── bubbleSort.java          # Bubble sort implementation
        ├── run_gui.bat             # Windows GUI launcher
        ├── run_console.bat         # Windows console launcher
        ├── run_gui.ps1             # PowerShell GUI launcher
        └── out/                    # Compiled output directory
```

## 💡 Examples

### Example 1: Linear Search

```
Input: 1, 2, 3, 4, 5
Target: 3
Output: ✓ SUCCESS: Element '3' found at index 2
```

### Example 2: Mixed Data Bubble Sort

```
Input: banana, 42, 3.14, apple, 1
Output: [1, 3.14, 42, apple, banana]
```

### Example 3: Binary Search

```
Input: 5, 1, 9, 3, 7
Sorted: [1, 3, 5, 7, 9]
Target: 7
Output: ✓ SUCCESS: Element '7' found at index 3
```

## 🛠️ Technical Features

- **Robust Type Handling**: Intelligent comparison system handles type mismatches
- **Memory Efficient**: Optimized algorithms with minimal space complexity
- **Error Recovery**: Graceful handling of invalid inputs and edge cases
- **Cross-Platform**: Works on any system with Java support
- **Clean Architecture**: Modular design with separated concerns

## 🤝 Contributing

Contributions are welcome! Here's how you can help:

1. **Fork** the repository
2. **Create** a feature branch (`git checkout -b feature/AmazingFeature`)
3. **Commit** your changes (`git commit -m 'Add some AmazingFeature'`)
4. **Push** to the branch (`git push origin feature/AmazingFeature`)
5. **Open** a Pull Request

### Areas for Contribution

- Additional sorting algorithms (Quick Sort, Merge Sort, etc.)
- More search algorithms (Exponential Search, Fibonacci Search)
- Enhanced GUI features and animations
- Unit tests and documentation
- Performance optimizations

## 📜 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## 👥 Authors

- **Your Name** - _Initial work_ - [YourGitHub](https://github.com/yourusername)

## 🙏 Acknowledgments

- Inspired by fundamental computer science algorithms
- Built for educational purposes and algorithm visualization
- Thanks to the Java Swing community for GUI insights

---

⭐ **Star this repository if you found it helpful!** ⭐

📫 **Questions?** Feel free to open an issue or reach out!
