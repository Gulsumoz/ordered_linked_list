/**
 * Class OrderedLinkedList.
 *
 * This class functions as a linked list, but ensures items are stored in
 * ascending order.
 *
 */
public class OrderedLinkedList {
/**************************************************************************
 * Constants
 *************************************************************************/
    /** return value for unsuccessful searches */
    private static final OrderedListNode NOT_FOUND = null;
/**************************************************************************
 * Attributes
 *************************************************************************/
    /** current number of items in list */
    private int theSize;
    /** reference to list header node */
    private OrderedListNode head;
    /** reference to list tail node */
    private OrderedListNode tail;
    /** current number of modifications to list */
    private int modCount;
/**************************************************************************
 * Constructors
 *************************************************************************/
    /**
     * Create an instance of OrderedLinkedList.
     *
     */
    public OrderedLinkedList() {
// empty this OrderedLinkedList
//clear();

    }
    /**************************************************************************
     * Methods
     *************************************************************************/
/*
* Add the specified item to this OrderedLinkedList.
*
* @param obj the item to be added
*/
    public void add(Comparable obj) {
        OrderedListNode newNode = new OrderedListNode(obj);
        if (head == null) {
            head = newNode;
            tail = newNode;
            return;
        }
        OrderedListNode nodeTraverse = head;
        while(nodeTraverse!=null)
        {
            int currentValue = Integer.parseInt(newNode.theItem.toString());
            int tempValue = Integer.parseInt(nodeTraverse.theItem.toString());
            if(currentValue>tempValue) {
                if(nodeTraverse.next==null)
                {
                    nodeTraverse.next=newNode;
                    newNode.prev =nodeTraverse;
                    break;
                }
                else
                {
                    nodeTraverse=nodeTraverse.next;
                    continue;
                }
            }
            else
            {
                nodeTraverse.prev.next = newNode;
                newNode.prev = nodeTraverse.prev;
                newNode.next= nodeTraverse;
                nodeTraverse.prev=newNode;
                break;
            }
        }
    }
    /*
    * Remove the first occurrence of the specified item from this
    * OrderedLinkedList.
    *
    * @param obj the item to be removed
    */
    public boolean remove(Comparable obj) {
        OrderedListNode current = head;
        OrderedListNode previous = head;
        while (current != null && !(current.theItem.compareTo(obj) == 0)) {
            previous = current;
            current = current.next;
        }
        if (current == null)
            return false;
        else {
            previous.next = current.next;
            current = null;
            return true;
        }
    }
    /**
     * Empty this OrderedLinkedList.
     */
    public void clear() {
// reset header node
        head = new OrderedListNode("HEAD", null, null);
// reset tail node
        tail = new OrderedListNode("TAIL", head, null);
// header references tail in an empty LinkedList
        head.next = tail;
// reset size to 0
        theSize = 0;
// emptying list counts as a modification
        modCount++;
    }
    /**
     * Return true if this OrderedLinkedList contains 0 items.
     */
    public boolean isEmpty() {
        return theSize == 0;
    }
    /**
     * Return the number of items in this OrderedLinkedList.
     */
    public int size() {
        return theSize;
    }
/*
* Return a String representation of this OrderedLinkedList.
*
* (non-Javadoc)
*
* @see java.lang.Object#toString()
*/
//@Override

public String toString() {
    String s = "";
    OrderedListNode currentNode = head;
    while (currentNode != null) {
        s = s + currentNode.theItem.toString() + ",";
        currentNode = currentNode.next;
    }
    return s;
}



/**************************************************************************
 * Inner Classes
 *************************************************************************/
    /**
     * Nested class OrderedListNode.
     *
     * Encapsulates the fundamental building block of an OrderedLinkedList
     * contains a data item, and references to both the next and previous nodes
     * in the list
     */
// TODO: Implement the nested class OrderedListNode (5 points). This nested class
// should be similar to the nested class ListNode of the class LinkedList,but
// should store a data item of type Comparable rather than Object.

    public static void main(String[] args) {
        OrderedLinkedList list = new OrderedLinkedList();

        list.add("1");
        list.add("11");
        list.add("3");
        list.add("9");
        list.add("4");
        list.add("5");
        list.add("15");
        list.add("7");
        list.remove("5");
        System.out.println(list.toString());

    }
    private static class OrderedListNode {
        Comparable theItem;
        OrderedListNode next;
        OrderedListNode prev;
        OrderedListNode(Comparable data) {
            this(data, null, null);
        }
        OrderedListNode(Comparable item, OrderedListNode prev, OrderedListNode next) {
            this.theItem = item;
            this.next = next;
            this.prev = prev;
        }

        OrderedListNode getNext() {
            return next;
        }
        OrderedListNode getPrev() {
            return prev;
        }

    }

}


