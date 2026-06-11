1class Solution {
2    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
3        ListNode dummay= new ListNode();
4        ListNode temp=dummay;
5        int carry=0;
6
7        while(l1!=null || l2!=null || carry !=0){
8            int sum=carry;
9
10            if(l1!=null){
11                sum+=l1.val;
12                l1=l1.next;
13            }
14            if(l2!=null){
15                sum+=l2.val;
16                l2=l2.next;
17            }
18            carry =sum/10;
19            temp.next=new ListNode(sum%10);
20            temp=temp.next;
21        }
22        return dummay.next;
23    }
24}