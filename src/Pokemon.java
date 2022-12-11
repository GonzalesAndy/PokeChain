public interface Pokemon<T> {
    boolean isAlive();

    String remainingHp();

    void attack(T pokemon);
}
