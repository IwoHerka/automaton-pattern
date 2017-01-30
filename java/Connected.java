public class Connected implements State {
    public final static String DISCONNECT = "DISCONNECT";

    private Automaton mAutomaton;

    public Connected(Automaton automaton) {
        mAutomaton = automaton;
    }

    public void connect() {
        //throw new IllegalActionException("");
    }

    public void disconnect() {
        mAutomaton.cast(DISCONNECT);
    }

    public void sendMsg(String msg) {
        // out.println("Sending message!");
    }
}
