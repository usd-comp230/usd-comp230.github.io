import java.util.NoSuchElementException;

public class ProbingHashTable<K,V> {
  class Entry {
    K k; V v;
    public Entry(K k, V v) { this.k = k; this.v = v; }
    public String toString() { return "{" + this.k + ": " + this.v + "}"; }
  }
  
  Entry[] buckets; // An array of Entries (no lists for buckets!)
  int size;
  
  @SuppressWarnings("unchecked")
  public ProbingHashTable() {
    this.size = 0;
    this.buckets = (Entry[])(new ProbingHashTable.Entry[4]);
  }
  public double loadFactor() {
    return (double)(this.size) / this.buckets.length;
  }
  /*
    Value get(key):
      hashed = hash(key)
      index = hashed % this.buckets.length
      while this.buckets[index] != null:
        b = this.buckets[index]
        if b.key == key: return b.value
        index += 1
        if index == this.buckets.length: index = 0
  */
  public V get(K k) {
    int hashCode = k.hashCode();
    int index = hashCode % this.buckets.length;
    while(this.buckets[index] != null) {
      Entry e = this.buckets[index];
      if(e.k.equals(k)) { return e.v; }
      index = (index + 1) % this.buckets.length; // Note – if loadFactor >= 1, this may not terminate!
    }
    throw new NoSuchElementException("Could not find key " + k);
  }
  /*
  set(key, value):
    hashed = hash(key)
    index = hashed % array length
    while this.buckets[index] != null:
      b = this.buckets[index]
      if b.key == key: break;
      if index == this.buckets.length: index = 0
    this.buckets[index] = {key: value}
  */
  public void set(K k, V v) {
    if(loadFactor() > 0.66) { expandCapacity(); }
    int hashCode = k.hashCode();
    int index = hashCode % this.buckets.length;
    while(this.buckets[index] != null) {
      Entry entry = this.buckets[index];
      if(entry.k.equals(k)) { break; }
      index = (index + 1) % this.buckets.length;
    }
    this.buckets[index] = new Entry(k, v);
    this.size += 1;
  }
  /*
  expandCapacity():
    newEntries = new Entry[this.buckets.length * 2];
    oldEntries = this.buckets
    this.buckets = newEntries
    this.size = 0
    for each entry {k:v}:
      this.set(k, v)
  */
  @SuppressWarnings("unchecked")
  public void expandCapacity() {
    Entry[] newEntries = (Entry[])(new ProbingHashTable.Entry[this.buckets.length * 2]);
    Entry[] oldEntries = this.buckets;
    this.buckets = newEntries;
    this.size = 0;
    for(int i = 0; i < oldEntries.length; i += 1) {
      if(oldEntries[i] == null) { continue; }
      Entry e = oldEntries[i];
      this.set(e.k, e.v);
    }
  }
  
  ProbingHashTable<String, Integer> build2() {
	  ProbingHashTable<String, Integer> pht = new ProbingHashTable<>();
	  pht.set("c", 22); // will be at index 3
	  pht.set("g", 45); // will also be at index 3, should wrap
	  return pht;
  }
}

