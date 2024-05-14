package StudentManagement;
public class ProgressBar {
        public static void Detail(int iteration, int total, String prefix, String suffix, int decimals, int length, char fill) {
            float percent = (float) (100 * (iteration / (float) total));
            int filledLength = (int) (length * iteration / total);
            StringBuilder bar = new StringBuilder();
            for (int i = 0; i < filledLength; i++) {
                bar.append(fill);
            }
            for (int i = filledLength; i < length; i++) {
                bar.append('-');
            }
            System.out.print("\r" + prefix + " |" + bar + "| " + String.format("%." + decimals + "f", percent) + "% " + suffix);
            if (iteration == total) {
                System.out.println();
            }
        }

        public static void main(String[] args) throws InterruptedException {
            int[] items = new int[50];
            for (int i = 0; i < items.length; i++) {
                items[i] = i;
            }
            int l = items.length;

            System.out.print("System Loading: ");
            Detail(0, l, "", "Complete", 1, l, '#');
            for (int i = 0; i < items.length; i++) {
                Thread.sleep(100);
                Detail(i + 1, l, "System Loading:", "Complete", 1, l, '#');
            }
        }
    }


