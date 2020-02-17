package linear;

/**
 * 实现顺序表
 * @date 2020/1/13
 */
public class ArrayList<T> implements List<T> {

    /**
     * 存储数据的最大数量
     */
    private int maxSize;

    /**
     * 当前数组元素数量
     */
    private int currentSize;

    /**
     * 存储的数据元素
     */
    private T[] data;

    /**
     * 初始化顺序表
     * @param maxSize 初始化最大元素数量
     */
    public ArrayList(int maxSize) {
        this.currentSize = 0;
        this.maxSize = maxSize;
        this.data = (T[]) new Object[maxSize];
    }

    /**
     * 读取顺序表中的数据元素
     * @param i
     * @return
     */
    @Override
    public T get(int i) {
        if (i < 0 || i > this.currentSize) {
            throw new IndexOutOfBoundsException();
        }

        return this.data[i];
    }

    /**
     * 在顺序表中第i个数据前，插入数据data，表长度加1
     * @param data
     * @param i
     */
    @Override
    public void insertData(T data, int i) {

        // 输入校验
        if (i < 0 || i > this.currentSize + 1) {
            throw new IndexOutOfBoundsException();
        }

        // 判断表空间大小
        if (this.currentSize == this.maxSize) {
            // 表空间不足
            // 如何扩容？
            throw new RuntimeException("this array if full.");
        }

        // 插入数据不在表尾
        if (i < this.currentSize) {
            // 将要插入位置后的数据向后移动一位，倒序更优雅
            for (int j = this.currentSize; j >= i; j--) {
                this.data[j + 1] = this.data[j];
            }
        }

        // 执行插入i
        this.data[i] = data;
        this.currentSize++;
    }

    /**
     * 删除第i个数据，返回被删除数据，表长减1
     * @param i
     * @return
     */
    @Override
    public T deleteData(int i) {
        T data;

        // 输入校验
        if (i < 0 || i > this.currentSize + 1) {
            throw new IndexOutOfBoundsException();
        }

        // 判断表空间大小
        if (this.currentSize == 0) {
            // 空表
            throw new RuntimeException("this array if empty.");
        }

        // 获得被删除数据
        data = this.data[i];

        // 被删除数据不在表尾
        if (i < this.currentSize) {
            for (int j = i; j <= this.currentSize; j++) {
                this.data[j] = this.data[j + 1];
            }
        }
        this.currentSize--;
        return data;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < this.currentSize; i++) {
            sb.append(this.data[i]);
            if (i < this.currentSize - 1) {
                sb.append(',');
            }
        }
        return sb.toString();
    }
}
