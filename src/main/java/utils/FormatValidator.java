package utils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class FormatValidator {
    private List<Format> formats = new ArrayList<>();

    public FormatValidator() {
        formats.add(new Format('0', "\\d"));
        formats.add(new Format('a', "[a-z]"));
        formats.add(new Format('A', "[A-Z]"));
        formats.add(new Format('C', "[a-zA-Z]"));
    }

    public FormatValidator(List<Format> formats) {
        this.formats = formats;
    }

    public boolean testAgainst(String s, String format) {
        return Pattern.matches(pattern(format), s);
    }

    public boolean testAgainstAny(String s, List<String> formats) {
        for (String format : formats) {
            if (Pattern.matches(pattern(format), s)) {
                return true;
            }
        }

        return false;
    }

    private String pattern(String formatString) {
        StringBuilder formatStringBuilder = new StringBuilder();

        for (int i = 0; i < formatString.length(); i++) {
            char c = formatString.charAt(i);
            boolean hasFormatDefined = false;

            for (Format fmt : formats) {
                if (c == fmt.identifier()) {
                    formatStringBuilder.append(fmt.replacement());
                    hasFormatDefined = true;
                    break;
                }
            }

            if (!hasFormatDefined) {
                formatStringBuilder.append("\\").append(c);
            }
        }

        return formatStringBuilder.toString();
    }

    private record Format(char identifier, String replacement) { }
}