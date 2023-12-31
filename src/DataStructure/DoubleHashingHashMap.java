package DataStructure;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DoubleHashingHashMap<K, V> implements Serializable {
    private static final int DEFAULT_CAPACITY = 17;
    private static final double LOAD_FACTOR = 0.75;

    private int size;
    private int capacity;
    private Entry<K, V>[] table;

    public DoubleHashingHashMap() {
        this(DEFAULT_CAPACITY);
    }

    public DoubleHashingHashMap(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.table = new Entry[capacity];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void put(K key, V value) {
        if (key == null) {
            throw new IllegalArgumentException("Key cannot be null");
        }

        if (size >= capacity * LOAD_FACTOR) {
            resize();
        }

        int hash1 = hash1(key);
        int hash2 = hash2(key);

        int index = hash1;

        while (table[index] != null) {
            if (table[index].getKey().equals(key)) {
                table[index].setValue(value);
                return;
            }

            index = (index + hash2) % capacity;
        }

        table[index] = new Entry<>(key, value);
        size++;
    }

    public V get(K key) {
        int hash1 = hash1(key);
        int hash2 = hash2(key);

        int index = hash1;

        while (table[index] != null) {
            if (table[index].getKey().equals(key)) {
                return table[index].getValue();
            }

            index = (index + hash2) % capacity;
        }

        return null;
    }

    //hash function
    private int hash1(K key) {
        return key.hashCode() % capacity;
    } //ถ้าเป็นตัวเลข hash ออกมาก็เป็ฯตัวเลขอยู่ดี

    private int hash2(K key) {
        // Use a different prime number for hash2 to avoid clustering
        return 7 - (key.hashCode() % 7);
    }

    private void resize() {
        capacity *= 2;
        Entry<K, V>[] newTable = new Entry[capacity];

        for (Entry<K, V> entry : table) {
            if (entry != null) {
                int hash1 = hash1(entry.getKey());
                int hash2 = hash2(entry.getKey());

                int index = hash1;

                while (newTable[index] != null) {
                    index = (index + hash2) % capacity;
                }

                newTable[index] = entry;
            }
        }

        table = newTable;
    }

    public void clear() {
        size = 0;
        table = new Entry[capacity];
    }

    private static class Entry<K, V> implements Serializable{
        private final K key;
        private V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }

    public void replace(K key, V newValue) {
        int hash1 = hash1(key);
        int hash2 = hash2(key);

        int index = hash1;

        while (table[index] != null) {
            if (table[index].getKey().equals(key)) {
                table[index].setValue(newValue);
                return;
            }

            index = (index + hash2) % capacity;
        }

        // หากไม่พบ key ในตาราง hash
        throw new IllegalArgumentException("Key not found: " + key);
    }

    public void printAll() {
        for (Entry<K, V> entry : table) {
            if (entry != null) {
                System.out.print("Key: " + entry.getKey() + ", Value: " + entry.getValue() +",");
            }
        }
    }

    public List<V> getAllValues() {
        List<V> values = new ArrayList<>();

        for (Entry<K, V> entry : table) {
            if (entry != null) {
                values.add(entry.getValue());
            }
        }

        return values;
    }

    public List<Map.Entry<K, V>> getAllEntries() {
        List<Map.Entry<K, V>> entries = new ArrayList<>();

        for (Entry<K, V> entry : table) {
            if (entry != null) {
                entries.add(new AbstractMap.SimpleEntry<>(entry.getKey(), entry.getValue()));
            }
        }

        return entries;
    }
}

