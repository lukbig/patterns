package com.bigos.patterns.bridge;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * https://stackoverflow.com/questions/319728/when-do-you-use-the-bridge-pattern-how-is-it-different-from-adapter-pattern:
 * 1)
 * When:
 *
 *                 ---------Shape-------
 *                /                    \
 *       Rectangle                   Circle
 *      /         \                 /      \
 * BlueRectangle  RedRectangle BlueCircle RedCircle
 *
 * Refactor to:
 *
 *        ----Shape---                        Color
 *       /            \                       /   \
 * Rectangle(Color)   Circle(Color)         Blue   Red
 *
 * 2)
 * When:
 *
 *         --A--
 *        /     \
 *      Aa      Ab
 *     / \     /  \
 *   Aa1 Aa2  Ab1 Ab2
 *
 * Refactor to:
 *    A           N
 *  /   \        / \
 *Aa(N) Ab(N)   1   2
 *
 *
 *
 * The Bridge pattern is an application of the old advice, "prefer composition over inheritance".
 * It becomes handy when you must subclass different times in ways that are orthogonal with one another.
 *
 * Decouple an abstraction from its implementation so that the two can vary independently.
 */
class BridgeTest {

    @Test
    void shouldDescribeRedCircle() {
        Shape shape = new Circle(new Red());

        String description = shape.describe();

        assertThat(description).isEqualTo("Red circle");
    }

    @Test
    void shouldDescribeBlueCircle() {
        Shape shape = new Circle(new Blue());

        String description = shape.describe();

        assertThat(description).isEqualTo("Blue circle");
    }

    @Test
    void shouldDescribeRedRectangle() {
        Shape shape = new Rectangle(new Red());

        String description = shape.describe();

        assertThat(description).isEqualTo("Red rectangle");
    }

    @Test
    void shouldDescribeBlueRectangle() {
        Shape shape = new Rectangle(new Blue());

        String description = shape.describe();

        assertThat(description).isEqualTo("Blue rectangle");
    }
}