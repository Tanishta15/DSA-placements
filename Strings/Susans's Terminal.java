class SusanTerminal {
    public static int countLines(String paragraph) {
        // Split the paragraph into words
        String[] words = paragraph.split(" ");
        // Calculate the number of lines needed
        int linesNeeded = (words.length + 1) / 2; // Add 1 before division to handle odd numbers
        return linesNeeded;
    }

    public static void main(String[] args) {
        String paragraph = "Here is a weird problem in Susan’s terminal. She can not write more than two words each line.";
        int lines = countLines(paragraph);
        System.out.println("Lines needed: " + lines);
    }
}
