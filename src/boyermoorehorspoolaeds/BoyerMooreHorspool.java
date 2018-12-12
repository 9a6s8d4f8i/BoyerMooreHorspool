package boyermoorehorspoolaeds;

import java.util.HashMap;
import java.util.Map;

/**
 * Boyer-Moore-Horspool sub string search algorithm
 */
public class BoyerMooreHorspool {

    /* String to store the file contents */
    private String text = new String();

    /* String to store search pattern */
    private String pattern = new String();

    /* Length of the pattern */
    private int patternLength;

    private int textLenght;

    /* Constructor */
    public BoyerMooreHorspool(String text, String pattern) {
        this.text = text;
        this.pattern = pattern;
        this.patternLength = pattern.length();
        this.textLenght = text.length();
    }

    public int CompareBMH(Map<Character, Integer> maMap) {
          int i = patternLength, k = 0, j = 0;
        char[] pat = pattern.toCharArray();
        char[] texto = text.toCharArray();

int contadorDecasamento=0;

        while (i <= textLenght) {
   
            k = i;
            System.out.println("k = " + k);
            j = patternLength;
            System.out.println("\nj = " + j);
            while (j > 0 && texto[k - 1] == pat[j - 1]){
                
                k--;//k 12
                j--;//j 6
                
            }
            if (j == 0) {
                contadorDecasamento++;
                i += 1;
            } else {
                if ( maMap.get(texto[k - 1])==null) {
                    i += patternLength;
                } else {   
                    i += maMap.get(texto[k - 1]);
                }
            }
        }
        return contadorDecasamento;
    }

    /* get Text */
    public String getText() {
        return text;
    }

    /* set search pattern */
    public void setText(String text) {
        this.text = text;
    }

    /* set pattern */
    public void setPattern(String pattern) {
        this.pattern = pattern;
        this.patternLength = pattern.length();
    }

    /* get pattern */
    public String getPattern() {
        return pattern;
    }

    /**
     * Map to store jump ahead values
     */
    private Map<Character, Integer> moveAheadMap = new HashMap<>();

    /**
     * Calculates moveAheadMap
     */
    public void computeMoveAheadMap(Map<Character, Integer> maMap) {
        char[] pat = pattern.toCharArray();
        for (int i = 0; i < patternLength; i++) {
            if (i == patternLength - 1) {
                maMap.put(pat[i], patternLength);
            } else {
                maMap.put(pat[i], patternLength - i - 1);
            }
        }
    }

    /**
     * BMH algorithm
     */
    public void BMHStringSearch(String text, String pat) {
        setText(text);
        setPattern(pat);

    }
}
