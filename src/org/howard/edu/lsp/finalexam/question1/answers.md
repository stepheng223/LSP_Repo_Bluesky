# Question 1 Answers

## Part 1:

Shared Resource #1:
`nextId`, because multiple threads may access and update the same counter.

Shared Resource #2:
`requests`, because multiple threads may add elements to the same `ArrayList`.

Concurrency Problem:
A race condition may occur. Multiple threads can interleave their operations while reading/updating `nextId` and modifying the shared list.

Why addRequest() is unsafe:
`addRequest()` is unsafe because it performs multiple operations on shared state without any concurrency control. One thread can be getting or updating the next request ID while another thread is doing the same thing, which can cause duplicate or incorrect request IDs. Also, `ArrayList` is not thread-safe, so multiple concurrent calls to `requests.add()` can corrupt the list or lose updates.

## Part 2:

Fix A: Explanation
Not correct. Making only `getNextId()` synchronized protects the ID counter, so two threads cannot update `nextId` at the same time. However, the shared `requests` list is still modified without protection inside `addRequest()`. Therefore, concurrent calls can still cause unsafe updates to the `ArrayList`.

Fix B: Explanation
Correct. Making `addRequest()` synchronized protects the entire critical section. Only one thread can generate the ID, build the request string, and add it to the list at a time. This prevents both duplicate ID problems and unsafe concurrent modifications to the list.

Fix C: Explanation
Not correct. Making `getRequests()` synchronized only protects access through that getter. It does not protect `getNextId()` or the `requests.add()` operation inside `addRequest()`. The concurrency problem still exists because writes to the shared state are still unsafe.

## Part 3:

Answer + Explanation
No, `getNextId()` should not be public. Based on Arthur Riel's object-oriented design heuristics, implementation details should be hidden from clients when they do not need to know them. The request ID counter is part of the internal responsibility of `RequestManager`, so outside code should not be able to call `getNextId()` directly and affect how IDs are assigned. Making it private improves encapsulation and keeps the public interface focused on meaningful operations such as adding and retrieving requests.

## Part 4:

Description:
An alternative approach is to use an explicit lock from `java.util.concurrent.locks`, such as `ReentrantLock`. The lock is acquired before the critical section that reads and updates `nextId` and adds the request to the shared list. The lock is released in a `finally` block so it is always unlocked even if an exception occurs.

Code Snippet:
```java
private final ReentrantLock lock = new ReentrantLock();

public void addRequest(String studentName) {
    lock.lock();
    try {
        int id = nextId++;
        requests.add("Request-" + id + " from " + studentName);
    } finally {
        lock.unlock();
    }
}
```
