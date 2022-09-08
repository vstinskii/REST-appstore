package com.vitaliy.appstore.model.comparator;

public class VersionInfo {

    private char[] version;
    private int index;

    public VersionInfo(char[] version) {
        this.version = version;
    }

    public char[] getVersion() {
        return version;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
