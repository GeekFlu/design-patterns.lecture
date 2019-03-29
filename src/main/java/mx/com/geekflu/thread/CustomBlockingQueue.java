package mx.com.geekflu.thread;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class CustomBlockingQueue<T> {
	private Queue<T> queue;
	private int max = 16;
	
	private ReentrantLock lock = new ReentrantLock(true);
	private Condition notEmpty = this.lock.newCondition();
	private Condition notFull = this.lock.newCondition();
	
	public CustomBlockingQueue(int size) {
		queue = new LinkedList<>();
		this.max = size;
	}
	
	public void put(T item) throws InterruptedException {
		lock.lock();
		try {
			if(this.queue.size() == this.max) {
				//block thread
				this.notFull.await();
			}
			queue.add(item);
			notEmpty.signalAll();
		} finally {
			lock.unlock();
		}
	}
	
	public T take() throws InterruptedException {
		lock.lock();
		try {
			if(this.queue.size() == 0) {
				//block the thread
				this.notEmpty.await();
			}
			T i = queue.remove();
			notFull.signalAll();
			return i;
		} finally {
			lock.unlock();
		}
	}
}
