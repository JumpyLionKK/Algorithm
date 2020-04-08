## [1.SymmetricBinaryTree](./SymmetricBinaryTree)

[leetCode question link](https://leetcode-cn.com/problems/symmetric-tree/)

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



## 2.movingCount

[leetCode question link](https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof/)

经典的BFS算法，沿着每个点所有可能到达的路径依次遍历即可，需要一个数组记录状态（区分已到达和未到达）