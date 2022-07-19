package com.github.1056227556.hdev.services

import com.intellij.openapi.project.Project
import com.github.1056227556.hdev.MyBundle

class MyProjectService(project: Project) {

    init {
        println(MyBundle.message("projectService", project.name))
    }
}
