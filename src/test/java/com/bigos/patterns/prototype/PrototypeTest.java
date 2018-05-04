package com.bigos.patterns.prototype;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 1. Prototype pattern refers to creating duplicate object while
 * keeping performance in mind. This pattern involves implementing
 * a prototype interface which tells to create a clone of current
 * object. This pattern is used when creation of object directly
 * is costly because of f.e. network communication, database reads
 * or disk I/O.
 * 2. A prototype is a template of any object before the actual
 * object is constructed. This pattern is used in scenarios when
 * application needs to create a number of instances of a class,
 * which has almost same state or differs very little.
 * 3. Java provides the Cloneable interface to mark objects that
 * permit cloning. This interface is a marker interface and
 * therefore does not contain any method declaration. When
 * implemented in a class, Cloneable marks that objects of the
 * class can be cloned. To perform cloning, you need to call
 * he protected clone() method of the Object class through a call
 * to super.clone(). Note: If an object calls super.clone() but
 * does not implements Cloneable, the method throws an exception
 * of type, CloneNotSupportedException.
 * A call to super.clone() performs a shallow copy where all the fields
 * values of the original object are copied to the new object.
 * If a field value is a primitive type, a shallow copy copies the
 * value of the primitive type. But, if a field value is a reference
 * type, then only the reference is copied, and not the referred
 * object itself.
 * When you go for a deep copy, you will need to override the
 * Object.clone() method in all the member classes and then
 * recursively clone their objects. Alternatively, you can get
 * a deep copy by serializing an object and then restoring it
 * back through Java object serialization.
 */

class PrototypeTest {

    private static final String STATE = "state";

    @Test
    void shouldClone() {
        ConcretePrototype prototype = new ConcretePrototype(STATE);

        ConcretePrototype cloned = prototype.clonePrototype();

        assertThat(cloned.getState()).isEqualTo(STATE);
    }
}