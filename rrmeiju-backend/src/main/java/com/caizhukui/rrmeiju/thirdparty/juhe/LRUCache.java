package com.caizhukui.rrmeiju.thirdparty.juhe;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 遵循最近使用优先原则的Cache，基于LinkedHashMap实现
 * 
 * @author caizhukui
 * @date 2017年3月1日上午9:28:04
 */
public class LRUCache<K, V> extends LinkedHashMap<K, V> {

	private static final long serialVersionUID = -8494743996717014171L;
	
	private final int maxEntries;
	
	private static final int DEFAULT_INITIAL_CAPACITY = 16;
	  
	private static final float DEFAULT_LOAD_FACTOR = 0.75f;
	
	public LRUCache(int initialCapacity, float loadFactor, int maxEntries) {
		super(initialCapacity, loadFactor, true);
		this.maxEntries = maxEntries;
	}
	
	public LRUCache(int initialCapacity, int maxEntries) {
		this(initialCapacity, DEFAULT_LOAD_FACTOR, maxEntries);
	}
	
	public LRUCache(int maxEntries) {
		this(DEFAULT_INITIAL_CAPACITY, maxEntries);
	}
	
	public LRUCache(Map<? extends K, ? extends V> m, int maxEntries) {
		this(m.size(), maxEntries);
		putAll(m);
	}
	
	/**
	 * (non-Javadoc)
	 * @see java.util.LinkedHashMap#removeEldestEntry(java.util.Map.Entry)
	 */
	@Override
	protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
		return size() > maxEntries;
	}

}
