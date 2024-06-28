class ListNode {
  constructor(data) {
    this.data = data;
    this.next = null;
  }
}

class SinglyLinkedList {
  /**
   * Constructs a new instance of an empty linked list that inherits all the
   * methods.
   * @returns {SinglyLinkedList} The new list that is instantiated is implicitly
   *    returned without having to explicitly write "return".
   */
  constructor() {
    /** @type {ListNode|null} */
    this.head = null;
  }

  /**
   * Determines if this list is empty.
   * @returns {boolean}
   */
  isEmpty() {
    return this.head === null;
  }

  /**
   * Creates a new node with the given data and inserts it at the back of
   * this list.
   * @param {any} data The data to be added to the new node.
   * @returns {SinglyLinkedList} This list.
   */
  insertAtBack2(data) {
    const newBack = new ListNode(data);

    if (this.isEmpty()) {
      this.head = newBack;
      return this;
    }

    let runner = this.head;

    while (runner.next !== null) {
      runner = runner.next;
    }

    runner.next = newBack;
    return this;
  }

  insertAtBack(newBack) {
    if (this.isEmpty()) {
      this.head = newBack;
      return this;
    }

    let runner = this.head;

    while (runner.next !== null) {
      runner = runner.next;
    }

    runner.next = newBack;
    return this;
  }
  /**
   * Calls insertAtBack on each item of the given array.
   * - Time: O(n * m) n = list length, m = arr.length.
   * - Space: O(1) constant.
   * @param {Array<any>} vals The data for each new node.
   * @returns {SinglyLinkedList} This list.
   */
  insertAtBackMany(vals) {
    for (const item of vals) {
      this.insertAtBack(item);
    }
    return this;
  }

  /**
   * Converts this list into an array containing the data of each node.
   * - Time: O(n) linear.
   * - Space: O(n).
   * @returns {Array<any>} An array of each node's data.
   */
  toArr() {
    const arr = [];
    let runner = this.head;

    while (runner) {
      arr.push(runner.data);
      runner = runner.next;
    }
    return arr;
  }

  /**
   * Creates a new node with the given data and inserts that node at the front
   * of this list.
   * @param {any} data The data for the new node.
   * @returns {SinglyLinkedList} This list.
   */
  insertAtFront(data) {
    const newHead = new ListNode(data);
    newHead.next = this.head;
    this.head = newHead;
    return this;
  }

  /**
   * Removes the first node of this list.
   * @returns {any} The data from the removed node.
   */
  removeHead() {
    if (this.isEmpty()) {
      return null;
    }

    const oldHead = this.head;
    this.head = oldHead.next;
    return oldHead.data;
  }

  /**
   * Calculates the average of this list.
   * @returns {number|NaN} The average of the node's data.
   */
  average() {
    let runner = this.head;
    let sum = 0;
    let cnt = 0;

    while (runner) {
      cnt++;
      sum += runner.data;
      runner = runner.next;
    }
  }

  /**
   * Removes the last node of this list.
   * @returns {any} The data from the node that was removed.
   */
  removeBack() {
    if (this.isEmpty()) {
      return null;
    }

    // Only 1 node.
    if (this.head.next === null) {
      return this.removeHead();
    }

    // More than 1 node.
    let runner = this.head;

    while (runner.next.next) {
      runner = runner.next;
    }

    // after while loop finishes, runner is now at 2nd to last node
    const removedData = runner.next.data;
    runner.next = null; // remove it from list
    return removedData;
  }

  /**
   * Determines whether or not the given search value exists in this list.
   * @param {any} val The data to search for in the nodes of this list.
   * @returns {boolean}
   */
  contains(val) {
    let runner = this.head;

    while (runner) {
      if (runner.data === val) {
        return true;
      }
      runner = runner.next;
    }
    return false;
  }

  /**
   * Recursively finds the maximum integer data of the nodes in this list.
   * @param {ListNode} runner The start or current node during traversal, or null
   *    when the end of the list is reached.
   * @param {ListNode} maxNode Keeps track of the node that contains the current
   *    max integer as it's data.
   * @returns {?number} The max int or null if none.
   */
  recursiveMax(runner = this.head, maxNode = this.head) {
    if (this.head === null) {
      return null;
    }

    if (runner === null) {
      return maxNode.data;
    }

    if (runner.data > maxNode.data) {
      maxNode = runner;
    }

    return this.recursiveMax(runner.next, maxNode);
  }

  /**
   * Retrieves the data of the second to last node in this list.
   * @returns {any} The data of the second to last node or null if there is no
   *    second to last node.
   */
  secondToLast() {
    if (!this.head || !this.head.next) {
      return null;
    }

    // There are at least 2 nodes since the above return hasn't happened.
    let runner = this.head;

    while (runner.next.next) {
      runner = runner.next;
    }
    return runner.data;
  }

  /**
   * Removes the node that has the matching given val as it's data.
   * @param {any} val The value to compare to the node's data to find the
   *    node to be removed.
   * @returns {boolean} Indicates if a node was removed or not.
   */
  removeVal(val) {
    if (this.isEmpty()) {
      return false;
    }

    if (this.head.data === val) {
      this.removeHead();
      return true;
    }

    let runner = this.head;

    while (runner.next) {
      if (runner.next.data === val) {
        runner.next = runner.next.next;
        return true;
      }
      runner = runner.next;
    }
    return false;
  }

  /**
   * Inserts a new node before a node that has the given value as its data.
   * @param {any} newVal The value to use for the new node that is being added.
   * @param {any} targetVal The value to use to find the node that the newVal
   *    should be inserted in front of.
   * @returns {boolean} To indicate whether the node was pre-pended or not.
   */
  prepend(newVal, targetVal) {
    if (this.isEmpty()) {
      return null;
    }

    if (this.head.data === targetVal) {
      this.insertAtFront(newVal);
      return this.head;
    }

    // we already know we're not going to need to prepend before the head
    let runner = this.head;

    while (runner) {
      // End of list and not found.
      if (runner.next === null) {
        return null;
      }

      if (runner.next.data === targetVal) {
        const prependNode = new ListNode(newVal);
        prependNode.next = runner.next;
        runner.next = prependNode;
        return prependNode;
      }
      runner = runner.next;
    }
  }

  /**
   * Concatenates the nodes of a given list onto the back of this list.
   * @param {SinglyLinkedList} addList An instance of a different list whose
   *    whose nodes will be added to the back of this list.
   * @returns {SinglyLinkedList} This list with the added nodes.
   */
  concat(addList) {
    let runner = this.head;

    if (runner === null) {
      this.head = addList.head;
    } else {
      while (runner.next) {
        runner = runner.next;
      }
      runner.next = addList.head;
    }
    return this;
  }

  /**
   * Finds the node with the smallest data and moves that node to the front of
   * this list.
   * @returns {SinglyLinkedList} This list.
   */
  moveMinToFront() {
    if (this.isEmpty()) {
      return this;
    }

    let minNode = this.head;
    let runner = this.head;
    let prev = this.head;

    while (runner.next) {
      if (runner.next.data < minNode.data) {
        prev = runner;
        minNode = runner.next;
      }

      runner = runner.next;
    }

    if (minNode === this.head) {
      return this;
    }

    prev.next = minNode.next;
    minNode.next = this.head;
    this.head = minNode;
    return this;
  }

  /**
   * Splits this list into two lists where the 2nd list starts with the node
   * that has the given value.
   * splitOnVal(5) for the list (1=>3=>5=>2=>4) will change list to (1=>3)
   * and the return value will be a new list containing (5=>2=>4)
   * @param {any} val The value in the node that the list should be split on.
   * @returns {SinglyLinkedList} The split list containing the nodes that are
   *    no longer in this list.
   */
  splitOnVal(val) {
    const newList = new SinglyLinkedList();

    if (!this.head) {
      return newList;
    }

    if (this.head.data === val) {
      newList.head = this.head;
      this.head = null;
      return newList;
    }

    let runner = this.head;

    while (runner.next) {
      if (runner.next.data === val) {
        newList.head = runner.next;
        runner.next = null;
        return newList;
      }
      runner = runner.next;
    }
    return newList;
  }

  // ==========================================================================
  // NEW PROBLEMS =============================================================
  // ==========================================================================
  /**
   * Determines whether the list has a loop in it which would result in
   * infinitely traversing unless otherwise avoided. A loop is when a node's
   * next points to a node that is behind it.
   * @returns {boolean} Whether the list has a loop or not.
   */
  hasLoop() {
    /**
      APPROACH:
      two runners are sent out and one runner goes faster so it will
      eventually 'lap' the slower runner if there is a loop, 
      at the moment faster runner laps slower runner, they are at the same
      place, aka same instance of a node.
    */
    // check if the list has anything inside
    if (!this.head || !this.head.next) return false;

    let runner = this.head;
    let fasterRunner = this.head;

    // JS will evaluate true if there is a node
    // JS will evaluate false if null
    while (fasterRunner && fasterRunner.next) {
      runner = runner.next;
      fasterRunner = fasterRunner.next.next;

      if (runner === fasterRunner) {
        return true;
      }
    }

    return false;
  }

  /**
   * If the list has a loop, return the value of the node at the beginning of the loop
   * @returns {any} The value of the node where the loop starts, else null if no loop
   */
  loopStart() {
    if (!this.head || !this.head.next) return null;

    let runner = this.head;
    let fasterRunner = this.head;
    // boolean variables
    // generally follow a naming convention of isWord
    let isLoop = false;

    // JS will evaluate true if there is a node
    // JS will evaluate false if null
    while (fasterRunner && fasterRunner.next) {
      runner = runner.next;
      fasterRunner = fasterRunner.next.next;

      if (runner === fasterRunner) {
        isLoop = true;
        break;
      }
    }

    if (isLoop) {
      runner = this.head;

      while (runner !== fasterRunner) {
        runner = runner.next;
        fasterRunner = fasterRunner.next;
      }

      return runner.data;
    }

    return null;
  }
}

const mySll = new SinglyLinkedList();

const node1 = new ListNode(11);
const node2 = new ListNode(22);
const node3 = new ListNode(33);
const node4 = new ListNode(44);
const node5 = new ListNode(55);
const node6 = new ListNode(66);
const node7 = new ListNode(77);
const node8 = new ListNode(88);
const node9 = new ListNode(99);

mySll.insertAtBack(node1);
mySll.insertAtBack(node2);
mySll.insertAtBack(node3);
mySll.insertAtBack(node4);
mySll.insertAtBack(node5);
mySll.insertAtBack(node6);
mySll.insertAtBack(node7);
mySll.insertAtBack(node8);
mySll.insertAtBack(node9);

node9.next = node4;

// Floyd's cycle-finding algorithm
// also known as the tortoise and the hare algorithm
// uncomment these console logs when ready to test
// console.log(mySll.hasLoop()) // true
// console.log(mySll.loopStart()) // 44
