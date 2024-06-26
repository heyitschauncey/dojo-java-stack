/*
Design a class to process incoming orders and keep track of the running total
sales and leftover orders awaiting new orders to possibly match with.

Orders should be matched and processed based on the following criteria:
  - Match the highest available buy price to the lowest available sell price
  - Only process the order if the sell price is <= the buy price.
  - Processing a matched pair of orders simply means using up available quantity
  and incrementing the total by the sale amount.
  - Continue matching orders until there are no more viable matches.

Leftover orders / quantity that couldn't be matched should be kept so they can
be matched when new orders come in.
*/

/**
 * @typedef {object} Order
 * @property {('buy' | 'sell')} action
 * @property {number} price
 * @property {number} quantity
 */

/** @typedef {Order & { action: 'sell'}} SellOrder */
/** @typedef {Order & { action: 'buy'}} BuyOrder */

/** @type {Order[]} */
const incomingOrders1 = [
  {
    price: 155,
    quantity: 3,
    action: 'buy',
  },
  {
    price: 100,
    quantity: 5,
    action: 'sell',
  },
  {
    price: 125,
    quantity: 3,
    action: 'buy',
  },
  {
    price: 90,
    quantity: 2,
    action: 'buy',
  },
  {
    price: 110,
    quantity: 4,
    action: 'sell',
  },
];

/*
Explanation:

The highest buy price of 155 is matched to the lowest sell price of 100.
3 are bought at the 100 sell price, leaving 2 more sells left at that price.

total: 300 (3 * 100)

The next highest buy price of 125 is matched to the 2 leftover sells at 100,
increasing the total by 200 for a total of 500.

There is 1 more buy at 125 leftover which is matched to the next lowest sell
at a price of 110 increasing the total by 110 for a total of 610.

There are remaining buys at price 90 but the price is below the 3 leftover
sells at 110 so no more orders can be processed.

The total is 610 now until a new batch of orders comes in and are processed
with each other and the remaining orders that haven't been matched.
*/
const expected1 = 610;

/** @type {Order[]} */
const incomingOrders2 = [
  {
    price: 80,
    quantity: 6,
    action: 'buy',
  },
  {
    price: 120,
    quantity: 4,
    action: 'sell',
  },
  {
    price: 80,
    quantity: 8,
    action: 'sell',
  },
];

/*
Explanation: when these orders are added to the same OrderSaleMaximizer
instance, they will be merged with the leftover orders and the total will
continue to be incremented.

1. the 80 priced sell will be matched with the 100 price buys:
  - total: 610 + (80 * 2) = 770
  - the 80 sell has 6 quantity left
2. the remaining 80 sell quantities are matched with the next highest buy which
    is the leftover 90 price buys:
  - total: 770 + (80 * 2) = 930
  - the 80 sell has 4 quantity left
3. the remaining 80 price sell quantities match with the next highest buys at:
  price 80
  - total: 930 + (80 * 4) = 1250
  - the 80 price sell has no more quantity left
  - the 80 price buy has 2 quantity left
  - there are no more sells prices <= any buy prices
*/
const expected2 = 1250;

// Design a class below to handle the above requirements.

/*****************************************************************************/
