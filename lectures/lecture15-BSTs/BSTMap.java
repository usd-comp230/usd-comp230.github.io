class Node<K,V> {
  K key;
  V value;
  Node<K,V> left;
  Node<K,V> right;
  public Node(K key, V value, Node<K,V> left, Node<K,V> right) {
    this.key = key;
    this.value = value;
    this.left = left;
    this.right = right;
  }
  public String toString() {
    String children = "";
    if(left != null || right != null) {
      children = ", " + left + ", " + right;
    }
    return "(" + key + ": " + value + children + ")";
  }
}

// We are implementing an interface
class BSTMap<K,V> implements DefaultMap<K, V> {
  Node<K,V> root;
  
  BSTMap() {
    this.root = null;
  }
  
  BSTMap(Node<K,V> root) {
    this.root = root;
  }

  V get(Node<K, V> node, K key) {
	  if (node == null) { throw new IllegalArgumentException(ILLEGAL_ARG_NULL_KEY); }
	  
      if (node.key.equals(key)) return node.value;
      
      // Note we cannot use > here. What should we use?
//      if (node.key > key) {
//    	  return get(node.left, key);
//      } else {
//    	  return get(node.right, key);
//      }
      
      return null; // placeholder
  }
  
  @Override
  public V get(K key) throws IllegalArgumentException {
    return this.get(this.root, key);
  }
  
  // I am actually going to leave this for you to try filling out!
  // Think about what we need to figure out the height of our tree.
  public int height() {
	  return 0; 
  }
  
  public void printAllElements() {
	  printAllElements(this.root);
  }
  
  void printAllElements(Node<K,V> node) {
	  if (node == null) {
		  return;
	  }
	  
	  System.out.println(node.key);
	  
	  printAllElements(node.left);
	  printAllElements(node.right);
	  // How could we rewrite this to print each value at a time?
  }
}