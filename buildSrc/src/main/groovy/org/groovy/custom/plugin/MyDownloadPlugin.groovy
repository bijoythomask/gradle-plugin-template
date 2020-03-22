package org.groovy.custom.plugin

import org.gradle.api.Plugin
import org.gradle.api.Project

class MyDownloadPlugin implements Plugin<Project> {
    @Override
    void apply(Project project) {

        project.tasks.create("P2RepoDownload", MyDownloadTask).configure {
            group = 'cec.build'
        }
        //Create the NamedDomainObjectContainers
        def artifacts=  project.container(Artifacts)
        def repo = project.container(Repo)
        // Create and install the extension object
        project.extensions.create("P2RepoDownload", MyDownloadExtenstion, artifacts, repo)

    }
}
