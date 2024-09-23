package com.anz.tech_programming_test;

import java.util.Arrays;
import java.util.Comparator;

public class StackingBlocks {

    public static void sort(int[][] blocks) {
        for(var b : blocks) {
            // ensure W <= L <= H
            Arrays.sort(b);
        }

        // sort blocks in ascending order by W -> L -> H
        Arrays.sort(blocks, (b1, b2) -> {
            if(b1[0] == b2[0]) {
                if(b1[1] == b2[1]) {
                    return b1[2] - b2[2];
                }
                return b1[1] - b2[1];
            }
            return b1[0] - b2[0];
        });
    }

    public static int maxHeight(int[][] blocks) {
        sort(blocks);

        int[] results = new int[blocks.length];

        int max = 0;

        for(int i = 0; i < blocks.length; i++) {
            results[i] = blocks[i][2]; // height

            for(int j = 0; j < i; j++) {
                // test the i-th block can be stacked under any prev j-th blocks
                if(blocks[j][0] <= blocks[i][0]
                        && blocks[j][1] <= blocks[i][1]
                        && blocks[j][2] <= blocks[i][2]
                ) {
                    results[i] = Math.max(results[i], results[j] + blocks[i][2]);
                }
            }

            max = Math.max(max, results[i]);
        }

        return max;
    }
}
