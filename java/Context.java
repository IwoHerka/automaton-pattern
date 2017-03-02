public abstract class Context {
  protected IAutomaton mState;

  public void setState(IAutomaton state) {
    mState = state;
  }

}
