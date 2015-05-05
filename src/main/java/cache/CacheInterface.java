package cache;

public interface CacheInterface<K, V> {
	void put(K key, V value);

	V get(K key);

	V remove(K key);
}
