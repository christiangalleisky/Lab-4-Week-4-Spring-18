package edu.gcccd.csis;

public class LazyCtor {
    // static members
    private static final int K = 30;
    private static final LazyCtor[] LA = new LazyCtor[K];
    private static int instanceCounter = 0;

    // static initializer
    static {
        for (int i = 0; i < K; i++) {
            LA[i] = new LazyCtor(i);
            instanceCounter++;
        }
    }

    // instance variables
    private final int id;

    // only constructor is private
    private LazyCtor(final int id) {
        this.id = id;
    }

    public static int getNumOfInstancesAllowed() {
        return LazyCtor.K;
    }

    public static int getNumOfInstancesCreated() {
        return LazyCtor.instanceCounter;
    }

    public static LazyCtor getInstance() {
        LazyCtor x = null;
        for (int i = 0; i < K && x == null; i++) {
            if (LA[i] != null) {
                x = LA[i];
                LA[i] = null;
            }
        }
        return x;
    }

    public int getId() {
        return this.id;
    }

    @Override
    public String toString() {
        return String.format("I'm the LazyCtor Object, with the id: %d", id);
    }
}
