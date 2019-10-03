package moc.qq;

public class TestMyStack {
    private TestIMyQueue testIMyQueue1;
    private TestIMyQueue testIMyQueue2;
    private int usedSize;
    public TestMyStack() {
        this.testIMyQueue1 = new TestIMyQueue();
        this.testIMyQueue2 = new TestIMyQueue();
        this.usedSize = 0;
    }
    public void push(int x) {
        if (!testIMyQueue1.empty()) {
            testIMyQueue1.add(x);
        }else if(!testIMyQueue2.empty()) {
            testIMyQueue2.add(x);
        }else {
            testIMyQueue1.add(x);
        }
        this.usedSize++;
    }
    public int pop() {
        if (empty()) {
            return -1;
        }
        int data = 0;
        if (!testIMyQueue1.empty()) {
            for (int i = 0; i <this.usedSize-1 ; i++) {
                testIMyQueue2.add(testIMyQueue1.poll());
            }
            data = testIMyQueue1.poll();
        }else {
            for (int i = 0; i <this.usedSize-1 ; i++) {
                testIMyQueue1.add(testIMyQueue2.poll());
            }
            data = testIMyQueue2.poll();
        }
        this.usedSize--;
        return data;
    }
    public int top() {
        if (empty()) {
            return -1;
        }
        int data = 0;
        if (!testIMyQueue1.empty()) {
            for (int i = 0; i <this.usedSize ; i++) {
                data = testIMyQueue1.poll();
                testIMyQueue2.add(data);
            }
        }else {
            for (int i = 0; i <this.usedSize ; i++) {
                data = testIMyQueue2.poll();
                testIMyQueue1.add(data);
            }
        }
        return data;
    }
    public boolean empty() {
        if (this.usedSize == 0) {
            return true;
        }
        return false;
    }
    public int size() {
        if (this.usedSize == 0) {
            throw new  UnsupportedOperationException("队列实现栈为空！");
        }
        return this.usedSize;
    }
}
