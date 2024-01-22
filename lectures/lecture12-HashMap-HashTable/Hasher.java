public interface Hasher<K> { int hash(K key); }

class HasherA implements Hasher<String> {
  int i;
  public HasherA() { this.i = 0; }
  public int hash(String s) { i += 1; return s.length() + i; }
}

class HasherB implements Hasher<String> {
  public int hash(String s) { return Character.codePointAt(s, 0); }
}