# Set on Binary Search Tree (BST)

## Description
The **Set on Binary Search Tree (BST)** project implements a `Set` data structure layered on top of a `BinaryTree`. By leveraging the properties of a binary search tree (BST), the project achieves more efficient search, insertion, and removal operations compared to linear implementations. This implementation follows the kernel design pattern, ensuring modularity and adherence to strict specifications.

This project emphasizes:
- Kernel-level programming using binary search trees.
- Debugging interconnected methods and ensuring representation invariants.
- Designing systematic test plans to verify correctness and robustness.

---

## Objectives
1. Implement a `SetKernel` interface using a binary search tree as the underlying data structure.
2. Develop constructors and kernel methods, including:
   - `add`
   - `remove`
   - `removeAny`
   - `contains`
   - `size`
3. Optimize operations for logarithmic average-case time complexity.
4. Design and execute a thorough test plan for all constructors and kernel methods.

---

## Features
### 1. Efficient Set Representation
- Uses a binary search tree to store elements.
- Ensures no duplicate elements, maintaining the properties of a mathematical set.

### 2. Key Operations
- **`add`**: Inserts an element while maintaining BST properties.
- **`remove`**: Deletes a specific element, rebalancing the tree as needed.
- **`removeAny`**: Removes an arbitrary element from the set.
- **`contains`**: Checks if an element exists in the set.
- **`size`**: Returns the total number of elements in the set.

### 3. Private Helper Methods
- **`isInTree`**: Checks if a value exists in the tree.
- **`insertInTree`**: Inserts a value into the BST.
- **`removeSmallest`**: Removes the smallest value in the BST.
- **`removeFromTree`**: Removes a specific value from the BST.

---

## Technologies Used
- **Java**: For implementing the BST-based `Set` and kernel methods.
- **JUnit**: For unit testing and systematic test execution.

---

## How to Run
### Prerequisites
- Java Development Kit (JDK)
- Any Java-compatible IDE or terminal

### Steps
1. Clone the repository:
   ```bash
   git clone [repository URL]
