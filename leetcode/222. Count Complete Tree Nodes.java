/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {            // ͨ��ʽ�ⷨ��û��������ȫ���������ص㣬ʱ�临�Ӷ�ΪO(N)
    public int num = 0;
    public int countNodes(TreeNode root) {
        if(root == null) return num;
        countNodes(root.left);
        countNodes(root.right);
        num++;
        return num;
    }
}

class Solution {            // ��΢΢�Ż��汾
    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        int left = countNodes(root.left);
        int right = countNodes(root.right);
        return left + right + 1;
    }
}

class Solution {            // ��������ȫ������������
    private int countLevel(TreeNode root){      // ���㵱ǰ�����������
        int level = 0;
        while(root != null){
            level++;
            root = root.left;       // ������ȫ�����������ԣ���root��ʼһֱ����һ�������
        }
        return level;
    }
    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        int leftLevel = countLevel(root.left);  // ������ڵ����/�����������
        int rightLevel = countLevel(root.right);

        if(leftLevel == rightLevel){        // ��ô������һ�����ˣ��ټ�������������
            return countNodes(root.right) + (1 << leftLevel);   // ����������+��������2^n-1��+1��Ϊroot��
        }
        else{               // ��ô������һ�����ˣ��ټ�������������
            return countNodes(root.left) + (1 << rightLevel);
        }
    }
}

class Solution {            // ��Ϊ����ķ���
    private boolean existNode(TreeNode root, int cur, int level){      // ͨ��λ���㵱ǰ�ڵ��Ƿ����
        int bit = 1 << (level - 2);         // ��Ϊlevel��ʾ���Ǵ�1��ʼ����ĵ�ǰ�㼶����������Ҫ�ų����λ(��ʾ��ǰ�㼶)���ӵڶ�λ��ʼ����
        while(root != null && bit != 0){
            if((bit & cur) != 0) root = root.right;     // ��λΪ1����ʾ��������
            else root = root.left;          // ��λΪ0����ʾ��������
            bit = bit >> 1;
        }
        if(root != null) return true;
        else return false;

    }
    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        int level = 0;
        TreeNode node = root;
        while(node != null){        // ����������ڵ㣬����������
            level++;
            node = node.left;
        }
        int left = (1 << (level - 1));   // �ö��������²����Сֵ
        int right = (1 << level) - 1;     // ���²�����ֵ

        while(left < right){            // ��ֹ��������left=right����ô�����ҵ��ˡ���ֱ�ӷ���left������Ҫ��ֵ
            int mid = (right - left + 1)/2 + left;  // ��������ȵ�ʱ��ȡ�����Ǹ��ڵ�
            if(existNode(root, mid, level)){        // ������ڸýڵ㣬��ô�ڵ����>=mid
                left = mid;
            }
            else{           // ��������ڣ���ô�ڵ����<mid
                right = mid - 1;
            }
        }
        return left;
    }
}