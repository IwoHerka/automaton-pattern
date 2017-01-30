public class Connected implements State {
    public final static String DISCONNECT = "DISCONNECT";

    private Automaton mAutomaton;

    public Connected(Automaton automaton) {
        mAutomaton = automaton;
    }

    public void connect() {}

    public void disconnect() throws IllegalTransitionException {
        mAutomaton.cast(DISCONNECT);
    }

    public void sendMsg(String msg) {
        System.out.println(msg);
    }
}
