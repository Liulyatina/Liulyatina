package home_work_5.animal;

import java.util.Comparator;

public class AnimalComparator {
    public static class ageCopmarator implements Comparator<Animal> {
        @Override
        public int compare(Animal p1, Animal p2) {
            return Integer.compare(p1.getAge(), p2.getAge());
        }
    }

    public static class agedAndNickCompatator implements Comparator<Animal> {

        @Override
        public int compare(Animal p1, Animal p2) {
            int ageCopar =Integer.compare(p1.getAge(), p2.getAge());
            return (ageCopar != 0) ? ageCopar : p1.getNick().compareTo(p2.getNick());
        }

    }
}
