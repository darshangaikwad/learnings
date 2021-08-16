package com.darshangaikwad.mylearning.game

import android.util.Log
import androidx.lifecycle.ViewModel

/**
 * Created by Darshan Gaikwad on 16,August,2021
 */
class GameViewModel : ViewModel() {

    private var _score = 0
    var score: Int = 0
        get() = score
    private var _currentWordCount = 0
    var currentWordCount: Int = 0
        get() = _currentWordCount
    private lateinit var _currentScrambledWord: String
    var currentScrambledWord: String = ""
        get() = _currentScrambledWord
    private var wordsList: MutableList<String> = mutableListOf()
    private lateinit var currentWord: String


    init {
        Log.d("GameFragment", "GameViewModel created!")
        getNextWord()
    }

    /*
    * Updates currentWord and currentScrambledWord with the next word.
    */
    private fun getNextWord() {
        currentWord = allWordsList.random()
        val tempWord = currentWord.toCharArray()
        tempWord.shuffle()

        while (tempWord.toString().equals(currentWord, false)) {
            tempWord.shuffle()
        }
        if (wordsList.contains(currentWord)) {
            getNextWord()
        } else {
            _currentScrambledWord = String(tempWord)
            ++currentWordCount
            wordsList.add(currentWord)
        }
    }

    /*
* Returns true if the current word count is less than MAX_NO_OF_WORDS.
* Updates the next word.
*/
    fun nextWord(): Boolean {
        return if (currentWordCount < MAX_NO_OF_WORDS) {
            getNextWord()
            true
        } else false
    }

    override fun onCleared() {
        super.onCleared()
        Log.d("GameFragment", "GameViewModel destroyed!")
    }
}