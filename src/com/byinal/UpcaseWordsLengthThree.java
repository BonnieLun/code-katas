package com.byinal;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UpcaseWordsLengthThree {

    private static final String REGEX = "(\\b\\w{3}\\b)";

    public static void main(String[] args) {
        String whyString = "why do you want to work with us?";
        String example = "there is abc some words xyz with length three bjk.you need to make the words uppercase. +ex";

        String bufferResult = solutionWithBuffer(example);
        String builderResult = solutionWithBuilder(example);
        System.out.println(bufferResult);
        System.out.println(builderResult);
    }

    private static String solutionWithBuffer(String sentence) {
        Pattern pattern = Pattern.compile(REGEX);
        Matcher m = pattern.matcher(sentence);

        StringBuffer buffer = new StringBuffer();
        while (m.find()) {
            m.appendReplacement(buffer, m.group().toUpperCase());
        }
        m.appendTail(buffer);

        return buffer.toString();
    }


    private static String solutionWithBuilder(String sentence) {
        Pattern pattern = Pattern.compile(REGEX);
        Matcher m = pattern.matcher(sentence);

        StringBuilder builder = new StringBuilder();
        int last = 0;
        while (m.find()) {
            builder.append(sentence, last, m.start());
            builder.append(m.group(1).toUpperCase());
            last = m.end();
        }
        builder.append(sentence.substring(last));


        return builder.toString();
    }


}
