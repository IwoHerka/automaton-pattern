public interface State {
    public void connect() throws IllegalTransitionException;
    public void disconnect() throws IllegalTransitionException;
    public void sendMsg(String msg) throws IllegalActionException;
}
