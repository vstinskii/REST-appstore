package com.vitaliy.appstore.model.comparator;

public class VersionLevelComparator {

    private VersionInfo versionOfApplication;
    private VersionInfo versionOfExternalApp;

    public VersionLevelComparator(char[] versionOfApplication, char[] versionOfExternalApp) {
        this.versionOfApplication = new VersionInfo(versionOfApplication);
        this.versionOfExternalApp = new VersionInfo(versionOfExternalApp);
    }

    public int compareVersion() {

        int levelComparing;

        levelComparing = getVersionRank(versionOfApplication) - getVersionRank(versionOfExternalApp);

        while (versionOfApplication.getIndex() != versionOfApplication.getVersion().length) {
            if (levelComparing == 0) {
                levelComparing = getVersionRank(versionOfApplication) - getVersionRank(versionOfExternalApp);
            } else
            {
                return levelComparing;
            }
        }

        return levelComparing;
    }

    private int getVersionRank(VersionInfo versionInfo) {

        StringBuilder stringBuilder = new StringBuilder();

        char[] version = versionInfo.getVersion();

        int index = versionInfo.getIndex();

        for (;index < version.length; index++) {
            if (Character.getType(version[index]) == 9) {
                stringBuilder.append(version[index]);
            } else if (version[index] == '.') {
                index++;
                versionInfo.setIndex(index);
                return Integer.parseInt(stringBuilder.toString());
            }
        }

        throw new IllegalArgumentException();
    }
}
