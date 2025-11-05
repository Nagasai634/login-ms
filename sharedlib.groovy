@Library('com.nagasai.sharedlib@main') _
pipeline {
  agent any // ensure Docker & Maven are available on agent

  environment {
    // optional: version/tag
    APP_VERSION = "${env.BUILD_NUMBER}"
    DOCKER_IMAGE = "nagasai634/login-ms:${APP_VERSION}"
  }

  stages {
    stage('Checkout') {
      steps {
        checkout scm
      }
    }

    stage('Maven Build') {
      steps {
        script {
          // call shared lib step
          mavenBuild(pom: 'pom.xml', goals: "clean package -DskipTests=true")
        }
      }
    }

    stage('Docker Build & Push') {
      steps {
        script {
          // provide credential id for registry (configure in Jenkins -> Credentials)
          dockerBuildPush(image: env.DOCKER_IMAGE, registry: "docker.io", credId: "docker-hub-cred")
        }
      }
    }
  }

  post {
    always {
      echo "Cleaning workspace"
      deleteDir()
    }
    success {
      echo "Build succeeded: ${env.DOCKER_IMAGE}"
    }
    failure {
      echo "Build failed"
    }
  }
}
