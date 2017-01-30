public class Disconnected implements State {
    public final static String CONNECT = "CONNECT";

    private Automaton mAutomaton;

    public Disconnected(Automaton automaton) {
        mAutomaton = automaton;
    }

    public void connect() {
       mAutomaton.cast(CONNECT);
    }

    public void disconnect() {}

    public void sendMsg(String msg) {
        final String errMsg = "Cannot send messages in disconnected state!";
        //throw new IllegalActionException(errMsg);
    }
}
