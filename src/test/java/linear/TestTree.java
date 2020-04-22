package linear;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liuzhongxu
 * @date 2020/4/22
 */
public class TestTree {

    /**
     *
     */
     public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
     }

    /**
     * 199. 二叉树的右视图
     * 给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
     *
     * 示例:
     *
     * 输入: [1,2,3,null,5,null,4]
     * 输出: [1, 3, 4]
     * 解释:
     *
     *    1            <---
     *  /   \
     * 2     3         <---
     *  \     \
     *   5     4       <---
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/binary-tree-right-side-view
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * 思路1
     * 递归，把右子树最右节点拿到，再将左子树最右侧节点拿到，最后合并，冲突以右子树为准；
     * 思路2
     * 层次遍历dfs
     * @param root
     * @return
     */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> results = new ArrayList<>();
        if (null == root) {
            return results;
        }
        results.add(root.val);
        List<Integer> right = rightSideView(root.right);
        List<Integer> left = rightSideView(root.left);

        results.addAll(right);

        if (left.size() > right.size()) {
            for (int i = right.size(); i < left.size() ; i++) {
                results.add(left.get(i));
            }
        }

        return results;
    }

    @Test
    public void testRightSideView() {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.left.right = new TreeNode(5);
        root.right.left.left = new TreeNode(6);

        rightSideView(root);
    }


}
