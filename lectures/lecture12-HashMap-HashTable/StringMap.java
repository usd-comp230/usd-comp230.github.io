public interface StringMap {
	int get(String key);
	void update(String key, int value);
	boolean contains(String key);
	void remove(String key);
	void add(String key, int value);
	void set(String key, int value);
}
