package com.ghf.learn.od.lecode;

/**
 * 路径总和
 * https://leetcode.cn/problems/path-sum/
 * 给你二叉树的根节点 root 和一个表示目标和的整数 targetSum 。
 * 判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和 targetSum 。如果存在，返回 true ；否则，返回 false 。
 *
 *
 * @author huafengguo2020
 * @version 2023/4/23 22:24
 * @since JDK8
 */
public class PathSum {

      public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode() {}
          TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
              this.right = right;
          }
      }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null ){
            return false;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        if(left == null && right == null ){
            targetSum -= root.val;
            return targetSum == 0;
        }
        targetSum -= root.val;
        return hasPathSum(left,targetSum) || hasPathSum(right,targetSum);
    }

}
