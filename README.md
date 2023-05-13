# MazeSolving

Assignment
-----------

This assignment involves writing a program to solve a maze that is provided in a text file. You should use some version of a search algorithm to find this solution.
When your program is complete, it should do the following:
- Prompt the user to enter a file name. Open that file – if it doesn’t exist, print an error
and exit. Otherwise, read in the maze (see below) and print out the original maze.
- Solve the maze (using some sort of search algorithm), and print the solved maze. If you want to “animate” the solution to the maze, you can, but you only need to print
the fully solved maze.

You may assume that a maze file is a text file that has the following format:
- The first line contains two integers – first is the number of rows in the maze, and the
second is the number of columns. Let’s say there are N rows and M columns.
- Then, there are N rows of data. Each row consists of M characters, either a # (which represents a wall) or a space (which represents an open space). There is no space
between characters.

You can make a few assumptions about how the maze is constructed:
- The maze’s entrance will be on the left (in column 0). There will be only one entrance.
- The maze’s exit will be on the right side (in column M-1). There could be multiple
exits. It is permissible for your program to “know” the location of the exit(s) during its
search.
- There may or may not be a path through the maze; you should handle either case. If
there is no solution, print a message to that effect instead of printing the solved maze.
- You can only move up, down, left, or right in the maze; no diagonal moves are
possible.
- Once solved, the solution path should be represented with *.
