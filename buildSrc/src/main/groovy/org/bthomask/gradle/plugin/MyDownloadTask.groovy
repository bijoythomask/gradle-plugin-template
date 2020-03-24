package org.bthomask.gradle.plugin

import groovy.transform.CompileStatic
import org.gradle.api.DefaultTask
import org.gradle.api.provider.Property
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.Internal
import org.gradle.api.tasks.Optional
import org.gradle.api.tasks.TaskAction
import de.undercouch.gradle.tasks.download.Download

@CompileStatic
class MyDownloadTask extends DefaultTask {

    @Input
    @Optional
    Property<String> repository = project.objects.property(String)

    @Input
    @Optional
    Property<String> release = project.objects.property(String)

    @Input
    @Optional
    Property<String> destDir = project.objects.property(String)

    @Input
    @Optional
    Property<String> folder = project.objects.property(String)

    String getRepository() {
        if (repository.isPresent())
             repository.get()
    }

    void setRepository(String repository) {
        this.repository.set(repository)
    }

    String getRelease() {
        if(release.isPresent())
            return release.get()
    }

    void setRelease(String release) {
        this.release.set(release)
    }

    String getDestDir() {
        if(destDir.isPresent())
            return destDir.get()
    }

    void setDestDir(String destDir) {
        this.destDir.set(destDir)
    }

    String getFolder() {
        if(folder.isPresent())
            return folder.get()
    }

    void setFolder(String rootFolder) {
        this.folder.set(rootFolder)
    }

    @Internal
    def repos

    @Internal
    def artifactory

    @TaskAction
    def execute() {

       artifactory.each { item ->
            def artifactoryItem = item.asType(Artifactory)
            setRepository(artifactoryItem.repository)
            setRelease(artifactoryItem.release)
            setDestDir(artifactoryItem.destDir)
            setFolder(artifactoryItem.folder)
        }

        repos.each {
            def repo = it.asType(Repo)
            println("${getRepository()}/${getFolder()}/${repo.name}/${getRelease()}/${repo.version}.zip")
        }

    }
    
}


