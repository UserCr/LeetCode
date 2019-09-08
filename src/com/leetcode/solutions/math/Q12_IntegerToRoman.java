package com.leetcode.solutions.math;

import com.leetcode.solutions.SolutionInterface;

public class Q12_IntegerToRoman implements SolutionInterface {
    @Override
    public void run() {
    }

    //水题，略麻烦。
    public String intToRoman(int num) {
        int[] symbolValue = {1000, 500, 100, 50, 10, 5, 1};
        char[] symbolChar = {'M', 'D', 'C', 'L', 'X', 'V', 'I'};
        StringBuilder stringBuilder = new StringBuilder();
        int thousandNum = num / symbolValue[0];
        for (int i = 0; i < thousandNum; ++i) {
            stringBuilder.append(symbolChar[0]);
        }
        num -= (thousandNum * symbolValue[0]);

        for (int groupId = 0; groupId < symbolValue.length - 1; groupId += 2) {
            int baseUnitPos = groupId + 2;
            int quintupleBaseUnitPos = groupId + 1;
            int baseUnitNum = num / symbolValue[baseUnitPos];
            if (0 < baseUnitNum && baseUnitNum < 4) {
                for (int j = 0; j < baseUnitNum; j++) {
                    stringBuilder.append(symbolChar[baseUnitPos]);
                }
            } else if (5 < baseUnitNum && baseUnitNum < 9) {
                stringBuilder.append(symbolChar[quintupleBaseUnitPos]);
                for (int j = 5; j < baseUnitNum; ++j) {
                    stringBuilder.append(symbolChar[baseUnitPos]);
                }
            } else if (4 == baseUnitNum) {
                stringBuilder.append(symbolChar[baseUnitPos]);
                stringBuilder.append(symbolChar[quintupleBaseUnitPos]);
            } else if (9 == baseUnitNum) {
                stringBuilder.append(symbolChar[baseUnitPos]);
                stringBuilder.append(symbolChar[groupId]);
            } else if (5 == baseUnitNum) {
                stringBuilder.append(symbolChar[quintupleBaseUnitPos]);
            }
            num -= (baseUnitNum * symbolValue[baseUnitPos]);
        }
        return stringBuilder.toString();
    }
}
