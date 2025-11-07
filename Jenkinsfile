@Library ("com.nagasai.sharedlib") _ // import com.nagasai.sharedlib
pipeline {
    agent any

    stages {
        stage('buliding'){
            steps{
                mavenBuild()
            }
        }
      stage("Docker Build"){
        steps{
            dockerBuild("my-java-app:latest")
        }
      }
      stage("Docker Run"){
        steps{
            runContainer("my-java-app:latest","myjava",8989,8080)
        }
      }
    }
}
