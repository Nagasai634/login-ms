@Library('com.nagasai.sharedlib') _
pipeline {
    agent any

    stages {
        stage('Build and Deploy App') {
            steps {
                script {
                    // Call the shared library method with optional parameters
                    deployApp(
                        imageName: 'my-java-app:latest',
                        containerName: 'myjava',
                        hostPort: 8989,
                        containerPort: 8080
                    )
                }
            }
        }
    }
}

// @Library('com.nagasai.sharedlib') _

// pipeline {
//     agent any

//     stages {
//         stage('Build and Deploy') {
//             steps {
//                 script {
//                     // Single call that runs all stages
//                     myPipeline(
//                         imageName: "my-java-app:latest",
//                         containerName: "myjava", 
//                         hostPort: 8989,
//                         containerPort: 8080,
//                         skipTests: true
//                     )
//                 }
//             }
//         }
//     }
// }
