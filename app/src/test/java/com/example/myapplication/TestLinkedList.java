package com.example.myapplication;

/**
 * 双链表
 */
public class TestLinkedList<E> {

    /**
     * 结点里面保存数据域，前驱的地址域，后继的地址域
     * 结点
     *
     * @param <E> 数据类型
     */
    private static class Node<E> {
        Node<E> prev;
        E item;
        Node<E> next;

        public Node(Node<E> prev, E item, Node<E> next) {
            this.prev = prev;
            this.item = item;
            this.next = next;
        }
    }

    public TestLinkedList() {

    }

    /**
     * 双向列表内有头结点，尾结点，以及大小
     */
    Node<E> firstNode;

    Node<E> endNode;

    int size;

    /**
     * 添加对象到末尾
     *
     * @param e 数据对象
     */
    public void addToEnd(E e) {
        //先保存之前的尾结点
        Node<E> l = endNode;
        //如果直接添加到尾部
        Node<E> newNode = new Node<>(l, e, null);
        //把尾结点赋值为新结点
        endNode = newNode;
        //如果等于null，说明当前列表为空
        if (l == null) {
            firstNode = newNode;
        } else {
            //旧的尾结点要连接上新的尾结点
            l.next = newNode;
            //这一步不需要是因为在创建新结点时，已经连接上旧的尾结点了
            //newNode.prev = l;
        }
        size++;
    }

    /**
     * 添加对象到队列中
     * 1.先定位要插入的位置
     * 2.连接上新的位置
     *
     * @param e     数据对象
     * @param index 位置
     */
    public void addToMiddle(E e, int index) {
        if (index == size) {
            addToEnd(e);
        } else {
            //找到位置添加
            Node<E> target = node(index);
            //拿到位置结点的前一个
            Node<E> pre = target.prev;
            //创建新结点,并且指定前驱和后继
            Node<E> newNode = new Node<>(pre, e, target);
            //把新结点插入到target的前面
            target.prev = newNode;
            //如果没有前一个，newNode要变为第一个
            if (pre == null) {
                firstNode = newNode;
            } else {
                //把新结点出入到target的前一个结点的后面
                pre.next = newNode;
            }
            size++;
        }
    }

    /**
     * 查找位置
     *
     * @param index 想插入的位置
     * @return 想插入的位置的结点
     */
    public E get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        return node(index).item;
    }

    /**
     * 根据位置查找结点
     * <p>
     * 从这里也可以看出，链表结构查找中间数据很麻烦
     * 双向列表比单项列表比，查找更快一点，因为前者保存了前驱和后继的值，可以选择从头开始查找还是从尾
     *
     * @param index 想插入的位置
     * @return 想插入的位置的结点
     */
    private Node<E> node(int index) {
        //如果直接插入头或者尾
        if (index == 0) {
            return firstNode;
        } else if (index == size) {
            return endNode;
        }

        Node<E> node;
        //先判断在前半部分还是后半部分
        if (index < size / 2) {
            //先拿到第一个结点，再一直遍历，到了index的位置停下
            node = firstNode;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
        } else {
            //先拿到最后一个结点，再反向遍历，到了index的位置停下
            node = endNode;
            for (int i = size - 1; i > index; i--) {
                node = node.prev;
            }
        }
        return node;
    }

    /**
     * 根据位置删除元素
     *
     * @param index 位置
     */
    public void remove(int index) {
        Node<E> target = node(index);
        unlinkNode(target);
    }

    /**
     * 删除任意结点元素
     *
     * @param target 目标
     */
    private void unlinkNode(Node<E> target) {
        //先拿到对应结点的前驱后继
        Node<E> pre = target.prev;
        Node<E> next = target.next;
        //如果没有前驱，就说明要删第一个，就把firstNode设为后继
        if (pre == null) {
            firstNode = next;
        } else {
            //否则就把前驱的指针域指向下一个后继
            pre.next = next;
            //target前驱设null
            target.prev = null;
        }

        //如果没有后继，就说明删最后一个，就把endNode设为前驱
        if (next == null) {
            endNode = pre;
        } else {
            //否则就把后继的指针域指向下一个前驱
            next.prev = pre;
            //target后继设null
            target.next = null;
        }

        //target数据域设null
        target.item = null;
        size--;
    }
}
