/**
 * Class to represent a queue using an array to store the queued items.
 * Follows a FIFO (First In First Out) order where new items are added to the
 * back and items are removed from the front.
 */
class Queue {
  constructor() {
    this.items = [];
  }
  /**
   * Adds a new given item to the back of this queue.
   * @param {any} item The new item to add to the back.
   * @returns {number} The new size of this queue.
   */
  enqueue(item) {
    this.items.push(item);
    return this.size();
  }

  /**
   * Removes and returns the first item of this queue.
   * @returns {any} The first item or undefined if empty.
   */
  dequeue() {
    return this.items.shift();
  }

  /**
   * Retrieves the first item without removing it.
   * @returns {any} The first item or undefined if empty.
   */
  front() {
    return this.items[0];
  }

  /**
   * Returns whether or not this queue is empty.
   * @returns {boolean}
   */
  isEmpty() {
    return this.items.length === 0;
  }

  /**
   * Retrieves the size of this queue.
   * @returns {number} The length.
   */
  size() {
    return this.items.length;
  }
}

// use this class for your nodes in the linked list version of Queue
class QueueNode {
  constructor(data) {
    this.data = data;
    this.next = null;
  }
}

class LinkedListQueue {
  constructor() {
    this.head = null;
    this.tail = null;
    this.size = 0;
  }

  /**
   * Adds a new given item to the back of this queue.
   * @param {any} item The new item to add to the back.
   * @returns {number} The new size of this queue.
   */
  enqueue(item) {}

  /**
   * Removes and returns the first item of this queue.
   * @returns {any} The first item or undefined if empty.
   */
  dequeue() {}

  /**
   * Retrieves the first item without removing it.
   * @returns {any} The first item or undefined if empty.
   */
  front() {}

  /**
   * Returns whether or not this queue is empty.
   * @returns {boolean}
   */
  isEmpty() {}

  /**
   * Retrieves the size of this queue.
   * @returns {number} The length.
   */
  size() {}
}
