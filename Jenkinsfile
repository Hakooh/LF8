pipeline {
    agent any
    
    tools {
        jdk'JDK-17'
        maven 'Maven-3.8.6'
    }

    stages {
        stage('Build') {
            steps {
                configFileProvider([configFile(fileId: '34e418b0-dfbd-4183-ad56-5cf706efdad2', targetLocation: './backend/src/main/resources/application.properties')]) {
                    sh'mvn clean install'
                }
            }
        }
    }
    post {
        always {
            junit '**/target/surefire-reports/*.xml'
        }     
    }
}