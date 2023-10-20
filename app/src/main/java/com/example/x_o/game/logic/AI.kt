package com.example.x_o.game.logic


class AI(private val aiPlayer:Char) {

    private  var opponent:Char
    init {
        opponent=opponent()
    }
    private fun evaluate(board: List<Char>): Int {
        if (hasLetterWon(board, aiPlayer)) {
            return Int.MAX_VALUE
        }
        if (hasLetterWon(board, opponent)) {
            return -Int.MAX_VALUE
        }

        val playerTwoLinesCount = countLinesWithTwoLetters(board, aiPlayer)
        val playerOneLineCount = countLinesWithOneLetter(board, aiPlayer)
        val oppTwoLinesCount = countLinesWithTwoLetters(board, opponent)
        val oppOneLineCount = countLinesWithOneLetter(board, opponent)

        return 3 * playerTwoLinesCount + playerOneLineCount - (3 * oppTwoLinesCount + oppOneLineCount)
    }

    fun findBestMove(currentState:List<Char>): Int {
        val emptyCells = currentState.indices.filter { currentState[it] == ' ' }
        val evaluationMap = mutableMapOf<Int, Int>()
        for (emptyCell in emptyCells) {
            val nextState = currentState.toMutableList()
            nextState[emptyCell] = aiPlayer
            val evaluation = evaluate(nextState)
            evaluationMap[emptyCell] = evaluation
        }
        return  evaluationMap.maxBy { it.value }.key
    }
    private fun countLinesWithTwoLetters(board: List<Char>, value: Char): Int {
        // Count the number of lines with 2 X's and a blank
        return GameRules.winningLines.count { line ->
            val (a, b, c) = line
            (board[a] == value && board[b] == value && board[c] == ' ') ||
                    (board[a] == value && board[b] == ' ' && board[c] == value) ||
                    (board[a] == ' ' && board[b] == value && board[c] == value)
        }
    }

    private fun countLinesWithOneLetter(board: List<Char>, value: Char): Int {
        // Count the number of lines with 1 X and 2 blanks
        return GameRules.winningLines.count { line ->
            val (a, b, c) = line
            (board[a] == value && board[b] == ' ' && board[c] == ' ') ||
                    (board[a] == ' ' && board[b] == value && board[c] == ' ') ||
                    (board[a] == ' ' && board[b] == ' ' && board[c] == value)
        }
    }

    private fun hasLetterWon(board: List<Char>, value: Char): Boolean {
        // Check if X has won
        for (line in GameRules.winningLines) {
            val (a, b, c) = line
            if (board[a] == value && board[b] == value && board[c] == value) {
                return true
            }
        }
        return false
    }


    private fun opponent():Char{
        return if (aiPlayer=='X') '0' else 'X'
    }
}

