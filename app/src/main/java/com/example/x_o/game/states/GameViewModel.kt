import android.util.Log
import androidx.compose.runtime.MutableState

import androidx.lifecycle.ViewModel

import androidx.compose.runtime.mutableStateOf
import kotlin.random.Random


class TicTacToeViewModel(public val isSinglePlayer:Boolean=true) : ViewModel() {
    private val _board = mutableStateOf<List<Char>>(List(9) { ' ' })
    val board: MutableState<List<Char>> = _board
    private var currentPlayer = 'X'
    var winner=""
    var gameInProgress = true
    fun onCellClick(index: Int) {
        if (gameInProgress && _board.value!![index] == ' ') {
            _board.value = _board.value!!.toMutableList().apply {
                set(index, currentPlayer)
            }
            currentPlayer = if (currentPlayer == 'X') 'O' else 'X'
            checkGameStatus()
            if(gameInProgress && isSinglePlayer){
                aiMove()
            }
        }
    }

    fun aiMove(){
        var randomIndex = 0
        while(_board.value!![randomIndex] !=' '){
            randomIndex = Random.nextInt(0,8)
            Log.i("Here",randomIndex.toString())
        }
        _board.value = _board.value!!.toMutableList().apply {
            set(randomIndex ,currentPlayer);
        }
        currentPlayer = if (currentPlayer == 'X') 'O' else 'X'
        checkGameStatus()
    }
    private fun checkGameStatus() {
        val winningLines = listOf(
            listOf(0, 1, 2),
            listOf(3, 4, 5),
            listOf(6, 7, 8),
            listOf(0, 3, 6),
            listOf(1, 4, 7),
            listOf(2, 5, 8),
            listOf(0, 4, 8),
            listOf(2, 4, 6)
        )
        for (line in winningLines) {
            val (a, b, c) = line
            if (_board.value!![a] != ' ' && _board.value!![a] == _board.value!![b] && _board.value!![b] == _board.value!![c]) {
                gameInProgress = false
                if(_board.value!![a]=='X'){
                    winner="1"
                }else{
                    winner="2"
                }
                return
            }
        }
        if (_board.value!!.none { it == ' ' }) {
            gameInProgress = false
            winner=""
        }
    }
    fun resetGame() {
        _board.value = List(9) { ' ' }
        currentPlayer = 'X'
        gameInProgress = true
    }
}
