# Rock paper scissors
Rock paper scissors game programmed with Java while following the Introduction to Java course from the Jetbrains Academy on Hyperskill.

# Overview
The program works as described in the following step-by-step guide:

1. Fill in your name.
2. Enter all the options to choose from. Not given in any option will result in having the following default options: rock, paper, and scissors.
3. Choose one of the options to attack the opponent. Regardless of the chosen options, the program will identify which option beats which based on the following algorithm: An option will lose from the first half of the following options and will win against the remaining half (all options in a circle).
4. Enter !rating to get your total rating.
5. Enter !exit to close the program.

<pre>
Enter your name: > Tim
Hello, Tim
> rock,gun,lightning,devil,dragon,water,air,paper,sponge,wolf,tree,human,snake,scissors,fire
Okay, let's start
> rock
Sorry, but the computer chose air
> !rating
Your rating: 0
> rock
Well done. The computer chose sponge and failed
> !rating
Your rating: 100
> !exit
Bye!
</pre>

# Usage
Download the release and go in your terminal where you placed rock-paper-scissors.jar and run:

<pre>java -jar rock-paper-scissors.jar</pre>