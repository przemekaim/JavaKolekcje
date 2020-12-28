package pl.java.kolekcje;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        //linkedListAndIterators();
        //hashSetAndIterator();
        //treeSetAndComparator();
        //queueAndDeque();
        //priorityQueue();
        //hashMap();
        //hashAndTreeMap();
    }


    // Generuje randomowy String bo nie chce mi sie wymyslac nazw do kolekcji
    private static String generateString() {
        Random random = new Random();
        int length = random.nextInt(15) + 3;
        char[] genChars = new char[length];

        for (int i = 0; i < length; i++) {
            genChars[i] = (char) (random.nextInt(123 - 97) + 97);
        }

        return String.valueOf(genChars);
    }


    // Tutaj robie to samo z liczbami zeby miec tez sortowac po czyms innym
    private static int generateNumber() {
        return new Random().nextInt(30) + 10;
    }

    private static void linkedListAndIterators() {
        // LINKED LISTA + ITERATOR/LISTITERATOR

        // Tworzy 2 listy, scala je, usuwa co drugi element z drugiej z nich
        List<TestCollections> list1 = new LinkedList<>();
        List<TestCollections> list2 = new LinkedList<>();

        for (int i = 0; i < 6; i++) {
            list1.add(new TestCollections(generateString(), generateNumber()));
        }

        for (int i = 0; i < 8; i++) {
            list2.add(new TestCollections("BBBB" + generateString(), generateNumber()));
        }

        ListIterator<TestCollections> listIt = list1.listIterator();
        Iterator<TestCollections> it = list2.listIterator();

        while (it.hasNext()) {
            if (listIt.hasNext())
                listIt.next();
            listIt.add(it.next());
        }


        it = list2.iterator();
        while (it.hasNext()) {
            it.next();
            if (it.hasNext()) {
                it.next();
                it.remove();

            }
        }

        list1.forEach(System.out::println);
        System.out.println("--------");
        list2.forEach(System.out::println);

        list1.removeAll(list2);

        System.out.println("--------");
        list1.forEach(System.out::println);

        // Tworzy 2 listy, wstawia 2 na koniec 1
        System.out.println();
        System.out.println();
        System.out.println("----------------");
        System.out.println();
        System.out.println();

        List<TestCollections> lista1 = new LinkedList<>();
        List<TestCollections> lista2 = new LinkedList<>();
        for (int i = 0; i < 6; i++) {
            lista1.add(new TestCollections(generateString(), generateNumber()));
            lista2.add(new TestCollections("BBBB " + generateString(), generateNumber()));
        }
        // Ustawienie iteratora na koniec listy
        ListIterator<TestCollections> listIterator = lista1.listIterator(lista1.size());
        Iterator<TestCollections> iterator = lista2.iterator();
        // Wypisanie jednego elementu na ktory wskazuje iterator
        System.out.println(listIterator.previous().toString());
        // Dodanie elementow z listy2 do listy1
        for (TestCollections testCollections : lista2) {
            listIterator.add(testCollections);
        }

        System.out.println(lista1.size());
        lista1.forEach(System.out::println);

        // Usuniecie co 2 elementu z listy1 i listy2

        listIterator = lista1.listIterator();

        while (listIterator.hasNext()) {
            listIterator.next();
            if (listIterator.hasNext()) {
                listIterator.next();
                listIterator.remove();
            }
        }
        lista1.set(lista1.size() - 1, new TestCollections("aaaaa", 55));
        listIterator.previous();
        listIterator.remove();
        System.out.println("--------");
        //lista1.forEach(System.out::println);

        lista1.sort(Comparator.comparing(TestCollections::getName).thenComparing(TestCollections::getNumber));
        lista1.forEach(System.out::println);

        List<TestCollections> sublista = lista1.subList(5, 10);

    }

    private static void hashSetAndIterator() {
        List<String> aba = new LinkedList<>();
        aba.add("xxxxx");
        Set<String> set = new HashSet<>(aba);
        for (int i = 0; i < 1_000_000; i++) {
            set.add(generateString());
        }
        System.out.println(set.size());
        System.out.println(set.contains("xxxxx"));
        //set.forEach(System.out::println);

        // Tutaj po kolei bo hashcode jest taki sam jak sam int
        Set<Integer> set2 = new HashSet<>();
        for (int i = 0; i < 100; i++) {
            set2.add(generateNumber());
        }
        System.out.println("------------------");
        for (Integer integer : set2) {
            System.out.println(integer.hashCode());
        }
        //set2.stream().mapToInt(Object::hashCode).forEach(System.out::println);
        Set<TestCollections> testCollectionsSet = new HashSet<>();

        for (int i = 0; i < 20; i++) {
            testCollectionsSet.add(new TestCollections(i + generateString(), generateNumber()));
        }

        testCollectionsSet.forEach(System.out::println);
    }

    private static void treeSetAndComparator() {
        SortedSet<TestCollections> set = new TreeSet<>(); // Sortowanie za pomoca interfejsu Comparable

        for (int i = 0; i < 15; i++) {
            set.add(new TestCollections(generateString(), generateNumber()));
        }
        for (TestCollections testCollections : set) {
            System.out.println(testCollections.toString());
        }
        System.out.println("ROzmiar " + set.size());

        // Sortowanie za pomoca Comparatora podanego przy tworzeniu zbioru
        NavigableSet<TestCollections> set2 = new TreeSet<>(Comparator.comparing(TestCollections::getName));

        set2.addAll(set);
        System.out.println("--------------");
        set2.add(new TestCollections("aaaaaaaaaaaaa", 55));
        set2.forEach(System.out::println);

        Iterator<TestCollections> iterator = set2.iterator();
        iterator.next();
        iterator.remove();
        //Iterator<TestCollections> it = set2.descendingIterator();
        System.out.println(set2.size());
        System.out.println(set2.first());


    }


    private static void queueAndDeque() {
        Queue<TestCollections> queue = new ArrayDeque<>();
        Deque<TestCollections> deque = new ArrayDeque<>(); // lepsze w dodawaniu i usuwaniu na dwoch koncach
        //Deque<TestCollections> test2 = new LinkedList<>(); // lepsze tylko w usuwaniu przy iteracji
        for (int i = 0; i < 10; i++) {
            queue.add(new TestCollections(generateString(), generateNumber()));
        }
        Iterator<TestCollections> it = queue.iterator();

        while (it.hasNext()) {
            it.next();
            if (it.hasNext()) {
                it.next();
                it.remove();
            }
        }
        queue.forEach(System.out::println);

        for (int i = 0; i < 10; i++) {
            deque.add(new TestCollections(generateString(), generateNumber()));
        }
        System.out.println("---------------");
        System.out.println(deque.pollFirst() + " " + deque.size());
        System.out.println(deque.peekFirst());
        deque.offerFirst(new TestCollections("ANIME", 55));
        System.out.println(deque.peekFirst());
    }

    private static void priorityQueue() {
/*        PriorityQueue<Anime> pq = new PriorityQueue<>();
        pq.add(new Anime(generateString(), generateNumber(), Anime.Status.COMPLETED));
        pq.add(new Anime(generateString(), generateNumber(), Anime.Status.PLAN));
        pq.add(new Anime(generateString(), generateNumber(), Anime.Status.PLAN));
        pq.add(new Anime(generateString(), generateNumber(), Anime.Status.WATCHING));
        pq.add(new Anime(generateString(), generateNumber(), Anime.Status.DROPPED));
        pq.add(new Anime(generateString(), generateNumber(), Anime.Status.WATCHING));
        pq.add(new Anime(generateString(), generateNumber(), Anime.Status.DROPPED));
        pq.add(new Anime(generateString(), generateNumber(), Anime.Status.COMPLETED));
        pq.add(new Anime(generateString(), generateNumber(), Anime.Status.COMPLETED));
        pq.add(new Anime(generateString(), generateNumber(), Anime.Status.COMPLETED));

        for (Anime anime : pq) {
            System.out.println(anime);
        }

        while (!pq.isEmpty()) {
            pq.remove();
        }*/

        PriorityQueue<Anime> pq2 = new PriorityQueue<>(Comparator.comparing(Anime::getStatus));
        pq2.add(new Anime(generateString(), generateNumber(), Anime.Status.COMPLETED));
        pq2.add(new Anime(generateString(), generateNumber(), Anime.Status.PLAN));
        pq2.add(new Anime(generateString(), generateNumber(), Anime.Status.PLAN));
        pq2.add(new Anime(generateString(), generateNumber(), Anime.Status.WATCHING));
        pq2.add(new Anime(generateString(), generateNumber(), Anime.Status.DROPPED));
        pq2.add(new Anime(generateString(), generateNumber(), Anime.Status.WATCHING));
        pq2.add(new Anime(generateString(), generateNumber(), Anime.Status.DROPPED));
        pq2.add(new Anime(generateString(), generateNumber(), Anime.Status.COMPLETED));
        pq2.add(new Anime(generateString(), generateNumber(), Anime.Status.COMPLETED));
        pq2.add(new Anime(generateString(), generateNumber(), Anime.Status.COMPLETED));

        pq2.add(new Anime("RE ZERO", 40, Anime.Status.COMPLETED));
        for (Anime anime : pq2) {
            System.out.println(anime);
        }
        pq2.remove();
        pq2.remove();

        List<Anime> list = new ArrayList<>(pq2);

        List<Anime> completedAnime = new ArrayList<>();
        System.out.println("---------");
        list.stream()
                .sorted(Comparator.comparing(Anime::getStatus))
                //.filter(anime -> anime.getStatus().equals(Anime.Status.COMPLETED))
                .dropWhile(anime -> anime.getStatus().equals(Anime.Status.COMPLETED))
                //.collect()
                //.map(anime -> anime.getStatus() + "XXXX")
                .forEach(System.out::println);

        //list.forEach(System.out::println);
    }

    private static void hashMap() {
        Map<Integer, TestCollections> map = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            map.put(generateNumber(), new TestCollections(i+generateString(), generateNumber()));
        }
        map.put(0, new TestCollections("ANIMEEEEEEEE", 55));
        map.remove(9);
        map.replace(7, new TestCollections("Animu", 12));
        map.remove(5);
        map.putIfAbsent(6, new TestCollections("aba", 5));
        map.remove(6);
        map.putIfAbsent(6, new TestCollections("aba", 5));
        map.put(6, new TestCollections("bab", 6));

        map.forEach((k, v) -> System.out.println("Klucz: " + k + "Wartosc: "+ v));


        Map<Integer, TestCollections> treeMap = new TreeMap<>(map);

       // treeMap.forEach((k, v) -> System.out.println(k + " " + v));

    }


    private static void hashAndTreeMap() {
/*        Map<String, RandomStrings> map = new HashMap<>();
        for (int i = 0; i < 10; i++)
            map.put(generateString()+i, new RandomStrings(generateString()));

        Map<String, RandomStrings> treeMap = new TreeMap<>(map);

        treeMap.forEach((k, v )-> System.out.println(k + " " + v));*/

        Map<RandomStrings, Integer> map = new HashMap<>();
        for (int i = 0; i < 10; i++)
            map.put(new RandomStrings(generateString()), i);

        TreeMap<RandomStrings, Integer> treeMap = new TreeMap<>(map);

        treeMap.forEach((k, v) -> System.out.println(k + " " + v));

        Map<RandomStrings, Integer> treeMapReverse = new TreeMap<>(Comparator.comparing(RandomStrings::getRandomName).reversed());
        System.out.println("---------------");
        treeMapReverse.putAll(map);
        treeMapReverse.forEach((k, v) -> System.out.println(k + " " + v));


        System.out.println("---------------");
        SortedMap<RandomStrings, Integer> sortedMapReverse = new TreeMap<>(Comparator.comparing(RandomStrings::getRandomName).reversed());
        sortedMapReverse.putAll(map);
        sortedMapReverse.put(new RandomStrings("Anime"), 51);


        SortedMap<RandomStrings, Integer> treeMap2 = new TreeMap<>(sortedMapReverse);
        treeMap2.put(new RandomStrings(generateString()), 1);
        treeMap2.put(new RandomStrings(generateString()), 1);
        treeMap2.put(new RandomStrings(generateString()), 1);
        treeMap2.put(new RandomStrings(generateString()), 1);

        treeMap2.forEach((k, v) -> System.out.println(k + " " + v));

        //SortedMap<RandomStrings, Integer> tsaf = treeMap.subMap()

        //WIDOKI SLOWNIKOW
        RandomStrings rundom = new RandomStrings("ANIMUUUU");
        RandomStrings rundom2 = new RandomStrings("ANIMUUUUfsafsafsa");
        sortedMapReverse.put(rundom, 754);
        sortedMapReverse.put(rundom2, 6436531);
        Set<RandomStrings> keySet = sortedMapReverse.keySet();
        Collection<Integer> valueSet = sortedMapReverse.values();
        Set<Map.Entry<RandomStrings, Integer>> entrySet5 = sortedMapReverse.entrySet();

        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();

        //keySet.remove(rundom);
        valueSet.remove(51);
        //entrySet.remove(rundom); za pomoca iteroatora np
        Iterator<Map.Entry<RandomStrings, Integer>> it = sortedMapReverse.entrySet().iterator();
        while (it.hasNext()) {
            it.next();
        }
        it.remove();

        sortedMapReverse.entrySet().removeIf(e -> e.getValue().equals(6436531));

        entrySet5.forEach(System.out::println);
        System.out.println();
        sortedMapReverse.forEach((k, v) -> System.out.println(k + " " + v));
    }
}
