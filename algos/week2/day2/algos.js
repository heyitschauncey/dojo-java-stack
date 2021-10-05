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
  onstructor() {
    this.head = null;
    this.tail = null;
    this.size = 0;
  }

  isEmpty() {
    // return true if SLStack is empty
    // return false if SLStack is not empty
  }

  size() {
    // return length of SLStack
  }

  enqueue(newVal) {
    // push newVal to end of Queue
  }

  dequeue() {
    // remove and return the data at the front of the queue
  }

  front() {
    // return the data at the front of the queue without removing
  }
}