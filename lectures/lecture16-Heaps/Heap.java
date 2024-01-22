import java.util.List;

public class Heap<K, V> {

	List<Node<K, V>> entries;
	
	int left(int index) {
		return index * 2 + 1;
	}
	
	int right(int index) {
		return index * 2 + 2;
	}
	
	V get(int index, K key) {
		if (index >= this.entries.size()) { return null; }
		Node<K,V> entry = entries.get(index);
		
		if(entry.getKey().equals(key)) { return entry.getValue();}
		
		V leftResult = get(left(index), key);
		V rightResult = get(right(index), key);
		if (leftResult != null) { return leftResult; }
		if (rightResult != null) { return rightResult; }
		return null;
	}

	
//	void bubbleDown(int index) {
//		if(index >= this.entries.size()) { return; }
//		
//		int leftIndex = left(index);
//		if(leftIndex >= this.entries.size()) { return; }
//		
//		int largerChildIndex = leftIndex;
//		int rightIndex = right(index);
//		
//		if(existsAndGreater(rightIndex, leftIndex)) {
//			largerChildIndex = rightIndex;
//		}
//		if(existsAndGreater(largerChildIndex, index)) {
//			swap(index, largerChildIndex);
//			bubbleDown(largerChildIndex);
//		}
//	}
//	
//	void bubbleUp(int index) {
//		if(index <= 0) { return; }
//		Node<K,V> e = this.entries.get(index);
//		Node<K,V> parent = this.entries.get(parent(index));
//		
//		int comp = this.comparator.compare(e.key, parent.key);
//		if(comp > 0) {
//			swap(index, parent(index));
//			bubbleUp(parent(index));
//		} else {
//			return;
//		}
//	}
}
