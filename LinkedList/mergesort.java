public class mergesort {
    class Node {
        int data;
        Node next;
        Node(int d){
            this.data = d;
        }
    }
    Node head = null;
    Node tail = null;
    int size = 0;
    public void addNode(int data){
        Node n = new Node(data);
        if (head==null){
            head = n;
            tail = n;
        } else {
            tail.next = n;
            tail = n;
        }
        size++;
    }
    public Node middleNode(Node head) {
        Node fast = head;
        Node slow = head;
        while (fast.next!=null&&fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public Node merge(Node a, Node b){
        Node res = null;
        if (a==null){
            return b;
        }
        if (b==null){
            return a;
        }
        if (a.data<=b.data){
            res = a;
            res.next = merge(a.next, b);
        } else {
            res = b;
            res.next = merge(a, b.next);
        }
        return res;
    }
    public Node sort(Node head){
        if (head==null||head.next==null){
            return head;
        }
        Node mid = middleNode(head);
        Node midPlus = mid.next;
        mid.next = null;
        Node left = sort(head);
        Node right = sort(midPlus);
        Node output = merge(left, right);
        return output;
    }
    public void showList() {  
        Node current = head;  
        if(head == null) {  
            System.out.println("List is empty");  
            return;  
        }
        while(current != null) {  
            System.out.print(current.data + " ");  
            current = current.next;  
        }  
        System.out.println();  
    }      public static void main(String[] args){
        mergesort ll = new mergesort();
        ll.addNode(10);
        ll.addNode(78);
        ll.addNode(92);
        ll.addNode(8);
        ll.addNode(71);
        ll.addNode(16);
        ll.addNode(28);
        ll.addNode(30);
        ll.showList();
        ll.head = ll.sort(ll.head);
        ll.showList();
    }
}
