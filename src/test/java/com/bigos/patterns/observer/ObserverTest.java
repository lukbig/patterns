package com.bigos.patterns.observer;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Define a one-to-many dependency between objects so that when one object changes
 * state, all its dependents are notified and updated automatically
 *
 * Twitter is a great example of the Observer Pattern. You follow a user and when that
 * user tweets, you along with all other followers of that user receive the tweet.
 * Here, the user account you are following is the publisher and your twitter account
 * along with the other followers are the subscribers. As with any other subscriber,
 * when you unfollow the user, you stop receiving tweets of the user.
 */

class ObserverTest {

    private static final String STATE = "state";
    private static final String NEW_STATE = " new state";

    @Test
    void shouldNotifyObserver() {
        ConcreteObserver observer = new ConcreteObserver();
        Subject subject = new ConcreteSubject();
        subject.attach(observer);

        subject.setState(STATE);

        assertThat(observer.getState()).isEqualTo(STATE);

        subject.setState(NEW_STATE);

        assertThat(observer.getState()).isEqualTo(NEW_STATE);
    }
}