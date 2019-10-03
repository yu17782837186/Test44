package moc.qq;

public class TestIMyStack implements IMyStack {
    private int top;  //top永远指向可以存放数据元素的下标
    private int[] elem;  //数组
    private int usedSize;  //数据元素的个数
    public TestIMyStack(int size) {
        this.top = 0;
        this.elem = new int[size];
        this.usedSize = 0;
    }

    private boolean isFull() {
        if (this.usedSize == this.elem.length) {
            return true;
        }
        return false;
    }
    @Override
    public void push(int item) {
        if (isFull()) {
            throw new UnsupportedOperationException("栈为满！");
        }
        this.elem[top] = item;
        top++;
        usedSize = usedSize+1;
    }
    //返回栈顶元素，并且出栈
    @Override
    public int pop() {
        if (empty()) {
            throw new UnsupportedOperationException("栈为空！");
        }
        int data = this.elem[top-1];
        this.top--;
        this.usedSize--;
        return data;
    }
    //返回栈顶元素，但不出栈
    @Override
    public int peek() {
        if (empty()) {
            throw new UnsupportedOperationException("栈为空！");
        }
        return this.elem[top-1];
    }

    @Override
    public boolean empty() {
        if (this.usedSize == 0) {
            return true;
        }
        return false;
    }

    @Override
    public int size() {
        if (empty()) {
            throw new UnsupportedOperationException("栈为空！");
        }
        return this.usedSize;
    }
}
