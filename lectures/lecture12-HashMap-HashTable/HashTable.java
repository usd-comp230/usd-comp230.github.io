import java.util.List;
import java.util.ArrayList;

class HashTable<K,V> {
  class Entry {
    K k; V v;
    public Entry(K k, V v) { this.k = k; this.v = v; }
    public String toString() { return "{" + k + ": " + v + "}"; }
  }
  List<Entry>[] buckets; // An array of Lists of Entries
  int size;
  Hasher<K> hasher;

  public HashTable(Hasher<K> h, int startCapacity) {
    this.size = 0;
    this.hasher = h;
    this.buckets = (List<Entry>[])(new List[startCapacity]);
  }

  public double loadFactor() { return (double)(this.size) / this.buckets.length; }

  public V get(K k) {
    int hashCode = this.hasher.hash(k);
    int index = hashCode % this.buckets.length;
    if(this.buckets[index] == null) {
      return null;
    }
    else {
      for(Entry e: this.buckets[index]) {
        if(e.k.equals(k)) { return e.v; }
      }
      return null;
    }
  }

  public void set(K k, V v) {
    if(loadFactor() > 0.9) { expandCapacity(); }
    int hashCode = this.hasher.hash(k);
    int index = hashCode % this.buckets.length;
    if(this.buckets[index] == null) {
      this.buckets[index] = new ArrayList<Entry>();
      this.buckets[index].add(new Entry(k, v));
    }
    else {
      for(Entry e: this.buckets[index]) {
        if(e.k.equals(k)) { e.v = v; return; }
      }
      this.buckets[index].add(new Entry(k, v));
    }
    this.size += 1;
  }

  @SuppressWarnings("unchecked")
  public void expandCapacity() {
    List<Entry>[] newEntries = (List<Entry>[])(new List[this.buckets.length * 2]);
    List<Entry>[] oldEntries = this.buckets;
    this.buckets = newEntries;
    this.size = 0;
    for(int i = 0; i < oldEntries.length; i += 1) {
      if(oldEntries[i] == null) { continue; }
      for(Entry e: oldEntries[i]) {
        this.set(e.k, e.v);
      }
    }
  }
  
  HashTable<String, Integer> build() {
	  HashTable<String, Integer> ht = new HashTable<>(new HasherA(), 5);
	  ht.set("a", 6);
	  ht.set("b", 6);
	  ht.set("c", 6);
	  ht.set("d", 6);
	  return ht;
	}
}
