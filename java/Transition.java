public class Transition<T> {
    private T mPrevious;
    private T mNext;

    public Transition(T previous, T next) {
        mPrevious = previous;
        mNext = next;
    }

    public T getPrevious() {
        return mPrevious;
    }

    public T getNext() {
        return mNext;
    }
}
