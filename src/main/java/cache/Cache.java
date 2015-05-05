package cache;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Cache<K, V> implements CacheInterface<K, V> {

	private int max_size;
	private Map<K, V> cacheMap = new HashMap<K, V>();
	private PriorityQueue<K> cacheQueue;

	public Cache(int max_size) {
		this.max_size = max_size;
		cacheQueue = new PriorityQueue<K>();
	}

	public Cache(int max_size, Comparator<K> comparator) {
		this.max_size = max_size;
		cacheQueue = new PriorityQueue<K>(max_size, comparator);
	}

	@Override
	public void put(K key, V value) {
		K pollKey = null;
		if (cacheQueue.size() == max_size) {
			pollKey = cacheQueue.poll();
		}
		cacheMap.remove(pollKey);
		cacheQueue.offer(key);
		cacheMap.put(key, value);
	}

	@Override
	public V get(K key) {
		return cacheMap.get(key);
	}

	@Override
	public V remove(K key) {
		return cacheMap.remove(key);
	}

	public int size() {
		return cacheMap.size();
	}
}
