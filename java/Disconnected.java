public class Disconnected extends State implements IAutomaton {
    public final static String CONNECT = "CONNECT";

    public Disconnected(Context context) {
      super(context);
    }

    public void connect() throws IllegalTransitionException {
       cast(CONNECT);
    }

    public void disconnect() {}

    public void sendMsg(String msg) throws IllegalActionException {
        final String errMsg = "Cannot send messages in disconnected state!";
        throw new IllegalActionException(errMsg);
    }
}
