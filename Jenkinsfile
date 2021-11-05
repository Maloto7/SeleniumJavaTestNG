pipeline {
    agent any
    stages {
        stage('Compile and clean') {
            steps {
                sh 'mvn clean compile'
            }
        }
        stage('Compile and clean') {
            steps {
                sh 'mvn test'
            }
        }
    }
}