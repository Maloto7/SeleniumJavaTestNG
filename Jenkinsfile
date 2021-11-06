pipeline {
    agent any
    tools{
        maven 'M2_HOME'
    }
    stages {
        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }
    }
}