public class Main {
    public static void main(String [] args) {
        TCPConnection automaton = new TCPConnection();

        Connected connected = new Connected(automaton);
        Disconnected disconnected = new Disconnected(automaton);

        automaton.setState(disconnected);

        connected.register(Connected.DISCONNECT, disconnected);
        disconnected.register(Disconnected.CONNECT, connected);

        try {
            automaton.connect();
            automaton.sendMsg("First message!");
            automaton.disconnect();
            automaton.sendMsg("Second message!");
        } catch (IllegalTransitionException e) {
            e.printStackTrace();
        } catch (IllegalActionException e) {
            e.printStackTrace();
        }
    }
}
