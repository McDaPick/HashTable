package UrlSimilarity;

import java.util.Iterator;

public class HashIterator implements Iterator {

    Hash hash;
    HashNode curNode;
    int position;
    int slot;
    int size;
    boolean first;
    int greatestFreqPos;
    int greatestFreqAmount;

    public HashIterator(Hash hash) {
        this.hash = hash;
        restart();

    }

    @Override
    public boolean hasNext() {
        return position < size;
    }

    @Override
    public HashNode next() {
        if (hasNext()) {
            if (first) {
                position++;
                first = false;
                return curNode;
            } else if (curNode.hasNext()) {
                curNode = curNode.getNext();
                position++;
                return curNode;
            } else {
                do {
                    slot++;
                }while (hash.array[slot] == null);
                curNode = hash.array[slot];
                position++;
                return curNode;
            }
        }
        return null;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("Not Supported.");
    }

    public void restart() {
        position = 0;
        slot = 0;
        first = true;
        greatestFreqPos = 0;
        greatestFreqAmount = 0;
        curNode = hash.array[slot];
        if (!hash.isEmpty()) {
            while (curNode == null) {
                slot++;
                curNode = hash.array[slot];
            }
        }
    }

    public void grow() {
        size++;
    }

    public int getSize() {
        return size;
    }

    public HashNode greatestPos() {
        if (hash.isEmpty()) {
            return null;
        }
        restart();
        return null;
    }

}
