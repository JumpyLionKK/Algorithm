## [1.SymmetricBinaryTree](./SymmetricBinaryTree)

![image-20200406204417449](C:\Users\ruilo\AppData\Roaming\Typora\typora-user-images\image-20200406204417449.png)

镜像对称的二叉树需要满足的基础条件为：

```java
node.left = node.right
```

基础判断条件比较简单，考虑使用递归解决

递归结束的条件有两个：

1. 如果该树是一个镜像对称的二叉树，那么最后的结果应该是左右子树都为空，此时返回true
2. 如果该树不是一个镜像对称的二叉树，那么存在两种情况，一种是左右子树有一个是空，另外一种是左右子树均不为空，但是不满足上述相等的关系

因此递归关系如下：

```java
if ((node1 == null) && (node2 == null)) return true;
        if ((node1 == null) || (node2 == null)) return false;

        return (node1.val == node2.val)
                && (isUnitSymmetric(node1.left, node2.right))
                && (isUnitSymmetric(node2.left, node1.right));
```

