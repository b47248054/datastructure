# DataStructure

## 数据结构与算法

### 什么是数据结构？

- 基本概念：数据结构，指相互之间存在一种或多种特定关系的数据元素的集合。"结构"可以理解为关系，即数据"关系"。

### 数据结构中包含哪些基本的概念？

- 数据：是描述客观事物的符号，用于计算机理解识别。例如：图像、数字、声音等等。

- 数据对象：是性质相同的数据元素的集合。例如：班级、教师、学校等等。

- 数据元素：是数据的基本单位，被计算机整体处理，通常被称作记录。例如：学生、老师等等。

- 数据项：一个数据元素包含多个数据项。例如：学科、成绩、课时等等。

### 如何描述数据间关系？

- 通常在数据对象中，我们探索数据元素之间的逻辑关系，并归纳出普遍的种类，来描述数据元素间的关系，这些归纳出来的种类往往被我们称作逻辑结构。逻辑结构，指数据对象中，数据元素之间的关系。大致分为以下几种。

    - 集合结构，除属于同一个集合外，没有其他关系。
    
    - 线性结构，元素之间是一对一的关系。
    
    - 树形结构，元素之间是一对多的层次关系。
    
    - 图形结构，元素之间是多对多的关系。

- 逻辑结构是针对具体问题的，是为了解决某个问题，在对问题理解的基础上，选择一种合适的逻辑结构标识数据元素之间的逻辑关系。

### 如何在计算机中存储逻辑结构？

- 物理结构，即数据的逻辑结构在计算机中的存储形式，也被称为存储结构。这里的存储并非是存储介质，而是使用正确的存储结构来描述数据元素之间的逻辑关系，这是关键。如何存储数据元素之间的关系，是实现物理结构的重点和难点。

- 数据元素的存储形式有两种

    1. 顺序存储，数据存放在地址连续的存储单元中
    
    2. 链式存储，把数据存放在任意存储单元中


### 算法与数据结构的关系是什么？

- 数据是算法的内涵，算法是数据的灵魂，两者相辅相成，数据离开算法便失去了灵魂，算法离开数据便失去内涵。最基本的，我们在使用、更新、删除数据时就是算法的作用。算法就是操作数据的，数据就是被操作的，也可以理解为数据不被操作就失去了意义。

### 什么是算法？

- 算法是解决特定问题求解步骤的描述。

### 算法具备的特性有哪些？

- 0..* 个输入，1.. *个输出

- 有穷性，算法一定会执行结束。

- 确定性，算法的每个步骤都有确定的含义，不会出现二义性。

- 可行性

### 算法设计的要求有哪些？

- 正确性，能够得到正确答案。
	
> 算法的正确性有多个评价标准，也就是测试领域的工作了
> 1. 没有语法错误
> 2. 正确的输入给出正确结果
> 3. 非法的输入给出满足规格说明的结果

- 可读性，算法不仅是给机器执行的，更重要的是一种交流工具，要便于阅读、理解、交流

- 健壮性，非法输入不会引起异常

- 时间效率高、存储量低

### 算法时间复杂度推导方法

- 计算一个算法的时间复杂度，不可能把所有的算法都编写出实际的程序出来让计算机跑，这样会做很多无用功，效率太低。实际采用的方法是估算算法的时间复杂度。

- 在学习C语言的时候讲过，程序由三种结构构成：顺序结构、分支结构和循环结构。顺序结构和分支结构中的每段代码只运行一次；循环结构中的代码的运行时间要看循环的次数。

- 由于是估算算法的时间复杂度，相比而言，循环结构对算法的执行时间影响更大。所以，算法的时间复杂度，主要看算法中使用到的循环结构中代码循环的次数（称为“频度”）。次数越少，算法的时间复杂度越低。

- 例如：
```
a) ++x; s=0;
b) for (int i=1; i<=n; i++) { ++x; s+=x; }
c) for (int i=1; i<=n; i++) { for (int j=1; i<=n; j++) { ++x; s+=x; } }
```

- 上边这个例子中，a 代码的运行了 1 次，b 代码的运行了 n 次，c 代码运行了 n*n 次。

- 对于上边的例子而言，a 的时间复杂度为O(1)，b 的时间复杂度为O(n)，c 的时间复杂度为为O(n2)。如果a、b、c组成一段程序，那么算法的时间复杂度为O(n2+n+1)。但这么表示是不对的，还需要对n2+n+1进行简化。

- 简化的过程总结为3步（推导"O"阶）：
    1. 去掉运行时间中的所有加法常数。（例如 n2+n+1，直接变为 n2+n）
    2. 只保留最高项。（n2+n 变成 n2）
    3. 如果最高项存在但是系数不是1，去掉系数。（n2 系数为 1）

- 所以，最终a、b和c合并而成的代码的时间复杂度为O(n2)。

### 空间复杂度，忽略吧，这个不是重点。

### 总结
![IMG_6219](https://raw.githubusercontent.com/b47248054/datastructure/master/media/datastructure.png)

## 线性结构

### 线性表

#### 什么是线性表？
- 线性表是大于等于0个数据元素的有限序列，元素之间是1对1关系，全称为线性存储结构。线性表存在两个特征，有序性和有限性，除第一个元素外，每个元素都存在前驱元素，除最后一个元素外，每一个元素都存在后续元素；线性表的元素数量是有限的。

#### 线性表的物理结构
- 线性表按存储方式划分为两种物理结构，顺序存储结构和链式存储结构。将数据元素依次存储在连续的物理空间中，这样的存储方式被称为顺序存储结构（简称顺序表）。将数据元素分散的存储在任意的物理空间中，数据元素间通过相互链接，来存储期间的逻辑关系，这种存储方式被称为链式存储结构（简称链式表）。

#### 顺序表
- 顺序表的数据结构
    - 简单的来讲，顺序表就是一维数组，数据元素之间的有序性，通过其在数组中的位置来确定。其长度和容量在创建时按数据类型动态计算并分配连续的物理空间。
    - 其结构需要包含物理空间最大容量、当前数组被占用的数量和实际存放数据的数组。
    - 其特性还体现在读取数据时的性能为O(1)，在更新数据时性能为O(n)
    
- 顺序表的实现（java）    

```java
package linear;

/**
 * 实现顺序表
 * @date 2020/1/13
 */
public class ArrayList {

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
    private String[] data;

    /**
     * 初始化顺序表
     * @param maxSize 初始化最大元素数量
     */
    public ArrayList(int maxSize) {
        this.currentSize = 0;
        this.maxSize = maxSize;
        this.data = new String[maxSize];
    }

    /**
     * 读取顺序表中的数据元素
     * @param i
     * @return
     */
    public String get(int i) {
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
    public void insertData(String data, int i) {

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
    public String deleteData(int i) {
        String data;

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

```


#### 链式表
- 链式表的基本结构
- 单向链表的结构
    - 实现单向链表（java）
        - 创建
        - 读取
        - 更新
        - 删除
    - 实现单向循环链表（java）
        - 创建
        - 读取
        - 更新
        - 删除
- 双向链表的结构
    - 实现双向链表（java）
        - 创建
        - 读取
        - 更新
        - 删除
    - 实现双向循环链表
        - 创建
        - 读取
        - 更新
        - 删除
        
#### 顺序表和链表的优缺点
- 物理结构
- 时间性能
- 空间性能
- 静态链表的结构
- 实现静态链表（java）
    - 创建
    - 读取
    - 更新
    - 删除

#### 总结
![IMG_6219](https://raw.githubusercontent.com/b47248054/datastructure/master/media/list.png)
### 栈与队列

### 串

## 非线性结构

### 树

### 图

## 算法

### 查找

### 排序


*XMind: ZEN - Trial Version*

