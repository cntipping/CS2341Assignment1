CS2341
Cecilia Tipping - 49507335

This program implements features from stacks and queues to sort through a csv file of log entries. 
It initially reads in all logs, adding them using the enqueue function and dequeueing each entry until the queue is empty. 
Following this process, the log is added to a stack directly after being dequeud. 
Throughout the dequeue to stack process, error types and count are tracked as well as a having the last 100 errors logged for review later.
