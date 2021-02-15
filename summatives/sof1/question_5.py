#!/usr/bin/python
# -*- coding: utf-8 -*-
from pprint import pprint
import copy


class Blotris:

    def __init__(self, rows, cols):
        if not rows >= 5 or not cols >= 5:
            raise ValueError
        self.rows = rows
        self.cols = cols
        self._board = [[0] * cols for _ in range(rows)]  # 2d matrix of cols

    def update(self):
        for i in range(len(self._board)):
            row = self._board[i]
            if len(list(set(row))) == 1 and list(set(row))[0] == 1:  
                '''
                Check if there is a list of only 1s
                If there is, pop, then insert list of 0s
                '''
                self._board.pop(i)  # remove the line
                self._board.insert(0, [0] * self.cols)  # replace the list

    def add(
        self,
        shape,
        row,col):
        if row < 0 or col < 0:
            return False
        board = copy.deepcopy(self._board)  # create copy of the board

        tmp = []
        r = []
        c = []
        try:
            for i in range(0, len(shape)):
                r.append(i + row)
                for j in range(len(shape[i])):
                    if shape[i][j] == 1:
                        tmp.append(j + col)  # add the column incrememnt
                c.append(tmp)
                tmp = []  # reset temporary var
            a = list(zip(r, c))  # merge our indexes
            for i in a:
                for j in i[1]:
                    if board[i[0]][j] == 1:
                        return False  # there is a block in this position
                    board[i[0]][j] = 1  # no block so we can continue
        except IndexError:

            return False  # index error triggered
        self._board = board  # replace our self var
        return True
