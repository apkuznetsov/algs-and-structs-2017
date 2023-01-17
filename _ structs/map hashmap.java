package kuznetsov;

import java.util.ArrayList;

public class Main {

  public static void main(String[] args) {

  }

}

class MyHashMap {

  private final ArrayList<ArrayList<Entry>> buckets;

  MyHashMap() {
    int size = 100;
    this.buckets = new ArrayList<>(size);
    for (int i = 0; i < size; i++) {
      buckets.add(new ArrayList<>(size));
    }
  }

  private int hash(int key) {
    return key % 100;
  }

  public void put(int key, int value) {
    int index = hash(key);
    ArrayList<Entry> bucket = buckets.get(index);

    for (Entry entry : bucket) {
      if (entry.key == key) {
        entry.value = value;
        return;
      }
    }

    bucket.add(new Entry(key, value));
  }

  public void remove(int key) {
    int index = hash(key);
    ArrayList<Entry> bucket = buckets.get(index);

    int delIdx = -1;
    for (int i = 0; i < bucket.size(); i++) {
      Entry entry = bucket.get(i);
      if (entry.key == key) {
        delIdx = i;
      }
    }

    if (delIdx != -1) {
      bucket.remove(delIdx);
    }
  }

  public int get(int key) {
    int index = hash(key);
    ArrayList<Entry> bucket = buckets.get(index);

    for (Entry entry : bucket) {
      if (entry.key == key) {
        return entry.value;
      }
    }

    return -1;
  }

  static class Entry {
    int key;
    int value;

    Entry(int key, int value) {
      this.key = key;
      this.value = value;
    }
  }

}
