package com.ghf.learn.od.lecode;

import java.util.*;

/**
 * 从链表中移除节点-力扣-2487
 *
 * @author huafengguo2020
 * @version 2023/4/26 19:48
 * @since JDK8
 */
public class RemoveLinkedNode {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {
        }
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
    public ListNode removeNodes(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        List<Integer> vals = new ArrayList<>();
        while (head != null){
            while (!stack.isEmpty()){
                if(stack.peek() < head.val){
                    stack.pop();
                }else{
                    break;
                }
            }
            stack.add(head.val);
            ListNode next = head.next;
            head = next;
        }
        head = new ListNode();
        List<Integer> res = new ArrayList<>(stack);
        head = dfs(res,head,0);
        return head;
    }

    public ListNode dfs(List<Integer> vals ,ListNode res ,int index ){
        if(index == vals.size()-1){
            ListNode node = new ListNode(vals.get(index));
            return node;
        }
        res = new ListNode(vals.get(index),dfs(vals,res,index+1));
        return res;
    }

    public static void main(String[] args) {
        RemoveLinkedNode test = new RemoveLinkedNode();
        List<Integer> res = new ArrayList<>();
        res.add(13);
        res.add(8);
        ListNode node = new ListNode();
        node = test.dfs(res,node,0);
    }
}
