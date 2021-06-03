import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.LiveSpeechRecognizer;
import edu.cmu.sphinx.api.SpeechResult;

public class SpeechRecognition {
    public static void launchVoiceRecognition() throws Exception {
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
        String currentSpeech = "";
        int countOfAdditions = 0;

        while ((result = recognizer.getResult()) != null) {
            String currentPhrase = result.getHypothesis();
            System.out.println(currentPhrase);
            /*
            if (!currentSpeech.isEmpty()) {
                currentSpeech += " " + currentPhrase;
            } else {
                currentSpeech = currentPhrase;
            }
            countOfAdditions++;

            System.out.println(currentSpeech);

            if (currentPhrase.contains("<unk>")) {
                System.out.println("Стих не найден");
                currentSpeech = "";
                countOfAdditions = 0;
                continue;
            }

            String foundVerseLocation = BibleVerseLocationParser.getStdVerseLocation(currentSpeech);
            if (foundVerseLocation != null) {
                System.out.println(foundVerseLocation);
                String foundVerse = BibleParser.findBibleVerse(foundVerseLocation);
                if (foundVerse != null) {
                    System.out.println(foundVerse);
                    currentSpeech = "";
                    countOfAdditions = 0;
                } else {
                    System.out.println("Стих не найден");
                    currentSpeech = "";
                    countOfAdditions = 0;
                }
            } else {
                if (currentSpeech.contains("стих") || countOfAdditions == 3) {
                    System.out.println("Стих не найден");
                    currentSpeech = "";
                    countOfAdditions = 0;
                }
            }
            */
        }

        recognizer.stopRecognition();
    }
}
