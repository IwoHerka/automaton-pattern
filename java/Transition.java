public class Transition {
    private State mPrevious;
    private State mNext;

    public Transition(State previous, State next) {
        mPrevious = previous;
        mNext = next;
    }

    public State getPrevious() {
        return mPrevious;
    }

    public State getNext() {
        return mNext;
    }
}
