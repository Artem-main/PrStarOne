package HashMap;

import java.util.*;

public class HashMapWork {
    private final static int AMOUNT_ELEMENT = 1000000;
    private final static int GET_ELEMENT = 1000;
    private final static int RANDOM_INDEX_ELEMENT = 1000;
    private final static Random random = new Random();

    public static void main(String[] args) {

        HashOne();
        ArrList();
        LinkList();
        deleteDublicate(new ArrayList<>());
    }

    public static void HashOne () {
        HashMap <Integer, String> hashMapOne = new HashMap<>();
        hashMapOne.put(1, "one");
        hashMapOne.put(2, "two");
        hashMapOne.put(3, "three");

        HashMap <String, Integer> hashMapTwo = new HashMap<>();
        for (Map.Entry<Integer,String> entry : hashMapOne.entrySet()) {
                hashMapTwo.put(entry.getValue(), entry.getKey());
        }
        System.out.println(hashMapOne);
        System.out.println(hashMapTwo);
    }

    public static void ArrList() {
        long startTimeCode = System.currentTimeMillis();
        ArrayList <Integer> arrayList = new ArrayList <>();

        for (int i = 0; i < AMOUNT_ELEMENT; i++) {
            arrayList.add(random.nextInt(GET_ELEMENT));
        }
        for (int i = 0; i < AMOUNT_ELEMENT; i++) {
            arrayList.get(random.nextInt(RANDOM_INDEX_ELEMENT));
        }
        long stopTimeCode = System.currentTimeMillis();
        System.out.println("Arrays search time " + (stopTimeCode-startTimeCode));
    }

    public static void LinkList() {
        long startTimeCode = System.currentTimeMillis();
        LinkedList <Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < AMOUNT_ELEMENT; i++) {
            linkedList.add(random.nextInt(GET_ELEMENT));
        }
        for (int i = 0; i < AMOUNT_ELEMENT; i++) {
            linkedList.get(random.nextInt(RANDOM_INDEX_ELEMENT));
        }

        long stopTimeCode = System.currentTimeMillis();
        System.out.println("LinkedList search time " + (stopTimeCode-startTimeCode));
    }

    public static void deleteDublicate (ArrayList<String> del) {
        del.add("asd");
        del.add("dasd");
        del.add("asd");
        for (int i = 0; i < del.size() - 1; i++) {
            for (int j = i + 1; j <del.size(); j++) {
                if (del.get(i).equals(del.get(j))) {
                    del.remove(i);
                }
            }
        }
        System.out.println(del);
    }
}
