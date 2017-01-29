class InvalidTransitionException(Exception):
    pass


class IllegalActionException(Exception):
    pass


class State(object):
    def __init__(self, automaton):
        self._automaton = automaton


class Disconnected(State):
    CONNECT = 'CONNECT'

    def connect(self):
        self._automaton.cast(self.CONNECT)

    def send_msg(self, msg):
        # Either automatically connect, or throw an exception.
        err_msg = 'Cannot send messages in disconnected state!'
        raise IllegalActionException(err_msg)


class Connected(State):
    DISCONNECT = 'DISCONNECT'

    def disconnect(self):
        self._automaton.cast(self.DISCONNECT)

    def send_msg(self, msg):
        print('Message sent!')


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

    def send_msg(self, msg):
        self._state.send_msg(msg)


if __name__ == "__main__":
    automaton = ConcreteAutomaton()

    automaton.register(Disconnected.CONNECT, Disconnected, Connected)
    automaton.register(Connected.DISCONNECT, Connected, Disconnected)

    automaton.connect()
    automaton.send_msg('First message!')
    automaton.disconnect()
    automaton.send_msg('Second message!')
