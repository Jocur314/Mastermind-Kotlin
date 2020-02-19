Welcome to Mastermind!

(1) Setup and Running the Game
This section is a guide on installing requirements and running the game. If you have the requirements already installed, you can skip to section 1.3 - Running the game. The game has been tested on x64 OSes - Windows 10 version 1903, Mac OSX El Capitan, and Linux CentOS 7, so should be fit to run out of the box on at least any x64 system with the requirements installed. However, if needed, I have added a section 1.4 - Recompiling with instructions on compiling a new Mastermind.jar file

(1.1) Requirements
- Latest Version of Java development kit installed (you can find the installer from oracle by googling JDK8 download)
	-URL to latest versions as of writing- https://www.oracle.com/java/technologies/javase/javase-jdk8-downloads.html	
- Latest Version of Kotlin installed
	-URL to latest version as of writing- https://github.com/JetBrains/kotlin/releases/tag/v1.3.61
	
(1.2) Installation of Requirements:
Windows
	1. Grab the Windows x64 ".exe" installer for the latest version of JDK from here:
		https://www.oracle.com/java/technologies/javase/javase-jdk8-downloads.html
	2. Run the .exe file to install JDK
	3. Installing Kotlin is more manual. Download the kotlin compiler ".zip" file from here:
		https://github.com/JetBrains/kotlin/releases/tag/v1.3.61
	4. Extract the kotlinc folder to "C:\Program Files"
		-you can add "C:\Program Files\kotlinc\bin\" to your windows path to make kotlin compiler and kotlin script executer more easily accesssible, but it is not necessary
		
Mac OS
	1. Grab the ".dmg" installer for the latest MAC OS version of JDK from here:
		https://www.oracle.com/java/technologies/javase/javase-jdk8-downloads.html
	2. Run the .dmg file after download to install JDK
	3. To install kotlin, we need to install SDKMAN!
	4. Open a terminal and enter the following:
		curl -s https://get.sdkman.io | bash
	5. Now to install kotlin, open a new terminal after SDKMAN! installs and enter the following:
		sdk install kotlin

Linux OS (Tested in CentOS 7)
	1. Everything can be installed form the terminal. For java, open a terminal and enter the following:
		yum -y install java
	2. Installing kotlin requires SDKMAN! and SDKMAN! requires ZIP and UNZIP installed. To install ZIP and Unzip enter:
		yum -y install zip
		yum -y install unzip
	3. To install SDKMAN! enter:
		curl -s https://get.sdkman.io | bash
	4. To install kotlin, open a new terminal and enter:
		sdk install kotlin

(1.3) Running the Game:
Windows
	1. Extract Mastermind.jar from the Mastermind.zip folder to a location on your computer and remember the path to the file. Something like C:\users\<Your username>\Mastermind.jar is perfect
	2. Open Command Prompt (type cmd in the windows search bar and click the first result)
	3. Running with java enter:
		java -jar <path-to-Mastermind.jar>
	4. Running with kotlin enter:
		'C:\Program Files\kotlinc\bin\kotlin' <path-to-Mastermind.jar> 
			-if you added the bin folder to your path, you can simply enter:
				kotlin <path-to-Mastermind.jar>
		
Mac and Linux OSes
	1. Extract Mastermind.jar from the Mastermind.zip folder to a location on your computer. Somewhere such as ~/Mastermind.jar is perfect.
	2. Open a terminal and change directory to where you saved Mastermind.jar:
		cd <path-to-Mastermind.jar>
	3. Enter the following to run with java:
		java -jar Mastermind.jar
	4. Alternatively, enter the following to run with Kotlin
		kotlin Mastermind.jar
		
(1.4) Recompiling
- If the code needs to be recompiled to run, you will need to have kotlin installed as outlined above and then follow these steps:
- Go to your downloaded Mastermind.zip file and extract Mastermind.kt to a location and remember the file path (Something like C:\users\<Your username>\Mastermind.kt is perfect on windows or ~/Mastermind.kt works on Mac or Linux OSes)
Windows:
	1. Open command Prompt
	2. Enter the following:
		'C:\Program Files\kotlinc\bin\kotlinc' <path-to-Mastermind.kt> -include-runtime -d Mastermind.jar
	- This will create a Mastermind.Jar file in your current directory which is most likely your home directory, C:\Users\<Your Username>
	- If you want to specify the directory it saves to, you can change Mastermind.jar to "<path-to-some-folder>\Mastermind.jar"

Mac and Linux OSes (Unix based systems):
	1. Open a terminal
	2. Enter the following:
		kotlinc <path-to-Mastermind.kt> -include-runtime -d Mastermind.jar
	- Mastermind.jar will be saved to your home folder ~/Mastermind.jar
	
(3) What is Mastermind?
	Mastermind is a game where a secret code is generated using 4 colors and you have 12 tries to guess the colors while receiving coded hints along the way

(4) How To Play:
	- The game will start with the code being generated and you will be prompted to enter a guess. You will enter a guess by typing letters corrresponding to one of 4 colors into the terminal.
(4.1) Colors/letter choices-
	- r - Red
	- g - Green
	- b - Blue
	- y - Yellow
- The secret code will be any arrangement of the above letters and you must guess the code exactly in order
- Your entered guesses must be 4 characters long and each character must be one of the aforementioned characters corresponding to one of the 4 colors
	- examples - yyyy rgyb bbyy rrbb brgy gggg
(4.2) Hints
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
(4.3) Game Flow
	- After each guess, you will see something similar to the following - 
		- Code		Your 		Attempts 
		  hint		guess		remaining
		  2111		yyyy		11
		  Guess the code: 

		- As you can see, you get your hint, your guess and how many tries you have left before being prompted to guess again
		- Guess until the Attempts remianing reaches zero
		- Scroll back through the hints and guesses to piece together what you're missing in the secret code
(4.4) Winning
	- If you submit the right combination of letters in the right order, you win. Congrats! Now play again to see if you can get the code in less attempts.
(4.5) Losing
	- If you submit 12 guesses and the countdown reaches zero without guessing correctly, you lose the game. Worry not as you can play again with a new code
	- During a guess, you can type "quit" or "exit" to immediately drop the counter to zero and lose the game
