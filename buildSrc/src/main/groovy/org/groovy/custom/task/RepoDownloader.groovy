package org.groovy.custom.task

import org.gradle.api.tasks.Input
import org.gradle.api.tasks.TaskAction
import de.undercouch.gradle.tasks.download.Download

public class RepoDownloader extends Download {

    @Input
    def repository;

    @Input
    def release;

    @Input
    def p2repo;

    @Input
    def artifacts;

    @Input
    def String destDir;

    def src_list = [];

    RepoDownloader() {
        src(src_list)
        dest(project.buildDir)
        this.doFirst {
            println("From the Download Task: Do First")
            this.src_list.forEach({println("$it")})
        }
        this.doLast {
            println("From the Download Task: Do Last")
            this.src_list.forEach({println("$it")})
        }
    }

    @TaskAction
    def taskAction() {
        println "Hello processing the download task"
        assert artifacts instanceof java.util.List
        src_list = (List)artifacts.stream().map({"${repository}/${release}/${p2repo}/${it.repo}/${it.version}.zip"}).toList()
        src_list.forEach({println("$it")})
    }

}