import kotlin.random.Random

/***************************************************************
 Mastermind.kt
 Authur: Jordan Curran
 Date: 02/11/2020
 Description: A recreation of the boardgame mastermind where
 a secret code is generated and the player must guess at it
 using coded hints. Classes and functions are used to represent
 different states of the game to move th player from start
 to finish.
*****************************************************************/

class Game(// Game class - All game variables are setup here and initialized
	var code: Array<Char> = arrayOf(' ', ' ', ' ', ' '),
	var guess: String = " ",
	var hint: Array<Int> = arrayOf(0, 0, 0, 0),
	var countdown: Int = 12,
	var result: Int = 9
)

class GameView() {// View class - all user feedback is setup here
	private fun printArr(items: Array<Int>){
		for (x in items){
			print(x)
		}
	}
	fun showCode(code: Array<Char>): String{
		var codeString: String = ""
		for (x in code){
			codeString += x
		}
		return codeString
	}
	fun printWelcome(){
		println("Welcome to Mastermind! A secret code has been generated.")
		println("Try and guess the color combinations and make use of the hints along the way.")
		println("Crack the code and prove you are a MASTERMIND!")
	}
	fun printHeader(){
		println("Code\t\tYour \t\tAttempts ")
		println("hint\t\tguess\t\tremaining")
	}
	fun getGame(game: Game){
		printArr(game.hint)
		print("\t\t")
		print(game.guess)
		print("\t\t")
		print(game.countdown)
		println()
	}
	fun printResult(game: Game){
		var message: String
		val code = showCode(game.code)
		when (game.result) {
			0 -> message = "Could not crack it this time. You lose! The code was $code"
			1 -> message = "Congratulations! You cracked the code, mastermind. You win! The code was $code"
			else -> message = ""
		}
		println(message)
	}
	fun promptBadGuess(){
		println("Please enter a 4 digit color code without spaces, using only the characters r, g, b, or y")
	}
	fun promptGoodGuess(){
		print("Guess the code: ")
	}
	fun promptReplay(){
		print("Would you like to play again? (Y/N): ")
	}
}

class GameController (val game: Game, val view: GameView) {//Controller class - all actions in the game are setup here
	private val inGame = game
	private val inView = view
	
	init {//Generates a random code and assigns it to the game code
		for (i in 0..3){
			val randomValue = Random.nextInt(0, 4)
			val codeOut: Char
			when (randomValue) {
				0 -> codeOut = 'r'
				1 -> codeOut = 'g'
				2 -> codeOut = 'b'
				3 -> codeOut = 'y'
				else -> {codeOut = 'x'}
			}
			inGame.code[i] = codeOut
		}
	}
	fun intro() {//retrieves the intro message
		inView.printWelcome()
	}
	fun end(): Boolean {//retrieves win/loss prompts and returns true if player wants to play again
		var yesNo: String?
		inView.printResult(inGame)
		inView.promptReplay()
		yesNo = readLine()
		if (yesNo == null){
			yesNo = "n"
		}
		return (yesNo.decapitalize()[0] == 'y')
	}
	fun updateView() {//retrieves game data to show the player hint, guess and tries remaining
		inView.printHeader()
		inView.getGame(inGame)
	}
	fun guess(okay: Boolean) {//takes in the player guess and error checks it
		var codeGuess: String?
		val codeCheck = "rgby"
		var check = true
		if(!okay){inView.promptBadGuess()}	
		inView.promptGoodGuess()
		codeGuess = readLine()
		if (codeGuess != null){
			codeGuess = codeGuess.decapitalize()
			if (codeGuess.length == 4){
				for (g in codeGuess){
					if (!(codeCheck.contains(g)))
						check = false
				}
				if(check) {
					inGame.guess = codeGuess
				} else if(codeGuess == "show") {
					println(inView.showCode(inGame.code))
					guess(true)
				}
				else {
					guess(false)
				}
			} else {
				guess(false)
			}
		} else{guess(false)}	
	}
	
	fun compareGuess() {//compares the player guess against the secret code
		for (i in 0..3){
			if (inGame.guess[i] == inGame.code[i]) {
				inGame.hint[i] = 2
			} else if(inGame.code.contains(inGame.guess[i])) {
				inGame.hint[i] = 1
			} else {
				inGame.hint[i] = 0
			}
		}
		inGame.hint.sortDescending()
		inGame.countdown--
	}
	
	fun win(): Boolean {//tests for win state (all hints add up to 8) and returns true if win
		var win = false
		var tot: Int = 0
		for (h in inGame.hint){
			tot += h
		}
		if (tot == 8){
			inGame.result = 1
			win = true
		}
		return (win)
	}
	
	fun lose(): Boolean {//tests for lose state (countdown = zero) and returns true if lose
		var lose = false
		if(inGame.countdown == 0){
			inGame.result = 0
			lose = true
		}
		return (lose)
	}
}

class Mastermind() {// Main class where we set up our variables and start the application actions
	fun start() {//start the game and setup fresh class objects
		val masterGame = Game()
		val masterView = GameView()
		val master: GameController = GameController(masterGame, masterView)
		master.intro()
		play(master)
	}
	fun play(master: GameController){//plays through the actions with the most current states of the class objects
		master.guess(true)
		master.compareGuess()
		master.updateView()
		if (master.win() or master.lose()){//if win or loss state is reached, the game ends
			if(master.end()){
				start()
			}
		}else {
			play(master)
		}

	}
	companion object {//Main Function setup in order to run with Kotlin
		@JvmStatic
		fun main(args: Array<String>) {
			val mastermind = Mastermind()
			mastermind.start()
		}
	}
}

fun main () {//Main function setup in order to run with Java
	val mastermind = Mastermind()
	mastermind.start()
}