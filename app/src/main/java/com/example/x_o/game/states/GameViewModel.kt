import android.util.Log
import androidx.compose.runtime.MutableState

import androidx.lifecycle.ViewModel

import androidx.compose.runtime.mutableStateOf
import com.example.x_o.game.logic.AI
import com.example.x_o.game.logic.GameRules
import com.example.x_o.game.network.HttpClient
import kotlin.random.Random


class TicTacToeViewModel(public val isSinglePlayer:Boolean=true) : ViewModel() {


    private var currentPlayer:Char
    private  var ai:AI
    init {
        //TODO:CHange this latter to be more dynamic
        currentPlayer='X'
        ai=AI('O')
    }
    private val _board = mutableStateOf<List<Char>>(List(9) { ' ' })
    val board: MutableState<List<Char>> = _board

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

        val aiIndexChoice=ai.findBestMove(_board.value)
        _board.value = _board.value!!.toMutableList().apply {
            set(aiIndexChoice ,currentPlayer);
        }
        currentPlayer = if (currentPlayer == 'X') 'O' else 'X'
        checkGameStatus()
    }
    private fun checkGameStatus() {

        for (line in GameRules.winningLines) {
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
