class StackStringAL implements StringStack {
  ArrayStringList contents;
  
  public StackStringAL() {
    this.contents = new ArrayStringList();
  }
  
  public int size() {
    return this.contents.size();
  }
  
  public void push(String s) {
    this.contents.prepend(s);
  }
  
  public String pop() {
    String toReturn = this.contents.get(0);
    this.contents.remove(0);
    return toReturn;
  }
}