import static java.lang.System.out;
import java.util.HashMap;
import java.util.Map;


public class Automaton<T> {
    private Map<String, Transition<T>> mTable;
    protected T mState;

    public Automaton() {
        mTable = new HashMap<String, Transition<T>>();
        mState = null;
    }

    public void cast(final String EVENT) throws IllegalTransitionException {
        Transition<T> transition = (Transition<T>) mTable.get(EVENT);

        if (!transition.getPrevious().getClass().equals(mState.getClass())) {
            throw new IllegalTransitionException(null);
        } else {
            mState = transition.getNext();
        }
    }

    public void register(final String EVENT, T prev, T next) {
        mTable.put(EVENT, new Transition<T>(prev, next));
    }
}
