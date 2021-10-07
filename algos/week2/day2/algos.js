class Node {
  constructor(data) {
    this.data = data;
    this.next = null;
  }
}

/**
 * Class that represents a queue using a singly linked list
 * Stacks follow a FIFO (First In First Out) order where new Nodes are added
 * to the back (last element in the SLL) and removed from the top (first element in the SLL)
 * When using a Queue, we can only add and remove items by using the enqueue and dequeue methods
 */
class SLQueue {
  /**
   * Method that instantiates the SLQueue object
   * this.head points to the front of the queue
   * this.tail points to the back of the queue
   * this.size tracks the size. we need to make sure we increment or decrement
   * this.size when we enqueue or dequeue
   */
  constructor() {
    this.head = null;
    this.tail = null;
    this.size = 0;
  }

  /**
   * Returns whether the queue is empty or not
   * @returns {boolean} is the queue empty true/false
   */
  isEmpty() {
    return this.head !== null;
  }

  /**
   * Returns the size of the queue
   * @returns {number} the size of the queue
   */
  size() {}

  /**
   * Takes a node and adds it to the top of the queue
   * @param {Node} newNode the new node that is to be pushed to the back of the queue
   */
  enqueue(newNode) {}

  /**
   * Removes the Node at the front of the queue and returns it
   * @returns {Node} the node that was removed
   */
  dequeue() {}

  /**
   * Returns the node at the front of the queue without removing
   * @returns {Node} the node at the top of the queue
   */
  front() {}

  // EXTRA
  /**
   * Goes through the queue to see if it contains the value.
   * Bonus: follow the concept of a queue and only use pop and push.
   * By the end of the function, the queue should be in the original order it started in.
   * It is only to use another queue.
   * @param {any} value a value to search for in the queue
   * @returns {boolean} true/false whether the value is in the queue
   */
  contains(value) {}

  // EXTRA
  /**
   * Goes through the queue to print out all the values
   * Bonus: follow the concept of a queue and only use pop and push.
   * By the end of the function, the queue should be in the original order it started in.
   * It is only to use another queue.
   */
  print() {}

  /**
   * Enqueues each of the given items.
   * - Time: O(n) linear since enqueue is O(1), n = vals.length.
   * - Space: O(1) constant.
   * @param {Array<any>} vals
   */
  seed(vals) {
    vals.forEach((val) => this.enqueue(new Node(val)));
  }
}
