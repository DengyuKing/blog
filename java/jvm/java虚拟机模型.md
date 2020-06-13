 /**
 纯文本笔记没有word文档好用，也没有有道等笔记好用，也没有oneNote好用，所选的工具都是为效率服务的。
 **/
 
 # Java类加载器ClassLoader

- 用来加载 Class 的。它负责将 Class 的字节码形式转换成内存形式的 Class 对象。字节码可以来自于磁盘文件 *.class，也可以是 jar 包里的 *.class，也可以来自远程服务器提供的字节流，字节码的本质就是一个字节数组 []byte，它有特定的复杂的内部格式。
  
## classLoader加载类的三个途径
  jvm中存在多个classloader分别负责从不同的地方加载类

   - 文件目录
   - jar包
   - 网络
  
## classLoader加载器分类

- 根加载器(BootstrapClassLoader)：由C语言编写，负责加载Java中的必要的库文件 Java_Home/lib/rt.jar
- 扩展加载器(ExtensionClassLoader):负责加载 JVM 扩展类，比如 swing 系列、内置的 js 引擎、xml 解析器 等等，这些库名通常以 javax 开头，它们的 jar 包位于 JAVA_HOME/lib/ext/*.jar 中，有很多 jar 包
- 应用加载器(AppClassLoader):会加载 Classpath 环境变量里定义的路径中的 jar 包和目录。我们自己编写的代码以及使用的第三方 jar 包通常都是由它来加载的.
  
## 虚拟机调用类加载过程
   程序的入口main方法由AppClassLoader加载，程序在遇到未知的类时，虚拟机的默认策略会用当前调用者的类加载器尝试加载未知的类，这样，所有的未知类都会由main方法的所在类加载，而main方法的所在类是由AppClassLoader，这种特性也是类加载器的传递性

## Java security manager

## Java注解

### 1 Java元注解 

 java元注解可以标记到注解的注解，包括 @Retention、@Documented、@Target、@Inherited、@Repeatable
- @Target标识注解起作用的地方(作用)
        ElementType.ANNOTATION_TYPE 可以给一个注解进行注解
        ElementType.CONSTRUCTOR 可以给构造方法进行注解
        ElementType.FIELD 可以给属性进行注解
        ElementType.LOCAL_VARIABLE 可以给局部变量进行注解
        ElementType.METHOD 可以给方法进行注解
        ElementType.PACKAGE 可以给一个包进行注解
        ElementType.PARAMETER 可以给一个方法内的参数进行注解
        ElementType.TYPE 可以给一个类型进行注解，比如类、接口、枚举
- @Retention 标记注解的生命周期(编译器，运行时，源码)
        RetentionPolicy.SOURCE 注解只在源码阶段保留，在编译器进行编译时它将被丢弃忽视。
        RetentionPolicy.CLASS 注解只被保留到编译进行的时候，它并不会被加载到 JVM 中。
        RetentionPolicy.RUNTIME 注解可以保留到程序运行的时候，它会被加载进入到 JVM 中，所以在程序运行时可以获取到它们
- @Inherited 作用于注解的元注解，作用于注解A，被注解A注解的类的子类可以继承注解A  
  _注解中的属性 注解中的属性必须是8种基本类型_
 
## JAVA代理
- 静态代理：静态代理为在编译期就确定代理类和要代理的类，在运行期代理类已经存在，这种方式叫做静态代理，代理类不是运行期动态生成的，静态代理生成的代理类与被代理的类一样多，且使用代理类的代理功能时，需要修改调用处的代码！
- 动态代理:代理类在运行期间才动态生成，这种方式需要先把要代理的东西编辑好，然后在运行时需要的时候动态生成代理类，静态代理和动态代理在形式上没有区别，在调用的时候都需要修改调用的逻辑(配合SpringAOP标签可以不更改原有代码)，实在搞不懂这两个有什么本质上的区别（没有绝对的好，和绝对的不好）！
### AOP
    - AspectJ

### 垃圾回收器
 
垃圾回收器的发展主线-随着jvm要管理内存原来越大， 垃圾回收器也发展为从回收小内存到回收大内存，从单线程到多线程，从物理分区到逻辑分区再到不分区的发展趋势。

``` graphviz
graph scavenge{
 node[shape ="box" fontname="weiruanyahei"]
 edge[fontname ="weiruanyahei"]

 subgraph  clusteryoung {
     randdir="LR"
     label = "young"
     ParaLLelScavenge
     ParNew
     Serial
     
 }
 subgraph  clusterold {
     randdir="LR"
     label = "Old"
     ParallelOld
     SerialOld
     CMS
     {ParallelOld,SerialOld,CMS rank="same"}
 }
 G1
 Serial--{SerialOld,CMS}
 ParNew--{CMS,SerialOld}
 ParaLLelScavenge--{ParallelOld,SerialOld}
 CMS--SerialOld
}
```
图1-1 虚拟机垃圾回收器发展图

## java 线程池

### 线程池的作用
帮我们管理线程，包括线程的创建，销毁等，可以提高响应速度，同时提高资源的利用率
线程池。

### 线程池的


