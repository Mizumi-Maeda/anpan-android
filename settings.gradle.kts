pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven { url = uri("https://jitpack.io") }
    }
}

rootProject.name = "ANPAN"

include(":app")

// Core modules
include(":core:common")
include(":core:network")
include(":core:database")
include(":core:designsystem")
include(":core:featureflags")

// Feature modules
include(":feature:auth")
include(":feature:socialcommerce")
include(":feature:wallet")
include(":feature:ai")
include(":feature:chattie")

// Extension modules
include(":feature:music")
include(":feature:tv")
include(":feature:games")
include(":feature:map")
include(":feature:realty")
include(":feature:agreeagri")
include(":feature:potentialprime")
include(":feature:scribia")
include(":feature:uuu")
include(":feature:u")
include(":feature:chronosphere")
include(":feature:cosmosgate")
include(":feature:kago")
include(":feature:lyra")
include(":feature:popol")
include(":feature:aethelive")
