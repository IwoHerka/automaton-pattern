public class TCPConnection extends Automaton<State> {
    public TCPConnection() {
        super();
        mState = new Disconnected(this);
    }

    public void connect() throws IllegalTransitionException {
        mState.connect();
    }

    public void disconnect() throws IllegalTransitionException {
        mState.disconnect();
    }

    public void sendMsg(String msg) throws IllegalActionException {
        mState.sendMsg(msg);
    }
}
