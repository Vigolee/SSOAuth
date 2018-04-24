#Part 1: Unit Testing and TDD
##Requirements
### Part A: Getting the right derivative
		Firstly, We need write our unit tests inside `UnitTestsEx.java` to test `derivative()`, which takes an algebraic term, calculates its derivative, and then returns that expression as a String. `derivative()` is in ExampleClass.java.
		Next, we should comment out the first `derivative()`, and then rename `derivative2()` into `derivative()`, and fix the bug.
### Part B: Testing the Word Cloud
		There are a set of methods in `WordCloud.java`, we should write well-documented unit tests for the WordCloud methods in the provided file called `WordCloudTester.java`.
##Programs
### ExampleClass.java
		`derivative()` is  to take an algebraic term, calculates its derivative, and then returns that expression as a String. We consider both general situation and constant.
### UnitTestsEx.java
		`testDerivative()` is the unit test, we test 4 cases, including: 4y^3, 5x^1, 2z^-1, 6.

### `WordCloudTester.java`
	There are six unit tests for six methods in `WordCloud.java`.
	'testGetWordsFromFile()' is the unit test of `getWordsFromFile()`, and we test whether reading the file succeeded and make sure the WordCloud’s ArrayList contains the correct WordPairs read. We write our own small file named `myTest.txt`.
	`testRemoveCommon()` is the unit test of `removeCommon()`, and we test the ArrayList has been properly filtered to now exclude common words. We write our own samll file named `myCommonWords.txt`.
	`testPrintWords()` is the unit test of `printWords()`. The test includes two cases, If `printToFile` is `false`, it should print the ArrayList of WordPair with their counts on the screen. If `printToFile` is true, it should output the ArrayList of WordPair with their counts to a file `myOutput.out`. And we also check for consistency between the wordList and the printed words.
	`testTopNWordsWithLength()` is the unit test of `topNWords(int n, int length)`, and we test the invaild inputs and correctness.
	`testTopNWordsBeginsWith` is the unit test of `topNWords(int n, char beginsWith)`, and we also test the invaild inputs, case insensitive, critical condition and correctness.
	`testFindWordCount()` is the unit test of `findWordCount()`, and we test the correctness.

##Conclusion
		I learned to write testers for my code, including insert print statements, check the print statements, test various outputs for some input, and use Exceptions. And unit test can help me to consider more comprehensive.

#Part 2: WordCloud Methods
##Requirements
###A. Getting words from the input file
		**void getWordsFromFile( String filename ) throws IOException**

		This method constructs an ArrayList containing WordPairs for each word in the file. WordPairs includes two field: `String word`, `int count`. Words which save in WordPair are case insensitive, and include punctuations. For example, “Apple” and “Apple!” should be counted as different words in the ArrayList. we use a Scanner object to read words from the file.

###B. Remove a given set of common words
		**void removeCommon(String omitFilename) throws IOException
**
		
		This method will read each word from the `myCommonWords.txt` file and remove that word from the ArrayList. Also, removing a word is case insensitive.

###C. Print words
		**public void printWords(ArrayList<WordPair>wordList, boolean printToFile) throws IOException**

		This method is called to print the words in the WordPair Arraylist. This method takes in an ArrayList of WordPairs and a boolean printToFile. If printToFile is false, it should print the ArrayList of WordPair with their counts on the screen. If printToFile is true, it should output the ArrayList of WordPair with their counts to a file myOutput.out. And the output file should be written into the current path. the formatting likes "is(2) a(1) test(3) file(1) parsing(1) system.(1) ...".
###D. Find n most frequent words
		**public ArrayList<WordPair> topNWords(int n, int length)**

		This method will find the top n occurring words whose lengths are at least ‘length’, as determined by their frequency in the arraylist and returns this list of words. In the event of a tie, use the first occurring word with that count.
		We use Comparator object and Collections to sort the Arraylist by words' count.

		**public ArrayList<WordPair> topNWords(int n, char beginsWith)**

		This method will find the top n occurring words which begin with the character ‘beginsWith’ [Comparison should be case insensitive], as determined by their frequency in the arraylist and returns this list of words as well as their counts as an ArrayList. In the event of a tie, use the first occurring word with that count.

###E. Finding the word count
		**int findWordCount(String word)**

		This method will take a string and search for it in the ArrayList. If the word is found, its count is returned. If the word isn’t found, then 0 is returned. The word is also case insensitive.
##Conclusion
		I learned how to read data from files and save them in ArrayList. I also learned how to sort the ArrayList by Comparator object and Collections. Lastly, I learned how to test my own methods.
