package month2.Day28;

import java.util.ArrayList;

public class Demo6 {
    public static void main(String[] args) {
        String s = "abcqweracb";
        char[] chars = s.toCharArray();
        ArrayList<Character> characters = new ArrayList<>();
        for (char c : chars) {
            characters.add(c);
        }
        // System.out.println(characters);
        ArrayList<Character> newCharacters = new ArrayList<>();
        for (Character character : characters) {
            if (!newCharacters.contains(character)) {
                newCharacters.add(character);
            }
        }
        // System.out.println(newCharacters);
        char[] newChars = new char[newCharacters.size()];
        int i = 0;
        for (Character newCharacter : newCharacters) {
            newChars[i++] = newCharacter;
        }
        String newS = new String(newChars);
        System.out.println("newS = " + newS);
    }
}
