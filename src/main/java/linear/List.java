package linear;

/**
 * @author liuzhongxu
 * @date 2020/2/17
 */
public interface List<T> {
    T get(int i);

    void insertData(T data, int i);

    T deleteData(int i);
}
