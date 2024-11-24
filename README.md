# Sparse Vector Repository

## Overview

This repository implements a **Sparse Vector** representation using a singly linked list. Sparse Vectors are efficient for storing and manipulating data with a large number of zero entries, minimizing memory usage. The implementation is built upon Java concepts and structures covered in lectures.

---

## Contribution Guidelines

### Tasks for Contributors

1. **Testing**  
   - This project uses **Gradle** for execution and testing.  
   - Locate test files under the `src/test/java` directory.  
   - Add new test cases to validate the implementation of `SparseVector` methods.  

2. **Fork and Submit Changes**  
   - Fork the repository to make changes.  
   - If you encounter a test failure or have a suggestion to fix an issue, submit a **merge request** to the repository owner (**MusLead**) with detailed information about the problem.

3. **Writing Tests**  
   - Follow the existing test structure in the test files.  
   - Each test function should validate one feature of the `SparseVector` class.
   - Examples:
     - Test if `setElement` correctly updates or inserts values.
     - Validate that `getElement` returns `0.0` for missing indices.
     - Ensure `add` correctly merges sparse vectors.

## Notes for Developers

- Make sure the linked list maintains elements in **sorted order** by index.  
- Handle invalid inputs by throwing appropriate exceptions.  
- Aim for clean, efficient, and well-documented code.

---

## Repository Contents

### Java Files

1. **AlgoDS_LinkedList**  
   - General implementation of a singly linked list based on the lecture.

2. **AlgoDS_List**  
   - Interface for the list structure as defined in the lecture.

3. **AlgoDS_Node**  
   - A class representing a node in the singly linked list.  
   - Fields include:
     - `Object value`: Stores the node value (it should be in Double).
     - `int index`: Stores the index of the element in the vector.
     - `AlgoDS_Node next`: Points to the next node in the list.

4. **SparseVector**  
   - Implements the Sparse Vector by extending the `AlgoDS_LinkedList`.  
   - Provides methods for sparse vector manipulation.

---

## Sparse Vector Functionalities

The `SparseVector` class implements the following functionalities:

1. **Constructors**  
   - **Default Constructor**: Initializes an empty vector.  
   - **Parameterized Constructor**: Creates a vector of specified length.

2. **Core Methods**
   - `void setElement(int index, double value)`  
     Adds or updates an element at the specified index.  

   - `double getElement(int index)`  
     Returns the value at the specified index, or `0.0` if not present.  

   - `void removeElement(int index)`  
     Removes the element at the specified index.  

   - `int getLength()`  
     Returns the length of the vector.

   - `boolean equals(SparseVector other)`  
     Compares two sparse vectors for equality.

   - `void add(SparseVector other)`  
     Adds all elements from the `other` vector to the current vector.

---

For questions or clarifications, feel free to reach out to **MusLead**. Happy coding! 🚀
