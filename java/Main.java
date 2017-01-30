public class Main {
    public static void main(String [] args) {
        TCPConnection automaton = new TCPConnection();

        automaton.register(Connected.DISCONNECT, new Connected(automaton), new Disconnected(automaton));
        automaton.register(Disconnected.CONNECT, new Disconnected(automaton), new Connected(automaton));

        automaton.connect();
        automaton.sendMsg("First message!");
        automaton.disconnect();
        automaton.sendMsg("Second message!");
    }
}
