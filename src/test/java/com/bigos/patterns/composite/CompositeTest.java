package com.bigos.patterns.composite;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CompositeTest {

    @Test
    void shouldAddFileToDirectory() {
        Component file = new File("a");
        Component directory = new Directory("b");

        directory.addElement(file);
        directory.print();

        assertThat(directory.getSize()).isEqualTo(1);
    }

    @Test
    void shouldNotAddFileToFile() {
        Component fileAlpha = new File("a");
        Component fileBravo = new File("b");

        Throwable t = Assertions.catchThrowable(() -> fileAlpha.addElement(fileBravo));

        assertThat(t)
                .isInstanceOf(UnsupportedOperationException.class)
                .hasMessage("Cannot add element");
    }

    @Test
    void shouldNotAddDirectoryToFile() {
        Component file = new File("a");
        Component directory = new Directory("b");

        Throwable t = Assertions.catchThrowable(() -> file.addElement(directory));

        assertThat(t)
                .isInstanceOf(UnsupportedOperationException.class)
                .hasMessage("Cannot add element");
    }

    @Test
    void shouldNotReturnComponentSizeForFile() {
        Component file = new File("a");

        Throwable t = Assertions.catchThrowable(file::getSize);

        assertThat(t)
                .isInstanceOf(UnsupportedOperationException.class)
                .hasMessage("Cannot get size");
    }

    @Test
    void shouldReturnThatFileIsALeaf() {
        Component file = new File("a");

        boolean isLeaf = file.isLeaf();

        assertThat(isLeaf).isTrue();
    }

    @Test
    void shouldReturnThatDirectoryIsNotALeaf() {
        Component directory = new Directory("b");

        boolean isLeaf = directory.isLeaf();

        assertThat(isLeaf).isFalse();
    }

    @Test
    void shouldAddFileAndDirectoryToDirectoryAndTwoFileToInnerDirectory() {
        Component directoryAlpha = new Directory("a");
        Component fileBravo = new File("b");
        Component directoryCharlie = new Directory("c");
        Component fileDelta = new File("d");
        Component fileEta = new File("e");

        directoryAlpha.addElement(fileBravo);
        directoryAlpha.addElement(directoryCharlie);
        directoryCharlie.addElement(fileDelta);
        directoryCharlie.addElement(fileEta);
        directoryAlpha.print();

        assertThat(directoryAlpha.getSize()).isEqualTo(2);
        assertThat(directoryCharlie.getSize()).isEqualTo(2);
    }
}