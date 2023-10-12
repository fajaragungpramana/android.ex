plugins {
    id(Plugin.APPLICATION) version Version.GRADLE apply false
    id(Plugin.KOTLIN_ANDROID) version Version.KOTLIN apply false
    id(Plugin.LIBRARY) version Version.GRADLE apply false
    id(Plugin.GOOGLE_SERVICE) version Version.GOOGLE_SERVICE apply false
    id(Plugin.HILT) version(Version.HILT) apply(false)
}

buildscript {
    dependencies {
        classpath(Classpath.HILT)
    }
}