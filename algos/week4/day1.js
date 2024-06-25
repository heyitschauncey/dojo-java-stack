/**
 * Class to represent a stack using an array to store the stacked items.
 * Follows a LIFO (Last In First Out) order where new items are stacked on
 * top (back of array) and removed items are removed from the top / back.
 */
class Stack {
  /**
   * The constructor is executed when instantiating a new Stack() to construct
   * a new instance.
   * @returns {Stack} This new Stack instance is returned without having to
   *    explicitly write 'return' (implicit return).
   */
  constructor() {
    this.items = [];
  }

  /**
   * Adds a new given item to the top / back of this stack.
   * @param {any} item The new item to be added to the top / back.
   * @returns {number} The new length of this stack.
   */
  push(item) {
    this.items.push(item);
    return this.size();
  }

  /**
   * Removes the top / last item from this stack.
   * @returns {any} The removed item or undefined if this stack was empty.
   */
  pop() {
    return this.items.pop();
  }

  /**
   * Retrieves the top / last item from this stack without removing it.
   * @returns {any} The top / last item of this stack.
   */
  peek() {
    return this.items[this.items.length - 1];
  }

  /**
   * Returns whether or not this stack is empty.
   * @returns {boolean}
   */
  isEmpty() {
    return this.items.length === 0;
  }

  /**
   * Returns the size of this stack.
   * @returns {number} The length.
   */
  size() {
    return this.items.length;
  }
}

// use this class for your nodes in the linked list version of Stack
class StackNode {
  constructor(data) {
    this.data = data;
    this.next = null;
  }
}

// Stack implemented with a singly linked list
class LinkedListStack {
  constructor() {
    this.head = null;
  }

  /**
   * Adds a new given item to the top / back of this stack.
   * @param {any} item The new item to be added to the top / back.
   * @returns {void}
   */
  push(item) {
    const newNode = new StackNode(item);

    if (this.head === null) {
      this.head = newNode;
    } else {
      newNode.next = this.head;
      this.head = newNode;
    }
  }

  /**
   * Removes the top / last item from this stack.
   * @returns {any} The removed item or undefined if this stack was empty.
   */
  pop() {
    if (this.head === null) return null;

    const removed = this.head;
    this.head = this.head.next;

    return removed.data;
  }

  /**
   * Retrieves the top / last item from this stack without removing it.
   * @returns {any} The top / last item of this stack.
   */
  peek() {
    return this.head === null ? this.head.data : null;
  }

  /**
   * Returns whether or not this stack is empty.
   * @returns {boolean}
   */
  isEmpty() {
    return this.head === null;
  }

  /**
   * Returns the size of this stack.
   * @returns {number} The length.
   */
  size() {
    let len = 0;
    let runner = this.head;

    while (runner) {
      len += 1;
      runner = runner.next;
    }

    return len;
  }
}
