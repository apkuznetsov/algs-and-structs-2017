package kuznetsov;

/*
 * Проверка свойства дерева поиска.
 * Проверить, является ли данное двоичное дерево деревом поиска.
 *
 * Дереву разрешается содержать равные ключи,
 * но они всегда должны находиться в правом поддереве.
 * Формально, двоичное дерево называется деревом поиска,
 * если для любой вершины её ключ больше всех ключей из её левого поддерева
 * и не меньше всех ключей из правого поддерева.
 *
 * Вход.
 * Двоичное дерево.
 * Выход.
 * Проверить, является ли оно корректным деревом поиска:
 * верно ли, что для любой вершины дерева её ключ больше всех ключей
 * в левом поддереве данной вершины и меньше всех ключей в правом поддереве.
 *
 * Вы тестируете реализацию двоичного дерева поиска.
 * У вас уже написан код, который ищет, добавляет и удаляет ключи,
 * а также выводит внутреннее состояние структуры данных после каждой операции.
 * Вам осталось проверить, что в каждый момент дерево остаётся корректным деревом поиска.
 * Другими словами, вы хотите проверить, что для дерева корректно работает поиск,
 * если ключ есть в дереве, то процедура поиска его обязательно найдёт,
 * если ключа нет — то не найдёт.
 *
 * Формат входа.
 * Первая строка содержит число вершин n.
 * Вершины дерева пронумерованы числами от 0 до n−1.
 * Вершина 0 является корнем.
 * Каждая из следующих n строк содержит информацию о вершинах 0, 1, ..., n−1:
 * i-я строка задаёт числа key i, left i и right i, где
 * key i — ключ вершины i,
 * left i — индекс левого сына вершины i,
 * right i — индекс правого сына вершины i.
 * Если у вершины i нет одного или обоих сыновей,
 * соответствующее значение равно −1.
 * Формат выхода.
 * Выведите «CORRECT», если дерево является корректным деревом поиска,
 * и «INCORRECT» в противном случае.
 */

import java.util.Deque;
import java.util.LinkedList;

class Main {

    private final Deque<TreeNode> stack = new LinkedList<>();
    private final Deque<Integer> upperLimits = new LinkedList<>();
    private final Deque<Integer> lowerLimits = new LinkedList<>();

    public static void main(String[] args) {
    }

    public void update(TreeNode root, Integer low, Integer high) {
        stack.add(root);
        lowerLimits.add(low);
        upperLimits.add(high);
    }

    public boolean isValidBST(TreeNode root) {
        Integer low = null, high = null, val;
        update(root, low, high);

        while (!stack.isEmpty()) {
            root = stack.poll();
            low = lowerLimits.poll();
            high = upperLimits.poll();

            if (root == null) continue;
            val = root.val;
            if (low != null && val <= low) {
                return false;
            }
            if (high != null && val >= high) {
                return false;
            }
            update(root.right, val, high);
            update(root.left, low, val);
        }
        return true;
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

}
