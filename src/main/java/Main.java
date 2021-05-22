import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.LiveSpeechRecognizer;
import edu.cmu.sphinx.api.SpeechResult;

import java.util.HashMap;
import java.util.Map;


public class Main {
    public static void main(String[] args) throws Exception {
        launchVoiceRecognitionUnsafe();
    }

    public static void launchVoiceRecognitionUnsafe() throws Exception {
        System.out.println("Start Sphinx Demo ...");

        Configuration configuration = new Configuration();
        configuration.setAcousticModelPath("src/main/resources/SphinxResources/ru");
        configuration.setDictionaryPath("src/main/resources/SphinxResources/ru.dic");
        configuration.setGrammarPath("src/main/resources/SphinxResources/grammars");
        configuration.setGrammarName("bibleAssistantGrammar");
        configuration.setUseGrammar(true);

        LiveSpeechRecognizer recognizer = new LiveSpeechRecognizer(configuration);
        recognizer.startRecognition(true);

        SpeechResult result;

        System.out.println("Start recognizing...");
        while ((result = recognizer.getResult()) != null) {
            String currentPhrase = result.getHypothesis();
            System.out.println(currentPhrase);
        }

        recognizer.stopRecognition();
    }

    public static String findVerse(String text) {
        Map<String, String> verses = new HashMap<String, String>();
        verses.put("евангелие от иоанна первая глава первый стих", "В начале было Слово, и Слово было у Бога, и Слово было Бог.");
        verses.put("евангелие от иоанна первая глава второй стих", "Оно было в начале у Бога.");
        verses.put("евангелие от иоанна первая глава третий стих", "Все чрез Него на́чало быть, и без Него ничто не на́чало быть, что на́чало быть.");
        verses.put("евангелие от иоанна первая глава четвёртый стих", "В Нем была жизнь, и жизнь была свет человеков.");

        return verses.getOrDefault(text, "стих не найден :(");
    }
}
