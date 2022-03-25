package hashtable;

public class HashTableTest {

    public Slot[] slots;

    public HashTableTest(Integer size) {
        this.slots = new Slot[size];
    }

    public class Slot {
        String value;

        Slot(String value) {
            this.value = value;
        }
    }

    public int hashFunction(String key) {
        return (int) (key.charAt(0)) % this.slots.length;
    }

    public boolean saveData(String key, String value) {
        Integer address = this.hashFunction(key);
        if (this.slots[address] != null) {
            this.slots[address].value = value;
        } else {
            this.slots[address] = new Slot(value);
        }
        return true;
    }

    public String getValue(String key) {
        Integer address = this.hashFunction(key);
        if (this.slots[address] != null) {
            return this.slots[address].value;
        } else {
            return null;
        }
    }

}
