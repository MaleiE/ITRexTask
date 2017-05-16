package com.malei.itrex.tasks.logic.impl;

public class ModificationTextImpl {
    public StringBuilder deleteChar(StringBuilder text){
        final String ci = "ci";
        final String ce = "ce";
        final String si = "si";
        final String se = "se";
        final String ck = "ck";
        final String ckTok = "k";
        final String c = "c";
        final String k = "k";
        String s = text.toString().replace(ci,si).replace(ce,se).replace(ck,ckTok).replace(c,k);
        text.setLength(0);
        return text.append(s);
    }

    public StringBuilder deleteArticles(StringBuilder sb){
        String text = sb.toString().replaceAll("\\b([Tt][Hh][Ee])\\b|\\b([Aa][Nn])\\b|\\b([Aa])\\b","");
        sb.setLength(0);
        sb.append(text);
        return sb;
    }

    public StringBuilder deleteDuplicatesChar(StringBuilder sb){
        final String oo = "oo";
        final String ee = "ee";
        final String u = "u";
        final String i = "i";
        String text = sb.toString().replace(oo,u).replace(ee,i).replaceAll("(.)\\1{1,}", "$1");
        sb.setLength(0);
        sb.append(text);
        return sb;
    }

    public StringBuilder deleteLastChar(StringBuilder sb) {
        String text = sb.toString().replaceAll("[eE](?!\\w)","");
        sb.setLength(0);
        sb.append(text);
        return sb;
    }
}
