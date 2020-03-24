package org.bthomask.gradle.plugin


import org.gradle.api.Plugin
import org.gradle.api.Project

class MyDownloadPlugin implements Plugin<Project> {

    public static final String EXTENSION_NAME = "downloadRepo"
    public static final String TASK_NAME = "downloadRepo"+"Task"

    @Override
    void apply(Project project) {

        def downloadTask = project.tasks.create(TASK_NAME, MyDownloadTask).configure {
            group = 'cec.build'
        }
        //Create the NamedDomainObjectContainers
        def artifactory =  project.container(Artifactory)
        def repos = project.container(Repo)
        // Create and install the extension object
        def downloadRepo = project.extensions.create(EXTENSION_NAME, MyDownloadExtenstion, artifactory, repos)

        downloadTask.configure {
            downloadTask.repos = downloadRepo.repos
            downloadTask.artifactory = downloadRepo.artifactory
        }


    }
}
