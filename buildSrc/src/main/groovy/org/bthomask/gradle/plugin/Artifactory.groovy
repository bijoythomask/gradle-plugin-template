package org.bthomask.gradle.plugin

class Artifactory {

    String name

    String repository

    String release

    String destDir

    String folder

    Artifactory(String name) {
        this.name = name
    }
}
