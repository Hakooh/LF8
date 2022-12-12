pipeline {
    agent any
    
    tools {
        jdk'JDK-17'
        maven 'Maven-3.8.6'
    }

    stages {
        stage('Build') {
            steps {
                echo 'Building..'
                configFileProvider([configFile(fileId: '34e418b0-dfbd-4183-ad56-5cf706efdad2', targetLocation: './backend/src/main/resources/application.properties')]) {
                    sh'mvn clean install'
                }
            }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }
    }
}