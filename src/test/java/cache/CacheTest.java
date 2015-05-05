package cache;

import java.util.Comparator;

import junit.framework.Assert;

import org.junit.Test;

public class CacheTest {

	static class ReverseOrder implements Comparator<Integer> {

		@Override
		public int compare(Integer o1, Integer o2) {
			return (o2 - o1);
		}
	}

	@Test
	public void putItemIntoCacheTest() {

		int max_size = 100;
		Cache<Integer, String> cache = new Cache<Integer, String>(max_size);
		cache.put(1, "Object_1");
		cache.put(2, "Object_2");
		cache.put(3, "Object_3");
		cache.put(4, "Object_1");
		cache.put(5, "Object_5");
		cache.put(6, "Object_2");
		cache.put(7, "Object_7");
		cache.put(8, "Object_8");
		cache.put(9, "Object_1");

		Assert.assertTrue(cache.size() == 9);
	}

	@Test
	public void getItemFromCacheTest() {

		int max_size = 100;
		Cache<Integer, String> cache = new Cache<Integer, String>(max_size);
		cache.put(1, "Object_1");
		cache.put(2, "Object_2");
		cache.put(3, "Object_3");
		cache.put(4, "Object_1");
		cache.put(5, "Object_5");
		cache.put(6, "Object_2");
		cache.put(7, "Object_7");
		cache.put(8, "Object_8");
		cache.put(9, "Object_1");

		Assert.assertTrue(cache.get(4) == "Object_1");
	}

	@Test
	public void removeItemFromCacheTest() {

		int max_size = 100;
		Cache<Integer, String> cache = new Cache<Integer, String>(max_size);
		cache.put(1, "Object_1");
		cache.put(2, "Object_2");
		cache.put(3, "Object_3");
		cache.put(4, "Object_1");
		cache.put(5, "Object_5");
		cache.put(6, "Object_2");
		cache.put(7, "Object_7");
		cache.put(8, "Object_8");
		cache.put(9, "Object_1");

		Assert.assertTrue((cache.remove(2) == "Object_2")
				&& (cache.size() == 8));
	}

	@Test
	public void overflowCacheTest() {

		int max_size = 10;
		Cache<Integer, String> cache = new Cache<Integer, String>(max_size);
		cache.put(5, "Object_1");
		cache.put(2, "Object_2");
		cache.put(10, "Object_3");
		cache.put(14, "Object_1");
		cache.put(3, "Object_5");
		cache.put(6, "Object_2");
		cache.put(20, "Object_7");
		cache.put(30, "Object_8");
		cache.put(1, "Object_1");
		cache.put(18, "Object_10");
		cache.put(11, "Object_10");
		cache.put(12, "Object_11");

		Assert.assertTrue((cache.get(1) == null) && (cache.get(2) == null)
				&& (cache.size() == max_size));
	}

	@Test
	public void passCompararorIntoCacheTest() {

		int max_size = 10;
		ReverseOrder ro = new ReverseOrder();
		Cache<Integer, String> cache = new Cache<Integer, String>(max_size, ro);
		cache.put(5, "Object_1");
		cache.put(2, "Object_2");
		cache.put(10, "Object_3");
		cache.put(14, "Object_1");
		cache.put(3, "Object_5");
		cache.put(6, "Object_2");
		cache.put(20, "Object_7");
		cache.put(30, "Object_8");
		cache.put(1, "Object_1");
		cache.put(18, "Object_10");
		cache.put(11, "Object_10");
		cache.put(12, "Object_11");

		Assert.assertTrue((cache.get(30) == null) && (cache.get(20) == null)
				&& (cache.size() == max_size));
	}

}
