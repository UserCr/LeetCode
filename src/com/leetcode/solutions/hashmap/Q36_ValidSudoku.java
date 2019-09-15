package com.leetcode.solutions.hashmap;

import com.leetcode.solutions.SolutionInterface;

import java.util.stream.IntStream;

public class Q36_ValidSudoku implements SolutionInterface {
    @Override
    public void run() {
    }

    //水题。其实用三个boolean数组存储访问信息，遍历一遍就可以计算出结果（遍历时需要对坐标转换做些额外处理），但是时间复杂度都是O(n)，
    //所以用可读性更好的方式写题解。
    public boolean isValidSudoku(char[][] board) {
        return isValidByRow(board) && isValidByColumn(board) && isValidByGrid(board);
    }

    private boolean isValidByRow(char[][] board) {
        for (char[] charSet : board) {
            if (charSetIsInvalid(charSet)) {
                return false;
            }
        }
        return true;
    }

    private boolean isValidByColumn(char[][] board) {
        final int COLUMN_SIZE = 9, ROW_SIZE = 9;
        for (int col = 0; col < COLUMN_SIZE; col++) {
            char[] charSet = new char[9];
            for (int row = 0; row < ROW_SIZE; row++) {
                charSet[row] = board[row][col];
            }
            if (charSetIsInvalid(charSet)) {
                return false;
            }
        }
        return true;
    }

    private boolean isValidByGrid(char[][] board) {
        final int GRID_ROW_NUM = 3, GRID_COLUMN_NUM = 3, GRID_ROW_SIZE = 3, GRID_COLUMN_SIZE = 3;
        for (int i = 0; i < GRID_ROW_NUM; ++i) {
            for (int j = 0; j < GRID_COLUMN_NUM; ++j) {
                char[] charSet = new char[9];
                for (int row = i * 3; row < i * 3 + GRID_ROW_SIZE; ++row) {
                    for (int column = j * 3; column < j * 3 + GRID_COLUMN_SIZE; ++column) {
                        charSet[(row % 3) * 3 + (column % 3)] = board[row][column];
                    }
                }
                if (charSetIsInvalid(charSet)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean charSetIsInvalid(char[] set) {
        boolean[] appeared = new boolean[9];
        IntStream.range(0, appeared.length).forEach(i -> appeared[i] = false);
        for (char c : set) {
            if (c != '.' && appeared[c - '1']) {
                return true;
            } else if (c != '.') {
                appeared[c - '1'] = true;
            }
        }
        return false;
    }
}
