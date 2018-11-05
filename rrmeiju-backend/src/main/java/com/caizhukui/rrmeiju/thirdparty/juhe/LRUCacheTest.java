package com.caizhukui.rrmeiju.thirdparty.juhe;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class LRUCacheTest {
	
	private static void test(Map<Integer, String> map) {
	    System.out.println(map.getClass().getSimpleName());
	    map.put(42, "Meaning");
	    map.put(7, "Days Per Week");
	    map.put(86400, "Seconds");
	    map.put(1, "Highlander");
	    System.out.println("map = " + map);
	    System.out.println("map.get(7) = " + map.get(7));
	    System.out.println("map = " + map);
	  }

	public static void main(String... args) {
//		test(new LinkedHashMap<Integer, String>()); // insertion order
//	    System.out.println();
//	    test(new LinkedHashMap<Integer, String>(16, 0.75f, true)); // access order
//	    System.out.println();
//	    test(new TreeMap<Integer, String>()); // sorted order
//	    System.out.println();
//	    test(new HashMap<Integer, String>()); // undefined order
		Map<Integer, String> cache = new LRUCache<>(5);
		for (int i = 0; i < 10; i++) {
			cache.put(i, "hi");
		}
		System.out.println("cache = " + cache);
	    System.out.println(cache.get(7));
	    System.out.println("cache = " + cache);
	    for (int i = 10; i < 14; i++) {
	      cache.put(i, "hi");
	    }
	    System.out.println("cache = " + cache);
	}

}
