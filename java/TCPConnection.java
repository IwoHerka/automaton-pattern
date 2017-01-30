public class TCPConnection extends Automaton {
    public TCPConnection() {
        super();
        mState = new Disconnected(this);
    }

    public void connect() {
        mState.connect();
    }

    public void disconnect() {
        mState.disconnect();
    }

    public void sendMsg(String msg) {
        mState.sendMsg(msg);
    }
}
