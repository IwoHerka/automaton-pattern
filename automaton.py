class InvalidTransitionException(Exception):
    pass


class StateA(object):
    event_A = 'EVENT_A'

    def __init__(self, automaton):
        self._automaton = automaton

    def foo(self):
        print('foo')
        self._automaton.cast(self.event_A)


class StateB(object):
    event_B = 'EVENT_B'

    def __init__(self, automaton):
        self._automaton = automaton

    def bar(self):
        print('bar')
        self._automaton.cast(self.event_B)


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
        self._state = StateA(self)

    def foo(self):
        self._state.foo()

    def bar(self):
        self._state.bar()


if __name__ == "__main__":
    automaton = ConcreteAutomaton()
    automaton.register('EVENT_A', StateA, StateB)
    automaton.register('EVENT_B', StateB, StateA)
    automaton.foo()
    automaton.bar()
