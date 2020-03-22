package org.groovy.custom.demo;

import org.gradle.api.Action;
import org.gradle.api.Plugin;
import org.gradle.api.Project;

public class LiquibasePlugin implements Plugin<Project> {

    public void apply(Project project) {
        // Create and install custom tasks

//        project.getTasks().create('generateChangeLog', LiquibaseTask.class, {
//            group = 'Liquibase'
//            command = 'generateChangeLog'
//        });
//        project.task('changeLogSync', type: LiquibaseTask) {
//            group = 'Liquibase'
//            command = 'changeLogSync'
//        }
//        project.task('update', type: LiquibaseTask) {
//            group = 'Liquibase'
//            command = 'update'
//        }
//
         //Create the NamedDomainObjectContainers
//        def databases = project.container(Database)
//        def changelogs = project.container(ChangeLog)
//
//        // Create and install the extension object
//        project.extensions.create("liquibase", LiquibaseExtension, databases, changelogs)

   }
}