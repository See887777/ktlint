plugins {
    id("ktlint-publication")
    id("ktlint-kotlin-common")
}

dependencies {
    api(projects.ktlintRuleEngineCore)
}
