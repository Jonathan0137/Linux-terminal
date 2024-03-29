package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import command.Get;
import fileSystem.File;
import fileSystem.FileSystem;
import fileSystem.FileSystemManipulation;
import output.Output;

public class GetTest {

	Get instance = new Get();
	
	@Test
	public void testExecuteInvalidURL() {
		String commandCall = "get fakeURL";
		ArrayList<Object> params = new ArrayList<Object>();
		params.add(commandCall);
		instance.execute(params);
		String actual =  Output.getOutputInstance().getOutputList().get(0).getOutput();
		String expected = "Error: Get: invalid URL";
		assertEquals(expected, actual);
	}
	
	@Test
	public void testExecuteValidURLNewFile() {
		String commandCall = "get https://www.w3.org/TR/PNG/iso_8859-1.txt";
		String contents = "The following are the graphical (non-control) characters defined by\n" + 
				"ISO 8859-1 (1987).  Descriptions in words aren't all that helpful,\n" + 
				"but they're the best we can do in text.  A graphics file illustrating\n" + 
				"the character set should be available from the same archive as this\n" + 
				"file.\n" + 
				"\n" + 
				"Hex Description                 Hex Description\n" + 
				"\n" + 
				"20  SPACE\n" + 
				"21  EXCLAMATION MARK            A1  INVERTED EXCLAMATION MARK\n" + 
				"22  QUOTATION MARK              A2  CENT SIGN\n" + 
				"23  NUMBER SIGN                 A3  POUND SIGN\n" + 
				"24  DOLLAR SIGN                 A4  CURRENCY SIGN\n" + 
				"25  PERCENT SIGN                A5  YEN SIGN\n" + 
				"26  AMPERSAND                   A6  BROKEN BAR\n" + 
				"27  APOSTROPHE                  A7  SECTION SIGN\n" + 
				"28  LEFT PARENTHESIS            A8  DIAERESIS\n" + 
				"29  RIGHT PARENTHESIS           A9  COPYRIGHT SIGN\n" + 
				"2A  ASTERISK                    AA  FEMININE ORDINAL INDICATOR\n" + 
				"2B  PLUS SIGN                   AB  LEFT-POINTING DOUBLE ANGLE QUOTATION MARK\n" + 
				"2C  COMMA                       AC  NOT SIGN\n" + 
				"2D  HYPHEN-MINUS                AD  SOFT HYPHEN\n" + 
				"2E  FULL STOP                   AE  REGISTERED SIGN\n" + 
				"2F  SOLIDUS                     AF  OVERLINE\n" + 
				"30  DIGIT ZERO                  B0  DEGREE SIGN\n" + 
				"31  DIGIT ONE                   B1  PLUS-MINUS SIGN\n" + 
				"32  DIGIT TWO                   B2  SUPERSCRIPT TWO\n" + 
				"33  DIGIT THREE                 B3  SUPERSCRIPT THREE\n" + 
				"34  DIGIT FOUR                  B4  ACUTE ACCENT\n" + 
				"35  DIGIT FIVE                  B5  MICRO SIGN\n" + 
				"36  DIGIT SIX                   B6  PILCROW SIGN\n" + 
				"37  DIGIT SEVEN                 B7  MIDDLE DOT\n" + 
				"38  DIGIT EIGHT                 B8  CEDILLA\n" + 
				"39  DIGIT NINE                  B9  SUPERSCRIPT ONE\n" + 
				"3A  COLON                       BA  MASCULINE ORDINAL INDICATOR\n" + 
				"3B  SEMICOLON                   BB  RIGHT-POINTING DOUBLE ANGLE QUOTATION MARK\n" + 
				"3C  LESS-THAN SIGN              BC  VULGAR FRACTION ONE QUARTER\n" + 
				"3D  EQUALS SIGN                 BD  VULGAR FRACTION ONE HALF\n" + 
				"3E  GREATER-THAN SIGN           BE  VULGAR FRACTION THREE QUARTERS\n" + 
				"3F  QUESTION MARK               BF  INVERTED QUESTION MARK\n" + 
				"40  COMMERCIAL AT               C0  CAPITAL LETTER A WITH GRAVE\n" + 
				"41  CAPITAL LETTER A            C1  CAPITAL LETTER A WITH ACUTE\n" + 
				"42  CAPITAL LETTER B            C2  CAPITAL LETTER A WITH CIRCUMFLEX\n" + 
				"43  CAPITAL LETTER C            C3  CAPITAL LETTER A WITH TILDE\n" + 
				"44  CAPITAL LETTER D            C4  CAPITAL LETTER A WITH DIAERESIS\n" + 
				"45  CAPITAL LETTER E            C5  CAPITAL LETTER A WITH RING ABOVE\n" + 
				"46  CAPITAL LETTER F            C6  CAPITAL LETTER AE\n" + 
				"47  CAPITAL LETTER G            C7  CAPITAL LETTER C WITH CEDILLA\n" + 
				"48  CAPITAL LETTER H            C8  CAPITAL LETTER E WITH GRAVE\n" + 
				"49  CAPITAL LETTER I            C9  CAPITAL LETTER E WITH ACUTE\n" + 
				"4A  CAPITAL LETTER J            CA  CAPITAL LETTER E WITH CIRCUMFLEX\n" + 
				"4B  CAPITAL LETTER K            CB  CAPITAL LETTER E WITH DIAERESIS\n" + 
				"4C  CAPITAL LETTER L            CC  CAPITAL LETTER I WITH GRAVE\n" + 
				"4D  CAPITAL LETTER M            CD  CAPITAL LETTER I WITH ACUTE\n" + 
				"4E  CAPITAL LETTER N            CE  CAPITAL LETTER I WITH CIRCUMFLEX\n" + 
				"4F  CAPITAL LETTER O            CF  CAPITAL LETTER I WITH DIAERESIS\n" + 
				"50  CAPITAL LETTER P            D0  CAPITAL LETTER ETH (Icelandic)\n" + 
				"51  CAPITAL LETTER Q            D1  CAPITAL LETTER N WITH TILDE\n" + 
				"52  CAPITAL LETTER R            D2  CAPITAL LETTER O WITH GRAVE\n" + 
				"53  CAPITAL LETTER S            D3  CAPITAL LETTER O WITH ACUTE\n" + 
				"54  CAPITAL LETTER T            D4  CAPITAL LETTER O WITH CIRCUMFLEX\n" + 
				"55  CAPITAL LETTER U            D5  CAPITAL LETTER O WITH TILDE\n" + 
				"56  CAPITAL LETTER V            D6  CAPITAL LETTER O WITH DIAERESIS\n" + 
				"57  CAPITAL LETTER W            D7  MULTIPLICATION SIGN\n" + 
				"58  CAPITAL LETTER X            D8  CAPITAL LETTER O WITH STROKE\n" + 
				"59  CAPITAL LETTER Y            D9  CAPITAL LETTER U WITH GRAVE\n" + 
				"5A  CAPITAL LETTER Z            DA  CAPITAL LETTER U WITH ACUTE\n" + 
				"5B  LEFT SQUARE BRACKET         DB  CAPITAL LETTER U WITH CIRCUMFLEX\n" + 
				"5C  REVERSE SOLIDUS             DC  CAPITAL LETTER U WITH DIAERESIS\n" + 
				"5D  RIGHT SQUARE BRACKET        DD  CAPITAL LETTER Y WITH ACUTE\n" + 
				"5E  CIRCUMFLEX ACCENT           DE  CAPITAL LETTER THORN (Icelandic)\n" + 
				"5F  LOW LINE                    DF  SMALL LETTER SHARP S (German)\n" + 
				"60  GRAVE ACCENT                E0  SMALL LETTER A WITH GRAVE\n" + 
				"61  SMALL LETTER A              E1  SMALL LETTER A WITH ACUTE\n" + 
				"62  SMALL LETTER B              E2  SMALL LETTER A WITH CIRCUMFLEX\n" + 
				"63  SMALL LETTER C              E3  SMALL LETTER A WITH TILDE\n" + 
				"64  SMALL LETTER D              E4  SMALL LETTER A WITH DIAERESIS\n" + 
				"65  SMALL LETTER E              E5  SMALL LETTER A WITH RING ABOVE\n" + 
				"66  SMALL LETTER F              E6  SMALL LETTER AE\n" + 
				"67  SMALL LETTER G              E7  SMALL LETTER C WITH CEDILLA\n" + 
				"68  SMALL LETTER H              E8  SMALL LETTER E WITH GRAVE\n" + 
				"69  SMALL LETTER I              E9  SMALL LETTER E WITH ACUTE\n" + 
				"6A  SMALL LETTER J              EA  SMALL LETTER E WITH CIRCUMFLEX\n" + 
				"6B  SMALL LETTER K              EB  SMALL LETTER E WITH DIAERESIS\n" + 
				"6C  SMALL LETTER L              EC  SMALL LETTER I WITH GRAVE\n" + 
				"6D  SMALL LETTER M              ED  SMALL LETTER I WITH ACUTE\n" + 
				"6E  SMALL LETTER N              EE  SMALL LETTER I WITH CIRCUMFLEX\n" + 
				"6F  SMALL LETTER O              EF  SMALL LETTER I WITH DIAERESIS\n" + 
				"70  SMALL LETTER P              F0  SMALL LETTER ETH (Icelandic)\n" + 
				"71  SMALL LETTER Q              F1  SMALL LETTER N WITH TILDE\n" + 
				"72  SMALL LETTER R              F2  SMALL LETTER O WITH GRAVE\n" + 
				"73  SMALL LETTER S              F3  SMALL LETTER O WITH ACUTE\n" + 
				"74  SMALL LETTER T              F4  SMALL LETTER O WITH CIRCUMFLEX\n" + 
				"75  SMALL LETTER U              F5  SMALL LETTER O WITH TILDE\n" + 
				"76  SMALL LETTER V              F6  SMALL LETTER O WITH DIAERESIS\n" + 
				"77  SMALL LETTER W              F7  DIVISION SIGN\n" + 
				"78  SMALL LETTER X              F8  SMALL LETTER O WITH STROKE\n" + 
				"79  SMALL LETTER Y              F9  SMALL LETTER U WITH GRAVE\n" + 
				"7A  SMALL LETTER Z              FA  SMALL LETTER U WITH ACUTE\n" + 
				"7B  LEFT CURLY BRACKET          FB  SMALL LETTER U WITH CIRCUMFLEX\n" + 
				"7C  VERTICAL LINE               FC  SMALL LETTER U WITH DIAERESIS\n" + 
				"7D  RIGHT CURLY BRACKET         FD  SMALL LETTER Y WITH ACUTE\n" + 
				"7E  TILDE                       FE  SMALL LETTER THORN (Icelandic)\n" + 
				"                                FF  SMALL LETTER Y WITH DIAERESIS";
		ArrayList<Object> params = new ArrayList<Object>();
		params.add(commandCall);
		instance.execute(params);
		String expected =  contents;
		String actual = ((File) FileSystemManipulation.findSubNode(FileSystem.getFileSystem()
				.getCurrentDirectory(), "iso_8859-1")).getContents(); 
		assertEquals(expected, actual);
	}

	@Test
	public void testExecuteValidURLOldFile() {
		String commandCall = "get https://www.w3.org/TR/PNG/iso_8859-1.txt";
		String contents = "The following are the graphical (non-control) characters defined by\n" + 
				"ISO 8859-1 (1987).  Descriptions in words aren't all that helpful,\n" + 
				"but they're the best we can do in text.  A graphics file illustrating\n" + 
				"the character set should be available from the same archive as this\n" + 
				"file.\n" + 
				"\n" + 
				"Hex Description                 Hex Description\n" + 
				"\n" + 
				"20  SPACE\n" + 
				"21  EXCLAMATION MARK            A1  INVERTED EXCLAMATION MARK\n" + 
				"22  QUOTATION MARK              A2  CENT SIGN\n" + 
				"23  NUMBER SIGN                 A3  POUND SIGN\n" + 
				"24  DOLLAR SIGN                 A4  CURRENCY SIGN\n" + 
				"25  PERCENT SIGN                A5  YEN SIGN\n" + 
				"26  AMPERSAND                   A6  BROKEN BAR\n" + 
				"27  APOSTROPHE                  A7  SECTION SIGN\n" + 
				"28  LEFT PARENTHESIS            A8  DIAERESIS\n" + 
				"29  RIGHT PARENTHESIS           A9  COPYRIGHT SIGN\n" + 
				"2A  ASTERISK                    AA  FEMININE ORDINAL INDICATOR\n" + 
				"2B  PLUS SIGN                   AB  LEFT-POINTING DOUBLE ANGLE QUOTATION MARK\n" + 
				"2C  COMMA                       AC  NOT SIGN\n" + 
				"2D  HYPHEN-MINUS                AD  SOFT HYPHEN\n" + 
				"2E  FULL STOP                   AE  REGISTERED SIGN\n" + 
				"2F  SOLIDUS                     AF  OVERLINE\n" + 
				"30  DIGIT ZERO                  B0  DEGREE SIGN\n" + 
				"31  DIGIT ONE                   B1  PLUS-MINUS SIGN\n" + 
				"32  DIGIT TWO                   B2  SUPERSCRIPT TWO\n" + 
				"33  DIGIT THREE                 B3  SUPERSCRIPT THREE\n" + 
				"34  DIGIT FOUR                  B4  ACUTE ACCENT\n" + 
				"35  DIGIT FIVE                  B5  MICRO SIGN\n" + 
				"36  DIGIT SIX                   B6  PILCROW SIGN\n" + 
				"37  DIGIT SEVEN                 B7  MIDDLE DOT\n" + 
				"38  DIGIT EIGHT                 B8  CEDILLA\n" + 
				"39  DIGIT NINE                  B9  SUPERSCRIPT ONE\n" + 
				"3A  COLON                       BA  MASCULINE ORDINAL INDICATOR\n" + 
				"3B  SEMICOLON                   BB  RIGHT-POINTING DOUBLE ANGLE QUOTATION MARK\n" + 
				"3C  LESS-THAN SIGN              BC  VULGAR FRACTION ONE QUARTER\n" + 
				"3D  EQUALS SIGN                 BD  VULGAR FRACTION ONE HALF\n" + 
				"3E  GREATER-THAN SIGN           BE  VULGAR FRACTION THREE QUARTERS\n" + 
				"3F  QUESTION MARK               BF  INVERTED QUESTION MARK\n" + 
				"40  COMMERCIAL AT               C0  CAPITAL LETTER A WITH GRAVE\n" + 
				"41  CAPITAL LETTER A            C1  CAPITAL LETTER A WITH ACUTE\n" + 
				"42  CAPITAL LETTER B            C2  CAPITAL LETTER A WITH CIRCUMFLEX\n" + 
				"43  CAPITAL LETTER C            C3  CAPITAL LETTER A WITH TILDE\n" + 
				"44  CAPITAL LETTER D            C4  CAPITAL LETTER A WITH DIAERESIS\n" + 
				"45  CAPITAL LETTER E            C5  CAPITAL LETTER A WITH RING ABOVE\n" + 
				"46  CAPITAL LETTER F            C6  CAPITAL LETTER AE\n" + 
				"47  CAPITAL LETTER G            C7  CAPITAL LETTER C WITH CEDILLA\n" + 
				"48  CAPITAL LETTER H            C8  CAPITAL LETTER E WITH GRAVE\n" + 
				"49  CAPITAL LETTER I            C9  CAPITAL LETTER E WITH ACUTE\n" + 
				"4A  CAPITAL LETTER J            CA  CAPITAL LETTER E WITH CIRCUMFLEX\n" + 
				"4B  CAPITAL LETTER K            CB  CAPITAL LETTER E WITH DIAERESIS\n" + 
				"4C  CAPITAL LETTER L            CC  CAPITAL LETTER I WITH GRAVE\n" + 
				"4D  CAPITAL LETTER M            CD  CAPITAL LETTER I WITH ACUTE\n" + 
				"4E  CAPITAL LETTER N            CE  CAPITAL LETTER I WITH CIRCUMFLEX\n" + 
				"4F  CAPITAL LETTER O            CF  CAPITAL LETTER I WITH DIAERESIS\n" + 
				"50  CAPITAL LETTER P            D0  CAPITAL LETTER ETH (Icelandic)\n" + 
				"51  CAPITAL LETTER Q            D1  CAPITAL LETTER N WITH TILDE\n" + 
				"52  CAPITAL LETTER R            D2  CAPITAL LETTER O WITH GRAVE\n" + 
				"53  CAPITAL LETTER S            D3  CAPITAL LETTER O WITH ACUTE\n" + 
				"54  CAPITAL LETTER T            D4  CAPITAL LETTER O WITH CIRCUMFLEX\n" + 
				"55  CAPITAL LETTER U            D5  CAPITAL LETTER O WITH TILDE\n" + 
				"56  CAPITAL LETTER V            D6  CAPITAL LETTER O WITH DIAERESIS\n" + 
				"57  CAPITAL LETTER W            D7  MULTIPLICATION SIGN\n" + 
				"58  CAPITAL LETTER X            D8  CAPITAL LETTER O WITH STROKE\n" + 
				"59  CAPITAL LETTER Y            D9  CAPITAL LETTER U WITH GRAVE\n" + 
				"5A  CAPITAL LETTER Z            DA  CAPITAL LETTER U WITH ACUTE\n" + 
				"5B  LEFT SQUARE BRACKET         DB  CAPITAL LETTER U WITH CIRCUMFLEX\n" + 
				"5C  REVERSE SOLIDUS             DC  CAPITAL LETTER U WITH DIAERESIS\n" + 
				"5D  RIGHT SQUARE BRACKET        DD  CAPITAL LETTER Y WITH ACUTE\n" + 
				"5E  CIRCUMFLEX ACCENT           DE  CAPITAL LETTER THORN (Icelandic)\n" + 
				"5F  LOW LINE                    DF  SMALL LETTER SHARP S (German)\n" + 
				"60  GRAVE ACCENT                E0  SMALL LETTER A WITH GRAVE\n" + 
				"61  SMALL LETTER A              E1  SMALL LETTER A WITH ACUTE\n" + 
				"62  SMALL LETTER B              E2  SMALL LETTER A WITH CIRCUMFLEX\n" + 
				"63  SMALL LETTER C              E3  SMALL LETTER A WITH TILDE\n" + 
				"64  SMALL LETTER D              E4  SMALL LETTER A WITH DIAERESIS\n" + 
				"65  SMALL LETTER E              E5  SMALL LETTER A WITH RING ABOVE\n" + 
				"66  SMALL LETTER F              E6  SMALL LETTER AE\n" + 
				"67  SMALL LETTER G              E7  SMALL LETTER C WITH CEDILLA\n" + 
				"68  SMALL LETTER H              E8  SMALL LETTER E WITH GRAVE\n" + 
				"69  SMALL LETTER I              E9  SMALL LETTER E WITH ACUTE\n" + 
				"6A  SMALL LETTER J              EA  SMALL LETTER E WITH CIRCUMFLEX\n" + 
				"6B  SMALL LETTER K              EB  SMALL LETTER E WITH DIAERESIS\n" + 
				"6C  SMALL LETTER L              EC  SMALL LETTER I WITH GRAVE\n" + 
				"6D  SMALL LETTER M              ED  SMALL LETTER I WITH ACUTE\n" + 
				"6E  SMALL LETTER N              EE  SMALL LETTER I WITH CIRCUMFLEX\n" + 
				"6F  SMALL LETTER O              EF  SMALL LETTER I WITH DIAERESIS\n" + 
				"70  SMALL LETTER P              F0  SMALL LETTER ETH (Icelandic)\n" + 
				"71  SMALL LETTER Q              F1  SMALL LETTER N WITH TILDE\n" + 
				"72  SMALL LETTER R              F2  SMALL LETTER O WITH GRAVE\n" + 
				"73  SMALL LETTER S              F3  SMALL LETTER O WITH ACUTE\n" + 
				"74  SMALL LETTER T              F4  SMALL LETTER O WITH CIRCUMFLEX\n" + 
				"75  SMALL LETTER U              F5  SMALL LETTER O WITH TILDE\n" + 
				"76  SMALL LETTER V              F6  SMALL LETTER O WITH DIAERESIS\n" + 
				"77  SMALL LETTER W              F7  DIVISION SIGN\n" + 
				"78  SMALL LETTER X              F8  SMALL LETTER O WITH STROKE\n" + 
				"79  SMALL LETTER Y              F9  SMALL LETTER U WITH GRAVE\n" + 
				"7A  SMALL LETTER Z              FA  SMALL LETTER U WITH ACUTE\n" + 
				"7B  LEFT CURLY BRACKET          FB  SMALL LETTER U WITH CIRCUMFLEX\n" + 
				"7C  VERTICAL LINE               FC  SMALL LETTER U WITH DIAERESIS\n" + 
				"7D  RIGHT CURLY BRACKET         FD  SMALL LETTER Y WITH ACUTE\n" + 
				"7E  TILDE                       FE  SMALL LETTER THORN (Icelandic)\n" + 
				"                                FF  SMALL LETTER Y WITH DIAERESIS";
		ArrayList<Object> params = new ArrayList<Object>();
		params.add(commandCall);
		File oldFile = new File("iso_8859-1", "Some arbitrary String");
		FileSystemManipulation.addFileSystemNode(FileSystem.getFileSystem().getCurrentDirectory(), 
				oldFile);
		instance.execute(params);
		String expected =  contents;
		String actual = ((File) FileSystemManipulation.findSubNode(FileSystem.getFileSystem()
				.getCurrentDirectory(), "iso_8859-1")).getContents(); 
		assertEquals(expected, actual);
	}
}
