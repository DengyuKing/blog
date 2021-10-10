/*
 * @lc app=leetcode.cn id=853 lang=java
 *
 * [853] 车队
 *
 * https://leetcode-cn.com/problems/car-fleet/description/
 *
 * algorithms
 * Medium (38.30%)
 * Likes:    115
 * Dislikes: 0
 * Total Accepted:    10K
 * Total Submissions: 26.2K
 * Testcase Example:  '12\n[10,8,0,5,3]\n[2,4,1,1,3]'
 *
 * N  辆车沿着一条车道驶向位于 target 英里之外的共同目的地。
 * 
 * 每辆车 i 以恒定的速度 speed[i] （英里/小时），从初始位置 position[i] （英里） 沿车道驶向目的地。
 * 
 * 一辆车永远不会超过前面的另一辆车，但它可以追上去，并与前车以相同的速度紧接着行驶。
 * 
 * 此时，我们会忽略这两辆车之间的距离，也就是说，它们被假定处于相同的位置。
 * 
 * 车队 是一些由行驶在相同位置、具有相同速度的车组成的非空集合。注意，一辆车也可以是一个车队。
 * 
 * 即便一辆车在目的地才赶上了一个车队，它们仍然会被视作是同一个车队。
 * 
 * 
 * 
 * 会有多少车队到达目的地?
 * 
 * 
 * 
 * 示例：
 * 
 * 输入：target = 12, position = [10,8,0,5,3], speed = [2,4,1,1,3]
 * 输出：3
 * 解释：
 * 从 10 和 8 开始的车会组成一个车队，它们在 12 处相遇。
 * 从 0 处开始的车无法追上其它车，所以它自己就是一个车队。
 * 从 5 和 3 开始的车会组成一个车队，它们在 6 处相遇。
 * 请注意，在到达目的地之前没有其它车会遇到这些车队，所以答案是 3。
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 0 <= N <= 10 ^ 4
 * 0 < target <= 10 ^ 6
 * 0 < speed[i] <= 10 ^ 6
 * 0 <= position[i] < target
 * 所有车的初始位置各不相同。
 * 这个题的关键是超车，如果一辆车能够在到达终点前可以超过另一辆车，那么这两个车可以组成一队。所以起始位置离终点最近的车和可以超过它的车组成
 * 第一个车队，追不上第一个车队的车依次形成第二个车队，第三个车队。 这道题的关键是需要把车根据起始位置大小进行排序，然后依次找出每个车队，
 * 总的时间复杂度为 O（n*logn）。可以考虑采用平衡树进行优化（平衡树的时间复杂度）
 * 这个题的数组 position变动时，speed也要一起变动，所以常规的排序算法是不能用的，需要实现一个特殊的排序方法，实现两个数组联动。
 * 
 */
// @lc code=start
class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        if (position== null || position.length ==0){
            return 0;
        }

        quickSort(position,speed,0,piles.length-1);
        return findCarNums(position,speed,target);

    }
   
    public int findCarNums(int [] position,int [] speed,int target) {
        int sum = 1;
        int flag = position.length -1;
        for (int i = position.length-2;i>=0;i--) {
            int a1 = (target-position[flag])/speed[flag];
            int a2 = (target-position[i])/speed[i];
            if(a1<a2) {
                sum ++;
                flag = i;
            }
        }

        return sum;
    }



    public void quickSort(int [] position,int [] speed,int l,int r) {
        if (l<r) {
            int mid = partition(position,speed, l, r);
            quickSort(position,speed,l,mid-1);
            quickSort(position,speed,mid+1,r);
        }
    }

    /**
     * 快拍变种 先按照第一
     * @param position
     * @param speed
     * @param l
     * @param r
     * @return
     */
    public int partition(int [] position,int [] speed,int l,int r) {
        int tmp =  position[l];
        while (l<r) {
            if (position[l] < tmp){
                l++;
            }else if (position[r] >tmp){
                r --;
            }else if (position[l] == tmp && position[r] == tmp) {
                l++;
            }else {
                int k = position[l];
                position[l] = position[r];
                position[r] = k;

                int sp = speed[l];
                speed[l] = speed[r];
                speed[r] = sp;
            }

        }
        return l;
    }
}

// @lc code=end

