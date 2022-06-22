enum Color {
    /** Possible card or token colors. Joker only used for tokens */
    BLACK, WHITE, RED, BLUE, GREEN, JOKER;

    String emojiRes() {
        switch (this) {
            case BLACK:
                return Character.toChars(0x1F311).toString();
            case WHITE:
                return Character.toChars(0x1F315).toString();
            case RED:
                return Character.toChars(0x1F345).toString();
            case BLUE:
                return Character.toChars(0x1F48E).toString();
            case GREEN:
                return Character.toChars(0x1F340).toString();
            case JOKER:
                return "D";
        }
        return "d";
    }

}
