package com.leetcode.solutions.greedy;

import com.leetcode.solutions.SolutionInterface;

public class Q134_GasStation implements SolutionInterface {
    @Override
    public void run() {
    }

    /***
     * 首先证明总油量 >= 总消耗量时必然有解。可用反证法证明：若无解，则必然存在至少一个断点，此断点导致总油量 < 总消耗量，
     * 与题设矛盾，所以必然有解。
     * 因为题设已经限定唯一解，所以只需在有解的情况下找到这个唯一解即可。
     * 若从startPos到CurPos时无法再继续前进，说明这段路总油量不够，在必然有解的前提下，只能把startPos向前调整，
     * 但startPos初始值是0，再向前寻找实际上就等同于真正的startPos在CurPos之后，因此只需继续向后寻找startPos就行。
     * 按这个方法搜索到的某个startPos如果可以前进到数组末尾，在必然有解的前提下，就是正确解。
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int startPos = 0, totalGasIncome = 0, startToCurGasIncome = 0;
        for (int curPos = startPos; curPos < gas.length; ++curPos) {
            int gasIncome = gas[curPos] - cost[curPos];
            totalGasIncome += gasIncome;
            startToCurGasIncome += gasIncome;
            if (startToCurGasIncome < 0) {
                startPos = curPos + 1;
                startToCurGasIncome = 0;
            }
        }
        return totalGasIncome >= 0 ? startPos : -1;
    }
}
