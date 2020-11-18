package strings;

import java.util.Arrays;

/**
 * Class that contains three static and public methods for converting strings
 * into TitleCase, the three methods have the same function, but with different
 * approaches. The first and most basic, simply receives as parameters the
 * string to be converted and if necessary an array of exceptions to be ignored
 * in the conversion. The second, in addition to the string parameters to be
 * converted and exceptions, also has a boolean that activates the possibility
 * to respect the capitalization of exceptions. And finally, the third adds an
 * extra Boolean that allows the method to ignore words that are fully
 * capitalized when converting.
 * 
 * @author FaunoGuazina
 *
 **/
public final class TitleCase {

	// PUBLIC METHODS FOR USE ----------------------- PUBLIC METHODS FOR USE //

	/**
	 * Public static method that processes the string to be converted: eliminates
	 * any space characters that may be at the beginning and at the end, then
	 * removes any double spacing, then set false to ignore CAPITAL WORDS and
	 * exceptions with capitalization, after all proceed with the conversion into
	 * Title Case. This method calls the method of(toConvert, false, false,
	 * exceptions).
	 * 
	 * @param toConvert  : the string sentence that will be converted.
	 * @param exceptions : array of strings with all words that will be ignored when
	 *                   converting OR words strings separated by a comma : "word1",
	 *                   "word2", "word3"...
	 * @return The same string sentence converted to a Title Case.
	 */
	public static String of(String toConvert, String... exceptions) {

		return toTitleSentence(toConvert, false, false, exceptions);
	}

	/**
	 * Public static method that processes the string to be converted: eliminates
	 * any space characters that may be at the beginning and at the end, then
	 * removes any double spacing, if {@code caseSensitive} is true will first
	 * checks if there are exceptions, if so it configures that there are exceptions
	 * with sensitive case or variable capitalization, if negative transform
	 * exceptions in lower case, after all send everything to conversion. If the
	 * whole sentence is in upper case it will be fully converted to lower case by
	 * default.
	 * 
	 * @param toConvert     : the string sentence that will be converted.
	 * @param caseSensitive : boolean that configures if exceptions words will be
	 *                      ignored with case sensitive and keep their original
	 *                      forms, if false it will convert the exceptions string
	 *                      including capitalized words -> {@code False}:
	 *                      "exception1", "exception2", "exception3"...
	 *                      {@code True}: "EXCEPTION1", "eXcePtiOn2",
	 *                      "EXCEPtion3"...
	 * @param exceptions    : array of strings with all words that will be ignored
	 *                      when converting OR words strings separated by a comma :
	 *                      "word1", "word2", "word3"...
	 * @return the same string sentence converted to a Title Case.
	 */
	public static String of(String toConvert, boolean caseSensitive, String... exceptions) {

		return toTitleSentence(toConvert, caseSensitive, false, exceptions);
	}

	/**
	 * Public static method that processes the string to be converted: eliminates
	 * any space characters that may be at the beginning and at the end, then
	 * removes any double spacing. For each word of the string proceeds with the
	 * verification, if {@code caseSensitive} is true will first checks if there are
	 * exceptions, if so it configures that there are exceptions with sensitive case
	 * or variable capitalization, if false set exceptions lower case to variable
	 * capitalization, then if {@code capitalWord} is true will check if every word
	 * matches with a fully capitalized word, if so it does not convert into a Title
	 * Case, otherwise will convert the whole string including capitalized words,
	 * after all and send everything to conversion by {@code toTitleWord} method. If
	 * the whole sentence is in upper case it will be fully converted to lower case
	 * by default. This method calls the method of(toConvert, false, false,
	 * exceptions).
	 * 
	 * @param toConvert     : the string sentence that will be converted.
	 * @param caseSensitive : boolean that configures if exceptions words will be
	 *                      ignored with case sensitive and keep their original
	 *                      forms, if false it will convert the exceptions string
	 *                      including capitalized words -> {@code False}:
	 *                      "exception1", "exception2", "exception3"...
	 *                      {@code True}: "EXCEPTION1", "eXcePtiOn2",
	 *                      "EXCEPtion3"...
	 * @param capitalWord   : boolean that configures if CAPITAL WORDS will be
	 *                      ignored, if false it will convert the whole string
	 *                      including capitalized words, if true it will ignore
	 *                      capital.
	 * @param exceptions    : array of all words that will be ignored when
	 *                      converting OR words strings separated by a comma :
	 *                      "word1", "word2", "word3"...
	 * @return the same string sentence converted to a Title Case.
	 */
	public static String of(String toConvert, boolean capitalWord, boolean caseSensitive, String... exceptions) {

		return toTitleSentence(toConvert, capitalWord && !toConvert.matches(UPPER_SENTENCE), caseSensitive, exceptions);
	}

	// PRIVATE METHODS FOR INTERNAL USE ----------------------- PRIVATE METHODS FOR
	// INTERNAL USE //

	/**
	 * Private builder to prevent this utility class from being instantiated.
	 */
	private TitleCase() {
	}

	/**
	 * Private method that processes the string sentence to be converted: first
	 * eliminates any space characters that may be at the beginning and at the end,
	 * then removes any double spacing, then split the string from its spaces in an
	 * array of words. For each one of them proceeds with the verification, if
	 * {@code caseSensitive} is true will first checks if there are exceptions, if
	 * so it configures that there are exceptions with sensitive case or variable
	 * capitalization, if false set exceptions lower case to variable
	 * capitalization, then if {@code capitalWord} is true will check if every word
	 * matches with a fully capitalized word, if so it does not convert into a Title
	 * Case, otherwise will convert the whole string including capitalized words,
	 * after all and send everything to conversion by {@code toTitleWord} method. If
	 * the whole sentence is in upper case it will be fully converted to lower case
	 * by default.
	 * 
	 * @param toConvert     : the string sentence that will be converted.
	 * @param caseSensitive : boolean that configures if exceptions words will be
	 *                      ignored with case sensitive and keep their original
	 *                      forms, if false it will convert the exceptions string
	 *                      including capitalized words -> {@code False}:
	 *                      "exception1", "exception2", "exception3"...
	 *                      {@code True}: "EXCEPTION1", "eXcePtiOn2",
	 *                      "EXCEPtion3"...
	 * @param capitalWord   : boolean that configures if CAPITAL WORDS will be
	 *                      ignored, if false it will convert the whole string
	 *                      including capitalized words, if true it will ignore
	 *                      capital.
	 * @param exceptions    : array of all words that will be ignored when
	 *                      converting OR words strings separated by a comma :
	 *                      "word1", "word2", "word3"...
	 * @return the same string sentence converted to a Title Case.
	 */
	private static String toTitleSentence(String toConvert, boolean caseSensitive, boolean capitalWord,
			String... exceptions) {

		StringBuilder result = new StringBuilder();

		String exception = exceptions(caseSensitive, exceptions);

		Arrays.asList(((toConvert.matches(UPPER_SENTENCE)) ? toConvert.toLowerCase() : toConvert).trim()
				.replaceAll("( )+", " ").split(" ")).stream()
				.forEach(word -> result
						.append(((capitalWord && word.matches(CAPITAL_WORD) || exception.contains(word)) ? word
								: toTitleWord(word)) + " "));

		return (exception.isEmpty()) ? result.toString().trim()
				: String.valueOf(result.charAt(0)).toUpperCase() + result.toString().trim().substring(1);
	}

	/**
	 * Private method that really does the heavy lifting of this utility class, it
	 * checks if the word to be converted is in some of the conversion exceptions
	 * and if it doesn't analyze character by character to define its capitalization
	 * or not. to capitalize a character, the method checks the following
	 * possibilities: if it is the first letter of the word, if there was a space
	 * before or if there were any of these scores before:
	 * !"#$%&'()*+,-./:;<=>?@[\]^_`{|}~
	 * 
	 * @param word          : the string word itself that will be converted
	 * @param caseSensitive : boolean that configures the case of exceptions
	 * @param exceptions    : array of all words that will be ignored when
	 *                      converting
	 * @return a string word converted to a Title Case
	 */
	private static String toTitleWord(String word) {
		StringBuilder result = new StringBuilder();

		if (word.matches(JUST_LETTERS)) {

			result.append(String.valueOf(word.charAt(0)).toUpperCase() + word.substring(1).toLowerCase());

		} else {

			Arrays.asList(word.split("")).stream().forEach(c -> result.append(
					(result.length() == 0 || String.valueOf(result.charAt(result.length() - 1)).matches("\\p{Punct}"))
							? c.toUpperCase()
							: c.toLowerCase()));
		}

		return result.toString();
	}

	/**
	 * Method that configures exceptions, that is, the words that will be ignored
	 * when converting to {@code TitleCase}. This method has Varargs as a parameter
	 * and therefore the way of passing multiple words is in the form of strings
	 * separated by a comma or an array of strings.
	 * 
	 * @param caseSensitive : boolean that configures the case of exceptions, if
	 *                      false set the exceptions to toLowerCase, if true it will
	 *                      keep their original forms. {@code False}: "word1",
	 *                      "word2", "word3"... {@code True}: "WORD1", "wOrD2",
	 *                      "WorD3"...
	 * @param words         : Varargs whith de words to be ignored
	 * @return If set previously string with exceptions separated by space, is
	 *         equivalent to: "word1 word2 word3 ", otherwise an empty string "". It
	 *         also adds versions with these !,./\:;? grammatical points after each
	 *         word and versions in between ()[]{}.
	 */
	private static String exceptions(boolean caseSensitive, String... words) {

		StringBuilder result = new StringBuilder();

		String puncts = "!,./\\:;?";
		String wraps = "\"'`";

		Arrays.asList(words).parallelStream().forEach(word -> {
			result.append(word + " " + "(" + word + ") " + "[" + word + "] " + "{" + word + "} ");
			Arrays.asList(puncts.split("")).parallelStream().forEach(p -> result.append(word + p + " "));
			Arrays.asList(wraps.split("")).parallelStream().forEach(w -> result.append(w + word + w + " "));
		});

		return ((caseSensitive) ? result.toString() : result.toString().toLowerCase());
	}

	/*
	 * Sequence of string variables that make up the regex that checks if the input
	 * is all uppercase or if there are capital words to be ignored when conversion
	 * into Title Case, used in methods valueOf and {@code valueOfExceptCapitals}.
	 */
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
