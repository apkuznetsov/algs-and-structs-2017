package com.company;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Высота дерева.
 * Вычислить высоту данного дерева.
 */

public class Main {

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int inputLen = in.nextInt();
            int[] tree = new int[inputLen];

            for (int i = 0; i < tree.length; i++) {
                tree[i] = in.nextInt();
            }

            int height = findTreeHeight(tree);
            System.out.println(height);
        }
    }

    public static int findTreeHeight(int[] tree) {
        int height = 1;

        Map<Integer, Integer> cache = new HashMap<>();
        for (int node = 0; node < tree.length; node++) {
            height = Math.max(height, findNodeHeight(tree, node, cache));
        }

        return height;
    }

    private static int findNodeHeight(int[] tree, int node, Map<Integer, Integer> cache) {
        if (cache.containsKey(node)) {
            return cache.get(node);
        }

        int height = 1;
        if (tree[node] != -1) {
            height = 1 + findNodeHeight(tree, tree[node], cache);
        }

        cache.put(node, height);
        return height;
    }
}
