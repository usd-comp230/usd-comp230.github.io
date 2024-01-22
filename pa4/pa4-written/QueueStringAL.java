class StringQueueAL implements StringQueue {
  ArrayStringList contents;
  
  public StringQueueAL() {
    this.contents = new ArrayStringList();
  }

  public void enqueue(String s) {
    this.contents.insert(this.contents.size(), s);
  }
  
  public String dequeue() {
    String toReturn = this.contents.get(0);
    this.contents.remove(0);
    return toReturn;
  }
}