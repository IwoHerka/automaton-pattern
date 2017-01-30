public interface State {
    public void connect();
    public void disconnect();
    public void sendMsg(String msg);
}
