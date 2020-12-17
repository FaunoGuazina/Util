package strings;

import java.util.Arrays;

/**
 * Class that contains three static and public methods for converting strings
 * into Title Case, the three methods have the same function, but with different
 * approaches. The first and most basic, simply receives as parameters the
 * string to be converted. The second receives as parameters the string to be
 * converted and an array of exceptions to be ignored in the conversion. And
 * finally, the third method is the same as the second, except that it ignores
 * capitalized words, such as acronyms.
 * 
 * @author FaunoGuazina
 *
 **/
public final class TitleCase {

	// PUBLIC STATIC METHODS FOR USE ----------------------- PUBLIC STATIC METHODS FOR USE //

	/**
	 * Public static method that processes the string to be converted: eliminates
	 * any space characters that may be at the beginning and at the end, then
	 * removes any double spacing, after all proceed with the conversion into Title
	 * Case. If the whole sentence is in upper case it will be fully converted to
	 * lower case by default.
	 * 
	 * @param toConvert  : the string sentence that will be converted.
	 * @return The same string sentence converted to a Title Case.
	 */
	public static String all(String toConvert) {

		setExceptions();

		setCapitalWord(false);

		return toTitleSentence(toConvert);
	}

	/**
	 * Public static method that processes the string to be converted: eliminates
	 * any space characters that may be at the beginning and at the end, then
	 * removes any double spacing, if have any exceptions set to be ignored, after
	 * all send everything to conversion. If the whole sentence is in upper case it
	 * will be fully converted to lower case by default.
	 * 
	 * @param toConvert     : the string sentence that will be converted.
	 * @param exceptions    : array of strings with all words that will be ignored
	 *                      when converting OR words strings separated by a comma :
	 *                      "word1", "word2", "word3"...
	 * @return the same string sentence converted to a Title Case.
	 */
	public static String withExceptions(String toConvert, String... exceptions) {

		setExceptions(exceptions);

		setCapitalWord(false);

		return toTitleSentence(toConvert);
	}

	/**
	 * Public static method that processes the string to be converted: eliminates
	 * any space characters that may be at the beginning and at the end, then
	 * removes any double spacing, if have any exceptions set to be ignored, after
	 * all send everything to conversion. This method ignores any word that is fully
	 * capitalized, if the whole sentence is in upper case it will be fully
	 * converted to lower case by default.
	 * 
	 * @param toConvert  : the string sentence that will be converted.
	 * @param exceptions : array of all words that will be ignored when converting
	 *                   OR words strings separated by a comma : "word1", "word2",
	 *                   "word3"...
	 * @return the same string sentence converted to a Title Case.
	 */
	public static String withCAPITAL(String toConvert, String... exceptions) {

		setExceptions(exceptions);

		setCapitalWord(!toConvert.matches(UPPER_SENTENCE));

		return toTitleSentence(toConvert);
	}


	// PUBLIC INSTANCE METHODS FOR USE ----------------------- PUBLIC INSTANCE METHODS FOR USE //
	
	/**
	 * Constructor that allows you to create an instance of TitleCase class and thus
	 * configure the global exceptions that will be used in your methods. This
	 * method has Varargs as a parameter and therefore the way of passing multiple
	 * words is in the form of strings separated by a comma or an array of strings.
	 * 
	 * @param exceptions : array of all words that will be ignored when converting
	 *                   OR strings separated by a comma : "word1", "word2",
	 *                   "word3"...
	 */
	public TitleCase(String... exceptions) {
		setExceptions(exceptions);
	}

	/**
	 * Public instance method that processes the string to be converted: eliminates
	 * any space characters that may be at the beginning and at the end, then
	 * removes any double spacing, use instance global exceptions to set the words
	 * to be ignored, after all send everything to conversion. If the whole sentence
	 * is in upper case it will be fully converted to lower case by default.
	 * 
	 * @param toConvert  : the string sentence that will be converted.
	 * @return the same string sentence converted to a Title Case.
	 */
	public String titleCase(String toConvert) {

		setCapitalWord(false);

		return toTitleSentence(toConvert);
	}

	/**
	 * Public instance method that processes the string to be converted: eliminates
	 * any space characters that may be at the beginning and at the end, then
	 * removes any double spacing, use global instance exceptions to set the words
	 * to be ignored, after all send everything to conversion. This method ignores
	 * any word that is fully capitalized, if the whole sentence is in upper case it
	 * will be fully converted to lower case by default.
	 * 
	 * @param toConvert  : the string sentence that will be converted.
	 * @return the same string sentence converted to a Title Case.
	 */
	public String titleCAPITAL(String toConvert) {

		setCapitalWord(!toConvert.matches(UPPER_SENTENCE));

		return toTitleSentence(toConvert);
	}
	
	// PRIVATE METHODS FOR INTERNAL USE ----------------------- PRIVATE METHODS FOR INTERNAL USE //

	/**
	 * Private method that processes the string sentence to be converted: first
	 * eliminates any space characters that may be at the beginning and at the end,
	 * then removes any double spacing, then split the string from its spaces in an
	 * array of words. For each one of them proceeds with the verification of your
	 * specific case, then if {@code capitalWord} is true will check if every word
	 * matches with a fully capitalized word, if so it does not convert into a Title
	 * Case.
	 * 
	 * @param toConvert : the string sentence that will be converted.
	 * 
	 * @return the same string sentence converted to a Title Case.
	 */
	private static String toTitleSentence(String toConvert) {

		String[] arrayWords = Arrays.stream(arrayWordsOf(toConvert)).map(TitleCase::rateWords).toArray(String[]::new);

		if (!TitleCase.exceptions.isEmpty())
			arrayWords[0] = rateFirtWord(arrayWords[0]);

		return String.join(" ", arrayWords);
	}

	/**
	 * Private auxiliary method that prepares the string that will be converted into
	 * TitleCase. First check if the string is all uppercase, if so it converts it
	 * to all lowercase, if negative it keeps the same form. Then it eliminates
	 * spaces that may exist at the beginning and at the end (TRIM). Then replace
	 * any multiple space with single spaces. Then it transforms into an array by
	 * breaking the string by epsaces (SPLIT).
	 * 
	 * @param input
	 * @return array of strings
	 */
	private static String[] arrayWordsOf(String input) {
		input = (input.matches(UPPER_SENTENCE)) ? input.toLowerCase() : input;
		input = input.trim().replaceAll("( )+", " ");
		return input.split(" ");
	}
	
	/**
	 * Private auxiliary method that checks whether the word fits the exception rule or
	 * whether it should be converted to TitleCase, depending on the case invokes
	 * relevant auxiliary methods
	 * 
	 * @param word string each word in array
	 * @return string treated word (converted if is the case)
	 */
	private static String rateWords(String word) {
		return verifyIsExceptions(word) ? lowNonCapitalOrExceptions(word) : titleCaseBasic(word);
	}

	/**
	 * Private auxiliary method that checks whether the word is an exception or not.
	 * Compare the word with the list of exceptions ignoring the Case or if
	 * capitalWord is true check if the word is capitalized
	 * 
	 * @param word string each word in array
	 * @return boolean false if it doesn't match any type of exception or true if it
	 *         matches
	 */
	private static boolean verifyIsExceptions(String word) {
		boolean isException = Arrays.stream(exceptions.split(" ")).parallel().anyMatch(w -> w.equalsIgnoreCase(word));
		return capitalWord && word.matches(CAPITAL_WORD) || isException;
	}

	/**
	 * Private auxiliary method that checks if the word exists identically among the
	 * exceptions, if negative it returns all lower case.
	 * 
	 * @param word string each word in array
	 * @return returns the same string if it is an exception with Case variation or
	 *         returns all lower case if it is a word that needs to be ignored when
	 *         converting.
	 */
	private static String lowNonCapitalOrExceptions(String word) {
		boolean isException = Arrays.stream(exceptions.split(" ")).parallel().anyMatch(w -> w.equals(word));
		return capitalWord || isException ? word : word.toLowerCase();
	}
	
	/**
	 * Private auxiliary method that checks only the first word of the string, when
	 * there are exceptions it may be that the first word is in lowercase, so it
	 * proceeds with evaluation and if necessary conversion into TitleCase.
	 * 
	 * @param word
	 * @return string : if it is a capitalized word it returns identical, if it does
	 *         not convert into TitleCase
	 */
	private static String rateFirtWord(String word) {
		return capitalWord && word.matches(CAPITAL_WORD) ? word : titleCaseBasic(word);
	}

	/**
	 * Private method that really does the heavy lifting of this utility class, it
	 * checks if the word is made up of letters only or has special characters, for
	 * each case proceeds with the conversion in a different way.
	 * 
	 * @param word the string word itself that will be converted
	 * @return a string word converted to a Title Case
	 */
	private static String titleCaseBasic(String word) {
		return (word.matches(JUST_LETTERS)) ? titleJustLetters(word) : titleWithPuncts(word);
	}

	/**
	 * Private auxiliary method, if the word is only letters proceed with the
	 * simplest conversion using substring.
	 * 
	 * @param word the string word itself that will be converted
	 * @return a string word converted to a Title Case
	 */
	private static String titleJustLetters(String word) {
		return word.substring(0, 1).toUpperCase().concat(word.substring(1).toLowerCase());
	}

	/**
	 * Private auxiliary method, analyze character by character to define its capitalization or not. to
	 * capitalize a character, the method checks the following possibilities: if it
	 * 
	 * 
	 * @param word the string word itself that will be converted
	 * @return a string word converted to a Title Case
	 */
	private static String titleWithPuncts(String word) {
		StringBuilder builder = new StringBuilder();
		Arrays.stream(word.split("")).forEach(letter -> builder.append(lowOrUp(builder, letter)));
		return builder.toString();
	}
	
	/**
	 * Private auxiliary method, which evaluates whether the letter needs to be
	 * capitalized or not
	 * 
	 * @param builder instance being used to reconstruct the converted word
	 * @param letter  the character in question that is being analyzed
	 * @return the same character in upper or lower case
	 */
	private static String lowOrUp(StringBuilder builder, String letter) {
		return conditionToUpper(builder) ? letter.toUpperCase() : letter.toLowerCase();
	}

	/**
	 * Private auxiliary method, verify if is the first letter of the word, if there
	 * was a space before or if there were any of these chars before:
	 * !"#$%&'()*+,-./:;<=>?@[\]^_`{|}~
	 * 
	 * @param builder instance being used to reconstruct the converted word
	 * @return boolean true if it is the first letter of the word or if it has a
	 *         special char, false if not.
	 */
	private static boolean conditionToUpper(StringBuilder builder) {
		if (builder.length() == 0) return true;
		String lastCharOnBuilder = String.valueOf(builder.charAt(builder.length() - 1)); 
		return lastCharOnBuilder.matches("\\p{Punct}|\\s");
	}

	/**
	 * Method that configures exceptions, that is, the words that will be ignored
	 * when converting to TitleCase. This method has Varargs as a parameter
	 * and therefore the way of passing multiple words is in the form of strings
	 * separated by a comma or an array of strings.
	 * 
	 * @param words : Varargs whith de words to be ignored
	 * @return If set previously string with exceptions separated by space, is
	 *         equivalent to: "word1 word2 word3 ", otherwise an empty string "". It
	 *         also adds versions with these !,./\:;? grammatical points after each
	 *         word and versions in between ()[]{}.
	 */
	private static void setExceptions(String... words) {

		StringBuilder builder = new StringBuilder();

		String puncts = "!,./\\:;?";
		String wraps = "\"'`";

		Arrays.stream(words).forEach(word -> {
			builder.append(word + " (" + word + ") " + "[" + word + "] " + "{" + word + "} ");
			Arrays.stream(puncts.split("")).forEach(p -> builder.append(word + p + " "));
			Arrays.stream(wraps.split("")).forEach(w -> builder.append(w + word + w + " "));
		});

		TitleCase.exceptions = builder.toString();
	}

	/**
	 * method that configures whether the conversion will ignore capitalized words
	 * or convert them too
	 * 
	 * @param capitalWord boolean true to ignore words capitalized on conversion and
	 *                    false to convert them too
	 */
	private static void setCapitalWord(boolean capitalWord) {
		TitleCase.capitalWord = capitalWord;
	}
	
	//set of static variables used by this utility class

	private static String exceptions;

	private static boolean capitalWord;

	private static final String LOWER_LETTERS = "àáâãāăȧäảåǎȁȃąạḁầấẫẩằắẵẳǡǟǻậặⱥɐæǽǣɑ" + "ḃɓḅḇƃƅƀ" + "ćĉċčƈçḉȼ"
			+ "ḋɗḍḏḑḓďðđɖƌ" + "èéêẽēĕėëẻěȅȇẹȩęḙḛềếễểḕḗệḝǝɇɛ" + "ḟƒ" + "ǵĝḡğġǧɠģǥ" + "ĥḧȟḥḩḫħⱨƕ" + "ìíîĩīĭi̇ïỉǐịįȉȋḭɨḯ"
			+ "ĳĵɉ" + "ḱǩḵƙḳķⱪ" + "ĺḻḷļḽľŀłḹƚⱡɫ" + "ḿṁṃɱɯ" + "ǹńñṅňŋɲṇņṋṉƞ" + "òóôõōŏȯöỏőǒȍȏơǫọɵøồốỗổȱȫȭṍṑṓờớỡởợǭộǿɔœƣ"
			+ "ṕṗƥᵽ" + "ɋ" + "ŕṙřȑȓṛŗṟṝʀɍɽ" + "śŝṡšṣșşȿṥṧṩƨß" + "ṫťƭʈṭțţṱṯŧⱦ" + "ùúûũūŭüủůűǔȕȗưụṳųṷṵṹṻǜǘǖǚừứữửựʉṽ"
			+ "ṿʋʌ" + "ẁẃŵẇẅẉⱳ" + "ẋẍỳýŷỹȳẏÿỷƴỵɏ" + "źẑżžȥẓẕƶɀⱬ";

	private static final String UPPER_LETTERS = "ÀÁÂÃĀĂȦÄẢÅǍȀȂĄẠḀẦẤẪẨẰẮẴẲǠǞǺẬẶȺⱯÆǼǢⱭ" + "ḂƁḄḆƂƄɃ" + "ĆĈĊČƇÇḈȻ"
			+ "ḊƊḌḎḐḒĎÐĐƉƋ" + "ÈÉÊẼĒĔĖËẺĚȄȆẸȨĘḘḚỀẾỄỂḔḖỆḜƎɆƐ" + "ḞƑ" + "ǴĜḠĞĠǦƓĢǤ" + "ĤḦȞḤḨḪĦⱧǶ" + "ÌÍÎĨĪĬİÏỈǏỊĮȈȊḬƗḮ"
			+ "ĲĴɈ" + "ḰǨḴƘḲĶⱩ" + "ĹḺḶĻḼĽĿŁḸȽⱠⱢ" + "ḾṀṂⱮƜ" + "ǸŃÑṄŇŊƝṆŅṊṈȠ" + "ÒÓÔÕŌŎȮÖỎŐǑȌȎƠǪỌƟØỒỐỖỔȰȪȬṌṐṒỜỚỠỞỢǬỘǾ"
			+ "ƆŒƢṔṖƤⱣɊ" + "ŔṘŘȐȒṚŖṞṜƦɌⱤ" + "ŚŜṠŠṢȘŞⱾṤṦṨƧẞ" + "ṪŤƬƮṬȚŢṰṮŦȾ" + "ÙÚÛŨŪŬÜỦŮŰǓȔȖƯỤṲŲṶṴṸṺǛǗǕǙỪỨỮỬỰɄṼṾƲɅ"
			+ "ẀẂŴẆẄẈⱲẊẌ" + "ỲÝŶỸȲẎŸỶƳỴɎ" + "ŹẐŻŽȤẒẔƵⱿⱫ";

	private static final String JUST_LETTERS = "[A-Za-z" + UPPER_LETTERS + LOWER_LETTERS + "]+";

	private static final String CAPITAL_WORD = "\\p{Punct}*[A-Z0-9" + UPPER_LETTERS + "]+\\p{Punct}*[A-Z0-9"
			+ UPPER_LETTERS + "\\p{Punct}*]*";

	private static final String UPPER_SENTENCE = "^\\s*" + CAPITAL_WORD + "(\\s*" + CAPITAL_WORD + ")*\\s*$";

}
