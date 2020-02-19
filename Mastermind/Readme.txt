Welcome to Mastermind!

Running the game:
disclaimer- This code was compiled in a windows x64 environment using the kotlinc compiler and tested only on windows versions of Java and Kotlin. The following instructions will be for running the application in a similar setup
Requirements- 
	- Latest Version of Java Runtime Environment installed (you can find the installer from oracle by googling JRE8 download)
		-URL to latest version as of writing- https://www.oracle.com/technetwork/java/javase/downloads/jre8-downloads-2133155.html
		-Download and run the .exe file for windows x64 and that will install JRE8 to your programs folder and add it to your windows path
	- Alternatively, you can use the latest version of Kotlin, but installing the kotlin environment is more hands on
		-URL to latest version as of writing- https://github.com/JetBrains/kotlin/releases/tag/v1.3.61
		-Download the kotlin compiler .zip file and extract the kotlinc folder to a location such as "C:\Program Files"
		-If you want kotlin added to your windows path, you will want to add the "C:\Program Files\kotlinc\bin" folder to the path, but this is not necessary, just makes future runs more convenient
Running the application (jar file)-
	1. Save the Mastermind.zip folder and extract Mastermind.jar to a location on your computer and remember the path to the file. (Something like C:\users\<Your username>\Mastermind.jar is perfect)
	2. Open Command Prompt (type cmd in the windows search bar and click the first result)
	3. Splits off depeneding on what you wish to run the application with
	Running with java-
		- type in "java -jar <path-to-Mastermind.jar>"
	Running with kotlin-
		- type in "'C:\Program Files\kotlinc\bin\kotlin' <path-to-Mastermind.jar>" (if you added the bin folder to your path, you can simply type kotlin <path-to-Mastermind.jar>
Recompiling-
- If the code needs to be recompiled to run, you will need to have kotlin installed as outlined above and then follow these steps:
	1. Go to your downloaded Mastermind.zip file and extract Mastermind.kt to a location and remember the file path (Something like C:\users\<Your username>\Mastermind.kt is perfect)
	2. Open command Prompt
	3. type in "'C:\Program Files\kotlinc\bin\kotlinc' <path-to-Mastermind.kt> -include-runtime -d Mastermind.jar"
		- This will create a Mastermind.Jar file in your current directory which is most likely your home directory, C:\Users\<Your Username>
		- If you want to specify the directory it saves to, you can change Mastermind.jar to "<path-to-some-folder>\Mastermind.jar"




What is Mastermind?
	Mastermind is a game where a secret code is generated using 4 colors and you have 12 tries to guess the colors while receiving coded hints along the way
How To Play:
	- The game will start with the code being generated and you will be prompted to enter a guess. You will enter a guess by typing letters corrresponding to one of 4 colors into the terminal.
	- Colors/letter choices-
		- r - Red
		- g - Green
		- b - Blue
		- y - Yellow
	- The secret code will be any arrangement of the above letters and you must guess the code exactly in order
	- Your entered guesses must be 4 characters long and each character must be one of the aforementioned characters corresponding to one of the 4 colors
		- examples - yyyy rgyb bbyy rrbb brgy gggg
Hints:
	- When you submit a guess, the computer will give you a hint as to how close you are with a set of 4 numbers that will be returned next to your guess
	- Each number has a special meaning in regards to the characters you submitted and how they match up to the secret code
		- 2 = A perfect match. One letter matched up to a letter in the code and is in the correct position
		- 1 = A letter only match. One letter matched up to a letter in the code, but it is not in the correct position
		- 0 = Not a match
	- The numbers will be arranged in descending order, so pay no mind to their placement in relation to the characters you submitted
		- examples - Code is gbgy
			- you submit yyyg the hint will be - 1111 as all of the letters match a letter in the code, but there are no perfect matches
			- you submit brgy the hint will be - 2210 as there are two perfect matches with the g and the y and you have a b matching, but in the wrong place and the r doesn't match
			- you submit rrrr the hint will be - 0000 as there are no r's in the code
Game Flow:
	- After each guess, you will see something similar to the following - 
		- Code		Your 		Attempts 
		  hint		guess		remaining
		  2111		yyyy		11
		  Guess the code: 

		- As you can see, you get your hint, your guess and how many tries you have left before being prompted to guess again
		- Guess until the Attempts remianing reaches zero
		- Scroll back through the hints and guesses to piece together what you're missing in the secret code
Winning:
	- If you submit the right combination of letters in the right order, you win. Congrats! Now play again to see if you can get the code in less attempts.
Losing
	- If you submit 12 guesses and the countdown reaches zero without guessing correctly, you lose the game. Worry not as you can play again with a new code
