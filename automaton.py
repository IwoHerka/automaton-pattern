class InvalidTransitionException(Exception):
    pass


class State(object):
    def __init__(self, automaton):
        self._automaton = automaton


class Disconnected(State):
    connected = 'CONNECTED'

    def connect(self):
        self._automaton.cast(self.connected)


class Connected(State):
    disconnected = 'DISCONNECTED'

    def disconnect(self):
        self._automaton.cast(self.disconnected)


class Automaton(object):
    def __init__(self):
        self._t_table = {}
        self._state = None

    def register(self, ev, old_st, new_st):
        self._t_table[ev] = (old_st, new_st)

    def cast(self, ev):
        st_pair = self._t_table[ev]

        if self._state.__class__ != st_pair[0]:
            raise InvalidTransitionException()
        else:
            print("{} - Transition from: {} to: {}." \
                .format(ev, st_pair[0], st_pair[1]))

            self._state = st_pair[1](self)


class ConcreteAutomaton(Automaton):
    def __init__(self):
        super(ConcreteAutomaton, self).__init__()
        self._state = Disconnected(self)

    def connect(self):
        self._state.connect()

    def disconnect(self):
        self._state.disconnect()


if __name__ == "__main__":
    automaton = ConcreteAutomaton()
    automaton.register(Disconnected.connected, Disconnected, Connected)
    automaton.register(Connected.disconnected, Connected, Disconnected)
    automaton.connect()
    automaton.disconnect()
