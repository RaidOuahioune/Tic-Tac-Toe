# Tic-Tac-Toe AI

This repository contains the source code for a Tic-Tac-Toe AI that utilizes a heuristic evaluation function to make intelligent moves in the game. The heuristic used for the game is described by the following formula(**Assuming that the Agent Plays with X**):
$$\left\( E(S)=3S(X_2) + S(X_1)-3S(O_2)-S(O_1) \right\)$$

Where:
- S is an element of the search state.
- $(X_2)$ is the number of lines with 2 X's and a blank.
- $(X_1)$ is the number of lines with 1 X and 2 blanks.
- $(O_2)$ is the number of lines with 2 O's and a blank.
- $(O_1)$ is the number of lines with 1 O and 2 blanks.

The AI's goal is to maximize this evaluation function to make the best possible moves in the game.

## Heuristic Explanation

- $(X_2)$: This term represents the advantage of having two X's in a row with an empty cell, which is a strong position for the AI. Having more such lines increases the evaluation.

- $(X_2)$: This term represents the advantage of having one X in a line with two empty cells. While not as strong as \(X2\), it still contributes positively to the evaluation.

- $(O_2)$: Similarly, this term represents the advantage of having two O's in a row with an empty cell, which is a strong position for the opponent. The AI wants to minimize this value.

- $(O_1)$: This term represents the advantage of having one O in a line with two empty cells. The AI wants to minimize this value as well.

## Win Conditions

- If the evaluation results in a value of  $\propto$, it means that X has won the game.

- If the evaluation results in a value of - $\propto$, it means that O has won the game.
