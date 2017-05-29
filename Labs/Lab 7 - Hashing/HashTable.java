public interface HashTable<K,V> {
    public V get(K key);
    public boolean contains(K key);
    public boolean put(K key, V value);
    public String extraInfo();
    public double loadFactor();
    public void remove(K key);
    public int elements();
    public String type();
}
