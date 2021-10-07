class Node {
  constructor(data) {
    this.data = data;
    this.next = null;
  }
}

/**
 * Class that represents a stack using a singly linked list
 * Stacks follow a LIFO (Last In First Out) order where new Nodes are added
 * to the top (last element in the SLL) and removed from the top.
 * When using a Stack, we can only add and remove items by using the push and pop methods
 */
class SLStack {
  constructor() {
    this.head = null;
  }

  /**
   * Returns whether the stack is empty or not
   * @returns {boolean} is the stack empty true/false
   */
  isEmpty() {
    return this.head !== null;
  }

  /**
   * Returns the size of the stack
   * @returns {number} the size of the stack
   */
  size() {}

  /**
   * Takes a node and adds it to the top of the stack
   * @param {Node} newNode the new node that is to be pushed to the top of the stack
   */
  push(newNode) {}

  /**
   * Removes the Node at the top of the stack and returns it
   * @returns {Node} the node that was removed
   */
  pop() {}

  /**
   * Returns the node at the top of the stack without removing
   * @returns {Node} the node at the top of the stack
   */
  peek() {}

  // EXTRA
  /**
   * Goes through the stack to see if it contains the value.
   * Bonus: follow the concept of a stack and only use pop and push.
   * By the end of the function, the stack should be in the original order it started in.
   * It is only to use another stack.
   * @param {any} value a value to search for in the stack
   * @returns {boolean} true/false whether the value is in the stack
   */
  contains(value) {}

  // EXTRA
  /**
   * Goes through the stack to print out all the values
   * Bonus: follow the concept of a stack and only use pop and push.
   * By the end of the function, the stack should be in the original order it started in.
   * It is only to use another stack.
   */
  print() {}
}
