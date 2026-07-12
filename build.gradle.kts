import io.kotless.plugin.gradle.dsl.kotless

plugins {
    kotlin("jvm") version "1.9.25"
    id("io.kotless") version "0.1.5" apply true
}

group = "io.github.sassy.hellokotless"
version = "1.0-SNAPSHOT"

repositories {
    jcenter()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation("io.kotless", "ktor-lang", "0.1.3")
}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
}

kotless {
    config {
        //build後のモジュールとTerraformのstateファイルを配置するためのBucket
        bucket = "kotless-example-bucket2"
        //作成したリソースにつくprefix
        prefix = "dev"

        terraform {
            profile = "myaws"
            region = "ap-northeast-1"
        }
    }

    //webApplicationの設定
    webapp {
        //作成するlambdaのメモリとTimeout設定
        lambda {
            memoryMb = 1024
            timeoutSec = 120
        }
    }
}