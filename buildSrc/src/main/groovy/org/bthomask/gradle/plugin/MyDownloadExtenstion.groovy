package org.bthomask.gradle.plugin

import groovy.transform.CompileStatic
import org.gradle.api.NamedDomainObjectContainer

@CompileStatic
class MyDownloadExtenstion {

    final NamedDomainObjectContainer<Artifactory> artifactory
    final NamedDomainObjectContainer<Repo> repos

    MyDownloadExtenstion(NamedDomainObjectContainer<Artifactory> artifactory, final NamedDomainObjectContainer<Repo> repos) {
        this.artifactory = artifactory
        this.repos = repos
    }

    def artifactory(Closure closure) {
        artifactory.configure(closure)
    }

    def repos(Closure closure) {
        repos.configure(closure)
    }

}
