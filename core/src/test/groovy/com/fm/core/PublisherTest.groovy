package com.fm.core

import spock.lang.Specification

/**
 * @author zhangli on 2017/10/20.
 */
class PublisherTest extends Specification {

    Publisher  publisher   = new Publisher()
    Subscriber subscriber  = Mock()
    Subscriber subscriber2 = Mock()

    def setup() {
        publisher.subscribers.add(subscriber)
        publisher.subscribers.add(subscriber2)
    }

    def "should send messages to all subscribers"() {
        setup:
        subscriber.receive(_) >> "ok"
        subscriber.receive(_) >>> ["ok", "error", "error", "ok"]
        subscriber.receive(_) >> { throw new InternalError("ouch") }

        when:
        publisher.send("hello")

        then:
        1 * subscriber.receive("hello")
        1 * subscriber2.receive("hello")
        1 * subscriber.receive("hello")      // exactly one call
        0 * subscriber.receive("hello")      // zero calls
        (1..3) * subscriber.receive("hello") // between one and three calls (inclusive)
        (1.._) * subscriber.receive("hello") // at least one call
        (_..3) * subscriber.receive("hello") // at most three calls
        _ * subscriber.receive("hello")      // any number of calls, including zero
        1 * subscriber.receive("hello")     // an argument that is equal to the String "hello"
        1 * subscriber.receive(!"hello")    // an argument that is unequal to the String "hello"
        1 * subscriber.receive()            // the empty argument list (would never match in our example)
        1 * subscriber.receive(_)           // any single argument (including null)
        1 * subscriber.receive(*_)          // any argument list (including the empty argument list)
        1 * subscriber.receive(!null)       // any non-null argument
        1 * subscriber.receive(_ as String) // any non-null argument that is-a String
        1 * subscriber.receive({ it.size() > 3 }) // an argument that satisfies the given predicate
                                                  // (here: message length is greater than 3)
        1 * subscriber._(*_)     // any method on subscriber, with any argument list
        1 * subscriber._         // shortcut for and preferred over the above
        1 * _._                  // any method call on any mock object
        1 * _                    // shortcut for and preferred over the above

    }


}
