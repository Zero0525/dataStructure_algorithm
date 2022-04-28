
import sun.java2d.pipe.OutlineTextRenderer;

import java.util.*;

public class Solution {

    public String decodeString(String str) {

        //处理字符的栈
        Stack<String> chars = new Stack<String>();
        //处理数字的栈
        Stack<String> counts = new Stack<String>();


        int ptr = 0;

        while (ptr<str.length()){
            char curr = str.charAt(ptr);
            //如果是数字,可能不止一位数,进行拼接
            if (Character.isDigit(curr)){
                StringBuilder num = new StringBuilder();
                while (Character.isDigit(str.charAt(ptr))){
                    num.append(str.charAt(ptr++));
                }
                counts.push(num.toString());
            }else if (Character.isLetter(curr)||curr =='['){//非"]"字符入栈
                chars.push(String.valueOf(str.charAt(ptr++)));
            }else{
                //当遇到']'时将栈顶字符串出栈直至'['并组合
                LinkedList<String> sup = new LinkedList<String>();
                //temp用来组织重复的字符串
                StringBuilder temp = new StringBuilder();
                //把[]内的字符出栈并拼接
                while (!"[".equals(chars.peek())){
                    sup.addFirst(chars.pop());
                }
                //左括号出栈
                chars.pop();
                //临时链表内的字符转为字符串
                String comb = getString(sup);
                //重复字符串
                Integer repTime = Integer.valueOf(counts.pop());
                for (int i = 0; i < repTime; i++) {
                        temp.append(comb);
                }
                //构造好的字符串入栈
                chars.push(temp.toString());
                ptr++;
            }
        }
        return getString(chars);
    }

    public String getString(Stack<String> sup ){
        StringBuilder sb = new StringBuilder();
        for (String s : sup) {
            sb.append(s);
        }
        return sb.toString();
    }

    public String getString(LinkedList<String> sup ){
        StringBuilder sb = new StringBuilder();
        for (String s : sup) {
            sb.append(s);
        }
        return sb.toString();
    }


    public int fibonacci(int n){
        if (n==1)
            return 1;
        if (n==0)
            return 0;

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        if (map.containsKey(n))
            return map.get(n);


        int res =fibonacci(n-2)+fibonacci(n-1);
        map.put(n,res);
        return res ;

    }


    static class ListNode {
        public int data;
        public ListNode next;

        public static ListNode reverseList(ListNode head) {
            //结束条件
            if (head == null || head.next == null)
                return head;

            ListNode curr = head;
            ListNode pre = null;

            while (curr != null) {
                //记录curr后继节点
                ListNode next = curr.next;
                //反转指向
                curr.next = pre;
                //步进
                pre = curr;
                curr = next;
            }

            return pre;
        }

        public void printListFromHead(ListNode head) {
            while (head != null) {
                System.out.print("{" + head.data + "}");
                head = head.next;
            }
            System.out.println();
        }


        public boolean hasNext() {
            return null != next;
        }

        public ListNode() {
        }

        public ListNode(int data) {
            this.data = data;
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public ListNode getNext() {
            return next;
        }

        public void setNext(ListNode next) {
            this.next = next;
        }
    }
}
