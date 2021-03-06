package com.sys.concurrent;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class CopyOnWriteMap<K, V> implements Map<K, V>, Cloneable {

	private volatile Map<K, V> internalMap;

	public CopyOnWriteMap() {
		internalMap = new HashMap<K, V>();
	}

	public int size() {

		return 0;
	}

	public boolean isEmpty() {

		return false;
	}

	public boolean containsKey(Object key) {

		return false;
	}

	public boolean containsValue(Object value) {

		return false;
	}

	public V get(Object key) {
		return internalMap.get(key);
	}

	public V put(K key, V value) {
		synchronized (this) {
			Map<K, V> newMap = new HashMap<K, V>(internalMap);
			V val = newMap.put(key, value);
			internalMap = newMap;
			return val;
		}
	}

	public V remove(Object key) {

		return null;
	}

	public void putAll(Map<? extends K, ? extends V> m) {
		synchronized (this) {
			Map<K, V> newMap = new HashMap<K, V>(internalMap);
			newMap.putAll(m);
			internalMap = newMap;
		}
	}

	public void clear() {

	}

	public Set<K> keySet() {

		return null;
	}

	public Collection<V> values() {

		return null;
	}

	public Set<Entry<K, V>> entrySet() {

		return null;
	}

}
