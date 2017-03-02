public class Connected extends State implements IAutomaton {
    public final static String DISCONNECT = "DISCONNECT";

    public Connected(Context context) {
      super(context);
    }

    public void connect() {}

    public void disconnect() throws IllegalTransitionException {
        cast(DISCONNECT);
    }

    public void sendMsg(String msg) {
        System.out.println(msg);
    }
}
