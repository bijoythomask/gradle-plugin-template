package org.groovy.custom.demo

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction
import liquibase.integration.commandline.Main



class LiquibaseTask extends DefaultTask {
    String command
    String url, password, username
    File changeLog

    @TaskAction
    def liquibaseAction() {
        def args = [
                "--url=${url}",
                "--password=${password}",
                "--username=${username}",
                "--changeLogFile=${changeLog.absolutePath}",
                command
        ]

        Main.main(args as String[])
    }
}
