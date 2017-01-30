import static java.lang.System.out;
import java.util.HashMap;


public class Automaton {
    private HashMap<String, Transition> mTable;
    protected State mState;

    public Automaton() {
        mTable = new HashMap<String, Transition>();
        mState = null;
    }

    public void cast(final String EVENT) {
        Transition transition = (Transition) mTable.get(EVENT);

        if (transition.getPrevious().getClass().equals(mState.getClass())) {
            //throw new IllegalActionException("XXX");
        } else {
            mState = transition.getNext();
        }
    }

    public void register(final String EVENT, State prev, State next) {
        mTable.put(EVENT, new Transition(prev, next));
    }
}
