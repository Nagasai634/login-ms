@Library ("com.venkat.sharedlib") _ // import com.venkat.sharedlib.Utils
pipeline {
    agent {
        label "sujith-label1"
    }

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
