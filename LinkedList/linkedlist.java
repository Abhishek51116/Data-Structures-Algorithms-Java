public class linkedlist {
    class Node { 
        int data; 
        Node next; 
        Node(int d) {data = d; next = null; } 
    }
    public int size=0;
    public Node head = null;
    public Node tail = null; 
    public void addNode(int data) {
        Node ne = new Node(data);
        if (head == null){
            head = ne;
            tail = ne;
        }
        else {
            tail.next = ne;
            tail = ne;
        }
        size++;
    }
    public void insertBegin(int data) {
        Node ptr = head;
        Node newNode = new Node(data);
        newNode.next = ptr;
        head = newNode;
        System.out.println("Added " + data + " at beginning of list.");
        showList();
    }
    public void insertEnd(int data) {
        Node ptr = tail;
        Node newNode = new Node(data);
        ptr.next = newNode;
        tail = newNode;
        System.out.println("Added " + data + " at end of list.");
        showList();
    }
    public void insertNodeAfter(int data, int target) {
        Node ptr = head;
        while (ptr.data!=target){
            ptr = ptr.next;
        }
        if (ptr==head){
            System.out.println("Target Not Found");
            return;
        }
        Node newNode = new Node(data);
        newNode.next = ptr.next;
        ptr.next = newNode;
        System.out.println("Added " + data + " after " + target);
        showList();
    }
    public void insertNodeBefore(int data, int target) {
        Node ptr = head;
        Node pptr = ptr;
        while (ptr.data!=target){
            pptr = ptr;
            ptr = ptr.next;
        }
        if (ptr==head){
            System.out.println("Target Not Found");
            return;
        }
        Node newNode = new Node(data);
        newNode.next = pptr.next;
        pptr.next = newNode;
        System.out.println("Added " + data + " before " + target);
        showList();
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
    }  
    public static void main(String[] args){
        middleinsert mi = new middleinsert();
        mi.addNode(10);
        mi.addNode(78);
        mi.addNode(92);
        mi.addNode(8);
        mi.addNode(71);
        mi.addNode(16);
        mi.addNode(28);
        mi.addNode(30);
        System.out.println("Original List:");
        mi.showList();
        mi.insertNodeAfter(57, 71);
        mi.insertNodeBefore(420, 30);
        mi.insertBegin(53);
        mi.insertEnd(500);
    }
}
