# Java的一些知识笔记

## 1. Java的集合框架

常见的数据结构有：`LinkedList`、`ArrayList`

### 1）ArrayList：动态数组

可以动态修改的数组，**与普通的数组相比没有固定大小限制**。

ArrayList是一个数组队列，有对应的增、删、改、查的功能

**ArrayList，对于查找、修改效率很高，根据索引进行操作；而对于删除、增加效率较低**

- ArrayList用法

  ArrayList是List接口的一个实现类，关于ArrayList和List的区别：[这篇博客写的很好](https://blog.csdn.net/erlian1992/article/details/51298276)

  （1）需要导入包：

  ```java
  import java.util.ArrayList; // import the ArrayList class
  ```

  （2）new一个ArrayList对象：

  ```java
  ArrayList<String>fruit = new ArrayList<String>();	// 该对象存储的是字符串，对象名为fruit
  // 也可以这么写
  List<Integer>num = new ArrayList<Integer>();		// 对象存储的是int类型的数据
  ```

  :warning:：这里的类型是一个对象：String——**对象，而不是原始类型**，如果要使用其他类型，eg：bool、char、int、double等，<a name="table_type">都需要指定等效的包装器类</a>：

  <img src="C:/Users/Administrator/Desktop/update_everyday/algorithm/leetcode/pic/image-20200627161050020.png" alt="等效包装器类" style="zoom: 50%;" />

  （3）一些有用的方法：

  ```java
  ArrayList<String>fruit = new ArrayList<String>();		// 新建一个对象
  
  // add，添加元素
  fruit.add("apple");
  fruit.add("orange");
  
  // 可以直接将对象中的元素打印出来
  System.out.println(fruit);		// [apple]
  
  // get，获得指定下标的元素
  fruit.get(0);			// apple
  
  // set，设置指定下标的元素的值
  fruit.set(0, "banana");		// apple -> banana
  
  // remove，将指定下标的元素移除
  fruit.remove(1);			// orange x
  
  // clear，清空该对象
  fruit.clear();
  
  // size，求对象中的元素个数
  fruit.size();
  
  // 可以简单for循环
  for(String i: fruit){ .... }	// i即为里面的元素，而不是索引
  ```

  （4）排序：

  ```java
  // 排序需要导入Collections包，里面包含sort方法——能够按照字母或者数字对列表排列
  import java.util.Collections;  // Import the Collections class
  
  Collections.sort(fruit);	// 升序排列
  ```

  - 为什么用 List list = new ArrayList() ，而不用 ArrayList alist = new ArrayList()？

    **list拥有List的所有属性和方法，不会拥有ArrayList的独有的属性和方法**。

    这是**为了方便替换**，List有多个实现类，目前用的是ArrayList，如果之后要换成其他类，例如LinkList、Vector等，那么只需要换新建的这一行即可，而不需要修改后面的代码。如果直接用ArrayList，每一个语句都要修改，而且那么关于ArrayList特有的方法的地方需要重新实现 

### 2）LinkedList：链表

线性表，但是不是顺序存储，而是会在当前节点存放下一个节点的地址——和数据结构：链表一致，而Java已经封装好了该数据结构，直接使用即可。

LinkedList的删除、增加效率较高，而查找、修改效率低

*LinkedList 继承了 AbstractSequentialList 类。*

*LinkedList 实现了 Queue 接口，可作为队列使用。*

*LinkedList 实现了 List 接口，可进行列表的相关操作。*

*LinkedList 实现了 Deque 接口，可作为队列使用。*

*LinkedList 实现了 Cloneable 接口，可实现克隆。*

*LinkedList 实现了 java.io.Serializable 接口，即可支持序列化，能通过序列化去传输。*

- LinkedList用法

  （1）需要导入包

  ```java
  import java.util.LinkedList;	// 导入 LinkedList 的包
  ```

  （2）创建一个LinkedList对象

  元素类型是对象，具体见[表格](#table_type)，也可以是自定义的数据类型对象

  ```java
  LinkedList<Integer> list = new LinkedList<Integer>();	// 只能用该种创建方式，而不能用其他
  // 也需要指定链表中元素的类型——注意是对象，而不是原始类型
  ```

  （3）一些有用的方法

  ```java
  LinkedList<Integer> list = new LinkedList<Integer>();	// 创建一个LinkedList对象
  
  // 添加元素
  list.add(1);
  list.add(2);
  // 在链表头添加元素
  list.addFirst(5);
  // 在链表尾添加元素
  list.addLast(7);
  
  // 将链表头的元素删除，获取不到元素就会抛出异常
  list.removeFirst();
  // 将链表尾的元素删除
  list.removeLast();
  
  // 获得链表头的元素
  list.getFirst();
  // 获得链表尾的元素
  list.getLast();
  
  // 获得LinkedList的长度
  list.size();
  
  // 遍历元素，并根据index获得里面的数据
  for(int size = list.size(), i = 0; i < size; i++){
      list.get(i);		// list.get(index), 通过index获得数据
  }
  // 通过foreach遍历元素
  for(int i: list){
      System.out.println(i);	// i即为元素内容
  }
  
  // 取出链表头元素（get 和 remove 的结合）
  int first = list.pollFirst();
  // 取出链表尾元素
  int last = list.pollLast();
  ```

ArrayList的适用场景

- 需要频繁访问列表中的某个元素
- 只需要在**列表尾部**（最新添加的）进行增、删操作

LinkedList的适用场景

- 需要频繁的在开头、中间、末尾的位置进行增、删操作
- 通过循坏迭代来访问链表中的某些元素

### 3）Queue：队列

队列是一种特殊的线性表，只能够在表头进行删除，在表尾进行插入——先进先出

由于`LinkedList`类实现了`Queue`接口，可以将`LinkedList`当作`Queue`来使用

- Queue的用法

  （1）需要导入包

  ```java
  import java.util.LinkedList;
  import java.util.Queue;
  ```

  （2）创建一个queue对象

  ```java
  Queue<Integer>queue = new LinkedList<Integer>();	// 本质上还是创建一个 LinkedList，但是能使用queue方法
  ```

  （3）一些有用的方法

  由于创建的是`LinkedList`，所以其方法都能用，但是还有几个Queue的方法，比较适合队列特性

  ```java
  Queue<Integer>queue = new LinkedList<Integer>();	// 创建一个Queue对象
  
  // 添加元素， queue.add(2)也可以添加，但是如果添加失败会抛出异常，所以不推荐使用
  queue.offer(1);
  queue.offer(2);
  // foreach 打印出结果
  for(int i: queue){
      System.out.println(i);
  }
  
  // 取出队首元素
  int num = queue.poll();
  // 获得队首元素（不删除）
  int num2 = queue.element();
  // 获得队首元素
  int num3 = queue.peek();
  
  // 判断队伍是否为空
  queue.isEmpty();
  ```

### 4）Collections： 工具类

**Collections**（注意，不是collection集合），是JDK提供的一个工具类，包含了一系列的静态方法，**方便操作各种集合**。

- Collections的用法

  （1）需要导入包

  ```java
  import java.util.Collections;		// 注意C是大写
  ```

  （2）一些方法

  可以给一个`Collection`类型的集合进行操作，因为方法签名是`Collection`，所以可以传入`List, Set`等类型对象

  ```java
  public static boolean addAll(Collection<? super T> c, T... elements) { ... }	// addAll 方法的声明
  ```

  ```java
  LinkedList<Integer> list = new LinkedList<Integer>();		// 创建一个 collection dui'xiang
  
  Collections.addAll(list, 1,2,3,4,5,6);			// 向 list 对象中添加后面的所有元素，元素之间通过","分隔
  
  Collections.max(list);			// 求 list 对象的最大值，与Math.max的区别是，前者是对一个集合对象的最大值求取，而后者是求两个值之间的大者
  Collections.min(list);			// 求 list 对象的最小值
  
  Collections.sort(list);			// 会对 list 进行排序，是升序排列
  
  Collections.shuffle(list);		// 会随机将 list 的内容打乱，俗称洗牌
  ```

### 5）集合的嵌套使用

```java
// 初始化
List<List<Integer>> list = new ArrayList<>();		// 不用指定其泛型

/* 两层，需要添加其层和层里面的值 */
list.add(new ArrayList());		// 添加一层——本质上就是添加一个元素，而该元素的本质是 ArrayList 对象
list.get(0).add(1);				// 获得list的元素（本质上是数组），而对这个元素（数组）进行操作——添加一个元素
list.add(new ArrayList());
list.get(1).add(2);
list.get(1).add(3);
// 最后的数组是：
[
    [0],
    [1, 2]
]
```

