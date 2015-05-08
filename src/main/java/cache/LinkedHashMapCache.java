package cache;

import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapCache<K,V> implements CacheInterface<K, V>{

	private final int MAX_SIZE;
	private final LinkedHashMap<K,V> linkedHashMapCache;
	
	public LinkedHashMapCache(int max_size) {
		this.MAX_SIZE = max_size;
		linkedHashMapCache = new LinkedHashMap<K,V>(MAX_SIZE+1, 0.75f, false){
			@Override
			protected boolean removeEldestEntry(Map.Entry<K, V> eldest){
				return size() > MAX_SIZE;
			}
		};
	}
	
	@Override
	public void put(K key, V value) {
		linkedHashMapCache.put(key, value);
	}

	@Override
	public V get(K key) {
		return linkedHashMapCache.get(key);
	}

	@Override
	public V remove(K key) {
		return linkedHashMapCache.remove(key);
	}
	
	public int size() {
		return linkedHashMapCache.size();
	}
	
}
