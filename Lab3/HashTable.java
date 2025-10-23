import java.util.LinkedList;
import java.util.Iterator;

public class HashTable<K, V> {
    
    private class Entry<K, V> {
        K key;
        V value;
        
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
    
    private LinkedList<Entry<K, V>>[] table;
    private int size;
    
    @SuppressWarnings("unchecked")
    public HashTable() {
        table = new LinkedList[16];
        size = 0;
    }
    
    private int hash(K key) {
        return Math.abs(key.hashCode() % table.length);
    }
    
    public void put(K key, V value) {
        int index = hash(key);
        
        if (table[index] == null) {
            table[index] = new LinkedList<Entry<K, V>>();
        }
        
        Iterator<Entry<K, V>> iterator = table[index].iterator();
        while (iterator.hasNext()) {
            Entry<K, V> entry = iterator.next();
            
            if (entry.getKey().equals(key)) {
                entry.setValue(value);
                return;  // выходим из метода
            }
        }
        
        table[index].add(new Entry<K, V>(key, value));
        size++;
    }
    

    public V get(K key) {
        int index = hash(key);
        
        if (table[index] == null) {
            return null;
        }
        
        Iterator<Entry<K, V>> iterator = table[index].iterator();
        while (iterator.hasNext()) {
            Entry<K, V> entry = iterator.next();
            
            if (entry.getKey().equals(key)) {
                return entry.getValue();
            }
        }
        
        return null;
    }
    

    public V remove(K key) {
        int index = hash(key);
        
        if (table[index] == null) {
            return null;
        }
        
        Iterator<Entry<K, V>> iterator = table[index].iterator();
        while (iterator.hasNext()) {
            Entry<K, V> entry = iterator.next();
            
            if (entry.getKey().equals(key)) {
                V value = entry.getValue();
                iterator.remove();
                size--;
                return value;
            }
        }
        
        return null;
    }
    

    public int size() {
        return size;
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public void display() {
        System.out.println("Содержимое хеш-таблицы");
        for (int i = 0; i < table.length; i++) {
            if (table[i] != null && !table[i].isEmpty()) {
                System.out.print("Ячейка " + i + ": ");
                for (Entry<K, V> entry : table[i]) {
                    System.out.print("[" + entry.getKey() + "=" + entry.getValue() + "] ");
                }
                System.out.println();
            }
        }
        System.out.println("Всего элементов: " + size);
    }
    
    public static void main(String[] args) {
        HashTable<String, Integer> hashTable = new HashTable<>();
        
        System.out.println("Добавление элементов");
        hashTable.put("один", 1);
        hashTable.put("два", 2);
        hashTable.put("три", 3);
        hashTable.display();
        
        System.out.println("\nПолучение значений");
        System.out.println("get('два') = " + hashTable.get("два"));
        System.out.println("get('пять') = " + hashTable.get("пять"));
        
        System.out.println("\nОбновление значения");
        hashTable.put("два", 22);  // обновляем значение
        System.out.println("get('два') = " + hashTable.get("два"));
        
        System.out.println("\nУдаление элемента");
        System.out.println("remove('три') = " + hashTable.remove("три"));
        hashTable.display();
        
        System.out.println("\nsize() и isEmpty()");
        System.out.println("size() = " + hashTable.size());
        System.out.println("isEmpty() = " + hashTable.isEmpty());
    }
}
