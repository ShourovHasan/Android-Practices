pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
        maven { url "https://jcenter.bintray.com" }
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
//        maven { url("https://jcenter.bintray.com") }
        maven { url "https://jcenter.bintray.com" }

    }
}

rootProject.name = "PDF Mastering"
include(":app")
