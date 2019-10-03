package moc.qq;

public class TestIMyQueue implements IMyQueue {
    class Node {
        private int data;
        private Node next;
        public Node(int data) {
            this.data = data;
        }
    }

    private Node front;
    private Node rear;
    private int usedSize;
    public TestIMyQueue() {
        this.front = null;
        this.rear = null;
        this.usedSize = 0;
    }
    @Override
    public boolean empty() {
        if (this.usedSize == 0) {
            return true;
        }
        return false;
    }
    //返回队首元素，但不出队列
    @Override
    public int peek() {
        if (empty()) {
            return -1;
        }
        return this.front.data;
    }
    //将返回队首元素，并且出队列
    @Override
    public int poll() {
        if (empty()) {
            throw new UnsupportedOperationException("队列为空");
        }
        int data = this.front.data;
        if (this.usedSize == 1) {
            this.front = null;
            this.rear = null;
        }else {
            this.front = this.front.next;
        }
        this.usedSize =this.usedSize -1;
        return data;
    }
    //将item放入队列中  为空的时候直接指向头和尾
    // 不为空 尾插法
    @Override
    public void add(int item) {
        Node node = new Node(item);
        if (empty()) {
            this.front = node;
            this.rear = node;
        }else {
            this.rear.next = node;
            this.rear = node;
        }
        this.usedSize = this.usedSize+1;
    }
    //返回元素个数
    @Override
    public int size() {
        if (empty()) {
            return 0;
        }else {
            return this.usedSize;
        }
    }
}
