package org.groovy.custom.plugin

import org.gradle.api.NamedDomainObjectContainer
import org.gradle.api.component.Artifact

class MyDownloadExtenstion {
    final NamedDomainObjectContainer<Artifact> artifact
    final NamedDomainObjectContainer<Repo> repo

    MyDownloadExtenstion(NamedDomainObjectContainer<Artifact> artifact, final NamedDomainObjectContainer<Repo> repo) {
        this.artifact = artifact
        this.repo = repo
    }

    def artifact(Closure closure) {
        artifact.configure {closure}
    }

    def repo(Closure closure) {
        repo.configure(closure)
    }

}
