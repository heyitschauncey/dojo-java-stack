class Node {
  constructor(data) {
    this.data = data;
    this.next = null;
  }
}

/**
 * Class to represent a queue using an array to store the queued items.
 * Follows a FIFO (First In First Out) order where new items are added to the
 * back and items are removed from the front.
 */
class Queue {
  constructor() {
    this.head = null;
    this.tail = null;
    this.size = 0;
  }

  isEmpty() {
    return this.head === null;
  }

  size() {
    return this.size;
  }

  enqueue(newVal) {
    const newNode = new Node(newVal);

    if (this.isEmpty()) {
      this.head = newNode;
      this.tail = newNode;
    } else {
      this.tail.next = newNode;
      this.tail = newNode;
    }

    // pre-increment will modify this.size and THEN return the new size value
    return ++this.size;
  }

  // changed to return entire node
  dequeue() {
    if (this.isEmpty()) return null;

    // grab the node so we can return its data at the end
    const dequeued = this.head;
    // move the head to the right. this removes the original head
    this.head = this.head.next;
    // optional step to set the dequeued node's .next to null.
    // not required but I like to explicitly state this
    dequeued.next = null;

    // if this.head is now equal to null, then there was only one thing in the queue
    // we can then set this.tail to null to make sure tail doesn't point to any node that is dequeued
    if (this.head === null) {
      this.tail = null;
    }

    this.size--;

    return dequeued;
  }

  front() {
    // ternary allows for this to be in one line
    // if this.head is a node, the its truthy. if this.head is null, the its falsy
    return this.head ? this.head.data : null;
  }

  contains(searchVal) {
    let runner = this.head;

    while (runner) {
      if (runner.data === searchVal) return true;

      runner = runner.next;
    }

    return false;
  }

  // this method just allows for seed the queue from an array of values
  // the array.forEach is a functional method which allows us to easily perform an action
  // for each element in the array
  seed(vals) {
    vals.forEach((val) => this.enqueue(val));
  }

  /**
   * Compares this queue to another given queue to see if they are equal.
   * Avoid indexing the queue items directly via bracket notation, use the
   * queue methods instead for practice.
   * Use no extra array or objects.
   * The queues should be returned to their original order when done.
   * - Time: O(?).
   * - Space: O(?).
   * @param {Queue} q2 The queue to be compared against this queue.
   * @returns {boolean} Whether all the items of the two queues are equal and
   *    in the same order.
   */
   compareQueues(q2) {}

   /**
    * Determines if the queue is a palindrome (same items forward and backwards).
    * Avoid indexing queue items directly via bracket notation, instead use the
    * queue methods for practice.
    * Use only 1 stack as additional storage, no other arrays or objects.
    * The queue should be returned to its original order when done.
    * - Time: O(?).
    * - Space: O(?).
    * @returns {boolean}
    */
   isPalindrome() {}
}