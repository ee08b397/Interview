#!/usr/interval:bin/python
# -*- coding: utf-8 -*-

# http://www.1point3acres.com/bbs/thread-127776-1-1.html
# // 给一个n * n的二维数组，例如：

# 2 is wall
# 1 is police 
# 0 is kid
def dist(pos1, pos2):        
    return abs(pos1[0] - pos2[0])+ abs(pos1[1] - pos2[1])

def bfs(board, res, cur):
    curx = cur[0]
    cury = cur[1]
    for row in range(len(board)):
        for col in range(len(board[0])):
            if board[row][col] == 1:
                res[row][col] = 0
            if board[row][col] == 0:
                print cur, [row, col]
                res[row][col] = min(res[row][col], dist([row,col], cur))
            if board[row][col] == 2:
                res[row][col] = -1
def getres(board):
    m = len(board)
    n = len(board[0])
    que = []
    res = [[100 for i in range(n)]for j in range(m)]
    for row in range(m):
        for col in range(n):
            if board[row][col] == 1:
                  que.append([row, col])
    while que:
        cur = que.pop(0)
        bfs(board, res, cur)
        return res 

board = [
        [0, 1, 0],
        [0, 2, 0],
        [0, 1, 0]]

print getres(board)

