import static java.lang.System.out;
import java.util.HashMap;
import java.util.Map;


public class State {
    private Map<String, IAutomaton> mTable;
    private Context mContext;

    public State(Context context) {
        mContext = context;
        mTable = new HashMap<String, IAutomaton>();
    }

    public void cast(final String EVENT) throws IllegalTransitionException {
        mContext.setState(mTable.get(EVENT));
    }

    public void register(final String EVENT, IAutomaton state) {
        mTable.put(EVENT, state);
    }
}
