# circuit-breaker-pattern
The circuit breaker has three distinct states: Closed, Open, and Half-Open:

Closed – When everything is normal, the circuit breaker remains in the closed state and all calls pass through to the services. When the number of failures exceeds a predetermined threshold the breaker trips, and it goes into the Open state.
Open – The circuit breaker returns an error for calls without executing the function.
Half-Open – After a timeout period, the circuit switches to a half-open state to test if the underlying problem still exists. If a single call fails in this half-open state, the breaker is once again tripped. If it succeeds, the circuit breaker resets back to the normal, closed state. 

In this application, circuit breaker is implemented using Netflix Hystrix.