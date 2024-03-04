
        import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

        public class Main {

            public static void main(String[] args) {
                Map<String, Integer> maratonZamanlari = new HashMap<>();
                maratonZamanlari.put("Kadir", 341);
                maratonZamanlari.put("Gökhan", 273);
                maratonZamanlari.put("Hakan", 278);
                maratonZamanlari.put("Suzan", 329);
                maratonZamanlari.put("Pınar", 445);
                maratonZamanlari.put("Mehmet", 402);
                maratonZamanlari.put("Ali", 388);
                maratonZamanlari.put("Emel", 270);
                maratonZamanlari.put("Fırat", 243);
                maratonZamanlari.put("James", 334);
                maratonZamanlari.put("Jale", 412);
                maratonZamanlari.put("Ersin", 393);
                maratonZamanlari.put("Deniz", 299);
                maratonZamanlari.put("Gözde", 343);
                maratonZamanlari.put("Anıl", 317);
                maratonZamanlari.put("Burak", 265);

                int enIyiIndex = enIyiKosucu(maratonZamanlari);
                int ikinciEnIyiIndex = ikinciEnIyiKosucu(maratonZamanlari, enIyiIndex);
                int ucuncuEnIyiIndex = ucuncuEnIyiKosucu(maratonZamanlari, enIyiIndex, ikinciEnIyiIndex);

                if (enIyiIndex != -1 && ikinciEnIyiIndex != -1 && ucuncuEnIyiIndex != -1) {
                    yazdirDereceleri(maratonZamanlari, enIyiIndex, ikinciEnIyiIndex, ucuncuEnIyiIndex);
                    siniflandir(maratonZamanlari);
                } else {
                    System.out.println("Hata: Derece bulma işlemi başarısız oldu.");
                }
            }

            public static int enIyiKosucu(Map<String, Integer> zamanlar) {
                return getIndexOfMinValue(zamanlar);
            }

            public static int ikinciEnIyiKosucu(Map<String, Integer> zamanlar, int enIyiIndex) {
                return getIndexOfMinValueExcluding(zamanlar, enIyiIndex);
            }

            public static int ucuncuEnIyiKosucu(Map<String, Integer> zamanlar, int enIyiIndex, int ikinciEnIyiIndex) {
                return getIndexOfMinValueExcluding(zamanlar, enIyiIndex, ikinciEnIyiIndex);
            }

            private static int getIndexOfMinValue(Map<String, Integer> map) {
                return map.entrySet().stream()
                        .min(Map.Entry.comparingByValue())
                        .map(entry -> Arrays.asList(map.keySet().toArray()).indexOf(entry.getKey()))
                        .orElse(-1);
            }

            private static int getIndexOfMinValueExcluding(Map<String, Integer> map, int... excludedIndices) {
                return map.entrySet().stream()
                        .filter(entry -> !contains(excludedIndices, getIndexByKey(map, entry.getKey())))
                        .min(Map.Entry.comparingByValue())
                        .map(entry -> getIndexByKey(map, entry.getKey()))
                        .orElse(-1);
            }

            private static boolean contains(int[] array, int value) {
                for (int element : array) {
                    if (element == value) {
                        return true;
                    }
                }
                return false;
            }

            private static int getIndexByKey(Map<String, Integer> map, String key) {
                return Arrays.asList(map.keySet().toArray()).indexOf(key);
            }

            public static void siniflandir(Map<String, Integer> zamanlar) {
                int aSinifi = (int) zamanlar.values().stream().filter(zaman -> zaman >= 200 && zaman <= 299).count();
                int bSinifi = (int) zamanlar.values().stream().filter(zaman -> zaman >= 300 && zaman <= 399).count();
                int cSinifi = (int) zamanlar.values().stream().filter(zaman -> zaman >= 400).count();

                System.out.println("A Sınıfı → " + aSinifi + " öğrenci.");
                System.out.println("B Sınıfı → " + bSinifi + " öğrenci.");
                System.out.println("C Sınıfı → " + cSinifi + " öğrenci.");
            }

            public static void yazdirDereceleri(Map<String, Integer> zamanlar, int enIyiIndex, int ikinciEnIyiIndex, int ucuncuEnIyiIndex) {
                String enIyiAd = getNameByIndex(zamanlar, enIyiIndex);
                String ikinciEnIyiAd = getNameByIndex(zamanlar, ikinciEnIyiIndex);
                String ucuncuEnIyiAd = getNameByIndex(zamanlar, ucuncuEnIyiIndex);

                System.out.println("En iyi koşucu: " + enIyiAd + ", zaman: " + zamanlar.get(enIyiAd) + " dakika.");
                System.out.println("Ikinci en iyi koşucu: " + ikinciEnIyiAd + ", zaman: " + zamanlar.get(ikinciEnIyiAd) + " dakika.");
                System.out.println("Ucuncu en iyi koşucu: " + ucuncuEnIyiAd + ", zaman: " + zamanlar.get(ucuncuEnIyiAd) + " dakika.");
            }

            private static String getNameByIndex(Map<String, Integer> map, int index) {
                return (String) map.keySet().toArray()[index];
}
        }


