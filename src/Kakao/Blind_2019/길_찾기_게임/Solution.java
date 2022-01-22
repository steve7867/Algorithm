/**
 * 길 찾기 게임
 * https://programmers.co.kr/learn/courses/30/lessons/42892
 */
package Kakao.Blind_2019.길_찾기_게임;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Solution {
    static class BST {
        static class Node {
            int x;
            int y;
            int num;
            Node left;
            Node right;

            public Node(int x, int y, int num) {
                this.x = x;
                this.y = y;
                this.num = num;
            }
        }
        Node root;

        BST(Node node) {
            root = node;
        }

        public void preorder(List<Integer> list) {
            preorder(root, list);
        }
        private void preorder(Node node, List<Integer> list) {
            if (node == null)
                return;

            list.add(node.num);
            preorder(node.left, list);
            preorder(node.right, list);
        }

        public void postorder(List<Integer> list) {
            postorder(root, list);
        }

        private void postorder(Node node, List<Integer> list) {
            if (node == null)
                return;

            postorder(node.left, list);
            postorder(node.right, list);
            list.add(node.num);
        }

        void insert(Node node) {
            root = insert(root, node);
        }

        Node insert(Node root, Node node) {
            if (root == null)
                return node;

            if (root.x < node.x)
                root.right = insert(root.right, node);
            else if (root.x > node.x)
                root.left = insert(root.left, node);

            return root;
        }

    }

    public int[][] solution(int[][] nodeinfo) {
        BST.Node[] nodeArr = new BST.Node[nodeinfo.length];
        for (int i = 0; i < nodeinfo.length; i++) {
            int[] info = nodeinfo[i];
            nodeArr[i] = new BST.Node(info[0], info[1], i + 1);
        }

        Arrays.sort(nodeArr, new Comparator<BST.Node>() {
            @Override
            public int compare(BST.Node o1, BST.Node o2) {
                if (o1.y == o2.y)
                    return Integer.compare(o1.x, o2.x);

                return -Integer.compare(o1.y, o2.y);
            }
        });

        BST bst = new BST(nodeArr[0]);
        for (int i = 1; i < nodeArr.length; i++) {
            bst.insert(nodeArr[i]);
        }

        List<Integer> pre = new ArrayList<>();
        bst.preorder(pre);

        List<Integer> post = new ArrayList<>();
        bst.postorder(post);

        int[][] ans = new int[2][nodeinfo.length];

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < nodeinfo.length; j++) {
                ans[0][j] = pre.get(j);
                ans[1][j] = post.get(j);
            }
        }

        return ans;
    }
}