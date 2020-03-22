package org.groovy.custom.plugin

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction
public class MyDownloadTask extends DefaultTask {

    def repository
    def release
    def destDir
    def rootFolder

    def List<Repo> repos

    @TaskAction
    def greet() {
        println "hello from MyDownload Task $repository, $release, $destDir, $rootFolder, $repos"
    }
}


