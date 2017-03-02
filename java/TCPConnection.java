public class TCPConnection extends Context {
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
