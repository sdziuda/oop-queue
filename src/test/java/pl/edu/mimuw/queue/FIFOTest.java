package pl.edu.mimuw.queue;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FIFOTest {

  @Test
  void testCreatedAsEmpty() {
    final var queue = new FIFOIntQueue();

    final var expectedSize = 0;
    final var size = queue.size();

    assertEquals(expectedSize, size);
  }

  @Test
  void testAddsIncreasesSize() {
    final var queue = new FIFOIntQueue();

    final var expectedSize = 42;
    for (int i = 0; i < expectedSize; i++) queue.offer(i);

    final var size = queue.size();

    assertEquals(expectedSize, size);
  }

  @Test
  void testAddsElementsInOrder() {
    final var queue = new FIFOIntQueue();
    queue.offer(42);
    queue.offer(24);

    final var expectedHead = 42;
    final var head = queue.peek();

    assertEquals(expectedHead, head);
  }

  @Test
  void testAddsAndRemovesElementsInOrder() {
    final var queue = new FIFOIntQueue();
    queue.offer(42);
    queue.offer(24);
    queue.offer(21);
    queue.offer(37);

    final var expectedHead = 42;
    final var head = queue.poll();
    assertEquals(expectedHead, head);

    final var expectedHead2 = 24;
    final var head2 = queue.poll();
    assertEquals(expectedHead2, head2);

    queue.offer(100);

    final var expectedHead3 = 21;
    final var head3 = queue.poll();
    assertEquals(expectedHead3, head3);

    final var expectedHead4 = 37;
    final var head4 = queue.poll();
    assertEquals(expectedHead4, head4);

    final var expectedHead5 = 100;
    final var head5 = queue.poll();
    assertEquals(expectedHead5, head5);
  }

  @Test
  void testReturnsNullFromEmptyQueue() {
    final var queue = new FIFOIntQueue();
    final var head = queue.poll();

    assertNull(head);
  }

  @Test
  void testThrowsExceptionOnOfferingNull() {
    final var queue = new FIFOIntQueue();

    assertThrows(NullPointerException.class, () -> queue.offer(null));
  }

  @Test
  void testReturnsNullAfterOfferingAndPolling() {
    final var queue = new FIFOIntQueue();

    queue.offer(24);

    final var head = queue.poll();
    final var head2 = queue.poll();

    assertNull(head2);
  }

  @Test
  void testRemovesElementsInOrder() {
    final var queue = new FIFOIntQueue();
    queue.offer(42);
    queue.offer(24);

    final var expectedRemoved = 42;
    final var expectedSize = 1;
    final var head = queue.poll();
    final var size = queue.size();

    assertEquals(expectedRemoved, head);
    assertEquals(expectedSize, size);
  }
}
