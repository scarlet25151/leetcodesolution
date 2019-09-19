import java.util.HashMap;
import java.util.Map;

public class maximumNumberOfBalloons5189 {
    public static int maxNumberOfBalloons(String text) {
        String balloonString = "balloon";
        Map<Character, Integer> characterCnt = new HashMap<>();
        int balloonCnt = 0;
        boolean isCompleted;
        for (char textChar : text.toCharArray()) {
            characterCnt.put(textChar, characterCnt.getOrDefault(textChar, 0) + 1);
            isCompleted = true;
            for (char balloonChar : balloonString.toCharArray()) {
                if (!characterCnt.containsKey(balloonChar) || characterCnt.get(balloonChar) <= 0) {
                    isCompleted = false;
                }
                if (balloonChar == 'o' && characterCnt.getOrDefault(balloonChar, 0) < 2)
                    isCompleted = false;
                if (balloonChar == 'l' && characterCnt.getOrDefault(balloonChar, 0) < 2) {
                    isCompleted = false;
                }
            }
            if (isCompleted) {
                for (char balloonChar : balloonString.toCharArray()) {
                    characterCnt.replace(balloonChar, characterCnt.get(balloonChar) - 1);
                }
                balloonCnt ++;
            }
        }
        return balloonCnt;
    }
    public static void main(String[] args) {
        String test = "balon";
        maxNumberOfBalloons(test);
    }
}
