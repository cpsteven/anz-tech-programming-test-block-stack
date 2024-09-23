package com.anz.tech_programming_test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

public class StackingBlocksTest {

    private static Logger log = LogManager.getLogger(StackingBlocksTest.class);

    private static Stream<Arguments> testMaxHeightInputsAndResults() {
        return Stream.of(
                Arguments.of(new int[][] {
                        new int[] {50, 45, 20},
                        new int[] {95, 37, 53},
                        new int[] {45, 23, 12},
                }, new int[][] {
                        new int[] {12, 23, 45},
                        new int[] {20, 45, 50},
                        new int[] {37, 53, 95},
                }, 190),
                Arguments.of(new int[][] {
                        new int[] {38, 25, 45},
                        new int[] {76, 53, 3},
                }, new int[][] {
                        new int[] {3, 53, 76},
                        new int[] {25, 38, 45},
                }, 76),
                Arguments.of(new int[][] {
                        new int[] {7, 11, 17},
                        new int[] {7, 17, 11},
                        new int[] {11, 7, 17},
                        new int[] {11, 17, 7},
                        new int[] {17, 7, 11},
                        new int[] {17, 11, 7},
                }, new int[][] {
                        new int[] {7, 11, 17},
                        new int[] {7, 11, 17},
                        new int[] {7, 11, 17},
                        new int[] {7, 11, 17},
                        new int[] {7, 11, 17},
                        new int[] {7, 11, 17},
                }, 102)
        );
    }

    @ParameterizedTest
    @MethodSource("testMaxHeightInputsAndResults")
    public void testMaxHeight(int[][] blocks, int[][] sortedBlocks, int expectedMax) {
        log.info("testMaxHeight(). blocks: {}", () -> Arrays.deepToString(blocks));

        int actualMax = StackingBlocks.maxHeight(blocks);
        log.info("testMaxHeight(). sortedblocks: {}", () -> Arrays.deepToString(blocks));
        Assertions.assertArrayEquals(sortedBlocks, blocks, "StackingBlocks.sort()");

        log.info("testMaxHeight(). expectedMax: {}, actualMax: {}", expectedMax, actualMax);
        Assertions.assertEquals(expectedMax, actualMax, "StackingBlocks.maxHeight()");
    }
}
